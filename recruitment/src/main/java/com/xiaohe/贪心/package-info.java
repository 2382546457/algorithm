/**
 * @Description :
 * @author : 小何
 * @date : 2024-02-02 18:38
 */
package com.xiaohe.贪心;

/*
    贪心算法，简而言之不要考虑太多太长远，只顾及眼前利益就行了。

比如 找零问题，当对方给我 20，我需要找零 15 时，有两种策略:
1. 找零 10 + 5
2. 找零 5 + 5 + 5
对于贪心算法而言，不需要考虑当前10元、5元的个数是否会对后面找零时出现影响，直接使用当前的最优策略即可，即找零 10 + 5, 因为 5 元更加珍贵。

比如 将数组和减半的最少操作次数，要想通过减小某一个元素让整个数组的值快速变成原来的一半，不需要考虑减小某个值后对其他值的影响，当前的最优解就是
每次将数组中最大的值减半。
 */