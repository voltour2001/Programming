"""
[expr for val in collection]
[expr for val in collection1 and val in collection2]
[expr for val in collection if <test>]
[expr for val in collection if <test> and <test2>]
"""
squares = [i**2 for i in range(1, 101)] # first 100 squares
remainders5 = [x**2 % 5 for x in range(1, 101)] # devide the first 100 squares by 5 (x^2(mod5) )

A=[1,3,5,7]
B=[2,4,6,8]
cartesion_product = [(a, b) for a in A for b in B]
print(cartesion_product)