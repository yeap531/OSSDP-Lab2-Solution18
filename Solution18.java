import java.util.*;

/*
 * @Description:
 *
 * 除自身以外数组的乘积
 * 给你一个整数数组 nums，返回数组 answer，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 题目数据保证数组 nums 之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内。
 * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 示例 1:
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 *  示例 2:
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 */

class Solution {

    /**
     * 计算除自身以外数组的乘积
     *
     * 算法思路：
     * 1. 对于每个位置i，结果等于其左侧所有元素的乘积 × 右侧所有元素的乘积
     * 2. 使用两个数组分别存储左侧和右侧的累积乘积
     * 3. 最后将左右乘积相乘得到结果
     *
     * 时间复杂度：O(n) - 遍历数组三次
     * 空间复杂度：O(n) - 使用了两个辅助数组L和R（不包括输出数组）
     *
     * @param nums 输入的整数数组
     * @return 除自身以外所有元素乘积的数组
     * @throws IllegalArgumentException 如果输入为null或长度小于2
     */
    public int[] productExceptSelf(int[] nums) {
        // 输入验证
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("数组长度必须至少为2");
        }
        int length = nums.length;

        // L 和 R 分别表示左右两侧的乘积列表
        int[] L = new int[length];
        int[] R = new int[length];

        int[] answer = new int[length];

        // 第一步：计算每个位置左侧的累积乘积
        // L[i] 为索引 i 左侧所有元素的乘积
        // 对于索引为 '0' 的元素，因为左侧没有元素，所以 L[0] = 1
        // 例如：nums=[1,2,3,4], L=[1,1,2,6]
        L[0] = 1;
        for (int i = 1; i < length; i++) {
            // L[i] = nums[0] × nums[1] × ... × nums[i-1]
            // 利用动态规划思想：L[i] = L[i-1] × nums[i-1]
            L[i] = nums[i - 1] * L[i - 1];
        }

        // 第二步：计算每个位置右侧的累积乘积
        // R[i] 为索引 i 右侧所有元素的乘积
        // 对于索引为 'length-1' 的元素，因为右侧没有元素，所以 R[length-1] = 1
        // 例如：nums=[1,2,3,4], R=[24,12,4,1]
        R[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            // R[i] = nums[i+1] × nums[i+2] × ... × nums[length-1]
            // 利用动态规划思想：R[i] = R[i+1] × nums[i+1]
            R[i] = nums[i + 1] * R[i + 1];
        }

        // 第三步：计算最终结果
        // 对于索引 i，除 nums[i] 之外其余各元素的乘积就是
        // 左侧所有元素的乘积 × 右侧所有元素的乘积
        // 例如：nums=[1,2,3,4], answer=[24,12,8,6]
        for (int i = 0; i < length; i++) {
            answer[i] = L[i] * R[i];
        }

        return answer;
    }
}