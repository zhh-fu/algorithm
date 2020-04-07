package SortAlgorithm;

/**
 * 排序算法的测试器
 */
public class SortTest {
    public static void main(String[] args) {
        int[] arr = {1,3,6,2,8,5,3,9,12,21,16};
        SortAlgorithm.heapSort(arr);
        for (int i : arr){
            System.out.println(i);
        }
    }
}
