package com.yeojiin.ddd.study.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.yeojiin.ddd.study.constant.Message.INVALID_UNDER_ZERO;

@DisplayName("주문 항목 테스트")
public class OrderLineTest {
    Product book;

    @DisplayName("구매가격은 0보다 커야한다")
    @ParameterizedTest()
    @ValueSource(ints = {0, -1})
    void overZeroAmountTest(int amount) {
        OrderLine orderLine = OrderLine.of(book, 25000, 2);

        Assertions.assertThatThrownBy(() -> OrderLine.of(book, amount, 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_UNDER_ZERO);
    }

    @DisplayName("구매가격은 상품가격과 갯수의 곱이다")
    @Test
    void calculateAmountTest() {
        OrderLine orderLine = OrderLine.of(book, 25000, 2);

        Assertions.assertThat(orderLine.getAmounts()).isEqualTo(50000);
    }
}
