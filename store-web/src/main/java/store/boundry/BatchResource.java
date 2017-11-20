package store.boundry;

import org.apache.log4j.Logger;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.Properties;

@Path("/batch")
public class BatchResource {

    private final static Logger LOGGER = Logger.getLogger(BatchResource.class);

    @POST
    public void startBatch() {
        JobOperator jobOperator = BatchRuntime.getJobOperator();
        long jobId = jobOperator.start("simplejob", new Properties());

        LOGGER.info("BatchJob started ID " + jobId);
    }
}
