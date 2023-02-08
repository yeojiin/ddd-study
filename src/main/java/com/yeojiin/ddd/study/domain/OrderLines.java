package com.yeojiin.ddd.study.domain;

import java.util.List;

public class OrderLines {
    private List<OrderLine> orderLines;

    public OrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public static OrderLines from(List<OrderLine> orderLines) {
        return new OrderLines(orderLines);
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public int getTotalAmounts() {
        return orderLines.stream()
                .mapToInt(o -> o.getAmounts())
                .sum();
    }

    public boolean isEmpty() {
        return orderLines.isEmpty();
    }


}
