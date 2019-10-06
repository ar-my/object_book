package com.jenson.object;

import com.jenson.object.domain.Money;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ObjectApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void money_test() {
        Money money = Money.wons(1000L);
        Money plusMoney = Money.wons(100L);
        Money minusMoney = Money.wons(200L);
        Money plus = money.plus(plusMoney);
        Money minus = money.minus(minusMoney);
        Money times = money.times(2.5d);

        System.out.println("minus = " + minus);
        System.out.println("plus = " + plus);
        System.out.println("times = " + times);
    }

    @Test
    public void day_of_week_test() throws InterruptedException {
        DayOfWeek[] values = DayOfWeek.values();
        for (DayOfWeek dayOfWeek : values) {
            System.out.println("dayOfWeek = " + dayOfWeek);
        }

        LocalDateTime now = LocalDateTime.now();
        System.out.println("now.getDayOfWeek() = " + now.getDayOfWeek());

        Thread.sleep(10);
        LocalTime nowLocalTime = LocalTime.now();


        System.out.println("now to LocalTime = " + now.toLocalTime());
        System.out.println("nowLocalTime = " + nowLocalTime);

        /**
         * compareTo
         * 비교 대상이 늦으면 -1
         * 같으면 0
         * 비교 대상이 빠르면 1
         */
        System.out.println("compareTo = " + nowLocalTime.compareTo(now.toLocalTime()));
        System.out.println("compareTo = " + now.toLocalTime().compareTo(nowLocalTime));
    }
}
