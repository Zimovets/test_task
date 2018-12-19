package zimovets.test_task.entity;

public class DataChangeLog {

    private boolean first = false;
    private boolean second = false;
    private Long num;
    private String result;

    public DataChangeLog(Long num, String result) {
        this.num = num;
        this.result = result;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public boolean isSecond() {
        return second;
    }

    public void setSecond(boolean second) {
        this.second = second;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
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

        if (first != that.first) return false;
        if (second != that.second) return false;
        if (!num.equals(that.num)) return false;
        return result.equals(that.result);
    }

    @Override
    public int hashCode() {
        int result1 = (first ? 1 : 0);
        result1 = 31 * result1 + (second ? 1 : 0);
        result1 = 31 * result1 + num.hashCode();
        result1 = 31 * result1 + result.hashCode();
        return result1;
    }
}
