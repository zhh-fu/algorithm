package TestWorkSpace;

import BasicConstructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class test {
    public static void main(String[] args){
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//        root.right.left = new TreeNode(6);
//        System.out.println(serializedInOrder(root));
    //    System.out.println(12%10);
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(0,1);
//        list.add(1,2);
//        list.add(1,3);
//        list.add(2,4);
//        list.add(2,5);
//        list.add(6);
//        list.add(7);
//        int a = 6;
//        for (int i=0;i<=list.size() - 1;i++){
//            System.out.println(list.get(i));
//        }
        //System.out.println((int)'z' - 65);
        /*
        Queue<TreeNode> q = new LinkedList<>();
        q.add(new TreeNode(1));
        q.add(new TreeNode(2));
        q.add(new TreeNode(3));
        q.add(null);
        q.add(null);
        q.add(new TreeNode(4));

        for (TreeNode node : q){
            if (node == null){
                System.out.println(" ");
            }else {
                System.out.println(node.val);
            }
        }
        */
        int[] arr = new int[3];
        help(arr);
        System.out.println(arr[1]);
        //System.out.println(120^2*1);
        TestInstance instance = TestInstance.getInstance();
        instance.hello();
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
        str = root.val + "_";
        str += serializedInOrder(root.right);
        return str;
    }

    private static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

     static void help(int[] arr){
        arr[1] = 5;
    }
}
