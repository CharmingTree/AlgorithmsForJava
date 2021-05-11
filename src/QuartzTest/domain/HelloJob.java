package QuartzTest.domain;

import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashSet;

public class HelloJob implements Job {

    final Logger logger = LoggerFactory.getLogger(HelloJob.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        logger.info("Hello Job - {}", new Date());

        try {
            logger.info("{}", context.getJobDetail().getKey());
            logger.info("{}", Thread.currentThread().getName());

            //context.getJobDetail().getJobDataMap().put("state", "running");
            context.getScheduler().getJobDetail(context.getJobDetail().getKey()).getJobDataMap().put("state", "running");

            HashSet<JobKey> jobs = (HashSet<JobKey>) context.getScheduler().getJobKeys(GroupMatcher.anyGroup());
            jobs.stream().forEach(jb -> {
                try {
                    JobDetail tmp = context.getScheduler().getJobDetail(jb);
                    String jobName = tmp.getJobDataMap().get("jobName").toString();
                    String serverInfo = tmp.getJobDataMap().get("serverInfo").toString();
                    String state = tmp.getJobDataMap().get("state").toString();
                    Date startTime = (Date) tmp.getJobDataMap().get("startTime");

                    logger.info("jobName : {}, serverInfo : {}, state : {}, startTime : {}", jobName, serverInfo, state, startTime);
                } catch (SchedulerException e) {
                    e.printStackTrace();
                }
            });
            context.getScheduler().getCurrentlyExecutingJobs().stream().forEach(s->{logger.info("cur : {}", s.getJobDetail().getJobDataMap().get("jobName"));});
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
