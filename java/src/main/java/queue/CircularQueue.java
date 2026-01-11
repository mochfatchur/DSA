import java.util.*;

class CircularQueue {
    
    private int[] arr;
    private int front, rear;
    private int capacity, size;

    // Constructor
    public CircularQueue(int n) {
        // Define Data Structures
        arr = new int[n];
        front = rear = size = 0;
        capacity = n;
    }

    public boolean isEmpty() {
        // Check if queue is empty
        return size == 0;
    }

    public boolean isFull() {
        // Check if queue is full
        return size == capacity;
    }

    public void enqueue(int x) {
        // Enqueue
        if (isFull()) {
            throw new RuntimeException("full queue");
        }
        rear = (front + size) % capacity;
        arr[rear] = x;
        size++;
    }

    public void dequeue() {
        // Dequeue
        if (isEmpty()) {
            throw new RuntimeException("empty queue");
        }
        arr[front] = -1;
        front = (front + 1)%capacity;
        size--;
    }

    public int getFront() {
        // Get front element
        if (isEmpty()) return -1;
        return arr[front];
    }

    public int getRear() {
        // Get last element
        if (isEmpty()) return -1;
        return arr[rear];
    }
}
