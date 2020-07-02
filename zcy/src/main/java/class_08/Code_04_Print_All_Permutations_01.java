package class_08;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Code_04_Print_All_Permutations_01 {

	/**
	 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
	 *
	 * 示例:
	 *
	 * 输入: [1,2,3]
	 * 输出:
	 * [
	 *   [1,2,3],
	 *   [1,3,2],
	 *   [2,1,3],
	 *   [2,3,1],
	 *   [3,1,2],
	 *   [3,2,1]
	 * ]
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/permutations
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * @param nums
	 * @return
	 */
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        helper(nums, 0, res);
        return res;
    }

    private void helper(int[] nums, int i, List<List<Integer>> res) {
        if (i == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            res.add(list);
        }
        for (int j = i; j < nums.length; j++) {
            swap(nums, i, j);
            helper(nums, i + 1, res);
            swap(nums, i, j);
        }
    }

    //======================================================


	/**
	 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
	 *
	 * 示例:
	 *
	 * 输入: [1,1,2]
	 * 输出:
	 * [
	 *   [1,1,2],
	 *   [1,2,1],
	 *   [2,1,1]
	 * ]
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/permutations-ii
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		helper1(nums,0,res);
		return res;
	}
	private void helper1(int[] nums, int i, List<List<Integer>> res){
		if(i == nums.length){
			List<Integer> list = new ArrayList<>();
			for(int num : nums){
				list.add(num);
			}
			res.add(list);
		}
		Set<Integer> set = new HashSet<>();
		for(int j = i; j < nums.length;j++){
			if(!set.contains(nums[j])){
				set.add(nums[j]);
				swap(nums,i,j);
				helper(nums,i+1,res);
				swap(nums,i,j);
			}
		}
	}

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
