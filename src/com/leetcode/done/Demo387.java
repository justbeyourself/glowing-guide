package com.leetcode.done;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * <p>
 * 示例：
 * s = "leetcode"
 * 返回 0
 * s = "loveleetcode"
 * 返回 2
 *  
 * <p>
 * 提示：你可以假定该字符串只包含小写字母
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author:
 * @create: 2020-08-21 16:19
 */
public class Demo387 {

    public static void main(String[] args) {
        System.out.println(firstUniqChar3("loveleetcode"));
    }

    public static int firstUniqChar1(String s) {
        int[] r = new int[26];
        char[] a = s.toCharArray();

        for (char c : a) {
            r[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (r[a[i] - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static int firstUniqChar2(String s) {
        Map<Character, Integer> r = new HashMap<>(26);
        char[] a = s.toCharArray();

        for (char c : a) {
            r.put(c, r.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (r.get(a[i]) == 1) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 写得短，执行时间并不短。
     * indexOf内嵌轮训
     * @param s
     * @return
     */
    public static int firstUniqChar3(String s) {

        for (int i = 0; i < s.length(); i++) {
            char r = s.charAt(i);
            if (s.indexOf(r) == s.lastIndexOf(r)) {
                return i;
            }
        }

        return -1;
    }
}
