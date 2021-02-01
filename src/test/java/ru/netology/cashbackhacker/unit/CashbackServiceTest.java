package ru.netology.cashbackhacker.unit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.netology.cashbackhacker.CashbackService;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CashbackServiceTest {

    private CashbackService service;
    private static Random random;

    @BeforeAll
    public static void initialize() {
        random = new Random();
    }

    @BeforeEach
    public void setUp() {
        service = new CashbackService();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/multipleOfThousandSums.csv", numLinesToSkip = 1)
    public void WhenSumMultipleOfThousand_ThenNoRemain(int sum) {
        int remain = service.remain(sum);
        int expectedRemain = 0;
        assertEquals(expectedRemain, remain);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/notMultipleOfThousandSums.csv", numLinesToSkip = 1)
    public void WhenSumNotMultipleOfThousand_ThenNeedRemain(int sum, int expectedRemain) {
        int remain = service.remain(sum);
        assertEquals(expectedRemain, remain);
    }

    @Test
    public void WhenSumIsNegative_ThenThrowException() {
        int sum = -1000;
        assertThrows(IllegalArgumentException.class, () -> service.remain(sum));
    }
}
