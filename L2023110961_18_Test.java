import org.junit.Test;
import static org.junit.Assert.*;

/*
 * 测试用例设计总体原则：
 * 1. 等价类划分：正数、负数、包含0、单元素、多元素
 * 2. 边界值分析：数组长度边界（最小2个元素）、数值边界
 * 3. 特殊情况：包含0的数组、全负数、全正数、混合正负数
 */
public class L2023110961_18_Test {

    /**
     * 测试目的：验证基本功能 - 正整数数组
     * 测试用例：[1,2,3,4]
     * 预期输出：[24,12,8,6]
     * 等价类：正整数数组
     */
    @Test
    public void testBasicPositiveNumbers() {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4};
        int[] expected = {24, 12, 8, 6};
        assertArrayEquals(expected, solution.productExceptSelf(nums));
    }

    /**
     * 测试目的：验证包含0的情况
     * 测试用例：[-1,1,0,-3,3]
     * 预期输出：[0,0,9,0,0]
     * 等价类：包含0的混合数组
     */
    @Test
    public void testArrayWithZero() {
        Solution solution = new Solution();
        int[] nums = {-1, 1, 0, -3, 3};
        int[] expected = {0, 0, 9, 0, 0};
        assertArrayEquals(expected, solution.productExceptSelf(nums));
    }

    /**
     * 测试目的：验证边界条件 - 最小长度数组（2个元素）
     * 测试用例：[2,3]
     * 预期输出：[3,2]
     * 边界值：最小长度
     */
    @Test
    public void testMinimumLength() {
        Solution solution = new Solution();
        int[] nums = {2, 3};
        int[] expected = {3, 2};
        assertArrayEquals(expected, solution.productExceptSelf(nums));
    }

    /**
     * 测试目的：验证负数处理
     * 测试用例：[-2,-3,-4]
     * 预期输出：[12,8,6]
     * 等价类：全负数数组
     */
    @Test
    public void testAllNegativeNumbers() {
        Solution solution = new Solution();
        int[] nums = {-2, -3, -4};
        int[] expected = {12, 8, 6};
        assertArrayEquals(expected, solution.productExceptSelf(nums));
    }

    /**
     * 测试目的：验证包含1的情况
     * 测试用例：[1,1,1,1]
     * 预期输出：[1,1,1,1]
     * 特殊情况：全1数组
     */
    @Test
    public void testAllOnes() {
        Solution solution = new Solution();
        int[] nums = {1, 1, 1, 1};
        int[] expected = {1, 1, 1, 1};
        assertArrayEquals(expected, solution.productExceptSelf(nums));
    }

    /**
     * 测试目的：验证包含多个0的情况
     * 测试用例：[0,0,1]
     * 预期输出：[0,0,0]
     * 特殊情况：多个0
     */
    @Test
    public void testMultipleZeros() {
        Solution solution = new Solution();
        int[] nums = {0, 0, 1};
        int[] expected = {0, 0, 0};
        assertArrayEquals(expected, solution.productExceptSelf(nums));
    }

    /**
     * 测试目的：验证较大数组
     * 测试用例：[2,3,4,5]
     * 预期输出：[60,40,30,24]
     * 等价类：正整数数组（较长）
     */
    @Test
    public void testLargerArray() {
        Solution solution = new Solution();
        int[] nums = {2, 3, 4, 5};
        int[] expected = {60, 40, 30, 24};
        assertArrayEquals(expected, solution.productExceptSelf(nums));
    }

    /**
     * 测试目的：验证null输入的异常处理
     * 测试用例：null
     * 预期：抛出IllegalArgumentException
     * 边界值：异常输入
     */
    @Test(expected = IllegalArgumentException.class)
    public void testNullInput() {
        Solution solution = new Solution();
        solution.productExceptSelf(null);
    }

    /**
     * 测试目的：验证空数组的异常处理
     * 测试用例：[]
     * 预期：抛出IllegalArgumentException
     * 边界值：空数组
     */
    @Test(expected = IllegalArgumentException.class)
    public void testEmptyArray() {
        Solution solution = new Solution();
        solution.productExceptSelf(new int[]{});
    }

    /**
     * 测试目的：验证单元素数组的异常处理
     * 测试用例：[5]
     * 预期：抛出IllegalArgumentException
     * 边界值：长度为1的数组
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSingleElement() {
        Solution solution = new Solution();
        solution.productExceptSelf(new int[]{5});
    }

    /**
     * 测试目的：验证零在数组开头的情况
     * 测试用例：[0, 2, 3]
     * 预期输出：[6, 0, 0]
     * 特殊情况：单个0在开头
     */
    @Test
    public void testZeroAtBeginning() {
        Solution solution = new Solution();
        int[] nums = {0, 2, 3};
        int[] expected = {6, 0, 0};
        assertArrayEquals(expected, solution.productExceptSelf(nums));
    }

    /**
     * 测试目的：验证零在数组末尾的情况
     * 测试用例：[2, 3, 0]
     * 预期输出：[0, 0, 6]
     * 特殊情况：单个0在末尾
     */
    @Test
    public void testZeroAtEnd() {
        Solution solution = new Solution();
        int[] nums = {2, 3, 0};
        int[] expected = {0, 0, 6};
        assertArrayEquals(expected, solution.productExceptSelf(nums));
    }

    /**
     * 测试目的：验证奇数个负数的情况
     * 测试用例：[-2, 3, -4]
     * 预期输出：[-12, 8, -6]
     * 等价类：奇数个负数（结果包含负数）
     */
    @Test
    public void testOddNumberOfNegatives() {
        Solution solution = new Solution();
        int[] nums = {-2, 3, -4};
        int[] expected = {-12, 8, -6};
        assertArrayEquals(expected, solution.productExceptSelf(nums));
    }

    /**
     * 测试目的：验证偶数个负数的情况
     * 测试用例：[-2, -3, 4]
     * 预期输出：[-12, -8, 6]
     * 等价类：偶数个负数（部分结果为正）
     */
    @Test
    public void testEvenNumberOfNegatives() {
        Solution solution = new Solution();
        int[] nums = {-2, -3, 4};
        int[] expected = {-12, -8, 6};
        assertArrayEquals(expected, solution.productExceptSelf(nums));
    }

    /**
     * 测试目的：验证包含-1的情况
     * 测试用例：[-1, 2, -1, 3]
     * 预期输出：[-6, 3, -6, 2]
     * 特殊情况：包含-1的混合数组
     */
    @Test
    public void testWithNegativeOne() {
        Solution solution = new Solution();
        int[] nums = {-1, 2, -1, 3};
        int[] expected = {-6, 3, -6, 2};
        assertArrayEquals(expected, solution.productExceptSelf(nums));
    }
}
