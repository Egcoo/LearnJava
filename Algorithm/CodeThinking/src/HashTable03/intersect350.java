package HashTable03;

import java.util.*;

/**
 * @ author Egcoo
 * @ date 2022/8/17 - 19:24
 */
public class intersect350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length== 0){
            return new int[0];
        }
        List<Integer> set = new ArrayList<>();
        List<Integer> reset = new ArrayList<>();

        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i)){
                reset.add(i);
                // 从 set 除去已匹配的数值,如果不移除已经匹配过的数值，
                // reset中如果出现重复元素，依然会和set中已经匹配过的元素再次比较
                set.remove(i);
            }
        }
        int[] resArr = new int[reset.size()];
        int index = 0;
        //将结果转为数组
        for (int i : reset) {
            resArr[index] = i;
            index ++;
        }
        return resArr;
    }
}
