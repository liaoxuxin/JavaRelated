package datastructurealgorithm.tree;

import java.util.*;

public class TreeOrder {
    //递归前序遍历
    public void preOrder(TreeNode node) {
        if(node == null) {
            return;
        }
        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
    //非递归前序遍历
    public void preOrder2(TreeNode node) {
        if (node == null) {
            return;
        }
        Deque<TreeNode> st = new LinkedList<>();
        st.push(node);
        while (st.size() != 0) {
            TreeNode tmp = st.pop();
            System.out.print(tmp.val + " ");
            if (tmp.right != null) {
                st.push(tmp.right);
            }
            if (tmp.left != null) {
                st.push(tmp.left);
            }
        }
    }

    //递归中序遍历
    public void inOrder(TreeNode node) {
        if(node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.val + " ");
        inOrder(node.right);
    }
    //非递归中序遍历
    public void inOrder2(TreeNode node) {
        if (node == null) {
            return;
        }
        Deque<TreeNode> st = new LinkedList<>();
        st.push(node);
        while (st.peek().left != null) {
            st.push(st.peek().left);
        }
        while (st.size() != 0) {
            TreeNode tmp = st.pop();
            System.out.print(tmp.val + " ");
            if (tmp.right != null) {
                st.push(tmp.right);
                while (st.peek().left != null) {
                    st.push(st.peek().left);
                }
            }
        }
    }

    //递归后序遍历
    public void postOrder(TreeNode node) {
        if(node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + " ");
    }
    //非递归后序遍历
    public void postOrder2(TreeNode node) {
        if (node == null) {
            return;
        }
        Deque<TreeNode> st = new LinkedList<>();
        st.push(node);
        List<TreeNode> res = new ArrayList<>();
        while (st.size() != 0) {
            TreeNode tmp = st.pop();
            res.add(tmp);
            if (tmp.left != null) {
                st.push(tmp.left);
            }
            if (tmp.right != null) {
                st.push(tmp.right);
            }
        }
        Collections.reverse(res);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i).val + " ");
        }
    }

    //层序遍历
    public void levelOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node);
        while (q.size() != 0) {
            TreeNode tmp = q.poll();
            System.out.print(tmp.val + " ");
            if (tmp.left != null) {
                q.offer(tmp.left);
            }
            if (tmp.right != null) {
                q.offer(tmp.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeOrder treeOrder = new TreeOrder();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(5);
        root.left.right.right = new TreeNode(11);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(9);
        root.right.right.left = new TreeNode(4);

        System.out.println("递归前序遍历：");
        treeOrder.preOrder(root);
        System.out.println();
        System.out.println("非递归前序遍历：");
        treeOrder.preOrder2(root);
        System.out.println();

        System.out.println("递归中序遍历：");
        treeOrder.inOrder(root);
        System.out.println();
        System.out.println("非递归中序遍历：");
        treeOrder.inOrder2(root);
        System.out.println();

        System.out.println("递归后序遍历：");
        treeOrder.postOrder(root);
        System.out.println();
        System.out.println("非递归后序遍历：");
        treeOrder.postOrder2(root);
        System.out.println();

        System.out.println("层序遍历：");
        treeOrder.levelOrder(root);
        System.out.println();
    }
}