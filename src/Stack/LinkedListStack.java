package DataStructures.Stack;

/**
 * Stack implementation using LinkedList.
 * <p>This class includes all the methods for implementation a stack using LinkedList.</p>
 */
public class LinkedListStack {

    /**
     * This class helps to define the structure of LinkedList used in stack.
     */
    private class Node {
        /**
         * The value which will in stored.
         */
        int data;
        /**
         * The pointer to next Node in LinkedList.
         */
        Node next;

        /**
         * Initializes a new Node.
         *
         * @param data The value to be addded to Node.
         */
        public Node(int data) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * The pointer to the head of LinkedList, here it will work as top;
     */
    public static Node head;

    /**
     * The size of the LinkedList will be stored here.
     */
    public static int size;

    /**
     * Checks if the stack is empty or not.
     *
     * @return Boolean value True if stack is empty else returns False.
     */
    public boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Pushes data to the top of stack as inserting new Node to front of LinkedList.
     *
     * @param data The value to be pushed to stack.
     */
    public void push(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head.next;
        head = newNode;
        return;
    }

    /**
     * Gets and removes the element present on the top of the stack.
     *
     * @return The value which will be removed from the stack.
     */
    public int pop() {
        if (head == null) {
            System.out.println("Stack is empty");
            return -1;
        }
        int x = head.data;
        head = head.next;
        size--;
        return x;
    }

    /**
     * Gets the value present on the top of the stack without removing.
     *
     * @return the vlue present on the top of the stack.
     */
    public int peek() {
        if (head == null) {
            System.out.println("Stack is empty");
            return -1;
        }
        return head.data;
    }
}
