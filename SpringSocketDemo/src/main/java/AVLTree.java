public class AVLTree<E extends Comparable<? super E>> implements Tree<E> {
    static class TreeNode<E extends Comparable<? super E>> {
        E val;
        TreeNode<E> left, right;
        public TreeNode(E val) {
            this.val = val;
        }
        public TreeNode(E val, TreeNode<E> left, TreeNode<E> right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public static int height(TreeNode<?> t) {
            if (t == null) return 0;
            int lh = height(t.left);
            int rh = height(t.right);
            return Math.max(lh, rh) + 1;
        }

        public TreeNode<E> insert(E e) {
            // insert recursively
            TreeNode<E> l = left, r = right;
            if (e.compareTo(val) < 0) {
                l = l == null ? new TreeNode<>(e) : l.insert(e);
            }
            else
                r = r == null ? new TreeNode<>(e) : r.insert(e);
            // rebalance if needed
            return rebalance(val, l ,r);
        }

        private TreeNode<E> rebalance(E val, TreeNode<E> l, TreeNode<E> r) {
            int lh = height(l);
            int rh = height(r);
            if (lh - rh > 1) { // heavy left
                TreeNode<E> ll = l.left, lr = l.right;
                int llh = height(ll), lrh = height(lr);
                if (llh - lrh >= 0) { // case 1
                    r = new TreeNode<>(val, lr, r);
                    val = l.val;
                    l = ll;
                }
                else { // case 2
                    TreeNode<E> lrl = lr.left, lrr = lr.right;
                    r = new TreeNode<>(val, lrr, r);
                    val = lr.val;
                    l = new TreeNode<>(l.val, ll, lrl);
                }
            }
            else if (rh - lh > 1) { // heavy right
                TreeNode<E> rl = r.left, rr = r.right;
                int rlh = height(rl), rrh = height(rr);
                if (rlh - rrh > 0) { // case 3
                    TreeNode<E> rll = rl.left, rlr = rl.right;
                    l = new TreeNode<>(val, l, rll);
                    val = rl.val;
                    r = new TreeNode<>(r.val, rlr, rr);
                }
                else { // case 4
                    l = new TreeNode<>(val, l, rl);
                    val = r.val;
                    r = rr;
                }
            }
            return new TreeNode<>(val, l, r);
        }
    }

    private TreeNode<E> root;

    @Override
    public void add(E e) {
        if (root == null)
            root = new TreeNode<>(e);
        else
            root = root.insert(e);
    }

    @Override
    public Iterator<E> iterator(int i) {
        if(i == 2){
            return new PostorderAVLTreeIterator<>(root);
        } else if(i == 1){
            return new PreorderAVLIterator<>(root);
        }
        return null;
    }
}