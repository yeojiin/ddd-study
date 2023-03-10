package com.yeojiin.ddd.study.domain;

import com.yeojiin.ddd.study.constant.OrderState;

import java.util.List;

import static com.yeojiin.ddd.study.constant.Message.AT_LEAST_ONE_ORDER_LINE;
import static com.yeojiin.ddd.study.constant.Message.SHIPPING_INFO_IS_NOT_EMPTY;

public class Order {
    private OrderLines orderLines;
    private ShippingInfo shippingInfo;
    private Money totalAmounts;
    private OrderState orderState;

    public Order(OrderLines orderLines, ShippingInfo shippingInfo, OrderState orderState) {
        verifyOrderLines(orderLines);
        verifyShippingInfo(shippingInfo);
        calculateTotalAmounts();
        this.orderState = orderState;
    }

    public static Order of(List<OrderLine> orderLines, ShippingInfo shippingInfo, OrderState orderState) {
        return new Order(OrderLines.from(orderLines), shippingInfo, orderState);
    }
    public List<OrderLine> getOrderLines() {
        return orderLines.getOrderLines();
    }

    public Money getTotalAmounts() {
        return totalAmounts;
    }

    private void verifyOrderLines(OrderLines orderLines) {
        verifyAtLeastOneOrMoreOrderLines(orderLines);
        this.orderLines = orderLines;
    }
    public void calculateTotalAmounts() {
        this.totalAmounts = new Money(orderLines.getTotalAmounts());
    }
    private void verifyAtLeastOneOrMoreOrderLines(OrderLines orderLines) {
        if(orderLines == null || orderLines.isEmpty()) {
            throw new IllegalArgumentException(AT_LEAST_ONE_ORDER_LINE);
        }
    }

    private void verifyShippingInfo(ShippingInfo shippingInfo) {
        verifyShippingInfoIsNotEmpty(shippingInfo);
        this.shippingInfo = shippingInfo;
    }

    private void verifyShippingInfoIsNotEmpty(ShippingInfo shippingInfo) {
        if(shippingInfo == null) {
            throw new IllegalArgumentException(SHIPPING_INFO_IS_NOT_EMPTY);
        }
    }


}
