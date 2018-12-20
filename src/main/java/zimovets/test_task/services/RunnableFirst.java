package zimovets.test_task.services;

import zimovets.test_task.entity.DataChangeLog;

import java.util.Map;

public class RunnableFirst implements Runnable {

    private Map<Long, DataChangeLog> results;

    private Long input;

    public RunnableFirst(Map<Long, DataChangeLog> results, Long input) {
        this.results = results;
        this.input = input;
    }

    @Override
    public void run() {
        DataChangeLog dataChangeLog = results.get(input);
        dataChangeLog.setFirstResult(DataHandler.method1(input));
    }
}
