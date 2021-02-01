package ru.netology.cashbackhacker;

public class CashbackService {
    private final int boundary = 1000;

    public int remain(int amount) {
        return boundary - amount % boundary;
    }
}
