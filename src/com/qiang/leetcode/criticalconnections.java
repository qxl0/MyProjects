package com.qiang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one duplicate number in nums, return this duplicate number.

Follow-ups:

How can we prove that at least one duplicate number must exist in nums?
Can you solve the problem without modifying the array nums?
Can you solve the problem using only constant, O(1) extra space?
Can you solve the problem with runtime complexity less than O(n2)?
Input: nums = [1,3,4,2,2]
Output: 2
 */
public class criticalconnections {
    int time = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer>[] graph = new List[n];
        buildGraph(graph, connections);

        int[] disc = new int[n];
        int[] low = new int[n];
        int[] parents = new int[n];
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        Arrays.fill(parents, -1);

        for (int i=0;i<n;i++){
            if (disc[i] == -1){
                dfs(i, parents, low, disc, res, graph);
            }
        }
        return res;
    }

    private void dfs(int start, int[] parents, int[] low, int[] disc, List<List<Integer>> res, List<Integer>[] graph){
        if (disc[start] != -1) return;

        low[start] = disc[start] = time++;
        for (int v: graph[start]){
            if (disc[v] == -1){
                parents[v] = start;
                dfs(v, parents, low,disc,res,graph);

                if (low[v] > disc[start]){
                    res.add(Arrays.asList(start,v));
                }

                low[start] = Math.min(low[start], low[v]);
            } else if (parents[start] != v){
                low[start] = Math.min(low[start], disc[v]);
            }
        }
    }

    private void buildGraph(List<Integer>[] graph, List<List<Integer>> connections){
        for (List<Integer> c: connections){
            int a = c.get(0);
            int b = c.get(1);
            if (graph[a] == null){
                graph[a] = new ArrayList<>();
            }

            if (graph[b] == null){
                graph[b] = new ArrayList<>();
            }

            graph[a].add(b);
            graph[b].add(a);
        }
    }
}
