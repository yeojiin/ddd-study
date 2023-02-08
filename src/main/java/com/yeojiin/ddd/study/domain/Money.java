package com.yeojiin.ddd.study.domain;

import java.util.Objects;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return value == money.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
