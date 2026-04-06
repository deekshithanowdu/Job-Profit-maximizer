package com.example.demo;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@CrossOrigin
public class JobController {
    @PostMapping("/api/schedule")
    public Result scheduleJobs(@RequestBody String input) {
        List<Job> jobs = new ArrayList<>();
        String[] lines = input.split("\n");
        for (String line : lines) {
            String[] parts = line.split(",");
            jobs.add(new Job(
                    parts[0].trim(),
                    Integer.parseInt(parts[1].trim()),
                    Integer.parseInt(parts[2].trim())
            ));
        }
        return JobSchedulerService.scheduleJobs(jobs);
    }
}