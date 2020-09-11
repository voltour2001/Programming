import timeit

list_test = timeit.timeit(stmt="[1,2,3,4,5,6,7,8,9]",number=1000000)
tuple_test = timeit.timeit(stmt="(1,2,3,4,5,6,7,8,9)",number=1000000)

print(list_test)
print(tuple_test)