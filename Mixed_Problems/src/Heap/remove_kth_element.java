package Heap;

import java.io.*;

class Min_Heap
{
	private int[]Heap;
    private int size;
    private int maxSize;
    private static final int FRONT = 1;
    Min_Heap(int maxSize)
    {
        this.maxSize = maxSize;
        size=0;
        Heap = new int[this.maxSize+1];
        Heap[0] = Integer.MIN_VALUE;
    }
    private int parent(int pos) {
        return pos / 2;
    }
    private int leftChild(int pos)
    {
        return (2*pos);
    }
    private int rightChild(int pos)
    {
        return (2*pos)+1;
    }
    private boolean isLeaf(int pos)
    {
        if(pos>=(size/2) && pos<=size)
            return true;
        return false;
    }
    private void swap(int fpos, int spos)
    {
        int temp;
        temp = Heap[fpos];
        Heap[fpos]=Heap[spos];
        Heap[spos]=temp;
    }
    private void minHeapify(int pos)
    {
        int left = leftChild(pos);
        int right = rightChild(pos);
        int smallest = pos;
        if(left<=size && Heap[left]<Heap[smallest])
        	smallest=left;
        if(right<=size && Heap[right]<Heap[smallest])
        	smallest = right;
        if(smallest!=pos)
        {
            swap(pos, smallest);
            minHeapify(smallest);
        }
       }
    void insert(int element)
    {
        if(size>=maxSize)
            return;
        Heap[++size]=element;
        int i=size;
        while(Heap[i]<Heap[parent(i)])
        {
            swap(i,parent(i));
            i=parent(i);
        }
    }
    private void build_heap()
    {
        int j=(int)Math.floor(size/2.0);
        for(int i=j;i>=1;i--){
            minHeapify(i);
        }
    }
public void heapSort(Writer wr) throws IOException {
        build_heap();
        int length=size;
        for(int i=size;i>=2;i--)
        {
            swap(1,i);
            size--;
            minHeapify(1);
        }
        size=length;
    // printHeap(wr);
    }
    public int remove()
    {
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size];
        size=size-1;
        minHeapify(FRONT);
        return popped;
    }
    public void deleteKey(int i)
    {
        decreaseKey(i, Integer.MIN_VALUE);
        remove();
    }
    private void decreaseKey(int i, int new_val) {
        Heap[i]=new_val;
        while(i !=0 && Heap[parent(i)]>Heap[i])
        {
            swap(i,parent(i));
            i=parent(i);
        }
    }
    void printHeap()  {
        for(int i=1;i<=size;i++)
        {
            //wr.write(Heap[i]+" ");
            System.out.print(Heap[i]+" ");
        }
    }
}

public class remove_kth_element {
	public static void main(String[] args) throws IOException {
       
            int n=5;
            int k=2;
            
            Min_Heap minHeap = new Min_Heap(n);
            for (int i = 0; i < n; i++) {
                minHeap.insert(i);
            }
            
              // 0
           // 1     2
         // 3  4
            
            minHeap.deleteKey(k);
            
            minHeap.printHeap();
            System.out.println();
     
   }
}
