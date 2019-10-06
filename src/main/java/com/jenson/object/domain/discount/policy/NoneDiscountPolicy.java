package com.jenson.object.domain.discount.policy;

import com.jenson.object.domain.Money;
import com.jenson.object.domain.Screening;

public class NoneDiscountPolicy implements DiscountPolicy {

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
