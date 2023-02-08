package com.yeojiin.ddd.study.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("주문 항목 테스트")
public class OrderLineTest {

    Product book;

    @DisplayName("구매가격은 상품가격과 갯수의 곱이다")
    @Test
    void calculateAmountTest() {
        OrderLine orderLine = OrderLine.of(book, 25000, 2);

        Assertions.assertThat(orderLine.getAmounts()).isEqualTo(50000);
    }
}
