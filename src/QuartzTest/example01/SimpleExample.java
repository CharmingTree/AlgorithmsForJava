package QuartzTest.example01;

import QuartzTest.domain.HelloJob;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.Date;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;


public class SimpleExample {

    public static void run() throws Exception {

        Logger logger = LoggerFactory.getLogger(SimpleExample.class);

        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sched = sf.getScheduler();

        Calendar cal = Calendar.getInstance();
        cal.set(2021, Calendar.MAY,10,16,51,30);

        Date runTime = cal.getTime();

        JobDetail job = newJob(HelloJob.class).withIdentity("job1", "group1").build();

        Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();

        sched.scheduleJob(job, trigger);

        logger.info("{} will run at : {}", job.getKey(), runTime);

        sched.start();

        try {
            Thread.sleep(60L*1000L*5);
        }catch (Exception e) {
            logger.info(e.getMessage());
        }

        sched.shutdown(true);
    }


    public static void main(String[] args) throws Exception{
        run();
    }
}
