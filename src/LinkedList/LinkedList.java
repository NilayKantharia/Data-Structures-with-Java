package LinkedList;

/**
 * This class includes the core as well as some extra functionalities of a LinkedList
 * <p>Many methods in this class covers the python's functionality of handling negative indexing.</p>
 * @author Nilay Kantharia
 * @version 1.0
 * @since 2024
 * @see <a href = "https://github.com/NilayKantharia" target = "_blank">Github</a>
 */
public class LinkedList {
    /**
     * The structure of Nodes in the LinkedList.
     */
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
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
     * Inserts an element to the beginnig of the linkedList as head.
     * @param data The integer data to be added on the starting Node.
     */
    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            size++;
            return;
        }
        newNode.next = head;
        head = newNode;
        size++;
    }

    /**
     *Appends an element to ending of the LinkedList.
     * @param data The integer element to be added at last Node.
     */
    public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            size++;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        size++;
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
        temp.next = newNode;
        size++;
        return;
    }

    /**
     * Removes the first element of the LinkedList.
     * @return The data of first element which will be removed.
     */
    public int removeFirst(){
        Node temp = head;
        head = head.next;
        size--;
        return temp.data;
    }

    /**
     * Removes and returns the last element from this list.
     * @return The data of last element which will be removed.
     */
    public int removeLast(){
        Node temp = head;
        Node x = tail;
        int i = 0;
        while(i < size - 1){
            temp = temp.next;
        }
        temp.next = null;
        size--;
        return x.data;

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
        }
        else{
            temp.next = null;
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
            size--;
            return;
        }

        while(temp != null){
            if(temp.data == data){
                if(temp.next != null){
                    prev.next = temp.next;
                }
                else{
                    prev.next = null;
                    tail = prev;
                }
                temp.next = null;
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
     * Creates a shallow copy of LinkedList.
     * @return The head of shallow copied LinkedList.
     */
    public Node clone(){
        Node temp1 = head;
        Node temp2 = temp1;
        Node head2 = temp2;
        while(temp1 != null){
            temp2.next = temp1.next;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return head2;
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
    /**
     * Reverses the whole LinkedList and stores in the same head variable.
     */
    public void reverse(){
        Node curr = tail = head;
        Node prev = null;
        while (curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    /**
     * Prints the whole LinkedList, For representation purpose, it uses "->" in between and "null" at ending.
     */
    public void print(){
        if(head == null){
            System.out.println("LinkedList is Empty");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    /**
     * Finds the middle most Node in LinkedList.
     * @param head The head pointer to LinkedList.
     * @return The middle Node of given LinkedList.
     */
    public Node middle(Node head){
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * Checks wheather the given LinkedList is Node.data wise Palindromic or not.
     * <p>It uses a getMid private method</p>
     * @param head The head of a LinkedList.
     * @return The boolean value True if it is found palindromic else False.
     */
    public boolean isPalindrome(Node head){
        if (head == null || head.next == null){
            return true;
        }

        Node midNode = getMid(head);
        Node prev = null;
        Node curr = midNode;

        while (curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        while (prev != null){
            if (head.data != prev.data){
                return false;
            }
            head = head.next;
            prev = prev.next;
        }
        return true;
    }
    /**
     * This method is used by isPalindrome() method to get middle Node of LinkedList.
     * @return Next Node of middle of LinkedList if size is even else middle Node.
     */
    private Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * Checks if the LinkedList contains cycle or not.
     * @return The boolean value True if cycle is present else False.
     */
    public boolean containsCycle(){
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow){
                return true;
            }
        }
        return false;
    }

    /**
     * Sorts the LinkedList in ascending order. With help of merge() method, it implies Merge Sort.
     * @param head The head Node of a LinkedList.
     * @return The head Node sorted LinkedList.
     */
    public Node sort(Node head){
        if (head == null || head.next == null){
            return head;
        }
        Node mid = getMid(head);
        Node right = mid.next;
        mid.next = null;
        Node newLeft = sort(head);
        Node newRight = sort(right);

        return merge(newLeft, newRight);

    }
    /**
     * This method is used by sort() method. It merges two LinkedList.
     * @param head1 The head Node of first LinkedList.
     * @param head2 the head Node of second LinkedList.
     * @return The head Node of sorted and merged LinkedList.
     */
    private Node merge(Node head1, Node head2){
        Node merged = new Node(-1);
        Node temp = merged;
        while (head1 != null && head2 != null){
            if (head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        while (head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return merged.next;
    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(15);
        ll.addLast(10);
        ll.insert(100,5);
        ll.insert(4,50);
        ll.insert(50000, 500);
        Node x = ll.clone();
        ll.print();
        ll.head = ll.sort(ll.head);
        ll.print();
        // ll.reverse();
        // ll.print();
        // ll.append(1);
        // ll.append(2);
        // ll.append(1);
        // System.out.println(ll.isPalindrome(head));
        // ll.head = new Node(1);
        // ll.head.next = new Node(2);
        // ll.head.next.next = new Node(3);
        // // ll.head.next.next.next = ll.head;
        // System.out.println(ll.containsCycle());

    }
}



// toArray(): Returns an array containing all of the elements in this list in proper sequence (from first to last element).
// toString(): Returns a string representation of this list.
