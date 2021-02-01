package ru.netology.cashbackhacker.unit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.cashbackhacker.CashbackService;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void WhenSumMultipleOf1000_ThenNoRemain() {
        int sum = (random.nextInt(100) + 1) * 1000;
        int remain = service.remain(sum);
        assertEquals(0, remain);
    }
}
