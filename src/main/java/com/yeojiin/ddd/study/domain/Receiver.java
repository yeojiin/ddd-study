package com.yeojiin.ddd.study.domain;

import java.util.Objects;

public class Receiver {
    private String name;
    private String phoneNumber;

    public Receiver(String name, String phoneNumber) {
        verifyReciverName(name);
        verifyPhoneNumber(phoneNumber);
    }

    private void verifyPhoneNumber(String phoneNumber) {
        if(phoneNumber == null || phoneNumber.isBlank()) {
            throw new IllegalArgumentException("휴대폰 번호는 필수값 입니다.");
        }
        this.phoneNumber = phoneNumber;
    }

    private void verifyReciverName(String name) {
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 필수값 입니다.");
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
