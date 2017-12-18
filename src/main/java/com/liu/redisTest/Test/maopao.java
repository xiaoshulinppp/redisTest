package com.liu.redisTest.Test;

public class maopao {
	static void bubble_sort(int[] unsorted)
    {
        for (int i = 0; i < unsorted.length; i++)
        {
            for (int j = i; j < unsorted.length; j++)
            {
                if (unsorted[i] > unsorted[j])
                {
                    int temp = unsorted[i];
                    unsorted[i] = unsorted[j];
                    unsorted[j] = temp;
                }
            }
        }
    }

    static void Main(String[] args)
    {
        int[] x = { 6, 2, 4, 1, 5, 9 };
        bubble_sort(x);
        
    }
}
