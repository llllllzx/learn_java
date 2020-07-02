package basic_class_01;

/**
 * @author liuzhaoxin
 * <p>
 * 统一的二分查找版本
 */
public class Code_13_Binary_Search {
    public static int binary_search(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 直接返回
                return mid;
            }
        }
        // 直接返回
        return -1;
    }

    public static int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，锁定左侧边界
                right = mid - 1;
            }
        }
        // 最后要检查 left 越界的情况
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }


    public static int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，锁定右侧边界
                left = mid + 1;
            }
        }
        // 最后要检查 right 越界的情况
        if (right < 0 || nums[right] != target)
            return -1;
        return right;
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 7, 11};
        final int i = minEatingSpeed(arr, 8);
        System.out.println(i);
    }


    //koko吃香蕉问题
    public static int minEatingSpeed(int[] piles, int H) {
        int left = 1;
        int right = 0;
        for (int pile : piles) {
            right = Math.max(pile, right);
        }

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (canFinish(piles, mid, H)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;

    }

    public static boolean canFinish(int[] piles, int speed, int H) {
        int h = 0;
        for (int pile : piles) {
            h += (pile / speed) + ((pile % speed) == 0 ? 0 : 1);
        }
        return h <= H;
    }



    //在 D 天内送达包裹的能力

    /**
     *输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
     * 输出：15
     * 解释：
     * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
     * 第 1 天：1, 2, 3, 4, 5
     * 第 2 天：6, 7
     * 第 3 天：8
     * 第 4 天：9
     * 第 5 天：10
     *
     * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int shipWithinDays(int[] weights, int D) {
        //最小载重量
        int left = 0;
        int right = 0;
        for(int weight : weights){
            right += weight;
            left = Math.max(left,weight);
        }
        while(left <= right){
            int mid = left + ((right - left) >> 1);
            if(canFinish1(weights,mid,D)){
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
    public static boolean canFinish1(int[] weights,int cap,int D){
        int i = 0;
        for(int d = 0;  d < D;d++){
            int maxCap = cap;
            while((maxCap -= weights[i]) >= 0 ){
                i++;
                if(i == weights.length){
                    return true;
                }
            }
        }
        return false;
    }

}
