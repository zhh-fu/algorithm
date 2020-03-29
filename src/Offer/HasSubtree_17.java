package Offer;

import BasicConstructure.TreeNode;

/**
 * 树的子结构
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
 * 注意：树的子结构和子树是不一样的！！！！
 */
public class HasSubtree_17 {
    /**
     * 子结构的两种做法
     * @param root1
     * @param root2
     * @return
     */
    //子结构：方法一
    private static boolean hasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if(root1 != null && root2 !=null){
            //直接从两棵树的头结点进行比较
            result = doesHasThisTree(root1, root2);

            //头结点不匹配，则从root1的左子树进行比较
            if (!result){
                result = hasSubtree(root1.left, root2);
            }
            //左子树都不匹配，则从root1的右子树进行比较
            if (!result){
                result = hasSubtree(root1.right, root2);
            }
        }
        //上述都不可以，返回false
        return result;
    }
    //子结构：方法二
    private static boolean hasSubtree_1(TreeNode root1, TreeNode root2) {
        //如果两树里有一棵树为空，即不成立
        //因为提示说空树不是任何树的子结构
        if(root2 == null || root1 == null) return false;
        /*
        if(root1 != null && root2 !=null){
            if (!result){
                result = doesHasThisTree(root1, root2);
            }
            if (!result){
                result = HasSubtree(root1.left, root2);
            }
            if (!result){
                result = HasSubtree(root1.right, root2);
            }
        }
        */
        /*
            分为三种可能性：
            1.root2是root1的整棵树的子结构，也就是两者的头结点相同
            2.root2是root1的左子树的子结构
            3.root2是root1的右子树的子结构
            然后root1的整棵树，左子树，右子树分别和root2进行匹配
        */

        return doesHasThisTree(root1, root2) || hasSubtree_1(root1.left, root2) || hasSubtree_1(root1.right, root2);
    }

    private static boolean doesHasThisTree(TreeNode root1, TreeNode root2){
        /*
            此处两个if判断的位置不能交换
            因为如果root1 = null直接返回false了，但是root2也为null的这种情况被忽略，会出错
            在这种情况下，子结构就蜕变成了子树，所以应该先判root2，再判root1
         */
        //root2完了证明遍历到了结尾，成功
        if (root2 == null) return true;
        //root2还没完，root1完了，肯定不匹配
        if (root1 == null) return false;

        //两者当前的头结点不相同，不匹配
        if (root1.val != root2.val){
            return false;
        }

        //上述都通过，则依次通过递归的方法对所有的节点进行匹配
        return doesHasThisTree(root1.left, root2.left) &&
                    doesHasThisTree(root1.right, root2.right);
    }

    /**
     * 子树的两种做法
     * 1、序列化
     * 2、递归
     * @param root1
     * @param root2
     * @return
     */
    //子树：方法一，序列化
    //思想是如果root2是root1的子树，那么root2序列化的序列必然是root1序列化后序列的子序列
    private static boolean isSubtree_1(TreeNode root1,TreeNode root2) {
        if(root2 == null) return false;
        String str1 = process(root1);
        String str2 = process(root2);

        return str1.contains(str2);

    }

    private static String process(TreeNode root){
        //null进行区分
        if(root == null){
            return "_#";
        }
        //注意分隔符的位置，如果“_”放在后面会影响判断
        //如12_和2_无法分辨，但是_12和_2则可以分清
        String str = "_" + root.val;

        str += process(root.left);
        str += process(root.right);
        return str;
    }

    //子树：方法二，递归
    private static boolean isSubtree_2(TreeNode s, TreeNode t) {
        //两树均为空，则必定相同
        if (s == null && t == null) return true;
        //一树为空，一树不为空，必定不相同
        if (s == null || t == null) return false;

        /*
            分为三种可能性：
            1.root2是root1的整棵树的子树，也就是两者的头结点相同
            2.root2是root1的左子树的子树
            3.root2是root1的右子树的子树
            然后root1的整棵树，左子树，右子树分别和root2进行匹配
        */
        return isEqual(s, t) || isSubtree_2(s.left, t) || isSubtree_2(s.right, t);

    }

    private static boolean isEqual(TreeNode root1, TreeNode root2){
        //两树均为空，则必定相同
        if (root2 == null && root1 == null) return true;
        //一树为空，一树不为空，必定不相同
        if (root1 == null || root2 == null) return false;

        //当前节点相同，再分别判断左右子树
        if (root1.val == root2.val){
            return doesHasThisTree(root1.left, root2.left) &&
                    doesHasThisTree(root1.right, root2.right);
        }
        //如果不想听则直接返回false；
        return false;
    }

    public static void main(String[] args){
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.left.left = new TreeNode(5);
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(4);
        //root2.left.left = new TreeNode(5);
        System.out.println(hasSubtree_1(root1, root2));
    }

}
