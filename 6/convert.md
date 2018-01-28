The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

现在我们将尝试解决这个问题如下：

首先，我们得到的字符串s，如“ABCDEFGHIJKLMNO ......”，以及三排nS，各自等于3，4并且5，如下图所示：

n = 3
A     E     I  
B  D  F  H  J
C     G     K

n = 4
A        G       M
B     F  H    L  N
C  E     I  K    O
D        J       P

n = 5
A         I         Q
B      H  J      P  R
C    G    K    O    S
D  F      L  N      T
E         M         U

 以“Z”字形进行排序
 输出以  每一行的字符
