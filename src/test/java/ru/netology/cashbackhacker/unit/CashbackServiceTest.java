package ru.netology.cashbackhacker.unit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

    @Test
    public void WhenSumMultipleOfThousand_ThenNoRemain() {
        int sum = 1000;
        int remain = service.remain(sum);
        int expectedRemain = 0;
        assertEquals(expectedRemain, remain);
    }

    @Test
    public void WhenSumNotMultipleOfThousand_ThenNeedRemain() {
        int sum = 700;
        int remain = service.remain(sum);
        int expectedRemain = 300;
        assertEquals(expectedRemain, remain);
    }

    @Test
    public void WhenSumIsNegative_ThenThrowException() {
        int sum = -1000;
        assertThrows(IllegalArgumentException.class, () -> service.remain(sum));
    }
}
