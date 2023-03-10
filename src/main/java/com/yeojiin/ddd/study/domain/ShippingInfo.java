package com.yeojiin.ddd.study.domain;


public class ShippingInfo {
    private Receiver receiver;
    private Address address;

    public ShippingInfo(Receiver receiver, Address address) {
        this.receiver = receiver;
        this.address = address;
    }

    public static ShippingInfo of(Receiver receiver, Address address) {
        return new ShippingInfo(receiver, address);
    }
}
