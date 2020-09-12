def quadratic_function(a,b,c):
    """Returns the function f(x) = ax^2 + bx + c"""
    return lambda x: a*x**2 + b*x + c

print(quadratic_function(-4,2,9)(4))