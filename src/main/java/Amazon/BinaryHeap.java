package Amazon;

import org.junit.Test;

import java.util.Arrays;
import java.util.NoSuchElementException;

/*
https://medium.com/@shahad9381/binary-heap-the-basics-implementations-b790b939a202
*/
// PriorityQueueImpl
public class BinaryHeap {

    private static final int CAPACITY= 16;
    private int[] heap;
    private int heapSize;

    public BinaryHeap(int capacity){
        heapSize = 0;
        heap = new int[capacity+1];
        Arrays.fill(heap, -1);
    }

    public void push(int value) {
        if (heapSize == heap.length) {
            throw new IllegalArgumentException();
        }

        int pos = heapSize;
        heap[pos] = value;
        while(pos > 0) {
            int parent = (pos+1) / 2 -1;
            if (heap[parent] >= heap[pos]) break;
            swapIndexes(parent, pos);
            pos = parent;
        }
        heapSize++;
    }

    public int pop() {
        if (heapSize == 0) throw new IllegalArgumentException();
        int toReturn = heap[0];
        heap[0] = heap[heapSize-1];

        int pos = 0;
        while(pos < heapSize/2) {
            int leftChild = pos*2+1;
            int rightChild = leftChild+1;
            if(rightChild < heapSize && heap[leftChild] < heap[rightChild]) {
                if (heap[pos] >= heap[rightChild]) break;
                swapIndexes(pos, rightChild);
                pos = rightChild;
            } else {
                if (heap[pos] >= heap[leftChild]) break;
                swapIndexes(pos, leftChild);
                pos = leftChild;
            }
        }

        heapSize--;
        return toReturn;
    }

    private void swapIndexes(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public boolean isEmpty(){
        return heapSize==0;
    }

    public boolean isFull(){
        return heapSize == heap.length;
    }

    private int parent(int i){
        return (i-1)/CAPACITY;
    }

    private int kthChild(int i,int k){
        return CAPACITY*i + k;
    }

    public void insert(int x){
        if(isFull())
            throw new NoSuchElementException("Heap is full, No space to insert new element");
        heap[heapSize++] = x;
        heapifyUp(heapSize-1);
    }

    public int delete(int x){
        if(isEmpty())
            throw new NoSuchElementException("Heap is empty, No element to delete");
        int key = heap[x];
        heap[x] = heap[heapSize -1];
        heapSize--;
        heapifyDown(x);
        return key;
    }

    private void heapifyUp(int i) {
        int temp = heap[i];
        while(i>0 && temp > heap[parent(i)]){
            heap[i] = heap[parent(i)];
            i = parent(i);
        }
        heap[i] = temp;
    }

    private void heapifyDown(int i) {
        int child;
        int temp = heap[i];
        while (kthChild(i, 1) < heapSize) {
            child = maxChild(i);
            if (temp < heap[child]) {
                heap[i] = heap[child];
            } else break;
            i = child;
        }
        heap[i] = temp;
    }

    private int maxChild(int i) {
        int leftChild = kthChild(i, 1);
        int rightChild = kthChild(i, 2);
        return heap[leftChild] > heap[rightChild] ? leftChild : rightChild;
    }

    public void printHeap() {
        System.out.print("nHeap = ");
        for (int i = 0; i < heapSize; i++)
            System.out.print(heap[i] +" ");
        System.out.println();
    }

    public int findMax() {
        if (isEmpty())
            throw new NoSuchElementException("Heap is empty.");
        return heap[0];
    }

    @Test
    public void test() {
        BinaryHeap maxHeap = new BinaryHeap(10);
        maxHeap.insert(10);
        maxHeap.insert(4);
        maxHeap.insert(9);
        maxHeap.insert(1);
        maxHeap.insert(7);
        maxHeap.insert(5);
        maxHeap.insert(3);

        maxHeap.printHeap();
        maxHeap.delete(5);
        maxHeap.printHeap();
    }
}