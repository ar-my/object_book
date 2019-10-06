package com.jenson.object;

import com.jenson.object.domain.*;
import com.jenson.object.domain.discount.condition.PeriodCondition;
import com.jenson.object.domain.discount.condition.SequenceCondition;
import com.jenson.object.domain.discount.policy.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.*;

@RunWith(SpringRunner.class)
public class MovieTest {

    private DiscountPolicy discountPolicy;

    @Test
    public void create_avatar_test() {
        discountPolicy = new AmountDiscountPolicy(
                Money.wons(800),
                new SequenceCondition(1),
                new SequenceCondition(10),
                new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59)));

        Movie avatar = new Movie("아바타",
                Duration.ofMinutes(120),
                Money.wons(10000),
                discountPolicy);

        Screening screening = new Screening(avatar, 1, LocalDateTime.now());

        System.out.println("avatar = " + avatar);
        System.out.println("calculateFee = " + avatar.calculateMovieFee(screening));
        // avatar fee 의 금액이 변경되지 않는 이유는 calculateMovieFee 에서 새로운 Money 객체를 만들어서 리턴하기 때문.
        System.out.println("avatar fee = " + avatar.getFee());
    }

    @Test
    public void create_titanic_test() {
        discountPolicy = new PercentDiscountPolicy(
                0.1,
                new PeriodCondition(DayOfWeek.SUNDAY, LocalTime.of(14, 0), LocalTime.of(16, 59)),
                new SequenceCondition(2),
                new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(13, 59)));

        Movie titanic = new Movie("타이타닉",
                Duration.ofMinutes(180),
                Money.wons(11000),
                discountPolicy);

        Screening screening = new Screening(titanic, 1, LocalDateTime.of(LocalDate.now(), LocalTime.of(14, 10)));

        System.out.println("titanic = " + titanic);
        System.out.println("calculateFee = " + titanic.calculateMovieFee(screening));
        System.out.println("titanic fee = " + titanic.getFee());

        titanic.changeDiscountPolicy(new NoneDiscountPolicy());
        System.out.println("calculateFee = " + titanic.calculateMovieFee(screening));
    }

    @Test
    public void create_starwars_test() {
        discountPolicy = new NoneDiscountPolicy();

        Movie starwars = new Movie("스타워즈",
                Duration.ofMinutes(210),
                Money.wons(10000),
                discountPolicy);

        System.out.println("starwars = " + starwars);
        System.out.println("starwars fee = " + starwars.getFee());
    }

}
