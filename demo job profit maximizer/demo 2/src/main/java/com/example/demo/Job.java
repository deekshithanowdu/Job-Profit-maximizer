package com.example.demo;

public class Job {
    private String id;
    private int deadline;
    private int profit;

    public Job(String id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }

    public String getId() { return id; }
    public int getDeadline() { return deadline; }
    public int getProfit() { return profit; }

}
