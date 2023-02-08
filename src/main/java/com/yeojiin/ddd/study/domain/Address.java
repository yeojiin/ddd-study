package com.yeojiin.ddd.study.domain;

import java.util.Objects;

import static com.yeojiin.ddd.study.constant.Message.ADDRESS_IS_NOT_EMPTY;

public class Address {
    private String address1;
    private String address2;
    private String address3;

    public Address(String address1, String address2, String address3) {
        verifyAddress(address1, address2, address3);
    }

    public static Address of(String address1, String address2, String address3) {
        return new Address(address1, address2, address3);
    }

    private void verifyAddress(String address1, String address2, String address3) {
        if(address1 == null || address1.isBlank()) {
            throw new IllegalArgumentException(ADDRESS_IS_NOT_EMPTY);
        }

        if(address2 == null || address2.isBlank()) {
            throw new IllegalArgumentException(ADDRESS_IS_NOT_EMPTY);
        }

        if(address3 == null || address3.isBlank()) {
            throw new IllegalArgumentException(ADDRESS_IS_NOT_EMPTY);
        }
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(address1, address.address1) && Objects.equals(address2, address.address2) && Objects.equals(address3, address.address3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address1, address2, address3);
    }
}
