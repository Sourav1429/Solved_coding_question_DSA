'''Please Note:
Another question which belongs to the category of questions which are intentionally stated vaguely.
Expectation is that you will ask for correct clarification or you will state your assumptions before you start coding.

Given an integer A, convert it to a roman numeral, and return a string corresponding to its roman numeral version

 Note : This question has a lot of scope of clarification from the interviewer. Please take a moment to think of all the needed clarifications and see the expected response using “See Expected Output” For the purpose of this question, https://projecteuler.net/about=roman_numerals has very detailed explanations. 


Input Format

The only argument given is integer A.
Output Format

Return a string denoting roman numeral version of A.
Constraints

1 <= A <= 3999
For Example

Input 1:
    A = 5
Output 1:
    "V"

Input 2:
    A = 14
Output 2:
    "XIV"
'''
##################My approach##################################
class Solution:
    def intToRoman(self, n):
        rom=list();
        while(n>0):
            if(int(n/1000)>0):
                rom.append('M');
                n=n-1000;
            elif(int(n/900)>0):
                rom.append('CM');
                n-=900;
            elif(int(n/500)>0):
                rom.append('D');
                n-=500;
            elif(int(n/400)>0):
                rom.append('CD');
                n-=400;
            elif(int(n/100)>0):
                rom.append('C');
                n-=100;
            elif(int(n/90)>0):
                rom.append('XC');
                n-=90;
            elif(int(n/50)>0):
                rom.append('L');
                n-=50;
            elif(int(n/40)>0):
                rom.append('XL');
                n-=40;
            elif(int(n/10)>0):
                rom.append('X');
                n-=10;
            elif(int(n/9)>0):
                rom.append('IX');
                n-=9;
            elif(int(n/5)>0):
                rom.append('V');
                n-=5;
            elif(int(n/4)>0):
                rom.append('IV');
                n-=4;
            elif(int(n/1)>0):
                rom.append('I');
                n-=1;
        return ''.join(rom);
      
      
   #########################Their approach###################################
  class Solution:
    val = {
                1 : ['I', 'V'],
                2 : ['X', 'L'],
                3 : ['C', 'D'],
                4 : ['M']
            }
    
    # @param A : integer
    # @return a strings
    def intToRoman(self, n):
        # Roman Literal for 1s, 10s, 100s and 1000s places 
        p = 1
        res = ''
        while n > 0:
            d = n % 10
            # digit is zero, we skip
            if d > 0:
                res += self.generateRomanNumeralForDigit(d, p)
            p += 1
            # go to next digit
            n = int(n/10)
        return res[::-1]
        
    
    # @param d: digit
    # @param p: place
    def generateRomanNumeralForDigit(self, d, p):
        res = ''
        
        if d < 4:
            res += ''.join(self.val[p][0] for q in range(d))

        elif d >= 4 and d<= 8:
            if d == 4:
                res += self.val[p][1] + self.val[p][0] 
            else:
                d = d-5
                res += ''.join(self.val[p][0] for q in range(d)) + self.val[p][1]

        elif d == 9:
            res += self.val[p+1][0] + self.val[p][0]
            
        return res


  
  
  
  
  
  
  
  
