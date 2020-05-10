package SortAlgorithm;

/**
 * 排序算法的测试器
 */
public class SortTest {
    public SortTest(){
        System.out.println(1);
    }

    public void SortTest(){
        System.out.println(2);
    }

    public static void main(String[] args) {
        int[] arr = {1,3,6,2,8,5,3,9,12,21,16};
        SortAlgorithm.heapSort(arr);
        for (int i : arr){
            System.out.println(i);
        }
        SortTest s = new Sort();
        s.SortTest();
    }
}

class Sort extends SortTest{
    public Sort(){
        System.out.println(3);
    }

    @Override
    public void SortTest() {
        System.out.println(4);
    }
}
