package zimovets.test_task.services;

import zimovets.test_task.entity.DataChangeLog;

import java.util.Map;

public class RunnableSecond implements Runnable{

    private Map<Long, DataChangeLog> results;

    private Long input;

    public RunnableSecond(Map<Long, DataChangeLog> results, Long input) {
        this.results = results;
        this.input = input;
    }

    @Override
    public void run() {
        System.out.println("Run Second" + Thread.currentThread().getName());
        if (!results.containsKey(input)){
            DataChangeLog currentData = new DataChangeLog(input);
            currentData.setSecondResult(DataHandler.method2(input));
            results.put(input, currentData);
        }else{
            DataChangeLog oldData = results.get(input);
            if (oldData.getResult().equals("")){
                oldData.setSecondResult(DataHandler.method2(input));
                oldData.setResult(DataHandler.combine(oldData.getFirstResult(), oldData.getSecondResult()));
                System.out.println("Result");
            }else{
                System.out.println("Dublicat-----------------------");
                oldData.setResult(oldData.getResult() + oldData.getResult());
            }
        }
    }
}
