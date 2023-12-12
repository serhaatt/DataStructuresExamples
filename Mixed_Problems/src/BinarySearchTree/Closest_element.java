package BinarySearchTree;

import java.util.*;

class Closest_element
{
      
     static int min_diff, min_diff_key;
       
/*  A binary tree node has key, pointer to left child
and a pointer to right child */
static class Node
{
    int key;
     
     Node  left,  right;
};
  
/*  Utility that allocates a new node with the
  given key and null left and right pointers.  */
 
 static Node  newnode(int key)
{
     
     Node  node = new Node();
    node.key = key;
    node.left = node.right  = null;
    return (node);
}
  
// Function to find node with minimum absolute
// difference with given K
// min_diff   -. minimum difference till now
// min_diff_key  -. node having minimum absolute
//                   difference with K
static void maxDiffUtil(Node  ptr, int k)
{
    if (ptr == null)
        return ;
  
    // If k itself is present
    if (ptr.key == k)
    {
        min_diff_key = k;
        return;
    }
  
    // update min_diff and min_diff_key by checking
    // current node value
    if (min_diff > Math.abs(ptr.key - k))
    {
        min_diff = Math.abs(ptr.key - k);
        min_diff_key = ptr.key;
    }
  
    // if k is less than ptr.key then move in
    // left subtree else in right subtree
    if (k < ptr.key)
        maxDiffUtil(ptr.left, k);
    else
        maxDiffUtil(ptr.right, k);
}
  
// Wrapper over maxDiffUtil()
static int maxDiff(Node  root, int k)
{
    // Initialize minimum difference
    min_diff = 999999999; min_diff_key = -1;
  
    // Find value of min_diff_key (Closest key
    // in tree with k)
    maxDiffUtil(root, k);
  
    return min_diff_key;
}
  
// Driver program to run the case
public static void main(String args[])
{
     
     Node  root = newnode(9);
    root.left    = newnode(4);
    root.right   = newnode(17);
    root.left.left = newnode(3);
    root.left.right = newnode(6);
    root.left.right.left = newnode(5);
    root.left.right.right = newnode(7);
    root.right.right = newnode(22);
    root.right.right.left = newnode(20);
    int k = 18;
    System.out.println( maxDiff(root, k));
     
}
}
//contributed by Arnab Kundu