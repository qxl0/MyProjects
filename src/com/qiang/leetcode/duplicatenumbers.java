package com.qiang.leetcode;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class duplicatenumbers {

    int[] ns;
    int n;
    public int findDuplicate(int[] nums) {
        ns = nums;
        n = ns.length - 1;
        for(int i = 1; i <= n + 1; i++){
            System.out.println("Calling find("+i+", true) inside the main()");
            int k = find(i, true);
            if(k > 0) return k;
        }
        return -1;
    }
    // if not found return 0 or -1, if found, return the number
    int find(int index, boolean start){
        System.out.println("find("+index+")");
        System.out.println("ns"+ Arrays.toString(ns)+" at pos "+ (index-1) +" = " + ns[index-1]);
        int j = ns[index - 1];

        System.out.println("j="+j);
        if(j == -1){
            System.out.println("return "+ (start ? -1 : index));
            return start ? -1 : index;
        }
        if(j == 0){
            ns[index - 1] = -1;
            System.out.print("set ns["+ (index-1) +"] to -1");
            System.out.println("   " + Arrays.toString(ns));
            return -1;
        }
        ns[index - 1] = start ? 0 : -1; // use -1 to indicated index has appeared
        System.out.print("set ns["+ (index-1)+"] to " + ns[index-1]);
        System.out.println("   " + Arrays.toString(ns));
        if(j == index){
            ns[index - 1] = -1;
            System.out.println("set ns["+ (index-1)+"] to " + ns[index-1] + ", ns="+ Arrays.toString(ns));
            System.out.println("return value is: "+ (start ? -1 : index));
            return start ? -1 : index;
        }
        else{
            System.out.println("call recursively find("+j+")");
            return find(j, false);
        }
    }
}
