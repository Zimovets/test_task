package zimovets.test_task.services;

import zimovets.test_task.entity.DataChangeLog;

import java.util.Map;

public class RunnableSecond implements Runnable {

    private Map<Long, DataChangeLog> results;

    private Long input;

    public RunnableSecond(Map<Long, DataChangeLog> results, Long input) {
        this.results = results;
        this.input = input;
    }

    @Override
    public void run() {
        DataChangeLog dataChangeLog = results.get(input);
        dataChangeLog.setSecondResult(DataHandler.method2(input));
    }
}
