import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Queue Test Suite")
public class QueueJUnitTest {
    
    private myQueue queue;
    
    @BeforeEach
    void setUp() {
        queue = new myQueue();
    }
    
    @Test
    @DisplayName("Test: Queue initialization should be empty")
    void testInitialization() {
        assertTrue(queue.isEmpty(), "Queue should be empty on initialization");
        assertEquals(0, queue.size(), "Queue size should be 0 on initialization");
    }
    
    @Test
    @DisplayName("Test: Enqueue single element")
    void testEnqueueSingle() {
        queue.enqueue(10);
        assertFalse(queue.isEmpty(), "Queue should not be empty after enqueue");
        assertEquals(1, queue.size(), "Queue size should be 1");
        assertEquals(10, queue.getFront(), "Front element should be 10");
        assertEquals(10, queue.getRear(), "Rear element should be 10");
    }
    
    @Test
    @DisplayName("Test: Enqueue multiple elements")
    void testEnqueueMultiple() {
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        
        assertEquals(4, queue.size(), "Queue size should be 4");
        assertEquals(10, queue.getFront(), "Front element should be 10");
        assertEquals(40, queue.getRear(), "Rear element should be 40");
    }
    
    @Test
    @DisplayName("Test: Get front and rear elements")
    void testGetFrontAndRear() {
        queue.enqueue(5);
        queue.enqueue(15);
        queue.enqueue(25);
        
        assertEquals(5, queue.getFront(), "Front should be 5");
        assertEquals(25, queue.getRear(), "Rear should be 25");
    }
    
    @Test
    @DisplayName("Test: Dequeue single element")
    void testDequeueSingle() {
        queue.enqueue(10);
        queue.dequeue();
        
        assertTrue(queue.isEmpty(), "Queue should be empty after dequeuing only element");
        assertEquals(0, queue.size(), "Queue size should be 0");
    }
    
    @Test
    @DisplayName("Test: Dequeue multiple elements")
    void testDequeueMultiple() {
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        
        queue.dequeue();
        assertEquals(3, queue.size(), "Size should be 3 after first dequeue");
        assertEquals(20, queue.getFront(), "Front should be 20 after dequeue");
        
        queue.dequeue();
        assertEquals(2, queue.size(), "Size should be 2 after second dequeue");
        assertEquals(30, queue.getFront(), "Front should be 30 after dequeue");
    }
    
    @Test
    @DisplayName("Test: FIFO behavior")
    void testFIFOBehavior() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        
        assertEquals(1, queue.getFront(), "First dequeued should be 1");
        queue.dequeue();
        
        assertEquals(2, queue.getFront(), "Second dequeued should be 2");
        queue.dequeue();
        
        assertEquals(3, queue.getFront(), "Third dequeued should be 3");
        queue.dequeue();
        
        assertTrue(queue.isEmpty(), "Queue should be empty");
    }
    
    @Test
    @DisplayName("Test: isEmpty on empty queue")
    void testIsEmptyOnEmptyQueue() {
        assertTrue(queue.isEmpty(), "isEmpty should return true for new queue");
    }
    
    @Test
    @DisplayName("Test: isEmpty on non-empty queue")
    void testIsEmptyOnNonEmptyQueue() {
        queue.enqueue(10);
        assertFalse(queue.isEmpty(), "isEmpty should return false for non-empty queue");
    }
    
    @Test
    @DisplayName("Test: Size changes correctly")
    void testSizeChanges() {
        assertEquals(0, queue.size(), "Initial size should be 0");
        
        queue.enqueue(1);
        assertEquals(1, queue.size(), "Size should be 1 after enqueue");
        
        queue.enqueue(2);
        assertEquals(2, queue.size(), "Size should be 2 after second enqueue");
        
        queue.dequeue();
        assertEquals(1, queue.size(), "Size should be 1 after dequeue");
        
        queue.dequeue();
        assertEquals(0, queue.size(), "Size should be 0 after dequeuing all");
    }
    
    @Test
    @DisplayName("Test: Enqueue and dequeue mixed operations")
    void testMixedOperations() {
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        
        queue.dequeue(); // Remove 10
        assertEquals(20, queue.getFront(), "Front should be 20");
        
        queue.enqueue(40); // Add 40
        assertEquals(3, queue.size(), "Size should be 3");
        assertEquals(20, queue.getFront(), "Front should still be 20");
        assertEquals(40, queue.getRear(), "Rear should be 40");
        
        queue.dequeue(); // Remove 20
        assertEquals(30, queue.getFront(), "Front should be 30");
        assertEquals(2, queue.size(), "Size should be 2");
    }
    
    @Test
    @DisplayName("Test: Exception on getFront with empty queue")
    void testGetFrontOnEmptyQueue() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            queue.getFront();
        }, "getFront should throw exception on empty queue");
    }
    
    @Test
    @DisplayName("Test: Exception on getRear with empty queue")
    void testGetRearOnEmptyQueue() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            queue.getRear();
        }, "getRear should throw exception on empty queue");
    }
    
    @Test
    @DisplayName("Test: Exception on dequeue with empty queue")
    void testDequeueOnEmptyQueue() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            queue.dequeue();
        }, "dequeue should throw exception on empty queue");
    }
}
