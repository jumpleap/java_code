package datastrcture;


public class BinarySearchTree {
    static class TreeNode {
        private int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private TreeNode root;

    /**
     * 查找节点
     */
    public boolean search(int val) {
        TreeNode cur = root;
        while (cur != null) {
            if (val < cur.val) {
                cur = cur.left;
            } else if (val > cur.val) {
                cur = cur.right;
            } else {
                //找到了
                return true;
            }
        }
        //没找到
        return false;
    }

    /**
     * 插入节点
     */
    public boolean insert(int val) {
        TreeNode node = new TreeNode(val);
        if (root == null) {
            root = node;
            return true;
        }

        TreeNode cur = root;
        TreeNode parent = null;


        while (cur != null) {
            if (val < cur.val) {
                parent = cur;
                cur = cur.left;
            } else if (val > cur.val) {
                parent = cur;
                cur = cur.right;
            } else {
                //二叉搜索树中的值不能相同
                return false;
            }
        }

        if (parent.val < val) {
            parent.right = node;
        } else {
            parent.left = node;
        }
        return true;
    }

    /**
     * 删除节点
     */
    public void remove(int val) {
        TreeNode cur = root;
        TreeNode parent = null;

        while (cur != null) {
            if (cur.val < val) {
                parent = cur;
                cur = cur.right;
            } else if (cur.val > val) {
                parent = cur;
                cur = cur.left;
            } else {
                //找到了要删除的节点
                removeNode(parent, cur);
                break;
            }
        }
    }

    private void removeNode(TreeNode parent, TreeNode cur) {
        if (cur.left == null) { //要删除节点的左边为空
            if (cur == root) { //左边为空且为根节点
                root = root.right;
            } else if (cur == parent.left) { //cur左边为空, 且cur在parent的左边
                //让parent的左边直接直到cur的右边
                parent.left = cur.right;
            } else { // cur为空且cur在parent的右边
                parent.right = cur.right;
            }

        } else if (cur.right == null) { //cur的右边为空
            if (cur == root) { //cur的右边为空且cur是根节点
                root = root.left;
            } else if (cur == parent.left) { //cur的右边为空且cur在parent的左边
                parent.left = cur.left;
            } else { // cur的右边为空且cur在parent的右边
                parent.right = cur.left;
            }

        } else { //cur的左右都不为空
            TreeNode targetParent = cur;
            TreeNode target = cur.right;

            //一直找, 找到最右边节点的最左边的值
            while (target.left != null) {
                targetParent = target;
                target = target.left;
            }
            //替换掉要删掉的值
            cur.val = target.val;
            //把target的节点删掉
            if (target == targetParent.left) {
                //target在最左边, 左边为空, 右边不为空, 且target在targetParent的左边
                targetParent.left = target.right;
            } else {
                //target在最左边,左边为空, 右边不为空, 且target在targetParent的右边
                targetParent.right = target.right;
            }
        }
    }
}