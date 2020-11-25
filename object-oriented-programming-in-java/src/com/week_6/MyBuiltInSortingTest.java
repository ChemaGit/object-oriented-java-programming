package com.week_6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MyBuiltInSortingTest {

    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> numsToSort = new ArrayList<Integer>();

        for(int i = 0; i < 5; i++) {
            numsToSort.add(random.nextInt(100));
        }
        Collections.sort(numsToSort);

        numsToSort.forEach(n -> System.out.println(n));
    }
}
