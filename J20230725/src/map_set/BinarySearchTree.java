package map_set;


/**
 * 模拟实现二叉搜索树
 */
public class BinarySearchTree {
    //节点内部类
    static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    //root节点
    private TreeNode root;

    /**
     * 查找与val相等值的节点
     * @param val 查找值
     * @return 返回是否查找成功： true/false
     */
    public boolean search(int val) {
        TreeNode cur = root;
        while (cur != null) {
            if (val < cur.val) {
                //在cur的左边
                cur = cur.left;
            } else if (val > cur.val) {
                //在cur的右边
                cur = cur.right;
            } else {
                //找到了
                return true;
            }
        }
        return false;//没有找到的情况
    }

    /**
     * 插入新节点
     * 1）root不为空 2）查找新节点的插入位置【即查找父亲节点】 3）判断插入位置在父亲节点的左边还是右边
     * @param val 插入值
     * @return 返回是否插入成功
     */
    public boolean insert(int val) {
        TreeNode node = new TreeNode(val);//申请节点
        //root为空，把插入的节点直接赋给root
        if (root == null) {
            root = node;
            return true;
        }
        //root不为空，找到相对应的位置进行插入
        TreeNode cur = root;
        //设置父亲节点：节点插入
        TreeNode parent = null;
        while (cur != null) {
            //判断查找node.val的值是在树的什么位置
            if (val < cur.val) {
                //更新父亲节点和遍历节点
                parent = cur;
                cur = cur.left;
            } else if (val > cur.val) {
                //更新父亲节点和遍历节点
                parent = cur;
                cur = cur.right;
            } else {
                //二叉搜索树中不存在值相等的节点
                return false;
            }
        }
        //cur为空后跳出循环

        //进行左右插入的判断
        if (val < parent.val) {
            parent.left = node;
        } else {
            parent.right = node;
        }
        return true;
    }


    /**
     * 删除节点：找到待删除节点的位置，进行删除
     * @param val 待删除值
     */
    public void remove(int val) {
        TreeNode cur = root;//待删除值的节点
        TreeNode parent = null;//待删除值的父亲节点

        while (cur != null) {
            //判断val的值处于那个位置
            if (val < cur.val) {
                parent = cur;
                cur = cur.left;
            } else if (val > cur.val) {
                parent = cur;
                cur = cur.right;
            } else {
                //删除节点
                removeNode(cur, parent);
                break;
            }
        }
    }

    /**
     * 删除节点
     * 1）待删除节点的左孩子为null 2）待删除节点的右孩子为空 3）待删除节点的左右孩子皆不为空
     * @param deleteNode 待删除节点
     * @param parent     待删除节点的父亲节点
     */
    private void removeNode(TreeNode deleteNode, TreeNode parent) {
        if (deleteNode.left == null) { //待删除节点的左边为null
            if (deleteNode == root) { //待删除节点是root节点
                root = root.right;
            } else if (deleteNode == parent.left) { //待删除节点是父亲节点的左孩子
                parent.left = deleteNode.right;
            } else { //待删除节点是父亲节点的右孩子
                parent.right = deleteNode.right;
            }
        } else if (deleteNode.right == null) { //待删除节点的右边为空
            if (deleteNode == root) { //待删除节点是root节点
                deleteNode = deleteNode.left;
            } else if (deleteNode == parent.left) { //待删除节点是父亲节点的左孩子
                parent.left = deleteNode.left;
            } else { //待删除节点是父亲节点的右孩子
                parent.right = deleteNode.left;
            }
        } else { //待删除节点的左右孩子皆不为空
            TreeNode targetParent = deleteNode; //目标父亲节点
            TreeNode target = deleteNode.right; //目标节点
            //查找最右边节点的第一个最左边的节点值
            while (target.left != null) {
                targetParent = target;
                target = target.left;
            }
            //最左边的节点值作为删除节点的值【即覆盖】
            deleteNode.val = target.val;

            //判断目标节点在目标父亲节点的左边还是右边
            if (target == targetParent.left) {
                targetParent.left = target.right;//指向target的右孩子
            } else {
                targetParent.right = target.right;
            }
        }
    }
}