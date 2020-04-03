package Offer;

/**
 * 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 * 解题思路：序列的最后一个值是根节点，那么从根节点向前找，找到最后一个大于它的数
 *          它左边是根节点的左子树，右边是右子树
 *          左子树里面有一个比根节点大的都不成立
 *          然后分别对左右子树进行上述的操作
 *
 * 还有一种解法：就是栈的压入弹出顺序，将中序遍历也就是序列排序后视为压入顺序，查看后序遍历是否是中序遍历的一种顺序
 *              如果是，那么就成立，不是就不成立
 */
public class VerifySquenceOfBST_23 {
    public boolean verifySquenceOfBST_1(int [] sequence) {
        if(sequence == null || sequence.length == 0) return false;
        if(sequence.length == 1) return true;
        return helper(sequence, 0, sequence.length - 1);
    }

    private boolean helper(int[] arr, int start, int root){
        if(start >= root){
            return true;
        }
        int i = root;
        //找到最后一个大于根节点的位置
        //也就是右子树的开头位置
        while(i > start && arr[i-1] > arr[root]){
            i--;
        }
        //如果左子树有一个大于根节点的就不成立
        for(int j=start;j<i-1;j++){
            if(arr[j] > arr[root]) return false;
        }
        //对左右子树也执行上述的逻辑
        return helper(arr,start,i-1) && helper(arr,i,root-1);
    }

    public boolean verifySquenceOfBST_2(int [] sequence) {
        int size = sequence.length - 1;
        if(size==-1)return false;

        int i = 0;
        while(size > 0)
        {
            //左子树小于根节点
            while(sequence[i]<sequence[size]){
                i++;
            }
            //右子树大于根节点
            while(sequence[i]>sequence[size]){
                i++;
            }

            //结束的时候i一定是位于size的位置上，不然就是中间出现了小于根节点的数
            if(i<size) return false;
            i=0;
            size--;
        }
        return true;
    }
}
