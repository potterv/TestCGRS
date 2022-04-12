package ru.sev.gonchar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenerationTest {
    private Generation generation;

    @BeforeAll
    void start() {
        this.generation = new Generation();
    }

    @Test
    void generate() {

        generation.generate(15);
    }

    @Test
    void gen() {
        generation.gen();
    }
}