package com.example.demo;
import java.util.*;
public class JobSchedulerService {
    public static Result scheduleJobs(List<Job> jobs) {

        jobs.sort((a, b) -> b.getProfit() - a.getProfit());

        int maxDeadline = jobs.stream()
                .mapToInt(Job::getDeadline)
                .max().orElse(0);

        String[] slots = new String[maxDeadline + 1];
        List<String> selectedJobs = new ArrayList<>();
        List<String> rejectedJobs = new ArrayList<>();

        int totalProfit = 0;

        for (Job job : jobs) {
            boolean placed = false;

            for (int i = job.getDeadline(); i > 0; i--) {
                if (slots[i] == null) {
                    slots[i] = job.getId();
                    selectedJobs.add(job.getId());
                    totalProfit += job.getProfit();
                    placed = true;
                    break;
                }
            }

            if (!placed) {
                rejectedJobs.add(job.getId());
            }
        }

        double efficiency = ((double) selectedJobs.size() / jobs.size()) * 100;

        // 🔥 AI Recommendation (Top missed jobs by profit)
        List<Job> missed = new ArrayList<>();
        for (Job j : jobs) {
            if (rejectedJobs.contains(j.getId())) {
                missed.add(j);
            }
        }

        missed.sort((a, b) -> b.getProfit() - a.getProfit());

        List<String> recommended = new ArrayList<>();
        for (int i = 0; i < Math.min(3, missed.size()); i++) {
            recommended.add(missed.get(i).getId());
        }

        return new Result(selectedJobs, totalProfit, efficiency, recommended, rejectedJobs.size());
    }
}