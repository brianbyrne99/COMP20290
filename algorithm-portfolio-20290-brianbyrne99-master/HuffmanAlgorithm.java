


/**
 * Java implementation of a compression and decompression system, that uses a huffman
 * tree data structure for more efficient timings.
 *
 *  @authors Zach Dunne, Thomas Thornton, Brian Byrne
 */
public class HuffmanAlgorithm {

    // alphabet size of extended ASCII
    private static final int R = 256;

    // Do not instantiate.
    private HuffmanAlgorithm() { }

    // Huffman trie node
    private static class Node implements Comparable<Node> {
        private final char ch;
        private final int freq;
        private final Node left, right;

        Node(char ch, int freq, Node left, Node right) {
            this.ch    = ch;
            this.freq  = freq;
            this.left  = left;
            this.right = right;
        }

        // is the node a leaf node?
        private boolean isLeaf() {
            assert ((left == null) && (right == null)) || ((left != null) && (right != null));
            return (left == null) && (right == null);
        }

        // compare, based on frequency
        public int compareTo(Node that) {
            return this.freq - that.freq;
        }
    }

    /**
     * Reads a sequence of 8-bit bytes from standard input; compresses them
     * using Huffman codes with an 8-bit alphabet; and writes the results
     * to standard output.
     */
    public static void compress() {
        // read the input
        String string = BinaryStdIn.readString();
        char[] inputString = string.toCharArray();

        // tabulate frequency counts
        int[] frequencies = new int[R];
        for (int i=0; i < inputString.length; i++)
            frequencies[inputString[i]]++;

        // build Huffman trie
        Node rootNode = buildTrie(frequencies);

        // build code table
        String[] str = new String[R];
        buildCode(str, rootNode, "");

        // print trie for decoder
        writeTrie(rootNode);

        // print number of bytes in original uncompressed message
        BinaryStdOut.write(inputString.length);

        // use Huffman code to encode input
        for (int i = 0; i < inputString.length; i++) {
            String codedStr = str[inputString[i]];
            for (int j = 0; j < codedStr.length(); j++) {
                if (codedStr.charAt(j) == '0') {
                    BinaryStdOut.write(false);
                }
                else if (codedStr.charAt(j) == '1') {
                    BinaryStdOut.write(true);
                }
                else throw new IllegalStateException("Illegal state");
            }
        }
        // close output stream
        BinaryStdOut.close();
    }


    /**
     * Reads a sequence of bits that represents a Huffman-compressed message from
     * standard input; expands them; and writes the results to standard output.
     */
    public static void decompress() {
        // read in Huffman trie from input stream
        Node rootNode = readTrie();

        // number of bytes to write
        int n = BinaryStdIn.readInt();

        // decode using the Huffman trie
        for (int i = 0; i < n; i++) {
            Node curr = rootNode;
            while (!curr.isLeaf()) {
                boolean boolBit = BinaryStdIn.readBoolean();
                if (boolBit)
                    curr = curr.right;
                else
                    curr = curr.left;
            }
            BinaryStdOut.write(curr.ch, 8);
        }
        BinaryStdOut.close();
    }

    // build the Huffman trie given frequencies
    private static Node buildTrie(int[] freq) {

        // initialze priority queue with singleton trees
        MinPQ<Node> pq = new MinPQ<Node>();
        for (char i = 0; i < R; i++)
            if (freq[i] > 0)
                pq.insert(new Node(i, freq[i], null, null));

        // special case in case there is only one character with a nonzero frequency
        if (pq.size() == 1) {
            if (freq['\0'] == 0) pq.insert(new Node('\0', 0, null, null));
            else                 pq.insert(new Node('\1', 0, null, null));
        }

        // merge two smallest trees
        while (pq.size() > 1) {
            Node left  = pq.delMin();
            Node right = pq.delMin();
            Node parent = new Node('\0', left.freq + right.freq, left, right);
            pq.insert(parent);
        }
        return pq.delMin();
    }


    // write bitstring-encoded trie to standard output
    private static void writeTrie(Node x) {
        if (x.isLeaf()) {
            BinaryStdOut.write(true);
            BinaryStdOut.write(x.ch, 8);
            return;
        }
        BinaryStdOut.write(false);
        writeTrie(x.left);
        writeTrie(x.right);
    }

    // make a lookup table from symbols and their encodings
    private static void buildCode(String[] st, Node x, String s) {
        if (!x.isLeaf()) {
            buildCode(st, x.left,  s + '0');
            buildCode(st, x.right, s + '1');
        }
        else {
            st[x.ch] = s;
        }
    }



    private static Node readTrie() {
        boolean isLeaf = BinaryStdIn.readBoolean();
        if (isLeaf) {
            return new Node(BinaryStdIn.readChar(), -1, null, null);
        }
        else {
            return new Node('\0', -1, readTrie(), readTrie());
        }
    }

    /**
     * Sample client that calls {@code compress()} if the command-line
     * argument is "compress" an {@code decompress()} if it is "decompress".
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        if      (args[0].equals("compress")) compress();
        else if (args[0].equals("decompress")) decompress();
        else throw new IllegalArgumentException("Illegal command line argument");
    }

}