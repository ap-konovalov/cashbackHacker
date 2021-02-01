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
    final static int AMOUNT_SPENT_FOR_CASHBACK = 1000;

    @BeforeAll
    public static void initialize(){
        random = new Random();
    }

    @BeforeEach
    public void setUp() {
        service = new CashbackService();
    }

    @Test
    public void WhenSumMultipleOfThousand_ThenNoRemain() {
        int sum = AMOUNT_SPENT_FOR_CASHBACK * (random.nextInt(100) + 1);
        int remain = service.remain(sum);
        int expectedRemain = 0;
        assertEquals(expectedRemain, remain);
    }

    @Test
    public void WhenSumNotMultipleOfThousand_ThenNeedRemain() {
        int sum = AMOUNT_SPENT_FOR_CASHBACK + (random.nextInt(998) + 1);
        int remain = service.remain(sum);
        int expectedRemain =  AMOUNT_SPENT_FOR_CASHBACK - sum % AMOUNT_SPENT_FOR_CASHBACK;
        assertEquals(expectedRemain, remain);
    }

    @Test
    public void WhenSumIsNegative_ThenThrowException() {
        assertThrows(IllegalArgumentException.class, () -> service.remain(-1000));
    }
}
