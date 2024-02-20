import java.util.NoSuchElementException;
import java.util.Stack;

public class PostorderAVLTreeIterator<E extends Comparable<? super E>> implements Iterator<E> {
    private final Stack<AVLTree.TreeNode<E>> stack1, stack2;

    public PostorderAVLTreeIterator(AVLTree.TreeNode<E> root) {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.empty()) {
            AVLTree.TreeNode<E> node = stack1.pop();
            stack2.push(node);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }
    }

    @Override
    public boolean hasNext() {
        return !stack2.empty();
    }

    @Override
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return stack2.pop().val;
    }
}
