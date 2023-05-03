package Array01.slidingWindow;

import java.util.List;

/**
 * @ author Egcoo
 * @ date 2022/8/12 - 23:28
 */
/*
 算法程序如何展开
 1. 又简单到复杂
    1.1 验证一步走一步
    1.2 多打印中间结果
 2. 先局部后整体
    2.1没思路时先细分
 3. 先粗糙后精细
    3.1变量更名
    3.2语句合并
    3.3边界处理
 */
public class totalFruit904 {
    public static void main(String[] args) {

    }

    // 本题这个还是使用滑动窗口，滑动窗口的主要在研究移动前面的位置

    /*
    class Solution {
    public:
    int totalFruit(vector<int>& fruits) {
       int left =0,right = 0,ans = 0;
       int ln=fruits[left],rn=fruits[right]; //篮子一号和二号
       while(right < fruits.size())
       {
        if(fruits[right] == rn || fruits[right] == ln){//属于篮子某个种类
            ans = max(ans,right + 1 - left);  //更新结果，每次取一个数就更新一下
            right++;
        }else{//如果遇到第三种，把慢指针移动到快指针前一步，该步的水果种类必然不同于快指针，此时慢指针慢慢回退齐所有的连续同类。（秒啊）
            left = right - 1;  //取到第三种则移动左标到right -1
            ln = fruits[left]; //更新第一个篮子
            while(left >= 1 && fruits[left - 1] == ln) left--; //更新第一个篮子的起始位置
            rn = fruits[right];
            ans = max(ans,right + 1 - left);
            }
       }
        return ans;
    }
};
     */

    //1.我的方法是单纯使用数组进行遍历
    public static int totalFruit(int[] fruits) {
        int left = 0, right = 0, ans = 0;
        int ln = fruits[left], rn = fruits[right]; // 篮子一号和篮子二号
        while (right < fruits.length) {
            if (fruits[right] == ln || fruits[right] == rn) {
                ans = Math.max(ans, right + 1 - left); // 更新结果，每添加一个就更新一回
                right++;
            } else {
                //如果遇到第三种，把慢指针移动到快指针前一步，
                // 该步的水果种类必然不同于快指针，此时慢指针慢慢回退齐所有的连续同类。（秒啊）
                left = right - 1; //取到第三种则移动左标到right -1
                ln = fruits[left]; // 更新第一个篮子
                while (left >= 1 && fruits[left - 1] == ln) {
                    left--;
                }
                rn = fruits[right];
            }
        }
        return ans;
    }
}
