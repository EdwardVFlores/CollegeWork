// File: Homework4MainClass.java from the package DataStructures.Homework4
// Package contains KeyedBag.java and Homework4MainClass.java this is main class where I run code
package DataStructures.Homework4;

public class Homework4MainClass extends KeyedBag implements Cloneable{
    public static void main(String[] args) {
        KeyedBag kb = new KeyedBag();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        System.out.println("Inserting entries a b c with keys 0 1 2 key index matches with entry index");
        for(int i = 0; i < 3; i++){
            kb.insert(alphabet[i]+"",i);
        }
        System.out.println(kb.toString());

        System.out.println();
        System.out.println("Overwriting key 1 with entry called d");
        kb.insert(alphabet[3]+"",1);
        System.out.println(kb.toString());

        System.out.println();
        System.out.println("Inserting entries a b f with keys 10 11 9");
        kb.insert("a",10);
        kb.insert("b",11);
        kb.insert("f",9);
        System.out.println(kb.toString());

        System.out.println();
        System.out.println("Removing key 1 with value of d");
        System.out.println("Removed? " + kb.remove(1));
        System.out.println(kb.toString());

        System.out.println();
        System.out.println("Removing key 1 again");
        System.out.println("Removed? " + kb.remove(1));
        System.out.println(kb.toString());

        System.out.println();
        System.out.println("Creating bag 2");
        KeyedBag kb2 = new KeyedBag();
        for(int i = 10; i < 15; i++){
            kb2.insert(alphabet[i]+"",i);
        }
        System.out.println(kb2.toString());

        System.out.println();
        System.out.println("Combining first keyed bag with second keyed bag");
        KeyedBag kb3 = KeyedBag.union(kb,kb2);
        System.out.println(kb3.toString());

        System.out.println();
        System.out.println("Combining first key bag to itself");
        KeyedBag.union(kb,kb);
        System.out.println(kb.toString());

        System.out.println();
        System.out.println("Trimming bag 1 to its size");
        kb.trimToSize();
        System.out.println(kb.toString());

        System.out.println();
        System.out.println("Printing out values of all bags");
        System.out.println("Bag 1");
        System.out.println(kb.toString());
        System.out.println("\nBag 2");
        System.out.println(kb2.toString());
        System.out.println("\nBag 3");
        System.out.println(kb3.toString());

        System.out.println();
        System.out.println("Testing get Entry using keys");
        System.out.println("Bag 1, key 0 , Entry " + kb.getEntry(0));
        System.out.println("Bag 2, key 11 , Entry " + kb2.getEntry(11));
        System.out.println("Bag 3, Key 0 , Entry " + kb3.getEntry(0));
        System.out.println("Bag 3, key 11 , Entry " + kb3.getEntry(11));

        System.out.println();
        KeyedBag kbClone = kb.clone();
        kbClone.insert("test",0);   // To test deep cloning
        System.out.println("Bag 1 Clone with changed key 0 to test");
        System.out.println(kbClone.toString());
        System.out.println("\nBag 1");
        System.out.println(kb.toString());
    }
}