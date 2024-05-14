package Stack;
import java.util.ArrayList;

/**
 * Includes all the stack operations using ArrayList.
 * <p>The class contains varios methods which are used to perform core functionalities of stack. There are many ways to implement a stack but specifically this class employees ArrayList to achieve it.</p>
 */
public class ArrayListStack {
    /**
     * The ArrayList on which each operation will be performed.
     */
    public static ArrayList<Integer> list = new ArrayList<>();

    /**
     * Checks if the stack is empty or not.
     * @return True if the stack is empty else returns False
     */
     public boolean isEmpty(){
        return list.size() == 0;
    }

    /**
     * Adds an element on top of the stack.
     * @param data The value which is to be added to stack.
     */
    public void push(int data){
        list.add(data);
    }

    /**
     * Removes and returns the element present on the top of the stack.
     * @return The value which is removed.
     */
    public int pop(){
        if (list.size() == 0){
            System.out.println("Stack is empty");
            return -1;
        }
        int top = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return top;
    }

    /**
     * Gets the value present on the top of stack without removing it.
     * @return The element at top of Stack.
     */
    public int peek(){
        if (list.size() == 0){
            System.out.println("Stack is empty");
            return -1;
        }
        return list.get(list.size() - 1);
    }
}
