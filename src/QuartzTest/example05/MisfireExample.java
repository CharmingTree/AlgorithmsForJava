package QuartzTest.example05;

import QuartzTest.domain.SimpleJob;
import QuartzTest.domain.StatefulDumbJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

import static org.quartz.DateBuilder.nextGivenSecondDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class MisfireExample {

    public static void run() throws Exception {
        Logger logger = LoggerFactory.getLogger(MisfireExample.class);

        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sched = sf.getScheduler();

        logger.info("initial complete...");

        Date startTime = nextGivenSecondDate(null,15);

        JobDetail job = newJob(StatefulDumbJob.class).withIdentity("statefulJob1", "group1").usingJobData(StatefulDumbJob.EXECUTION_DELAY, 10000L).build();

        SimpleTrigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(startTime).withSchedule(simpleSchedule().withIntervalInSeconds(3).repeatForever()).build();

        Date ft = sched.scheduleJob(job, trigger);
        logger.info("{} will run at: {} and repeat: {} times, every {} seconds", job.getKey(), ft, trigger.getRepeatCount(), trigger.getRepeatInterval() / 1000);

        job = newJob(StatefulDumbJob.class).withIdentity("statefuljob2", "group1")
                .usingJobData(StatefulDumbJob.EXECUTION_DELAY, 1000L).build();

        trigger = newTrigger()
                .withIdentity("trigger2", "group1")
                .startAt(startTime)
                .withSchedule(simpleSchedule().withIntervalInSeconds(3).repeatForever()
                .withMisfireHandlingInstructionNowWithExistingCount())
                .build();

        ft = sched.scheduleJob(job, trigger);
        logger.info("{} will run at: {} and repeat: {} times, every {} seconds", job.getKey(), ft, trigger.getRepeatCount(), trigger.getRepeatInterval() / 1000);

        logger.info("--- starting scheduler ---");

        sched.start();

        try {
            Thread.sleep(600L * 1000L);
        }catch (Exception e) {

        }

        sched.shutdown(true);

        SchedulerMetaData metaData = sched.getMetaData();
        logger.info("Executed {} jobs", metaData.getNumberOfJobsExecuted());

    }

    public static void main(String[] args) throws Exception{
        run();
    }
}
