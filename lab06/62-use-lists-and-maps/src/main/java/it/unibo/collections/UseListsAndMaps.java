package it.unibo.collections;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    private static final int ELEMS = 100_000;
    private static final int NTIMES = 1000;
    /**
     * Program entry point.
     */
    public static void main() {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */

        List<Integer> arraylist = new ArrayList<Integer>();
        int min = 1000;
        int max = 2000;
        for(int i=0; i < 1000; i++) {
            arraylist.add((int)(int)(Math.random() * (max - min)) + min);
        }

        
        /*
        * 2) Create a new LinkedList<Integer> and, in a single line of code
        * without using any looping construct (for, while), populate it with
        * the same contents of the list of point 1.
        */
       List<Integer> linkedlist = new LinkedList<Integer>();
       linkedlist.addAll(arraylist);

       /*
       * 3) Using "set" and "get" and "size" methods, swap the first and last
       * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */

        IO.println("FIRST ELEMENT: " + arraylist.getFirst());
        IO.println("LAST ELEMENT: " + arraylist.getLast());
        int first = arraylist.get(arraylist.size() - arraylist.size());
        int last = arraylist.get(arraylist.size() - 1);
        arraylist.set(arraylist.size() - arraylist.size(), last);
        arraylist.set(arraylist.size() - 1, first);
        IO.println("FIRST ELEMENT: " + arraylist.getFirst());
        IO.println("LAST ELEMENT: " + arraylist.getLast());
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        IO.print("[");
        for (int number : arraylist) { 
            IO.print(number + ", ");
        }
        IO.print("]");
        /*

         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        IO.println("");
        long time = System.nanoTime();
        for (int i = 0; i < ELEMS; i++) {
            arraylist.addFirst(i);
        }
        time = System.nanoTime() - time;
        long millis = TimeUnit.NANOSECONDS.toMillis(time);
        IO.println("To insert " + ELEMS + " elements in the arrayList, it took: " + time + "ns ( " + millis + "ms )");
        
        time = System.nanoTime();
        for (int i = 0; i < ELEMS; i++) {
            linkedlist.addFirst(i);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        IO.println("To insert " + ELEMS + " elements in the linkedList, it took: " + time + "ns ( " + millis + "ms )");
        

        
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */

        int middle = arraylist.size() / 2;
        time = System.nanoTime();
        for (int i = 0; i < NTIMES; i++) {
            arraylist.get(middle);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        IO.println("To read the middle element of the arraylist, " + NTIMES + " times it took: " + time + "ns ( " + millis + "ms )" );
        
        middle = linkedlist.size() / 2;
        time = System.nanoTime();
        for (int i = 0; i < NTIMES; i++) {
            linkedlist.get(middle);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        IO.println("To read the middle element of the linkedList, " + NTIMES + " times it took: " + time + "ns ( " + millis + "ms )" );
        /*
        * 7) Build a new Map that associates to each continent's name its
        * population:
        *
        * Africa -> 1,110,635,000
        *
        * Americas -> 972,005,000
        *
        * Antarctica -> 0
        *
        * Asia -> 4,298,723,000
        *
        * Europe -> 742,452,000
        *
        * Oceania -> 38,304,000
        */
        
        Map<String, BigInteger> continentPop = new HashMap<>();

        continentPop.put("Africa", new BigInteger("1110635000"));
        continentPop.put("Americas", new BigInteger("972005000"));
        continentPop.put("Antartica", new BigInteger("0"));
        continentPop.put("Asia", new BigInteger("4298723000"));
        continentPop.put("Europe", new BigInteger("742452000"));
        continentPop.put("Oceania", new BigInteger("38304000"));
        /*
         * 8) Compute the population of the world
         */
        IO.println(continentPop.values());
        BigInteger sum = new BigInteger("0");
        for (BigInteger num : continentPop.values()) {
            sum = sum.add(num);
        }

        IO.println("World Population: " + sum);
    }
}
