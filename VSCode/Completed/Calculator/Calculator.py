while True:
    x=int(input('First number :'))
    y=int(input('Second number :'))
    Operator=input('+, -, *, / :')
    Operator.strip()
    if Operator == '+':
        print(x+y)
    elif Operator == '-':
        print(x-y)
    elif Operator == '*':
        print(x*y)
    else:
        print(x/y)
