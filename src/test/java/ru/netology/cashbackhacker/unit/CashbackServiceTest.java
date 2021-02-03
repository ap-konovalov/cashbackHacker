package ru.netology.cashbackhacker.unit;

import org.junit.jupiter.api.BeforeEach;
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
    @CsvFileSource(resources = "/validSums.csv", numLinesToSkip = 1)
    public void whenSumIsValid_ThenCalculateRemain(int sum, int expectedRemain) {
        int remain = service.remain(sum);
        assertEquals(expectedRemain, remain);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/invalidSums.csv", numLinesToSkip = 1)
    public void whenSumIsInvalid_ThenThrowException(int sum) {
        String expectedExceptionMessage = "amount must be greater than zero";
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> service.remain(sum));
        assertEquals(expectedExceptionMessage, thrown.getMessage());
    }
}
