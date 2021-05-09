package QuartzTest.domain;

import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;


@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class ColorJob implements Job {

    static Logger logger = LoggerFactory.getLogger(ColorJob.class);

    public static final String FAVORITE_COLOR = "favorite color";
    public static final String EXECUTION_COUNT = "count";

    private int counter = 1;

    public ColorJob() {}

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        JobKey jobKey = context.getJobDetail().getKey();

        JobDataMap data = context.getJobDetail().getJobDataMap();
        String favoriteColor = data.getString(FAVORITE_COLOR);
        int count = data.getInt(EXECUTION_COUNT);

        logger.info("ColorJob : {} executing at {} \n" +
                        " Favorite Color is {} \n" +
                        " execution count (from job map) is {} \n" +
                        " execution count (from job member variable) is {}",
        jobKey, new Date(), favoriteColor, count, counter);

        count++;
        data.put(EXECUTION_COUNT, count);

        counter++;
    }
}
