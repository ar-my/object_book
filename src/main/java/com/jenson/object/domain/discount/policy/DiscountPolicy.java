package com.jenson.object.domain.discount.policy;

import com.jenson.object.domain.Money;
import com.jenson.object.domain.Screening;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
