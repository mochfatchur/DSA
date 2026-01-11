class LinkedListQueue {
    
    Node front, rear;
    int size = 0;
    
    static class Node {
        int value;
        Node next = null;
        
        Node(int value) {
            this.value = value; 
        }
    }
    

    public LinkedListQueue() {
        front = rear = null;
        size = 0;
    }

    public void enqueue(int x) {
        // insert x into queue
        Node newNode = new Node(x);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = rear.next;
        }
        size++;
    }

    public void dequeue() {
        // remove front element from queue
        // remove front Node
        if (isEmpty()) {
            throw new RuntimeException("empty queue");
        }
        front = front.next;
        size--;
    }

    public int getFront() {
        // return the front element of the queue
        if (isEmpty()) {
            throw new RuntimeException("empty queue");
        }
        return front.value;
    }

    public int getRear() {
        // return the rear element of the queue
        if (isEmpty()) {
            throw new RuntimeException("empty queue");
        }
        return rear.value;
    }

    public boolean isEmpty() {
        // check whether the queue is empty
        return front == null;
    }

    public int size() {
        // return the size of the queue
        return size;
    }
}
