package ru.sev.gonchar.generations;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Generation {
    //    Константное знаяение количество последовательностей
    private static final int COUNTSEQUENCE = 5;
    private int count = COUNTSEQUENCE;
    private int i = 0;
    //    Констнтное значение минимального количества элементов в последовательностях
    private static final int MIN = 10;
    //    Констнтное значение максимальное количества элементов в последовательностях
    private static final int MAX = 100;
    //    Длина последовательностей
    private int length;
    //    Коллекйия последовательностей

    private Map<String, List<Integer>> sequence = new HashMap<>();
    private Map<String, List<Integer>> unicSequence = new HashMap<>();

    public void setCount(int count) {
        this.count = count;
    }

    // Установка длины последовательностей
    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    //    Метод для генерации последовательности  простых чисел заданой длины
    public List<Integer> generate() {
        int array[] = new int[this.length];
        List primeNumbers = new LinkedList<>();
        int i = 0;
        while (primeNumbers.size() < this.length) {
            int integer = gen();
            if (integer % 2 == 0) continue;
            if (isPrime(integer)) {
                primeNumbers.add(integer);
//                array[i] = (int) primeNumbers.get(i);
//                i++;
//                int k = primeNumbers.size();
//                System.out.println(k);
//                primeNumbers = (List) primeNumbers.stream().distinct().collect(Collectors.toList());
//                int b = primeNumbers.size();
//                System.out.println(b);
//                if (k == b) {
//                    array[i] = (int) primeNumbers.get(i);
//                    i++;
//                }
            }
        }
//        System.out.println(primeNumbers.size() + "  -  " + i);
        return primeNumbers;

    }

    //    Метод для генерации числа
    private int gen() {
        List intList = new Random().ints(1, MIN, MAX)
                .boxed()
                .collect(Collectors.toList());
        return (int) intList.get(0);
    }

    // Метод проверки на принадлежность числа к простому
    private boolean isPrime(int number) {
        return IntStream.rangeClosed(2, (int) (Math.sqrt(number)))
                .allMatch(n -> number % n != 0);
    }

    public Map<String, List<Integer>> getSequence() {
        if (count <= 5 && count >= 1 && i < COUNTSEQUENCE) {
            sequence.put(Integer.toString(i), this.generate());

            count--;
            i++;
        }
        return sequence;
    }

    public Map<String, List<Integer>> getUnicSequence() {

        List<Integer> unicElements = new LinkedList<>();
        for (int t = 0; t <= 5; t++) {
            getSequence();
        }
        int g = 0;
        for (List<Integer> elements : sequence.values()
        ) {
            elements = elements.stream().distinct().collect(Collectors.toList());
//            System.out.println(elements);
            if (elements.size() > 6) {
                unicElements.clear();
                int j = 0;
                unicElements.clear();
                while (j < 6) {
                    unicElements.add(elements.get(j));
                    j++;
                }
                unicSequence.put(Integer.toString(g), unicElements);
            }
            g++;
        }
        return unicSequence;
    }
    public Map<String, List<Integer>> getSequence1() {
        List<Integer> unicElements = new LinkedList<>();
        if (count <= 5 && count >= 1 && i < COUNTSEQUENCE) {
            sequence.put(Integer.toString(i), this.generate());
            unicElements.clear();
            unicElements=sequence.get(i).stream().distinct().collect(Collectors.toList());
            if (unicElements.size() > 6) {

                int j = unicElements.size();

                while (j > 6) {
                    unicElements.remove(j);
                    j--;
                }
                unicSequence.put(Integer.toString(i), unicElements);
            }
            count--;
            i++;
        }
        return sequence;
    }

}
