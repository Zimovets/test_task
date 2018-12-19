package zimovets.test_task.entity;

public class DataChangeLog {

    private Long num;
    private String firstResult = "";
    private String secondResult = "";
    private String result = "";

    public DataChangeLog(Long num) {
        this.num = num;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getFirstResult() {
        return firstResult;
    }

    public void setFirstResult(String firstResult) {
        this.firstResult = firstResult;
    }

    public String getSecondResult() {
        return secondResult;
    }

    public void setSecondResult(String secondResult) {
        this.secondResult = secondResult;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataChangeLog that = (DataChangeLog) o;

        if (!num.equals(that.num)) return false;
        if (!firstResult.equals(that.firstResult)) return false;
        if (!secondResult.equals(that.secondResult)) return false;
        return result.equals(that.result);
    }

    @Override
    public int hashCode() {
        int result1 = num.hashCode();
        result1 = 31 * result1 + firstResult.hashCode();
        result1 = 31 * result1 + secondResult.hashCode();
        result1 = 31 * result1 + result.hashCode();
        return result1;
    }
}
