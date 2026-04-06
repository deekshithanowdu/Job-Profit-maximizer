package com.example.demo;
import java.util.List;
public class Result {
    public List<String> jobs;
    public int profit;
    public double efficiency;
    public List<String> recommendedJobs;
    public int missedJobs;

    public Result(List<String> jobs, int profit, double efficiency,
                  List<String> recommendedJobs, int missedJobs) {
        this.jobs = jobs;
        this.profit = profit;
        this.efficiency = efficiency;
        this.recommendedJobs = recommendedJobs;
        this.missedJobs = missedJobs;
    }
}