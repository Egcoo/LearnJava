package HashTable03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @ author Egcoo
 * @ date 2022/8/17 - 18:25
 */
public class intersection349 {

    //1.高效的 set 来实现
    public int[] intersection2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length== 0){
            return new int[0];
        }
        Set<Integer> set = new HashSet<>();
        Set<Integer> reset = new HashSet<>();

        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i)){
                reset.add(i);
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

    //1.我能想到的第一种方法就是 for 循环的遍历查找
    // 使用 hashSet 来记录
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();
        for (int j : nums1) {
            for (int k : nums2) {
                if (j == k) {
                    if (!set.contains(k)) {
                        set.add(j);
                    }
                    break;
                }
            }
        }
        int[] res = new int[set.size()];
        Iterator<Integer> iterator = set.iterator();
        int k = 0;
        while (iterator.hasNext()) {
            res[k] = (int) iterator.next();
            k++;
        }

        return res;

    }
}
