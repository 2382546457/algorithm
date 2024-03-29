package 全排列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-03-03 13:00
 */
public class Solution {
//
//    private List<List<Integer>> result = new ArrayList<>();
//    public List<List<Integer>> permute(int[] nums) {
//        // 如果数组没有数，直接返回
//        if (nums == null || nums.length == 0) {
//            return result;
//        }
//        // 如果有数，开始遍历
//        process(nums, 0, new boolean[nums.length], new Stack<Integer>());
//
//
//        return result;
//    }
//    private void process(int[] nums, int depth, boolean[] used, Stack<Integer> stack) {
//        // 如果当前深度等于数组长度，结束
//        if (depth == nums.length) {
//            ArrayList<Integer> list = new ArrayList<>(stack);
//            result.add(list);
//            return;
//        }
//        // 如果没有，开始遍历
//        for (int i = 0; i < nums.length; i++) {
//            if (!used[i]) {
//                stack.add(nums[i]);
//                used[i] = true;
//                process(nums, depth+1, used, stack);
//                stack.pop();
//                used[i] = false;
//            }
//        }
//    }


        private List<List<Integer>> list = new ArrayList<>();
        private List<Integer> path = new ArrayList<>();
        private boolean[] check = null;

        public List<List<Integer>> permute(int[] nums) {
            check = new boolean[nums.length];
            dfs(nums);
            return list;

        }
        private void dfs(int[] nums) {
            if (path.size() == nums.length) {
                list.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (!check[i]) {
                    // 添加到数组中
                    path.add(nums[i]);
                    // 标记为用过
                    check[i] = true;

                    dfs(nums);
                    // 用完了
                    check[i] = false;
                    path.remove(path.size() - 1);
                }
            }
        }


    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> permute = s.permute(new int[]{0, 1});
        permute.stream().forEach(list -> {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        });

    }
}
