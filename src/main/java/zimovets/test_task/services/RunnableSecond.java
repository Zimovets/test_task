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
        System.out.println("Run Second      " + Thread.currentThread().getName());

        if (!results.containsKey(input)) {
            DataChangeLog currentData = new DataChangeLog(input);
            currentData.setSecondResult(DataHandler.method2(input));
            results.put(input, currentData);
        } else {
            DataChangeLog dataChangeLog = results.get(input);
            if (!dataChangeLog.getFirstResult().equals("") && !dataChangeLog.getFirstResult().equals("")){
                dataChangeLog.setResult(dataChangeLog.getFirstResult() + dataChangeLog.getSecondResult());
            } else if (dataChangeLog.getFirstResult().equals("")){
                dataChangeLog.setFirstResult(DataHandler.method1(input));
            }else if (dataChangeLog.getSecondResult().equals("")){
                dataChangeLog.setSecondResult(DataHandler.method2(input));
            }
        }
    }
}
