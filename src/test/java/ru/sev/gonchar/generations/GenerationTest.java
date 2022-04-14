package ru.sev.gonchar.generations;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenerationTest {

    @Test
    public void generate() {
        Generation generation = new Generation();
        generation.generate().stream().forEach(System.out::println);
    }
    @Test
    void getSequence() {
        Generation generation = new Generation();
        generation.setLength(10);
        for (List<Integer> s:generation.getSequence().values()
             ) {
            s.stream().forEach(System.out::print);
            System.out.print(" ");
        }

    }

    @Test
    void getUnicSequence() {
        Generation generation = new Generation();
        generation.setLength(10);
        System.out.println(generation.getUnicSequence().values());;
    }
}