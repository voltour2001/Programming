#User function Template for python3

class Solution:
    def canReach(self, A, N):
    	cur = N-1
    	for i in range(N-1,-1,-1):
    		if i + A[i] >= cur :
    			cur = i

    	if cur > 0 :
    		return 0
    	else :
    	    return 1