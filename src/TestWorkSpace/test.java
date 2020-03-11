package TestWorkSpace;

import BasicConstructure.TreeNode;

import java.util.Arrays;

public class test {
    public static void main(String[] args){
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//        root.right.left = new TreeNode(6);
//        System.out.println(serializedInOrder(root));
        System.out.println(12%10);
    }

    private static void insertSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        for (int i = 1;i<arr.length;i++){
            int index = i;
            for (int j = i-1;j>=0;j--){
                if (arr[j] > arr[index]){
                    swap(arr,j,index);
                    index--;
                }
            }
        }
        //return arr;
    }
    static String str = null;
    private static String serializedInOrder(TreeNode root){
        if(root == null){
            return "#_";
        }

        str += serializedInOrder(root.left);
        str = root.value + "_";
        str += serializedInOrder(root.right);
        return str;
    }

    private static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
