public class BinaryTreeNode {
    private String letter;
    private BinaryTreeNode left;

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    protected BinaryTreeNode right;

    public BinaryTreeNode(String elem){
        letter = elem;
        left = null;
        right = null;

    }

}
