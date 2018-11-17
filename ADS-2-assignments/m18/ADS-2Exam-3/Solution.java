import java.util.Scanner;
import java.util.*;
/**
 * Class for solution.
 */
public class Solution {
    /**
     * Constructs the object.
     */
    Solution(){

    }

    //
    // Don't modify this method.
    //
    // @param      args  The arguments
    //
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String cases = scan.nextLine();

        switch (cases) {
        case "loadDictionary":
            // input000.txt and output000.txt
            BinarySearchST<String, Integer> hash = loadDictionary("/Files/t9.csv");
            while (scan.hasNextLine()) {
                String key = scan.nextLine();
                System.out.println(hash.get(key));
            }
            break;

        case "getAllPrefixes":
            // input001.txt and output001.txt
            T9 t9 = new T9(loadDictionary("/Files/t9.csv"));
            while (scan.hasNextLine()) {
                String prefix = scan.nextLine();
                for (String each : t9.getAllWords(prefix)) {
                    System.out.println(each);
                }
            }
            break;

        case "potentialWords":
            // input002.txt and output002.txt
            t9 = new T9(loadDictionary("/Files/t9.csv"));
            int count = 0;
            while (scan.hasNextLine()) {
                String t9Signature = scan.nextLine();
                for (String each : t9.potentialWords(t9Signature)) {
                    count++;
                    System.out.println(each);
                }
            }
            if (count == 0) {
                System.out.println("No valid words found.");
            }
            break;

        case "topK":
            // input003.txt and output003.txt
            t9 = new T9(loadDictionary("/Files/t9.csv"));
            Bag<String> bag = new Bag<String>();
            int k = Integer.parseInt(scan.nextLine());
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                bag.add(line);
            }
            for (String each : t9.getSuggestions(bag, k)) {
                System.out.println(each);
            }

            break;

        case "t9Signature":
            // input004.txt and output004.txt
            t9 = new T9(loadDictionary("/Files/t9.csv"));
            bag = new Bag<String>();
            k = Integer.parseInt(scan.nextLine());
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                for (String each : t9.t9(line, k)) {
                    System.out.println(each);
                }
            }
            break;

        default:
            break;

        }
    }
    // Don't modify this method.
    public static String[] toReadFile(String file) {
        In in = new In(file);
        return in.readAllStrings();
    }
    public static BinarySearchST<String, Integer> loadDictionary(String file) {
        BinarySearchST<String, Integer>  st = new BinarySearchST<String, Integer>();
        String[] word = toReadFile(file);
        for (int i = 0; i < word.length; i++) {
            String str = word[i].toLowerCase();
            if (st.contains(str)) {
                st.put(str, st.get(str)+ 1);
            } else {
                st.put(str, 1);
            }
        }
        return st;
        // your code goes here
    }
}

/**
 * Class for t 9.
 */
class T9 {
    TST<Integer> tst = new TST();

    /**
     * Constructs the object.
     *
     * @param      st    { parameter_description }
     */
    public T9(BinarySearchST<String, Integer> st) {
        for (String k : st.keys())
            if (!tst.contains(k)) {
                tst.put(k, st.get(k));
            }
        // your code goes here
        }
    //
    // get all the prefixes that match with given prefix.
    //
    // @param      prefix  The prefix
    //
    // @return     All words.
    //
    public Iterable<String> getAllWords(String prefix) {
        Queue que = new Queue();
        for (String s: tst.keysWithPrefix(prefix) ) {
            que.enqueue(s);
        }
        return que;
        // your code goes here
    }

    /**
     * { function_description }
     *
     * @param      t9Signature  The t 9 signature
     *
     * @return     { description_of_the_return_value }
     */
    public Iterable<String> potentialWords(String t9Signature) {
        // your code goes here
        return null;
    }

    //
    // return all possibilities(words), find top k with highest frequency.
    //
    // @param      words  The words
    // @param      k      { parameter_description }
    //
    // @return     The suggestions.
    //
    public Iterable<String> getSuggestions(Iterable<String> words, int k) {
        Queue que = new Queue();
        ArrayList<String> al = new ArrayList<String>();
        MaxPQ<Integer> pq = new MaxPQ<Integer>();
        for (String str : words ) {
         pq.insert(tst.get(str));   
        }
        for (int i = 0; i < k; i++) {
            int n = pq.delMax();
            for (String str : words) {
                if (n == tst.get(str)) {
                    que.enqueue(str);
                   // al.add(que);
                }
            }
        }
        // your code goes here
        //Arrays.sort(que);
        //Collections.sort(al);
        return que;
        }
        
        // your code goes here
    //
    // final output Don't modify this method.
    //
    // @param      t9Signature  The t 9 signature
    // @param      k            { parameter_description }.
    //
    // @return     { description_of_the_return_value }
    //
    public Iterable<String> t9(String t9Signature, int k) {
        return getSuggestions(potentialWords(t9Signature), k);
    }
}