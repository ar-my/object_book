package com.jenson.object.domain.discount.condition;

import com.jenson.object.domain.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
