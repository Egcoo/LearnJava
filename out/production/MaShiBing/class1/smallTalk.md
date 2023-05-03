```markdown
1.O估计的是一个数学指标的上限。
2.先看时间复杂度，再分析实际样本下的运行时间。
3.异或运算可以理解为 “无进位相加”
4. 异或运算满足 1）0^N = N  N^N=0
    2)交换律、结合律
5.问题1：一个数组中，只有一个数出现奇数次，剩余全出现偶数次
如何找出那个奇数次的数？
一个交换程序去异或，最后剩下的就是奇数次
int end = 0 然后把数组从头异或到尾 end = end^arr[0]
   end = end^arr[1]  end = end^arr[2]
因为异或次序可以换，就变成了先异或第一批偶数的数字，然后第二批出现偶数次的数字，最后是奇数词。
   
 问题2：一个数组中，有两个数出现奇数次，其余全部偶数次，找出来两个奇数次。
   优化问题从两个方向入手：1）数据状况特殊导致可以优化 2）问题特殊可优化
    只要你左右两侧与所求问题有关，而且确定可以甩掉一边，就可以二分。

递归可以理解为一个利用系统栈的过程，利用系统栈玩了一个后序遍历
每一个节点通过自己的子节点给自己汇总信息以后返回


Master公式使用条件：一切符合子问题规模等规模
```