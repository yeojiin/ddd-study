package com.yeojiin.ddd.study.constant;

public enum OrderState {
    PAYMENT_WAITING("결제 대기"), // 결제 대기 중(출고 전)
    PREPARING("상품 준비중"), // 상품 준비중(출고 전)
    SHIPPED("상품출고"),
    DELIVERING("배송중"),
    DELIVER_COMPLETED("배송완료"),
    PURCHASE_COMPLETED("구매완려");

    private String value;

    OrderState(String value) {
    }
}
