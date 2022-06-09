import java.util.Arrays;
import java.util.Iterator;

public class MorseTree implements MorseTreeADT {

    private BinaryTreeNode rootNode;

    public BinaryTreeNode getRootNode() {
        return rootNode;
    }

    public void setRootNode(BinaryTreeNode r) {
        rootNode = r;
    }

    public MorseTree() {
        rootNode = null;
    }

    public boolean isEmpty() {
        return rootNode == null;
    }

    /**
     * Inserts letters to the tree
     *
     * @param letter alphabetic letter from "morse.txt"
     * @param code   respective morse code
     */
    @Override
    public void insert(String letter, String code) {
        BinaryTreeNode newNode = new BinaryTreeNode(letter);

        if (isEmpty()) {
            BinaryTreeNode n = new BinaryTreeNode(" ");
            rootNode = n;
        }

        BinaryTreeNode curr = rootNode;
        BinaryTreeNode parent;
        char c;
        int i = 0;

        do {
            c = code.charAt(i);
            parent = curr;

            if (c == '.') {
                curr = curr.getLeft();
            } else if (c == '-') {
                curr = curr.getRight();
            }

            i++;

        } while (i != code.length() && curr != null);

        if (c == '.') {
            parent.setLeft(newNode);

        } else if (c == '-') {

            parent.setRight(newNode);
        }

    }


    /**
     * decodes one letter(code) at a time
     *
     * @param code each code in the line
     * @return decoded letter
     */
    public String decodeLetter(String code) {
        String letter = "";
        BinaryTreeNode current = rootNode;
        BinaryTreeNode parent;
        char c;
        int i = 0;
        do {
            parent = current;
            c = code.charAt(i);
            if (c == '.') {
                current = current.getLeft();
            } else if (c == '-') {
                current = current.getRight();
            }
            i++;

        } while (i != code.length() && current != null);

        if (c == '.') {
            letter = parent.getLeft().getLetter();
        } else if (c == '-') {
            letter = parent.getRight().getLetter();
        }

        return letter;
    }


    /**
     * Merges each decoded letter returned by decodeLetter() to form words
     * and merges each word to make it a phrase
     *
     * @param line each line from "translate.txt"
     * @return the decoded phrase
     */
    @Override
    public String decode(String line) {
        String[] words = line.split("  ");
        String word = "";
        String msg = "";

        for (int i = 0; i < words.length; i++) {
            String[] mCode = words[i].split(" ");
            for (String c : mCode) {
                word += decodeLetter(c);

            }

            if (i != words.length - 1) {
                word = word + " ";
            }

        }
        msg += word;


        return msg;
    }


    /**
     * Inorder traversal
     *
     * @param node the starting node
     */
    @Override
    public void printInorder(BinaryTreeNode node) {

        if (node != null) {

            printInorder(node.getLeft());
            System.out.print(node.getLetter() + "");
            printInorder(node.getRight());
        }

    }


    public void printInorder() {
        printInorder(rootNode);

    }

    /**
     * Preorder Traversal
     *
     * @param node the starting node
     */
    @Override
    public void printPreorder(BinaryTreeNode node) {

        if (node != null) {

            System.out.print(node.getLetter() + "");
            printPreorder(node.getLeft());
            printPreorder(node.getRight());
        }

    }


    public void printPreorder() {
        printPreorder(rootNode);
    }

    /**
     * Postorder Traversal
     *
     * @param node the starting node
     */
    @Override
    public void printPostorder(BinaryTreeNode node) {
        if (node != null) {

            printPostorder(node.getLeft());
            printPostorder(node.getRight());
            System.out.print(node.getLetter() + "");

        }


    }

    public void printPostorder() {
        printPostorder(rootNode);

    }


}























