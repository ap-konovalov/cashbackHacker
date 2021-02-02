package ru.netology.cashbackhacker.unit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.netology.cashbackhacker.CashbackService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CashbackServiceTest {

    protected CashbackService service;

    @BeforeEach
    public void setUp() {
        service = new CashbackService();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/multipleOfThousandSums.csv", numLinesToSkip = 1)
    public void whenSumMultipleOfThousand_ThenNoRemain(int sum) {
        int remain = service.remain(sum);
        int expectedRemain = 0;
        assertEquals(expectedRemain, remain);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/notMultipleOfThousandSums.csv", numLinesToSkip = 1)
    public void whenSumNotMultipleOfThousand_ThenNeedRemain(int sum, int expectedRemain) {
        int remain = service.remain(sum);
        assertEquals(expectedRemain, remain);
    }

    @Test
    public void whenSumIsNegative_ThenThrowException() {
        int sum = -1000;
        String expectedExceptionMessage = "amount must be greater than zero";
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> service.remain(sum));
        assertEquals(expectedExceptionMessage, thrown.getMessage());
    }
}
