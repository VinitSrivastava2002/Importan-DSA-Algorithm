import java.util.*;

public class Sliding_Window {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
//        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));

        List<Integer> result = maxSlidingWindow1(nums, k);

        // Print the results
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    // Naive solution time complexity is O(n*k) and space complexity is O(1)
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int j, max;
        int index = 0;
        int[] res = new int[nums.length-k + 1];
        for(int i=0;i<=nums.length-k;i++){
            max = nums[i];

            for(j=1;j<k;j++){
                if(nums[i+j] > max){
                    max = nums[i+j];
                }
            }
            res[index++] = max;
        }
        return res;
    }

    // AVL tree/Max heap approach time complexity is O(nlogn) and space complexity is O(k)
    public static ArrayList<Integer> maxSlidingWindow1(int[] nums, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        ArrayList<Integer> res = new ArrayList<>();
        int i=0;
        for(;i<k;i++){
            pq.add(nums[i]);
        }
        res.add(pq.peek());
        pq.remove(nums[0]);

        for(;i<nums.length;i++){
            pq.add(nums[i]);
            res.add(pq.peek());
            pq.remove(nums[i] - k +1);
        }
        return res;
    }

}
