package Hashing.OpenAddressing;

/**
 * Includes all methods to demonstrate Collisions occurs while using Linear Probing of Open Addressing.
 * <p>
 *     We can see the difference in position if collision occurs.
 * </p>
 */
public class LinearProbing {

    /**
     * Declares size of HashMap
     */
    public static int size;

    /**
     * Declares the hashMap;
     */
    public static int hashMap[];

    /**
     * Initializing the HashMap with User given size.
     * @param size It defines the size of HashMap.
     */
    public LinearProbing(int size){
        this.size = size;
        hashMap = new int[size];
    }

    /**
     * The Hash Function on basis of which we achieve O(1) time complexity.
     * @param data The data whose position we want to find out
     * @return The key where we can keep the data.
     */
    public int hash(int data){
        return data % size;
    }

    /**
     * Assigns next empty position if Collision occurs.
     * @param key The position where Collision took place.
     * @param data The value which is to be inserted.
     */
    public void linearProbingCollision(int key, int data){
        int i = 0;
        while (hashMap[key] != 0){
            if (i == size){
                System.out.println("No empty space");
                return;
            }
            key = (key + 1) % size;
            i++;
        }
        hashMap[key] = data;
    }

    /**
     * Inserts value after getting key from hash() method.
     * @param data The data which is to be inserted in hashMap.
     */
    public void insert(int data) {
        int key = hash(data);
        if (hashMap[key] == 0) {
            hashMap[key] = data;
        } else {
            linearProbingCollision(key, data);
        }
    }

    /**
     * Checks if the value exists in HashMap or not.
     * @param data The value which we are searching.
     * @return The boolean value True if value exists else returns False.
     */
    public boolean exists(int data){
        int key = hash(data);
        if (hashMap[key] == data){
            return true;
        }
        else{
            int i = 0;
            while (i < size){
                if(hashMap[key] == data){
                    return true;
                }
                i++;
                key = (key + 1) % size;
            }
        }
        return false;
    }


    /**
     * Prints the HashMap. Although it is not required in concept of hashing but just to demonstrate the Collisions.
     */
    public void print(){
        System.out.print('[');
        for(int i = 0; i < size; i++){
            System.out.print(hashMap[i] + ", ");
        }
        System.out.println(']');
    }
}
