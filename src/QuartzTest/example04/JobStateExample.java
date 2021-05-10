package QuartzTest.example04;

import QuartzTest.domain.ColorJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.Date;

import static org.quartz.DateBuilder.nextGivenMinuteDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class JobStateExample {

    public static void run() throws Exception {
        Logger logger = LoggerFactory.getLogger(JobStateExample.class);

        logger.info("init");



        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sched = sf.getScheduler();

        logger.info("init complete");
        logger.info("Scheduling Jobs");

        Date startTime = nextGivenMinuteDate(null, 1);

        JobDetail job1 = newJob(ColorJob.class).withIdentity("job1", "group1").build();

        SimpleTrigger trigger1 = newTrigger().withIdentity("trigger1", "group1").startAt(startTime)
                .withSchedule(simpleSchedule().withIntervalInSeconds(10).withRepeatCount(4)).build();

        job1.getJobDataMap().put(ColorJob.FAVORITE_COLOR, "Green");
        job1.getJobDataMap().put(ColorJob.EXECUTION_COUNT, 1);

        Date schedulerTime1 = sched.scheduleJob(job1, trigger1);
        logger.info("{} will run at : {} and repeat {} times, every {} seconds", job1.getKey(), schedulerTime1, trigger1.getRepeatCount(), trigger1.getRepeatInterval() / 1000);


        JobDetail job2 = newJob(ColorJob.class).withIdentity("job2", "group1").build();

        SimpleTrigger trigger2 = newTrigger().withIdentity("trigger2", "group1").startAt(startTime)
                .withSchedule(simpleSchedule().withIntervalInSeconds(10).withRepeatCount(4)).build();

        job2.getJobDataMap().put(ColorJob.FAVORITE_COLOR, "Red");
        job2.getJobDataMap().put(ColorJob.EXECUTION_COUNT, 1);

        Date schedulerTime2 = sched.scheduleJob(job2, trigger2);
        logger.info("{} will run at : {} and repeat {} times, every {} seconds", job2.getKey(), schedulerTime2, trigger2.getRepeatCount(), trigger2.getRepeatInterval() / 1000);

        logger.info("starting sched");

        sched.start();


        logger.info("started");

        logger.info("waiting 60 sec");

        try {
            Thread.sleep(60L * 3000L);
        }catch (Exception e) {
            logger.info(e.getMessage());
        }

        logger.info("Shutting Down");

        sched.shutdown(true);

        SchedulerMetaData metaData = sched.getMetaData();
        logger.info("Executed {} Jobs", metaData.getNumberOfJobsExecuted());
    }

    public static void main(String[] args) throws Exception{
        run();
    }
}

