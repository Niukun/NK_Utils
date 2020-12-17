package com.niukun.thread;

public class TicketDemo {
    public static void main(String[] args) {
        SellTickets sellTickets = new SellTickets();
        for (int i = 0; i < 100 ;i++){
            new Thread(sellTickets, "window " +i).start();
        }






    }
}
