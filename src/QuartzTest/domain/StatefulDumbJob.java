package QuartzTest.domain;

import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;


//@PersistJobDataAfterExecution
//@DisallowConcurrentExecution
public class StatefulDumbJob implements Job {

    private static Logger logger = LoggerFactory.getLogger(StatefulDumbJob.class);
    public static final String NUM_EXECUTIONS = "NumExecutions";
    public static final String EXECUTION_DELAY = "ExecutionDelay";

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        logger.info("--- {} executing. [{}]", context.getJobDetail().getKey(), new Date());

        JobDataMap map = context.getJobDetail().getJobDataMap();

        int executeCount = 0;
        if (map.containsKey(NUM_EXECUTIONS)) {
            executeCount = map.getInt(NUM_EXECUTIONS);
        }

        executeCount++;

        map.put(NUM_EXECUTIONS, executeCount);

        long delay = 5000l;

        if (map.containsKey(EXECUTION_DELAY)) {
            delay = map.getLong(EXECUTION_DELAY);
        }

        try {
            Thread.sleep(delay);
        }catch (Exception e) {
            //
        }

        logger.info(" -{} complete ({}).", context.getJobDetail().getKey(), executeCount);
    }
}
