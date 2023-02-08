package com.yeojiin.ddd.study.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("주문자 테스트")
public class ReceiverTest {

    @DisplayName("주문자 명과 휴대폰 번호가 같으면 같은 주문인이다.")
    @Test
    void equalsTest3() {
        Receiver receiver1 = Receiver.of("yeojiin", "01012345678");
        Receiver receiver2 = Receiver.of("yeojiin", "01012345678");

        Assertions.assertThat(receiver1).isEqualTo(receiver2);
    }

    @DisplayName("주문자 명과 휴대폰 번호 중 하나라도 가르면 다른 주문인이다.")
    @Test
    void equalsTest2() {
        Receiver receiver1 = Receiver.of("yeojiin", "01012345678");
        Receiver receiver2 = Receiver.of("yeojiin2", "01012345678");

        Assertions.assertThat(receiver1).isNotEqualTo(receiver2);
    }
}
