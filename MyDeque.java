/*
 * Name: Andrea Calderon
 * Email: a6calderon@ucsd.edu
 * PID: A17303613
 * Sources: Tutoring and the Deque javadoc
 */


/** This class implements Deque using the instance variables data, size, rear, and front */
public class MyDeque<E> implements DequeInterface<E>{

    Object[] data;
    int size;
    int rear;
    int front;

    /** 
     * This constructor intializes the values of the rear, front, and size as
     * zero and intializes data as an array with the intial capacity
     * 
     * @param initialCapacity  the max amount of elements this data structure
     * is able to hold
     */
    public MyDeque(int initialCapacity){
        if (initialCapacity < 0){
            throw new IllegalArgumentException();
        }

        this.data =  new Object[initialCapacity];
        this.rear = 0;
        this.front = 0;
        this.size = 0;
    }

    /** 
     * returns the size
     * 
     * @return the size of the deque */
    public int size(){
        return size;
    }

    /**
     * expands the deque when it is out of capacity
     */
    public void expandCapacity(){
        if (data.length == 0){
            Object[] newArr = new Object[10];

            data = newArr;
            rear = 0;
            front = 0;
        }
        else if(rear > front){
            int j = 0;
            Object[] newArr = new Object[data.length*2];
            for (int i = front; i < rear+1; i++){
                newArr[j]=data[i];
                j++;
            }
            data = newArr;
            front = 0;
            rear = size-1;
        }
        else if(front > rear){
            int count = 0;
            int k = 0;
            Object[] newArr = new Object[data.length*2];
            for (int i = front; i < data.length; i++){
                newArr[k]=data[i];
                count++;
                k++;
            }
            int l = 0;
            for(int j = count; j < size; j++){
                newArr[j] = data[l];
                l++;
            }
            data = newArr;
            front = 0;
            rear = size-1;
        }
        else if(size == 0){
            Object[] newArr = new Object[data.length*2];
            data = newArr;
        }
        else if(size == 1){
            Object[] newArr = new Object[data.length*2];
            newArr[0] = data[front];
            data = newArr;
            front = 0;
            rear = size-1;
        }
        else{
            Object[] newArr = new Object[data.length*2];
            for (int i = front; i < rear; i++){
                newArr[i]=data[i];
            }
            data = newArr;
            front = 0;
            rear = size-1;
        }
        
    }
    /**
     * adds the element to the front of the deque
     * 
     * @param element
     */
    public void addFirst(E element){
        if (element == null){
            throw new NullPointerException();
        }
        if (size == data.length){
            expandCapacity();
        }
        if(data.length == 0){
            expandCapacity();
        }
        if (size == 0){
            data[front] = element;
            size++;
        }
        else if (front == 0){
            data[data.length-1] = element;
            front = data.length-1;
            size ++;
        }
        else {
            data[front-1] = element;
            front = front - 1;
            size ++;
        }
    }

    /** 
     * adds element to the rear of the deque
     * 
     * @param element
     */
    public void addLast(E element){
        if (element == null){
            throw new NullPointerException();
        }
        if (size == data.length){
            expandCapacity();
        }
        if(data.length == 0){
            expandCapacity();
        }
        if(size == 0){
            data[rear] = element;
            size++;
        }
        else if(rear == data.length-1){
            data[0]=element;
            size++;
            rear = 0;
        }
        else{
            data[rear+1]=element;
            size++;
            rear = rear + 1;
        }
    }

    /**
     * removes the element at the front of the deque
     * 
     * @return the element that is removed
     */
    @SuppressWarnings("unchecked")
    public E removeFirst(){
        if (size == 0){
            return null;
        }
        E temp = (E) data[front];
        data[front] = null;
        if (front == data.length-1){
            front = 0;
        }
        else{
            front = front+1;
        }
        size--;
        
        return (E) temp;
        
    }

    /**
     * removes the element at the rear of the deque
     * 
     * @return the element that is removed
     */
    @SuppressWarnings("unchecked")
    public E removeLast(){
        if (size == 0){
            return null;
        }
        E temp = (E) data[rear];
        data[rear] = null;
        if (rear == 0){
            rear = data.length-1;
        }
        else if (rear == data.length-1) {
            rear = data.length-1;
        }
        else{
            rear = rear - 1;
        }
        size--;
        return temp;
    }

    /** 
     * returns the element at the beginning of the deque
     * 
     * @return the element at the front of the deque
     */
    @SuppressWarnings("unchecked")
    public E peekFirst(){
        if (size == 0){
            return null;
        }
        return (E) data[front];
    }

    /**
     * returns the element at the end of the deque
     * 
     * @return the element at the rear of the deque
     */
    @SuppressWarnings("unchecked")
    public E peekLast(){
        if (size == 0){
            return null;
        }
        return (E) data[rear];
    }
}
