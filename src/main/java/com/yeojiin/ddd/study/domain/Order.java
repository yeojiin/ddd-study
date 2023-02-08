package com.yeojiin.ddd.study.domain;

import com.yeojiin.ddd.study.constant.OrderState;

import java.util.List;

public class Order {
    private List<OrderLine> orderLines;
    private ShippingInfo shippingInfo;
    private int totalAmounts;
    private OrderState orderState;

}
