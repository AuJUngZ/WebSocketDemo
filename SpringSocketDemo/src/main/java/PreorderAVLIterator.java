import java.util.NoSuchElementException;
import java.util.Stack;

public class PreorderAVLIterator<E extends Comparable<? super E>> implements Iterator<E> {
    private Stack<AVLTree.TreeNode<E>> stack;

    public PreorderAVLIterator(AVLTree.TreeNode<E> root) {
        stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        AVLTree.TreeNode<E> node = stack.pop();
        E result = node.val;
        if (node.right != null) {
            stack.push(node.right);
        }
        if (node.left != null) {
            stack.push(node.left);
        }
        return result;
    }
}