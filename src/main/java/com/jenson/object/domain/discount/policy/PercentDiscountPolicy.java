package com.jenson.object.domain.discount.policy;

import com.jenson.object.domain.Money;
import com.jenson.object.domain.Screening;
import com.jenson.object.domain.discount.condition.DiscountCondition;

public class PercentDiscountPolicy extends DefaultDiscountPolicy {
    private double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
