package com.yeojiin.ddd.study.domain;

import com.yeojiin.ddd.study.constant.OrderState;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.yeojiin.ddd.study.constant.Message.ADDRESS_IS_NOT_EMPTY;
import static com.yeojiin.ddd.study.constant.Message.AT_LEAST_ONE_ORDER_LINE;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("주문 테스트")
public class OrderTest {

    ShippingInfo shippingInfo = ShippingInfo.of(Receiver.of("yeojiin", "01012345678"), Address.of("add1", "add2", "add3"));

    @DisplayName("최소 한 종류 이상의 상품을 주문해야 함")
    @Test
    void atLeastOneOrderLineTest() {
        Assertions.assertThatThrownBy(() -> Order.of(new ArrayList<>(), shippingInfo, OrderState.PAYMENT_WAITING))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(AT_LEAST_ONE_ORDER_LINE);
    }

    @DisplayName("정상 주문 테스트")
    @Test
    void validOrderTest() {
        OrderLine orderLine1 = OrderLine.of(new Product(), 10000, 1);
        OrderLine orderLine2 = OrderLine.of(new Product(), 25000, 2);
        List<OrderLine> orderLines = List.of(orderLine1, orderLine2);

        Order order = Order.of(orderLines, shippingInfo, OrderState.PAYMENT_WAITING);

        assertAll(
                () -> Assertions.assertThat(order.getOrderLines().size()).isEqualTo(2),
                () -> Assertions.assertThat(order.getTotalAmounts()).isEqualTo(Money.from(60000))
        );
    }
}
