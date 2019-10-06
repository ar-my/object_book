package com.jenson.object.domain.discount.policy;

import com.jenson.object.domain.Money;
import com.jenson.object.domain.Screening;
import com.jenson.object.domain.discount.condition.DiscountCondition;

public class AmountDiscountPolicy extends DefaultDiscountPolicy {
    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return this.discountAmount;
    }
}
