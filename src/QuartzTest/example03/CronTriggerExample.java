package QuartzTest.example03;


import QuartzTest.domain.SimpleJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class CronTriggerExample {

    public static void run() throws Exception {
        Logger logger = LoggerFactory.getLogger(CronTriggerExample.class);

        logger.info("--- Initializing ---");
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sched = sf.getScheduler();

        JobDetail job = newJob(SimpleJob.class).withIdentity("job1", "group1").build();
        CronTrigger trigger = newTrigger().withIdentity("trigger1" ,"group1").withSchedule(cronSchedule("0/20 * * * * ?")).build();

        Date ft = sched.scheduleJob(job, trigger);
        logger.info("{} has been scheduled to run at: {} and repeat based on expression : {}", job.getKey(), ft, trigger.getCronExpression());

        sched.start();

        logger.info("--- Started Scheduler ---");

        logger.info("--- Waiting five minutes... ---");

        try {
            Thread.sleep(300L * 1000L);
        }catch (Exception e) {

        }

        logger.info("--- Shutting Down ---");

        sched.shutdown(true);

        logger.info("--- Shutdown Complete ---");
        SchedulerMetaData metaData = sched.getMetaData();
        logger.info("Executed {} Jobs.", metaData.getNumberOfJobsExecuted());
    }

    public static void main(String[] args) throws Exception{
        run();
    }
}
