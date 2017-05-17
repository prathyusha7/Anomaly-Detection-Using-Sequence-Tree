import java.io.*;
import java.util.*;
public class BinaryTreeTest 
{String msg[];

static class Node 
{
Node left;
Node right;
String value;
public Node(String value) 
{
this.value = value;
}
}

BinaryTreeTest(String user,String pass,String[] msg,int l)
{
System.out.println(l);
int i=0;
Node root = new Node(msg[i]);
System.out.println("Building tree with root value " + root.value);
for(i=1;i<l;i++)
insert(root, msg[i]);
int h=height(root);
System.out.println("height"+h);
System.out.println("user "+user);
System.out.println("pass "+pass);
Anomaly an=new Anomaly(user,pass,h);
}

public void insert(Node node, String value) 
{
if (value.compareTo(node.value)<0) 
{
if (node.left != null) 
insert(node.left, value);
else 
{
System.out.println("Inserted  "+value+" to left of  "+node.value);
node.left = new Node(value);
}
}
 else if (value.compareTo(node.value) >0)
{
if (node.right != null)
insert(node.right, value);
else 
{
System.out.println("Inserted "+ value+" to right of "+node.value);
node.right = new Node(value);
}
}
}

public int height(Node node)
{
    if (node == null)
    {
        return 0;
    }
    else
    {
        return 1 +
        Math.max(height(node.left),
            height(node.right));
    }
}

}