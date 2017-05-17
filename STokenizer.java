import java.util.*;
import java.io.*;
public class STokenizer
{
static int l;
String t[]=new String[20];
STokenizer(String user,String pass,String s)
{
  StringTokenizer stringTokenizer = new 
   StringTokenizer(s);
  System.out.println("The total no. of tokens generated :  " + stringTokenizer.countTokens());
  while(stringTokenizer.hasMoreTokens())
 {
 l=stringTokenizer.countTokens();
System.out.println(l);
for(int x=0;x<l;x++)
t[x]=stringTokenizer.nextToken();
}

for(int i=0;i<l;i++)
System.out.print(t[i] + "  ");
BinaryTreeTest bt=new BinaryTreeTest(user,pass,t,l);
}
}