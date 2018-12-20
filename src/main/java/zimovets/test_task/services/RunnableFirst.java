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
        System.out.println("Run First     " + Thread.currentThread().getName());

        if (!results.containsKey(input)) {
            DataChangeLog currentData = new DataChangeLog(input);
            currentData.setFirstResult(DataHandler.method1(input));
            results.put(input, currentData);
        } else {
            DataChangeLog dataChangeLog;
            synchronized (results) {
                dataChangeLog = results.get(input);

                if (!dataChangeLog.getFirstResult().equals("") && !dataChangeLog.getFirstResult().equals("")) {
                    dataChangeLog.setResult(dataChangeLog.getFirstResult() + dataChangeLog.getSecondResult());
                } else if (dataChangeLog.getFirstResult().equals("")) {
                    dataChangeLog.setFirstResult(DataHandler.method1(input));
                    dataChangeLog.setResult(dataChangeLog.getFirstResult() + dataChangeLog.getSecondResult());
                } else if (dataChangeLog.getSecondResult().equals("")) {
                    dataChangeLog.setSecondResult(DataHandler.method2(input));
                    dataChangeLog.setResult(dataChangeLog.getFirstResult() + dataChangeLog.getSecondResult());
                }
            }
        }
    }
}
