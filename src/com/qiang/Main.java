package com.qiang;

import com.qiang.leetcode.criticalconnections;
import com.qiang.leetcode.duplicatenumbers;
import com.qiang.shared.helper;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //System.out.println("hello");
        //criticalconnections cn = new criticalconnections();
        // Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
        // Output: [[1,3]]
        // Explanation: [[3,1]] is also accepted.

//        int[][] c = {{0,1}, {1,3}, {2,3}, {1,2}};
//        int[][] d = {{0,1}, {1,2}, {2,0}, {1,4}, {2,3},{3,4}};
//        //String s = "[[0,1],[1,2],[2,0],[1,3]]";
//        //String s = "[[7], [2,2,3]]";
//        List<List<Integer>> t = helper.toListList(d);
//
//        var res = cn.criticalConnections(5, t);
        int[] nums = {1,3,4,2,2};
        duplicatenumbers dn = new duplicatenumbers();
        var res = dn.findDuplicate(nums);
        System.out.println(res);
    }
}
