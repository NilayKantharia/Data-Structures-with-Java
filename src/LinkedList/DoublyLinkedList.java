package LinkedList;

/**
 * The core functionalities of a Doubly LinkedList.
 * <p>All the methods present in this class are created with respect to Doubly LinkedList structure.</p>
 */

public class DoublyLinkedList {
    /**
     * The structure of Nodes in Doubly LinkedList.
     */
    public static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    /**
     * The Head pointer to the LinkedList.
     */
    public static Node head;
    /**
     * The Tail pointer to LinkedList which always points to last Node.
     */
    public static Node tail;
    /**
     * The size of LinkedList.
     */
    public static int size;

    /**
     * Adds a new Node in beginning of the LinkedList.
     * @param data The value which is to be added in front of LinkedList.
     */
    public void addFirst(int data){
        size++;
        Node newNode = new Node(data);
        if (head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    /**
     * Adds a new Node in the ending of the LinkedList.
     * @param data the value which is to be added in end of LinkedList.
     */
    public void addLast(int data){
        size++;
        Node newNode = new Node(data);
        if (head == null){
            head = tail = newNode;
            return;
        }
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
        return;
    }

    /**
     * Prints the whole LinkedList. For representation purpose, it uses "<->" between Nodes and "null" in ending.
     */
    public void print(){
        Node temp = head;
        System.out.print("null <-> ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    /**
     * Removes the first Node of the LinkedList.
     * @return the value present in Node which is to be removed.
     */
    public int removeFirst(){
        if (head == null){
            System.out.println("LinkedList is empty");
            return Integer.MIN_VALUE;
        }
        size--;
        if (size == 1){
            int val = head.data;
            head = tail = null;
            return val;
        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        return val;
    }

    public int removeLast(){
        if (head == null){
            System.out.println("LinkedList is empty");
            return Integer.MIN_VALUE;
        }
        if (size == 1){
            int val = head.data;
            head = tail = null;
            return val;
        }
        int val = tail.data;
        Node temp = head;
        int i = 0;
        while (i < size - 1){
            temp = temp.next;
        }
        temp.next = null;
        tail.prev = null;
        tail = temp;
        return val;
    }
    /**
     * Gets the first element of LinkedList without removing.
     * @return The first Node of the LinkedList.
     */
    public Node getFirst(){
        return head;
    }

    /**
     * Gets the last element of this list.
     * @return The last Node of the LinkedList.
     */
    public Node getLast(){
        return tail;
    }

    /**
     * Inserts given element at given index of LinkedList.
     * @param index The position where the new element will be inserted.
     * @param data The integer data to be inserted in new Node.
     */
    public void insert(int index, int data){
        if(index > size){
            index = size;
        }
        else if(index < 0){
            index += size + 1;
        }
        if(index <= 0){
            addFirst(data);
            return;
        }

        Node temp = head;
        int i = 0;
        while(i < index - 1){
            temp = temp.next;
            i++;
        }

        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next.prev = newNode;
        newNode.prev = temp;
        temp.next = newNode;
        size++;
        return;
    }


    /**
     * Removes the last element. Similar to pop function in python, which by-default removes the last element.
     * @return The data of removed element
     */
    public int pop(){
        return pop(size - 1);
    }

    /**
     *Removes the element at given position.
     *<p>Similar to Python, we can provide index more than size or negative in value as per reverse indexing or even lesser than negative indexing.</p>
     * @param index The position that we want to remove.
     * @return The data present in removed Node.
     */
    public int pop(int index){
        if(head == null){
            System.out.println("LinkedList is Empty");
            return 0;
        }
        if(index >= size){
            index = size - 1;
        }
        else if (index < 0){
            index = size + index;
        }
        if(index <= 0){
            Node x = head;
            head = head.next;
            head.prev = null;
            size--;
            return x.data;
        }
        Node temp = head;
        int i = 0;
        while(i < index - 1){
            temp = temp.next;
            i++;
        }
        Node x = temp.next;
        if(x.next != null){
            temp.next = x.next;
            temp.next.prev = temp;
        }
        else{
            temp.next = null;
            x.prev = null;
            tail = temp;
        }
        size--;
        return x.data;
    }

    /**
     * Removes the first occurence of given data from LinkedList. If not present, does nothing.
     * @param data The integer value which it will find first.
     */
    public void remove(int data){
        Node temp = head.next;
        Node prev = head;
        if(head.data == data){
            head = head.next;
            head.prev = null;
            size--;
            return;
        }

        while(temp != null){
            if(temp.data == data){
                if(temp.next != null){
                    prev.next = temp.next;
                    prev.next.prev = prev;
                }
                else{
                    prev.next = null;
                    temp.prev = null;
                    tail = prev;
                }
                temp.next = null;
                temp.prev = null;
                size--;
                return;
            }
            prev = temp;
            temp = temp.next;
        }
    }

    /**
     * Checks if the given element is present in the LinkedList or not.
     * @param data The integer value which will be checked
     * @return If the data is present in LinkedList, It will return True else return False.
     */
    public boolean contains(int data){
        int x = find(data);
        if (x == -1){
            return false;
        }
        else{
            return true;
        }
    }

    /**
     * Finds the length of LinkedList in terms of elements or nodes.
     * @return The number of Nodes present in LinkedList.
     */
    public int size(){
        return size;
    }


    /**
     * Checks if the LinkedList is empty or not.
     * @return Boolean value True if found empty else False.
     */
    public boolean isEmpty(){
        return (head == null);
    }

    /**
     * Empties the whole LinkedList.
     */
    public void clear(){
        head = tail = null;
    }

    /**
     * Finds the element in the LinkedList.
     * @param data The element which we want to find.
     * @return The index or position on which it finds the element. If not present, it will return -1.
     */
    public int find(int data){
        if(head == null){
            System.out.println("LinkedList is Empty");
            return -1;
        }

        Node temp = head;
        int i = 0;
        while(temp != null){
            if(temp.data == data){
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    /**
     * Reverses the whole LinkedList and stores in the same head variable.
     */
    public void reverse(){
        Node curr = tail = head;
        Node prev = null;
        while (curr != null){
            Node t = curr.prev;
            curr.prev = curr.next;
            curr.next = t;
            prev = curr;
            curr = curr.prev;
        }
        head = prev;
    }

    /**
     * Gets the element present at given position in LinkedList.
     * @param index The position in LinkedList.
     * @return The element present on given position.
     */
    public int get(int index){
        if(index >= size){
            index = size - 1;
        }
        else if(index < 0){
            index += size;
        }

        Node temp = head;
        int i = 0;
        while(i < index){
            temp = temp.next;
            i++;
        }
        return temp.data;
    }


    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addFirst(2);
        dll.addFirst(5);
        dll.print();
    }
}
