/*
 * Name: Andrea Calderon
 * Email: a6calderon@ucsd.edu
 * PID: A17303613
 * Sources: None
 */

// imports used:
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This class implements test cases for the classes MyQueue, MyStack, and MyDeque
 */
public class CustomTester {


    static void initDeque(MyDeque<Integer> deque, Object[] data, int size,
                          int front, int rear) {
        deque.data = data;
        deque.size = size;
        deque.front = front;
        deque.rear = rear;
    }


// -----------Deque-------------
    /**Tests the Deque constructor with a negative initialCapacity */
    @Test
    public void testDeqConstructor(){
        assertThrows(IllegalArgumentException.class, () ->{
            new MyDeque<>(-10);
        });
    }

    /** Tests expandCapacity when the deque has 0 capacity */
    @Test
    public void testExpCap(){
        MyDeque<Integer> deque = new MyDeque<>(5);
        Integer[] orig = {3,4,5,1,2};
        initDeque(deque, orig, 5, 0, 4);
        deque.expandCapacity();
        assertEquals(10, deque.data.length);
    }
    /** Tests addFirst when the parameter is null */
    @Test
    public void addFirstTest(){
        MyDeque<Integer> test1 = new MyDeque<>(10);
        assertThrows(NullPointerException.class, () -> {
            test1.addFirst(null);
        });
    }

    /** Tests addLast when the parameter is null */
    @Test
    public void DeqaddLastTest(){
        MyDeque<Integer> deque = new MyDeque<>(5);
        Integer[] orig = {3,4,5,1,2};
        initDeque(deque, orig, 5, 0, 4);
        deque.addLast(6);
        assertEquals(3,deque.data[0]);
        assertEquals(4,deque.data[1]);
        assertEquals(5,deque.data[2]);
        assertEquals(1,deque.data[3]);
        assertEquals(2,deque.data[4]);
        assertEquals(6,deque.data[5]);
        assertEquals(6,deque.size);
    }

    /** Tests removeFirst on an empty list */
    @Test
    public void removeFirstTest(){
        MyDeque<String> test3 = new MyDeque<>(10);
        test3.size = 0;
        assertEquals(null, test3.removeFirst());
    }

    /** Tests removeLast on an empty list */
    @Test
    public void removeLastTest(){
        MyDeque<Integer> test4 = new MyDeque<>(3);
        test4.size = 0;
        assertEquals(null, test4.removeLast());
    }

    /** Tests peekFirst on an empty list */
    @Test
    public void peekFirstTest(){
        MyDeque<Integer> test7 = new MyDeque<>(10);
        test7.size = 0;
        assertEquals(null, test7.peekFirst());
        assertEquals(0,test7.size);
    }

    /** Tests peekLast on an empty list */
    @Test
    public void peekLast(){
        MyDeque<Integer> test8 = new MyDeque<>(7);
        test8.size = 0;
        assertEquals(null, test8.peekLast());
    }
    // ------------ Stack ---------------

    /** Test pop method on an empty list */
    @Test
    public void popTest(){
        MyStack<Integer> test5 = new MyStack<>(10);
        assertEquals(null, test5.pop());
    }

    //------------ Queue-----------------

    /** Tests peek on an empt list */
    @Test
    public void peekTest(){
        MyQueue<Integer> test6 = new MyQueue<>(10);

        assertEquals(null, test6.peek());
    }
}
