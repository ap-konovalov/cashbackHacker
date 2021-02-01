package ru.netology.cashbackhacker.unit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.cashbackhacker.CashbackService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CashbackServiceTest {

    private CashbackService service;

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
        int sum = 300;
        int remain = service.remain(sum);
        int expectedRemain = 1000 - sum;
        assertEquals(expectedRemain, remain);
    }
}
