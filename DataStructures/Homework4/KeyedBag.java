// File: KeyedBag.java from the package DataStructures.Homework4
// Package contains KeyedBag.java and Homework4MainClass.java main file on Homework4MainClass
package DataStructures.Homework4;

/**
 * @author Edward Flores
 * @date 09/28/2019
 * Description: Uses two arrays that are parrallel to each other,
 * One Array is for all keys and another array is for all values.
 * This array will grow in size so user does not need to worry about capacity.
 */

public class KeyedBag implements Cloneable {
    private String[] data;
    private int[] keys;
    private int manyItems;

    public KeyedBag() {
        final int INITIAL_CAPACITY = 10;
        manyItems = 0;
        data = new String[INITIAL_CAPACITY];
        keys = new int[INITIAL_CAPACITY];
    }

    private KeyedBag(int initialCapacity) { // Made private so user does not worry about capacity, bag grows in size while adding items.
        data = new String[initialCapacity];
        keys = new int[initialCapacity];
        manyItems = 0;
    }

    public void insert(String entry, int key) {
        for(int i = 0; i < manyItems; i++){ // overwrites keys value if key already has a value.
            if(keys[i] == key) {
                data[i] = entry;
                return;
            }
        }
        if(manyItems == Integer.MAX_VALUE) throw new ArithmeticException("Bag is out of space");
        if (manyItems == keys.length && getCapacity() != Integer.MAX_VALUE) { // Ensure twice as much space as we need and if capacity is at Integer.MAX_VALUE it won't grow.
            if(((Long.parseLong(String.valueOf(manyItems)) + 1) * 2) >= Integer.MAX_VALUE){
                ensureCapacity(Integer.MAX_VALUE);
            } else ensureCapacity((manyItems + 1) * 2);
        }
        data[manyItems] = entry;
        keys[manyItems++] = key;
    }

    public String getEntry(int key){ // gets the entry given a key.
        for(int i = 0; i < manyItems; i++){
            if(keys[i] == key) return data[i];
        }
        return null;
    }

    public boolean contains(int key) { // checks if bag contains key replaced with count occurrences
        for(int i = 0; i < manyItems; i++)
            if (keys[i] == key) return true;
        return false;
    }

    public KeyedBag clone() { // Clone a KeyedBag object.
        KeyedBag answer;
        try {
            answer = (KeyedBag) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("This class does not implement Cloneable");
        }
        answer.data = data.clone();
        answer.keys = keys.clone();
        return answer;
    }

    private void ensureCapacity(int minimumCapacity) { // Private so user can't change capacity, they can use trimToSize after they added all key and values.
        String[] biggerArrayData;
        int[] biggerArrayKeys;

        if (keys.length < minimumCapacity) {
            biggerArrayData = new String[minimumCapacity];
            biggerArrayKeys = new int[minimumCapacity];
            System.arraycopy(data, 0, biggerArrayData, 0, manyItems);
            System.arraycopy(keys, 0, biggerArrayKeys, 0, manyItems);
            data = biggerArrayData;
            keys = biggerArrayKeys;
        }
    }

    public int getCapacity() { return keys.length; } // Public just in case they want to check how much space is being wasted.

    public int getSize() {
        return manyItems;
    }

    public boolean remove(int key) {
        int index; // The location of target in the data array.

        for (index = 0; (index < manyItems) && (key != keys[index]); index++);

        if (index == manyItems) // The target was not found, so nothing is removed.
            return false;
        else { // The target was found at data[index], So reduce manyItems by 1 and copy the last element onto data[index].
            data[index] = data[--manyItems];
            keys[index] = keys[manyItems];
            return true;
        }
    }

    public void trimToSize() {
        String[] trimmedArrayData;
        int[] trimmedArrayKeys;

        if (data.length != manyItems) {
            trimmedArrayData = new String[manyItems];
            trimmedArrayKeys = new int[manyItems];
            System.arraycopy(data, 0, trimmedArrayData, 0, manyItems);
            System.arraycopy(keys, 0, trimmedArrayKeys, 0, manyItems);
            data = trimmedArrayData;
            keys = trimmedArrayKeys;
        }
    }

    public static KeyedBag union(KeyedBag b1, KeyedBag b2) {
        // If either b1 or b2 is null, then a NullPointerException is thrown.
        // In the case that the total number of items is at
        // Integer.MAX_VALUE, there will be an arithmetic overflow and
        // the bag will fail
        // This method does not overwrite duplicate keys, it keeps the values of first parameter's bag.
        KeyedBag combinedBag = new KeyedBag(b1.getCapacity() + b2.getCapacity());
        System.arraycopy(b1.data,0,combinedBag.data,0, b1.manyItems);
        System.arraycopy(b1.keys,0,combinedBag.keys,0, b1.manyItems);
        int indexBag = b1.manyItems;
        int indexStart = 0;
        for(int k : b2.keys){
            if(!b1.contains(k)) {
                System.arraycopy(b2.keys,indexStart,combinedBag.keys,indexBag,1);
                System.arraycopy(b2.data,indexStart,combinedBag.data,indexBag,1);
                indexBag++;
            }
            indexStart++;
        }
        combinedBag.manyItems = b1.manyItems + b2.manyItems - Math.abs(indexBag - indexStart); // Subtracts the amount of duplicate keys
        return combinedBag;
    }

    @Override
    public String toString(){   // Displays bag stuff as string. Used for testing only. Displays by 20's
        StringBuilder keyString = new StringBuilder().append("Keys:\n[").append((manyItems>19)?"\n":""); // Keys: \n [keyValue1,keyValue2,...,keyValueNth]
        for(int i = 0; i < manyItems; i++) keyString.append(keys[i]).append((i==manyItems-1)?"":",").append((i%20==19)?"\n":"");
        keyString.append("]");

        StringBuilder dataString = new StringBuilder().append("\nEntries:\n[").append((manyItems>19)?"\n":""); // Entries: \n [dataValue1,dataValue2,...,dataValueNth]
        for(int i = 0; i < manyItems; i++) dataString.append(data[i]).append((i==manyItems-1)?"":",").append((i%20==19)?"\n":"");
        dataString.append("]");

        StringBuilder sizeString = new StringBuilder().append("\nCapacity: ").append(getCapacity()).append("\nSize: ").append(getSize()); // Capacity: [bag capacity] \n Size: [bag size]

        return keyString.append(dataString.append(sizeString.toString()).toString()).toString(); // Oh boy
    }
}
