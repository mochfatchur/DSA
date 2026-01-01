# Reverse First K Elements of a Queue

## 📌 Problem Statement
Given a queue of integers and an integer `k`, reverse the first `k` elements of the queue while keeping the remaining elements in the same order.

---
## My First Attempt
I use stack to store the first k elements from the queue `q`, which reverses their order in the stack, while the remaining elements stay unreversed in the original queue `q`.
Then i create a new queue, and enqueue the elements by first adding the elements from the stack `q` followed by the remaining elements from the queue `q`.

```java
class Solution {
    public Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
        // code here
        if (q.size() < k) return q;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        // store first k elements to stack
        while (i < k) {
            stack.push(q.poll());
            i++;
        }
        
        Queue<Integer> newQ = new ArrayDeque<>();
        i = 0;
        // enqueue elements from the stack
        while (i < k) {
            newQ.offer(stack.pop());
            i++;
        }
        // enqueue remaining elements from the q
        while (q.size() > 0) {
            newQ.offer(q.poll());
        }
        
        return newQ;
    }
}
```

---

## Correct Approach & Key Insight

The most efficient and interview-preferred solution uses:

- **One Stack** → to reverse the first `k` elements
- **The original Queue (in-place)** → no additional queue needed

> **Key Insight:**  
> We can reverse the first `k` elements using a stack and then rotate the remaining elements to maintain their original order, without creating a new queue.

This approach minimizes memory usage and keeps the solution clean and optimal.

---

## 🧠 Algorithm Explanation

1. **Validate input**
   - If `k <= 0` or `k > queue.size()`, return the queue as is.

2. **Push first `k` elements into a stack**
   - This reverses their order due to LIFO behavior.

3. **Pop from stack and enqueue back to the same queue**
   - The first `k` elements are now reversed at the back of the queue.

4. **Rotate the remaining `n - k` elements**
   - Move them from the front to the back to restore correct order.

---

## 💻 My Second Attempt (by AI sugestion)

```java
public Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
        // code here
        if (q.size() < k) return q;
        
        // store first k elements to stack
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < k) {
            stack.push(q.poll());
            i++;
        }
        
        // enqueue elements from the stack to queue
        while (stack.size() > 0) {
            q.offer(stack.pop());
        }
        
        // rotate the queue by remaining elements
        int remainingElSize = q.size() - k;
        while (remainingElSize > 0) {
            q.offer(q.poll());
            remainingElSize--;
        }
        
        return q;
}
```
