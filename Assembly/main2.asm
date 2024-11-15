.data
prompt:    .asciiz "Enter a number (0 to 9999): "  # Prompt message
errorMsg:  .asciiz "Invalid input! Program terminated.\n"  # Error message
newline:   .asciiz "\n" # New line

.text
.globl __start

__start:
    # Print the prompt to ask for a number
    li $v0, 4                   # Load syscall for printing string
    la $a0, prompt              # Address of prompt string
    syscall                     # Print the prompt
    
    # Read the input from the user
    li $v0, 5                   # Load syscall for reading integer
    syscall                     # Read input, result in $v0
    move $t0, $v0               # Store the input in $t0

#? =================================== Part A =================================== ?# 

#!<-------------------- Valid Input Check -------------------->
    #*--------------------------------------*#

    # bltz = Branch on Less Than Zero  
    bltz $t0, Invalid   # if $t0 < 0, jump to Invalid label

    li $t1, 10000        # Upper bound of 9999 + 1
    bge $t0, $t1, Invalid  # If $t0 >= 10000, jump to invalid label

    #*--------------------------------------*#

#!<-------------------- Isolate Digits -------------------->
    #*--------------------------------------*#

    move $t5, $t0       # $t5 = original int

    # 1000
    div $t0, $t5, 1000  # $t0 = int / 1000 
    mflo $t1            # Move quotient to $t1 (thousands digit)
    mfhi $t0            # Move remainder to $t0 to continue with the division of 100 

    # 100
    div $t0, $t0, 100   # div the remainder of the previous div with 100 to get the hundreds digit
    mflo $t2            # Move quotient into $t2 (hundreds digit)
    mfhi $t0            # Move remainder to $t0 to continue with the division of 100 

    # 10
    div $t0, $t0, 10    # Divide by 10 to get the tens digit
    mflo $t3            # Move quotient (tens digit) into $t3
    mfhi $t4            # Move remainder (ones digit) into $t4

    #*--------------------------------------*#


#!<-------------------- Encrypt Digits -------------------->
    #*--------------------------------------*#

    # x mod 10 = what is left when dividing x by 10.

    li $t6, 10  # Load 10 into $t6 for modulo operations

    # Encrypt thousands
    addi $t1, $t1, 7    # $t1 + 7
    div $t1, $t1, $t6   # Divide by 10 to apply modulo
    mfhi $t1

    # Encrypt hundreds
    addi $t2, $t2, 7
    div $t2, $t2, $t6
    mfhi $t2
    
    # Encrypt tens
    addi $t3, $t3, 7
    div $t3, $t3, $t6
    mfhi $t3

    # Encrypt ones
    addi $t4, $t4, 7
    div $t4, $t4, $t6
    mfhi $t4

    #*--------------------------------------*#

#!<-------------------- Swap Digits -------------------->
    #*--------------------------------------*#

    # Swap thousands and tens (using $t6 as temp register)
    move $t6, $t1   # t6 = thousands
    move $t1, $t3   # t1 = tens
    move $t3, $t6   # t3 = thousands

    # Swap Hundreds and ones (using $t6 as temp register again)
    move $t6, $t2   # t6 = hundreds
    move $t2, $t4   # t2 = ones
    move $t4, $t6   # t4 = hundreds 

    #*--------------------------------------*#

#!<-------------------- Call Reconstruct_Number -------------------->
    #*--------------------------------------*#

    # jal = (Jump and Link) and jr $ra (Jump Register)
    jal		Reconstruct_Number				# jump to Reconstruct_Number and save position to $ra
    
    #*--------------------------------------*#

#!<-------------------- Print number -------------------->
    #*--------------------------------------*#

    # Print
    move $a0, $t5   # move number into $a0 to be able to print
    li $v0, 1       # load syscall for print integerx
    syscall         # print

    # Print newline
    li $v0, 4            # Syscall for printing string
    la $a0, newline      # Load the address of newline
    syscall              # Print newline
    #*--------------------------------------*#


#? =================================== Part B =================================== ?# 
#!<-------------------- Reverse Swap -------------------->
    #*--------------------------------------*#

    # Swap the thousands and tens 
    move $t6, $t1   # thousands into temp t6 
    move $t1, $t3   # tens -> thousands
    move $t3, $t6   # thousands -> tens 

    # Swap the hundreds and ones 
    move $t6, $t2   # hundreds into temp t6
    move $t2, $t4   # ones -> hundreds
    move $t4, $t6   # hundreds -> ones

    #*--------------------------------------*#

#!<-------------------- Reverse Encryption -------------------->
    #*--------------------------------------*#
    #   x = (y - 7 + 10 ) % 10

    li $t6, 7           # Load 7 into t6 for subtraction
    
    # Thousands
    sub $t1, $t1, $t6   # t1 -= 7    
    addi $t1, $t1, 10   # add 10 so that result is not negative 
    div $t1, $t1, 10    # mod 10
    mfhi $t1            # get remainder from mod 10 

    # Hundredsd
    sub $t2, $t2, $t6   # t2 -= 7
    addi $t2, $t2, 10   # +10 for not negative
    div $t2, $t2, 10    # mod 10
    mfhi $t2            # remainder of mod 10

    # Tens
    sub $t3, $t3, $t6   
    addi $t3, $t3, 10    
    div $t3, $t3, 10     
    mfhi $t3             

    # Ones
    sub $t4, $t4, $t6    
    addi $t4, $t4, 10    
    div $t4, $t4, 10     
    mfhi $t4             

    #*--------------------------------------*#

#!<-------------------- Call Reconstruct_Number -------------------->
    #*--------------------------------------*#

    # jal = (Jump and Link) and jr $ra (Jump Register)
    jal		Reconstruct_Number				# jump to Reconstruct_Number and save position to $ra
    
    #*--------------------------------------*#

#!<-------------------- Print number -------------------->
    #*--------------------------------------*#

    # Print
    move $a0, $t5   # move number into $a0 to be able to print
    li $v0, 1       # load syscall for print integerx
    syscall         # print

    # Print newline
    li $v0, 4            # Syscall for printing string
    la $a0, newline      # Load the address of newline
    syscall              # Print newline
    #*--------------------------------------*#




    # jump to exit to skip print Invalid
    j exit


Reconstruct_Number:

    # Reconstruct Integer
    mul $t5, $t1, 1000  # digit * 1000
    mul $t6, $t2, 100   # digit * 100
    add $t5, $t5, $t6   #  t5 = thousands + hundreds
    
    mul $t6, $t3, 10    # digit * 10 (t6 = temp reg)

    add $t5, $t5, $t6   # t5 = t5 + tens
    add $t5, $t5, $t4   # t5 = t5 + ones

    jr $ra               # Return to the point after jal

#! Invalid input
Invalid:
    # Print error and terminate.
    li $v0, 4           # Load syscall for print
    la $a0, errorMsg    # Address of error message
    syscall             # Print

    li $v0, 10          # Load syscall for EXIT
    syscall
exit:

    li $v0, 10
    syscall