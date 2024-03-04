import math

def orderless(numb,sets):
    result = math.factorial(numb) / math.factorial((number-sets))
    return int(result)

def ordered(numb,sets):
    result = math.factorial(numb) / (math.factorial(sets)*((math.factorial((number-sets)))))
    return int(result)


while True:

    print("Select one of the below:")
    print("1. Orders (Orderless)")
    print("2. Combinations (Ordered)")
    print("3. Explain")

    selection = int(input(": "))

    # Explenation of the choices
    if selection == 3:
        print("""
            Example A,B,C in pairs of 2
            1 = P(items, pairs)
            
            2 = C(items, pairs)
            """)


    if selection == 1:
        number = int(input("Number of elements: "))
        sets = int(input("Number of sets: "))
        print("\nPossible combinations:",orderless(number,sets),'\n\n')

    elif selection == 2:
        number = int(input("Number of elements: "))
        sets = int(input("Number of sets: "))
        print("\nPossible combinations:",ordered(number,sets),"\n\n")

