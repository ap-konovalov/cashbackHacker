package ru.netology.cashbackhacker;

public class CashbackService {
    private final int boundary = 1000;

    public int remain(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be greater than zero");
        }

        boolean isNeedMore = amount % boundary != 0;
        if (!isNeedMore) {
            return 0;
        }

        int remain = boundary - amount % boundary;
        return remain;
    }
}
