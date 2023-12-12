package Heap;

class Check_min_heap
{
    // Function to check if a given array represents min-heap or not
    public static boolean checkMinHeap(int[] A, int i)
    {
        // if `i` is a leaf node, return true as every leaf node is a heap
        if (2*i + 2 > A.length) {
            return true;
        }
 
        // if `i` is an internal node
 
        // recursively check if the left child is a heap
        boolean left = (A[i] <= A[2*i + 1]) && checkMinHeap(A, 2*i + 1);
 
        // recursively check if the right child is a heap (to avoid the array index out
        // of bounds, first check if the right child exists or not)
        boolean right = (2*i + 2 == A.length) ||
                        (A[i] <= A[2*i + 2] && checkMinHeap(A, 2*i + 2));
 
        // return true if both left and right child are heaps
        return left && right;
    }
 
    public static void main(String[] args)
    {
        int[] A = {1, 2, 3, 4, 5, 6};
 
        // start with index 0 (the root of the heap)
        int index = 0;
 
        if (checkMinHeap(A, index)) {
            System.out.println("The given array is a min-heap");
        }
        else {
            System.out.println("The given array is not a min-heap");
        }
    }
}

