package com.jenson.object.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketOffice {
    private Long amount;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketOffice(Long amount, Ticket... tickets) {
        this.amount = amount;
        this.tickets.addAll(Arrays.asList(tickets));
    }

    public void sellTicketTo(Audience audience) {
        this.plusAmount(audience.buy(getTicket()));
    }

    public Ticket getTicket() {
        return this.tickets.get(0);
    }

    public void plusAmount(Long amount) {
        this.amount += amount;
    }
}
