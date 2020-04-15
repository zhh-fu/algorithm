package Leetcode;

public class CollectRain {
    public static int trap(int[] height) {
        if(height == null || height.length < 3) return 0;
        int begin = 0, end = height.length - 1, sum = 0;
        int index=0;
        while(index < height.length - 1 && height[index] <= height[index+1]){
            index++;
        }
        begin = index;
        index = height.length - 1;
        while(index >= 1 && height[index] <= height[index-1]){
            index--;
        }
        end = index;
        if(begin >= end || begin == height.length - 1 || end == 0) return 0;
        int max = 0;
        for(int j=0;j<height.length;j++){
            if(height[max] < height[j]){
                max = j;
            }
        }
        index = begin + 1;
        while(begin <= max && index <= max){
            if(height[begin] > height[index]){
                sum += height[begin] - height[index];
            } else{
                begin = index;
            }
            index++;
        }

        index = end - 1;
        while(end >= max && index >= max){
            if(height[end] > height[index]){
                sum += height[end] - height[index];
            } else{
                end = index;
            }
            index--;
        }
        return sum;
    }

    public static int trap_2(int[] height) {
        if(height == null || height.length < 3) return 0;
        int left = 0, right = height.length - 1, sum = 0;
        int left_max = 0, right_max = height.length - 1;
        while(left < right) {
            if (height[left] < height[right]) {
                if(height[left] < height[left_max]){
                    sum += height[left_max] - height[left];
                } else{
                    left_max = left;
                }
                left++;
            } else {
                if(height[right] < height[right_max]){
                    sum += height[right_max] - height[right];
                } else{
                    right_max = right;
                }
                right--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap_2(arr));
    }
}
