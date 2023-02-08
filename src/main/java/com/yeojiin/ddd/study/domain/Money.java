package com.yeojiin.ddd.study.domain;
public class Money {
    private int value;

    public Money(int value) {
        this.value = value;
    }

    public static Money from(int value) {
        return new Money(value);
    }

    public Money add(int addValue) {
        return Money.from(value + addValue);
    }




}
