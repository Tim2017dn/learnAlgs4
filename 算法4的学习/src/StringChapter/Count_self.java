package StringChapter;

import edu.princeton.cs.algs4.Alphabet;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Count_self {

    // Do not instantiate.
    private Count_self() { }

    /**
     * Reads in text from standard input; calculates the frequency of
     * occurrence of each character over the alphabet specified as a
     * commmand-line argument; and prints the frequencies to standard
     * output.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {

        Alphabet alphabet = new Alphabet("ABCDR<ABRA.txt");
        final int R = alphabet.radix();
        int[] count = new int[R];
        while (StdIn.hasNextChar()) {
            char c = StdIn.readChar();
            if (alphabet.contains(c))
                count[alphabet.toIndex(c)]++;
        }
        for (int c = 0; c < R; c++)
            StdOut.println(alphabet.toChar(c) + " " + count[c]);
    }
}