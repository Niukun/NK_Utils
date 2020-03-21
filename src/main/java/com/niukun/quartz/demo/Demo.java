package com.niukun.quartz.demo;

import com.niukun.quartz.job.MyJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class Demo {
    public static void main(String[] args) {

        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                    .withIdentity("job1","group1")
                    .build();
            SimpleTrigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger1","group1")
                    .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(5))
                    .startNow()
                    .build();
            scheduler.scheduleJob(jobDetail,trigger);
            scheduler.start();


        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
