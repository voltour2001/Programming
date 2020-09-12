import time 

t0 = time.time()

for n in range(1,100000):
    #func_name(n)
    n=n*10%2/2+20*3
    
t1 = time.time()

print("Time required: ", t1- t0)