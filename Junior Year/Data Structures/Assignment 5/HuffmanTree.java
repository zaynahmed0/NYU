// HuffmanTree.java
import java.util.PriorityQueue;

public class HuffmanTree {
    HuffmanNode root;

    // Constructor to initialize the Huffman Tree with a given node
    public HuffmanTree(HuffmanNode huff) {
        this.root = huff;
    }

    // Print the Huffman coding legend
    public void printLegend() {
        printLegend(root, "");
    }

    // Helper method to recursively print the Huffman coding for each character
    private void printLegend(HuffmanNode node, String code) {
        if (node != null) {
            if (node.letter.length() == 1) { // Leaf node
                System.out.println(node.letter + "=" + code);
            } else { // Internal node
                printLegend(node.left, code + "0");
                printLegend(node.right, code + "1");
            }
        }
    }

    // Convert a legend string into a binary heap of Huffman nodes
    public static BinaryHeap<HuffmanNode> legendToHeap(String legend) {
        String[] parts = legend.split(" ");
        BinaryHeap<HuffmanNode> heap = new BinaryHeap<>();

        for (int i = 0; i < parts.length; i += 2) {
            String letter = parts[i];
            Double frequency = Double.parseDouble(parts[i + 1]);
            HuffmanNode node = new HuffmanNode(letter, frequency);
            heap.insert(node);
        }

        return heap;
    }

    // Create a Huffman Tree from a binary heap
    public static HuffmanTree createFromHeap(BinaryHeap<HuffmanNode> heap) {
        while (heap.getSize() > 1) {
            HuffmanNode left = heap.deleteMin();
            HuffmanNode right = heap.deleteMin();
            HuffmanNode combined = new HuffmanNode(left, right);
            heap.insert(combined);
        }

        return new HuffmanTree(heap.deleteMin());
    }

    // Main method for demonstration purposes
    public static void main(String[] args) {
        String legend = "A 20 E 24 G 3 H 4 I 17 L 6 N 5 O 10 S 8 V 1 W 2";
        BinaryHeap<HuffmanNode> heap = legendToHeap(legend);
        HuffmanTree huffmanTree = createFromHeap(heap);
        huffmanTree.printLegend();
    }
}
