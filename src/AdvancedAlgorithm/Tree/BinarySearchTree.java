package AdvancedAlgorithm.Tree;

import BasicConstructure.TreeNode;

/**
 * 搜索二叉树的查找，添加，删除
 */
public class BinarySearchTree {
    public TreeNode root;
    protected int size;
    //搜索二叉树的查找
    public TreeNode search(int element){
        TreeNode head = root;
        //此情况假设所有的节点均被复制
        while (head != null && head.val != element ){
            if (head.val > element){
                head = head.left;
            }
            else {
                head = head.right;
            }
        }
        return head;
    }

    //搜索二叉树的插入
    public TreeNode insert(int element){
        TreeNode node = root;
        if (node == null){
            node = new TreeNode(element);
            size++;
            return node;
        }

        //insertParentNode 记录需要插入节点的父节点
        TreeNode insertParentNode = null;
        while (node != null){
            insertParentNode = node;
            if (node.val > element){
                node = node.left;
            }
            else {
                node = node.right;
            }
        }

        //记录并插入节点
        TreeNode newNode = new TreeNode(element);
        if (insertParentNode.val > element){
            insertParentNode.left = newNode;
        }
        else {
            insertParentNode.right = newNode;
        }

        size++;
        return newNode;
    }

    //搜索二叉树的删除
    public void delete(int element){
        TreeNode deleteNode = search(element);
        if (deleteNode != null){
            //如果要删除节点的左子树为空，就让其右子树挂在删除节点的父节点上
            if (deleteNode.left == null){
                transplant(deleteNode,deleteNode.right);
            }
            //如果要删除节点的右子树为空，就让其左子树挂在删除节点的父节点上
            else if (deleteNode.right == null){
                transplant(deleteNode,deleteNode.left);
            }
            else{
                //找到右子树的最左节点
                TreeNode successorNode = getMin(deleteNode.right);
                if (successorNode.parent != deleteNode){
                    //将successorNode的右孩子赋给它父亲的左孩子
                    transplant(successorNode,successorNode.right);
                    //这两步是successorNode去代替deleteNode的过程
                    //调整deleteNode节点的右孩子的关系
                    successorNode.right = deleteNode.right;
                    successorNode.right.parent = successorNode;
                }
                //调整successorNode节点的父关系
                transplant(deleteNode,successorNode);
                //deleteNode的左孩子给successorNode
                successorNode.left = deleteNode.left;
                successorNode.left.parent = successorNode;
            }
            size--;
        }

    }

    private void transplant(TreeNode targetNode, TreeNode newNode){
        if (targetNode.parent == null){
            this.root = newNode;
        }
        else if (targetNode == targetNode.parent.left){
            targetNode.parent.left = newNode;
        }
        else {
            targetNode.parent.right = newNode;
        }

        if (newNode != null){
            newNode.parent = targetNode.parent;
        }
    }

    private TreeNode getMin(TreeNode node){
        while (node.left != null){
            node = node.left;
        }
        return node;
    }
}
