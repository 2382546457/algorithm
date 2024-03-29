package com.xiaohe.贪心.魔塔游戏;

import java.util.PriorityQueue;

/**
 * 小扣当前位于魔塔游戏第一层，共有 N 个房间，编号为 0 ~ N-1。
 * 每个房间的补血道具/怪物对于血量影响记于数组 nums，其中正数表示道具补血数值，即血量增加对应数值；负数表示怪物造成伤害值，即血量减少对应数值；0 表示房间对血量无影响。
 * 小扣初始血量为 1，且无上限。假定小扣原计划按房间编号升序访问所有房间补血/打怪，为保证血量始终为正值，小扣需对房间访问顺序进行调整，
 * 每次仅能将一个怪物房间（负数的房间）调整至访问顺序末尾。请返回小扣最少需要调整几次，才能顺利访问所有房间。若调整顺序也无法访问完全部房间，请返回 -1。
 *
 * 解题思路:
 * 按照原计划访问所有房间，当访问到第 i 个房间时，如果生命值小于等于 0，那么必须对之前的房间访问顺序进行调整：
 *      1. 显然选择第 i 个房间之后的房间是没有意义的，它并不会改变当前的生命值减少的情况；
 *      2. 因此只能选择第 i 个房间及之前的房间。对于所有可选的房间，无论将哪个房间调整至末尾，都不会改变最终的生命值（因为数组nums的和不会变化）。
 *         由于希望调整的次数最少，因此应当贪心地选择最小的那个 nums[j] 调整至末尾，使得当前的生命值尽可能高。
 * 解题步骤:
 *      1. 使用小根堆将所有访问过的负数房间放进去
 *      2. 如果当前房间放问之后，角色的血量<0了，从之前访问的负数房间中取出影响血量最大的，记录补血次数
 *      3. 当所有房间遍历完成后，还需要将补过的血重新加上，如果生命值小于等于 0，说明无解。
 */
class Solution {
    public int magicTower(int[] arr) {
        int count = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        // 角色的初始血量
        long hp = 1;
        // 角色补过的血, 负数
        long delay = 0;
        for (int i = 0; i < arr.length; i++) {
            // 如果这个房间扣血，记录到小根堆
            if (arr[i] < 0) {
                queue.offer(arr[i]);
            }
            hp = hp + arr[i];
            // 如果角色要死了，就从扣过的血中补
            if (hp <= 0) {
                count++;
                int poll = queue.poll();
                hp = hp - poll;
                delay = delay + poll;
            }
        }
        hp += delay;
        if (hp <= 0) {
            return -1;
        }
        return count;
    }
}