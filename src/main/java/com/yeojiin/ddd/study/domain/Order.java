package com.yeojiin.ddd.study.domain;

import com.yeojiin.ddd.study.constant.OrderState;

import java.util.List;

public class Order {
    private List<OrderLine> orderLines;
    private ShippingInfo shippingInfo;
    private Money totalAmounts;
    private OrderState orderState;

    public Order(List<OrderLine> orderLines, ShippingInfo shippingInfo, int totalAmounts, OrderState orderState) {
        verifyOrderLines(orderLines);
        verifyShippingInfo(shippingInfo);
        calculateTotalAmounts();
        this.orderState = orderState;
    }

    private void verifyOrderLines(List<OrderLine> orderLines) {
        verifyAtLeastOneOrMoreOrderLines(orderLines);
        this.orderLines = orderLines;
    }
    public void calculateTotalAmounts() {
        int totalAmounts = orderLines.stream()
                .mapToInt(o -> o.getAmounts())
                .sum();
        this.totalAmounts = new Money(totalAmounts);
    }
    private void verifyAtLeastOneOrMoreOrderLines(List<OrderLine> orderLines) {
        if(orderLines == null || orderLines.isEmpty()) {
            throw new IllegalArgumentException("최소 한 종류 이상의 상품을 주문해야 합니다");
        }
    }

    private void verifyShippingInfo(ShippingInfo shippingInfo) {
        verifyShippingInfoIsNotEmpty(shippingInfo);
        this.shippingInfo = shippingInfo;
    }

    private void verifyShippingInfoIsNotEmpty(ShippingInfo shippingInfo) {
        if(shippingInfo == null) {
            throw new IllegalArgumentException("배송지 정보는 필수값 입니다.");
        }
    }




}
