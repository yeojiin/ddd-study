package com.yeojiin.ddd.study.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
@DisplayName("주문자 테스트")
public class ReceiverTest {

    @DisplayName("주문자 명과 휴대폰 번호가 같으면 같은 주문인이다.")
    @Test
    void equalsTest3() {
        Receiver receiver1 = Receiver.of("yeojiin", "01012345678");
        Receiver receiver2 = Receiver.of("yeojiin", "01012345678");

        assertThat(receiver1).isEqualTo(receiver2);
    }

    @DisplayName("주문자 명과 휴대폰 번호 중 하나라도 가르면 다른 주문인이다.")
    @Test
    void equalsTest2() {
        Receiver receiver1 = Receiver.of("yeojiin", "01012345678");
        Receiver receiver2 = Receiver.of("yeojiin2", "01012345678");

        assertThat(receiver1).isNotEqualTo(receiver2);
    }

    @DisplayName("주문인 이름은 필수값 입니다.")
    @Test
    void NameIsNotEmptyTest() {

        assertAll(
                () -> Assertions.assertThatThrownBy(() -> Receiver.of("", "01012345678"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("이름은 필수값 입니다."),
                () -> Assertions.assertThatThrownBy(() -> Receiver.of(null, "01012345678"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("이름은 필수값 입니다.")
        );
    }

    @DisplayName("주문인 휴대폰 번호는 필수값 입니다.")
    @Test
    void PhoneNumberIsNotEmptyTest() {

        assertAll(
                () -> Assertions.assertThatThrownBy(() -> Receiver.of("yeojiin", ""))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("휴대폰 번호는 필수값 입니다."),
                () -> Assertions.assertThatThrownBy(() -> Receiver.of("yeojiin", null))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("휴대폰 번호는 필수값 입니다.")
        );
    }
}
