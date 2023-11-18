// HuffmanNode.java
public class HuffmanNode implements Comparable<HuffmanNode> {
    public String letter;
    public Double frequency;
    public HuffmanNode left, right;

    // Constructor for leaf nodes
    public HuffmanNode(String letter, Double frequency) {
        this.letter = letter;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }

    // Constructor for internal nodes
    public HuffmanNode(HuffmanNode left, HuffmanNode right) {
        this.letter = left.letter + right.letter; // Concatenating letters from children
        this.frequency = left.frequency + right.frequency; // Summing frequencies
        this.left = left;
        this.right = right;
    }

    // Compare nodes based on frequency for heap operations
    @Override
    public int compareTo(HuffmanNode other) {
        return this.frequency.compareTo(other.frequency);
    }

    // String representation of the Huffman Node
    @Override
    public String toString() {
        return "<" + letter + " " + frequency + ">";
    }
}
