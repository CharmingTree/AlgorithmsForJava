package QuartzTest.example01;

import QuartzTest.domain.HelloJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import static org.quartz.DateBuilder.evenSecondDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;
import static org.quartz.DateBuilder.evenMinuteDate;


public class SimpleExample {

    public static void run() throws Exception {

        Logger logger = LoggerFactory.getLogger(SimpleExample.class);

        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sched = sf.getScheduler();
        Scheduler sched2 = sf.getScheduler();

        if (sched == sched2) {
            logger.info("==");
        }
        if (sched.equals(sched2)) {
            logger.info("equals");
        }

        Calendar cal = Calendar.getInstance();
        cal.set(2021, Calendar.MAY,10,16,51,30);

        //Date runTime = cal.getTime();
        Date runTime = evenMinuteDate(new Date());
        Date runTime2 = evenMinuteDate(new Date());
        Date runTime3 = evenMinuteDate(new Date());
        //Date runTime2 = evenSecondDate(runTime);
        //Date runTime3 = evenSecondDate(runTime2);

        JobDataMap dataMap = new JobDataMap();
        dataMap.put("jobName", "job1");
        dataMap.put("serverInfo", "STG1");
        dataMap.put("state", "wait");
        dataMap.put("startTime", runTime);

        JobDataMap dataMap2 = new JobDataMap();
        dataMap2.put("jobName", "job2");
        dataMap2.put("serverInfo", "STG1");
        dataMap2.put("state", "wait");
        dataMap2.put("startTime", runTime2);

        JobDataMap dataMap3 = new JobDataMap();
        dataMap3.put("jobName", "job3");
        dataMap3.put("serverInfo", "STG1");
        dataMap3.put("state", "wait");
        dataMap3.put("startTime", runTime3);

        JobDetail job = newJob(HelloJob.class).usingJobData(dataMap).withIdentity("job1", "group1").build();
        JobDetail job2 = newJob(HelloJob.class).usingJobData(dataMap2).withIdentity("job2", "group1").build();
        JobDetail job3 = newJob(HelloJob.class).usingJobData(dataMap3).withIdentity("job3", "group1").build();

        Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();
        Trigger trigger2 = newTrigger().withIdentity("trigger2", "group1").startAt(runTime2).build();
        Trigger trigger3 = newTrigger().withIdentity("trigger3", "group1").startAt(runTime3).build();

        sched.scheduleJob(job, trigger);
        sched.scheduleJob(job2, trigger2);
        sched.scheduleJob(job3, trigger3);

        //.info("{} will run at : {}", job.getKey(), runTime);

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
