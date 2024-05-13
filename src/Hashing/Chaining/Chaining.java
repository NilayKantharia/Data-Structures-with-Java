package Hashing.Chaining;

/**
 * Includes all the methods to demonstrate Chaining in a hashMap.
 * <p>
 *     When Collision occurs in a hashMap, This technique creates a node and add it to the last position of a chain present at that index.
 * </p>
 */
public class Chaining {
    public class Node {
        /**
         * Stores that data in a Node.
         */
        public int data;
        /**
         * Stores the Address on next Node.
         */
        public Node next;
        /**
         * Initializes the Nodes of chain.
         * @param data The data which is to be added.
         */
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }


    /**
     * Declares size of hashMap.
     */

    public static int size;
    /**
     * Declares the hashMap which will have head of each chains in a Array;
     */
    public static Node linkMap[];
    /**
     * Initializes hashMap with given size.
     * @param size the size of hashMap.
     */
    public Chaining(int size){
        this.size = size;
        linkMap = new Node[size];
    }
    /**
     * The Hash Function on basis of which we achieve O(1) time complexity.
     * @param data The data whose position we want to find out.
     * @return The key where we can keep the data.
     */
    private int hash(int data){
        return data % size;
    }

    /**
     * When Collision is Detected. it will be responsible for creating and maintaining LinkedLists(chains).
     * @param key the position where Collision took place.
     * @param data the data which is to be inserted.
     */
    public void chainAddressing(int key, int data){
        Node newNode = new Node(data);
        Node temp = linkMap[key];
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;

    }

    /**
     * Inserts value after getting key from hash() method.
     * @param data The data which is to be inserted in hashMap.
     */
    public void insert(int data){
        int key = hash(data);
        if (linkMap[key] == null){
            linkMap[key] = new Node(data);
        }
        else{
            chainAddressing(key, data);
        }
    }

    /**
     * Prints the hashMap. Although it is not required in concept of hashing but just to demonstrate the Collisions.
     */
    public void print(){
        for (int i = 0; i < size; i++){

            if(linkMap[i] != null){
                Node temp = linkMap[i];
                while (temp != null){
                    System.out.print(temp.data + " -> ");
                    temp = temp.next;
                }
                System.out.println("null");
            }
            else{
                System.out.println(linkMap[i]);
            }
        }
    }

    /**
     * Checks if the value exists in hashMap or not.
     * @param data The value which we are searching.
     * @return The boolean value True if value exists else returns False.
     */
    public boolean exists(int data){
        int key = hash(data);
        Node temp = linkMap[key];
        while(temp != null){
            if (temp.data == data){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
}
