package Offer;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 数据流的中位数
 *如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 *
 * 解题思路：使用大小根堆
 * 第一个数直接存进大根堆，后续的数和大根堆的堆顶作比较，大于它的都放进小根堆，小于它的都放进大根堆
 * 当两个堆的大小相差大于1的时候，从size大的堆里面取出堆顶元素放入另一个堆，平衡
 * 那么较小的N/2个数都放在大根堆中，较大的N/2个数都放在小根堆中
 */
public class MidNumber_63 {
    //小根堆
    private Queue<Integer> minHeap = new PriorityQueue<>();
    //大根堆
    private Queue<Integer> maxHeap = new PriorityQueue<>(new ComInteger());
    private int cnt = 0;
    public void Insert(Integer num) {
        if (cnt == 0){
            maxHeap.add(num);
        }else{
            //大于大根堆堆顶的都放进小根堆，小于它的都放进大根堆
            if (num > maxHeap.peek()){
                minHeap.add(num);
            }else{
                maxHeap.add(num);
            }
        }
        //当数量相差大于1的时候，平衡下
        if (Math.abs(maxHeap.size() - minHeap.size()) > 1){
            if (maxHeap.size() > minHeap.size()){
                minHeap.add(maxHeap.poll());
            }else{
                maxHeap.add(minHeap.poll());
            }
        }
        cnt++;
    }

    //注意一定是peek()，而不是poll()
    public Double GetMedian() {
        if (cnt % 2 == 1){
            //注意这个地方，奇数个元素的时候中位数一定是元素较多的那个堆的堆顶元素
            return (double) (minHeap.size() > maxHeap.size() ? minHeap.peek() : maxHeap.peek());
        }else{
            //偶数个元素的时候，是两个堆堆顶元素的和的一半
            return (double) (minHeap.peek() + maxHeap.peek())/2;
        }
    }

    class ComInteger implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }
}
