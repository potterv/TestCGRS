package ru.sev.gonchar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generation {
    //    Константное знаяение количество последовательностей
    private static final int COUNTSEQUENCE = 5;
    //    Констнтное значение минимального количества элементов в последовательностях
    private static final int MIN = 10;
    //    Констнтное значение максимальное количества элементов в последовательностях
    private static final int MAX = 100;
    //    Длина последовательностей
    private int length;
    //    Коллекйия последовательностей
    private int[][] collect = new int[5][this.length];

    // Установка длины последовательностей
    public void setLength(int length) {
        this.length = length;
    }

    //    Метод для генерации 5 - ти последовательностей простых чисел
    public void generate(int length) {
        int[] one = new int[length];
        if (length >= 1) one[0] = 2;
        int l = 1;
        for (int k = 3; k < length; k += 2) {
//            if (k>MIN && k<MAX)
            if (isPrime(k)) one[l] = k;
            l++;
        }

        Arrays.stream(one).forEach(System.out::println);

    }

    private boolean isPrime(int k) {
        for (int i = 3; i * i <= k; i += 2)
            if (k % i == 0) return false;
        return true;
    }

}
