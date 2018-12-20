package zimovets.test_task.services;

import zimovets.test_task.entity.DataChangeLog;
import zimovets.test_task.entity.ResultData;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataHandler {

    public static String method1(Long value) {
        try {
            Thread.sleep(Double.valueOf(Math.random() * 2000).longValue());
        } catch (InterruptedException e) {
        }
        return "Hello, " + value + "!";
    }

    public static String method2(Long value) {
        try {
            Thread.sleep(Double.valueOf(Math.random() * 2000).longValue());
        } catch (InterruptedException e) {
        }
        return value + "*2 = " + (value * 2) + ".";
    }

    public static String combine(String s1, String s2) {
        return s1 + " " + s2;
    }

    public static Map<Long, DataChangeLog> createLogMap(Long[] array) {
        Map<Long, DataChangeLog> result = new HashMap<>();
        for (Long l : array) {
            if (!result.containsKey(l)) {
                result.put(l, new DataChangeLog());
            } else {
                result.get(l).increasDublicate();
            }
        }
        return result;
    }

    public static ArrayList<ResultData> convertToResult(Map<Long, DataChangeLog> input) {
        ArrayList<ResultData> result = new ArrayList<>();
        for (Map.Entry<Long, DataChangeLog> data : input.entrySet()) {
            DataChangeLog curent = data.getValue();
            ResultData resultData = new ResultData();
            resultData.setNum(data.getKey());
            resultData.setCreateTime(LocalDateTime.now());
            resultData.setResult(curent.getFirstResult() + curent.getSecondResult());
            String resultString = resultData.getResult();
            for (int i = 1; i < curent.getDublicat(); i++) {
                resultData.setResult(resultData.getResult() + resultString);
            }
            result.add(resultData);
        }
        return result;
    }
}
