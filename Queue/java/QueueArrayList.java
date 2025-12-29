import java.util.*;

class myQueue {
    
    private List<Integer> queue;

    public myQueue() {
        // initialize your queue
        queue = new ArrayList<>();
    }

    public void enqueue(int x) {
        // insert x into queue
        queue.add(x);
    }

    public void dequeue() {
        // remove front element from queue
        int el = queue.get(0);
        List<Integer> newArr = new ArrayList<>();
        for (int i = 0; i < this.size(); i++) {
            if (i != 0) {
                newArr.add(queue.get(i));
            }
        }
        queue = newArr;
    }

    public int getFront() {
        // return the front element of the queue
        return queue.get(0);
    }

    public int getRear() {
        // return the rear element of the queue
        return queue.get(this.size()-1);
    }

    public boolean isEmpty() {
        // check whether the queue is empty
        return queue.isEmpty();
    }

    public int size() {
        // return the size of the queue
        return queue.size();
    }
}
