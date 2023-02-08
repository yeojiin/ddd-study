package com.yeojiin.ddd.study.domain;

import java.util.Objects;

public class OrderLine {
    private Product product;
    private int price;
    private int quantity;
    private int amounts;

    public OrderLine(Product product, int price, int quantity, int amounts) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.amounts = calculateAmounts();
    }

    private int calculateAmounts() {
        return price * quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderLine orderLine = (OrderLine) o;
        return price == orderLine.price && quantity == orderLine.quantity && amounts == orderLine.amounts && Objects.equals(product, orderLine.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, price, quantity, amounts);
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "product=" + product +
                ", price=" + price +
                ", quantity=" + quantity +
                ", amounts=" + amounts +
                '}';
    }

    public int getAmounts() {
        return this.amounts;
    }
}
