class Solution(object):
    def isIsomorphic(self, s, t):
     if(len(s)!=len(t)):
      return False
     k=[0]*256
     j=[0]*256
     for i in range(len(s)):
      ch1=s[i]
      ch2=t[i]
      l=ord(ch1)
      m=ord(ch2)
      if(k[l]==0 and j[m]==0):
       k[l]=ch2
       j[m]=ch1
      elif (k[l]!=ch2 or j[m]!=ch1):
       return False 
     return True

        
        