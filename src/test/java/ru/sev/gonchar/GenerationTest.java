package ru.sev.gonchar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenerationTest {

    @Test
    void generate() {
        Generation generation  = new Generation();;
        generation.generate(15);
    }
}