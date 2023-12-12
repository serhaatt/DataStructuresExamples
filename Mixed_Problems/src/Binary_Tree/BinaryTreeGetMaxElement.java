package Binary_Tree;

public class BinaryTreeGetMaxElement {
    /*
     * @Author : Arpit Mandliya
     */
 
    public static class TreeNode
    {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data)
        {
            this.data=data;
        }
    }
 
    // Recursive Solution
    /* To get max node in a binary tree*/
    public static  int getMaximumRec(TreeNode root)
    {
        int max=Integer.MIN_VALUE;
        int value=0;
        int left,right;
        if(root != null)
        {
            value=root.data;
            left=getMaximumRec(root.left);
            right=getMaximumRec(root.right);
 
            if(left>right)
            {
                max=left;
            }
            else
            {
                max=right;
            }
            if(max < value)
            {
                max=value;
            }
        }
 
        return max;
    }
    public static void main(String[] args)
    {
        // Creating a binary tree
        TreeNode rootNode=createBinaryTree();
        System.out.println("Max node using recursion :"+getMaximumRec(rootNode));
   
    }
 
    public static TreeNode createBinaryTree()
    {
 
        TreeNode rootNode =new TreeNode(40);
        TreeNode node20=new TreeNode(20);
        TreeNode node10=new TreeNode(10);
        TreeNode node30=new TreeNode(30);
        TreeNode node60=new TreeNode(60);
        TreeNode node50=new TreeNode(50);
        TreeNode node70=new TreeNode(70);
        //40
   //20      60
//10    30   50   70
        rootNode.left=node20;
        rootNode.right=node60;
 
        node20.left=node10;
        node20.right=node30;
 
        node60.left=node50;
        node60.right=node70;
 
        return rootNode;
    }
}
            