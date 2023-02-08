package com.yeojiin.ddd.study.domain;

import java.util.Objects;

import static com.yeojiin.ddd.study.constant.Message.NAME_IS_NOT_EMPTY;
import static com.yeojiin.ddd.study.constant.Message.PHONE_NUMBER_IS_NOT_EMPTY;

public class Receiver {
    private String name;
    private String phoneNumber;

    public Receiver(String name, String phoneNumber) {
        verifyReciverName(name);
        verifyPhoneNumber(phoneNumber);
    }

    private void verifyPhoneNumber(String phoneNumber) {
        if(phoneNumber == null || phoneNumber.isBlank()) {
            throw new IllegalArgumentException(PHONE_NUMBER_IS_NOT_EMPTY);
        }
        this.phoneNumber = phoneNumber;
    }

    private void verifyReciverName(String name) {
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException(NAME_IS_NOT_EMPTY);
        }
        this.name = name;
    }

    public static Receiver of(String name, String phoneNumber) {
        return new Receiver(name, phoneNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receiver receiver = (Receiver) o;
        return Objects.equals(name, receiver.name) && Objects.equals(phoneNumber, receiver.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber);
    }
}
