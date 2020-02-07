package AdvancedAlgorithm;

import java.util.*;

/**
 * 大楼轮廓问题，超难
 */
public class BuildingOutline {

    //Node存储新的信息
    private static class Node{
        /**
         * @isUp 上下信息
         * @posi 起始/终止位置
         * @h    大楼高度
         */
        private boolean isUp;
        private int posi;
        private int h;

        private Node(boolean isUp,int posi,int h){
            this.isUp = isUp;
            this.posi = posi;
            this.h = h;
        }
    }

    //比较器
    public static class NodeComparator implements Comparator<Node>{
        @Override
        //比较Node的位置，进行排序
        public int compare(Node o1, Node o2) {
            if (o1.posi != o2.posi) {
                return o1.posi - o2.posi;
            }
            if (o1.isUp != o2.isUp) {
                return o1.isUp ? -1 : 1;
            }
            return 0;
        }
    }

    public static List<List<Integer>> buildingOutline(int[][] buildings){
        Node[] nodes = new Node[buildings.length * 2];
        //生成信息数组
        for (int i=0;i<buildings.length;i++){
            nodes[i*2] = new Node(true,buildings[i][0],buildings[i][2]);
            nodes[i*2+1] = new Node(false,buildings[i][1],buildings[i][2]);
        }

        //位置排序
        Arrays.sort(nodes,new NodeComparator());
        //htMap 高度Map，key为高度，value为高度的次数
        TreeMap<Integer,Integer> htMap = new TreeMap<>();
        TreeMap<Integer,Integer> pmMap = new TreeMap<>();

        //遍历数组，获取信息
        for (int i=0;i<nodes.length;i++) {
            if (nodes[i].isUp) {
                if (!htMap.containsKey(nodes[i].h)) {
                    htMap.put(nodes[i].h, 1);
                } else {
                    htMap.put(nodes[i].h, htMap.get(nodes[i].h) + 1);
                }
            } else {
                //此处和比较器有关，因此可能出现在同一个地方发生两种变化
                //上升在前，下降在后，因此在插入的时候必然会存在该节点
                if (htMap.containsKey(nodes[i].h)) {
                    if (htMap.get(nodes[i].h) == 1) {
                        htMap.remove(nodes[i].h);
                    } else {
                        htMap.put(nodes[i].h, htMap.get(nodes[i].h) - 1);
                    }
                }
            }

            //收集每一个位置的最大高度
            //此处Map为空的含义有两层
            //一是开始的时候，没有数据，高度为0
            //二是一组建筑结束的时候，没有高度了，当前的高度设为0
            if (htMap.isEmpty()) {
                pmMap.put(nodes[i].posi, 0);
            } else {
                pmMap.put(nodes[i].posi, htMap.lastKey());
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        int start = 0;
        int height = 0;
        for (Map.Entry<Integer,Integer> entry : pmMap.entrySet()) {
            int curPos = entry.getKey();
            //curMaxHeight为当前实际上的高度
            int curMaxHeight = entry.getValue();

            //heigth 为不变的高度
            if (height != curMaxHeight) {
                //高度不等于当前最大高度同时也不为0
                if (height != 0) {
                    List<Integer> newRecord = new ArrayList<Integer>();
                    /**
                     * @start 不变高度的起始位置
                     * @curPos 不变高度的终止位置
                     * @height 不变的高度
                     */
                    newRecord.add(start);
                    newRecord.add(curPos);
                    newRecord.add(height);
                    res.add(newRecord);
                }
                //如果当前没有高度即为0，证明是轮廓线的开始
                //刷新记录
                start = curPos;
                height = curMaxHeight;
            }
        }
        return res;
    }
}
