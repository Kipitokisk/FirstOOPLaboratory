package Lab3.Models;

public interface Queue {
    void enqueue(int element);
    int dequeue();
    int peek();
    boolean isEmpty();
}
