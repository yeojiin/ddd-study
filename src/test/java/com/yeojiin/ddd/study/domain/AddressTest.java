package com.yeojiin.ddd.study.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("주소 테스트")
public class AddressTest {
    @DisplayName("주소는 필수값 입니다.")
    @Test
    void AddressIsNotEmptyTest() {
        assertAll(
                () -> Assertions.assertThatThrownBy(() -> Address.of("주소1", "주소2", ""))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("주소는 필수값 입니다."),
                () -> Assertions.assertThatThrownBy(() -> Address.of("주소1", "", "주소3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("주소는 필수값 입니다.")
        );
    }
}
