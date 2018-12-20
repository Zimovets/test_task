package zimovets.test_task.entity;

public class DataChangeLog {

    private String firstResult = "";
    private String secondResult = "";
    private Integer dublicat = 1;

    public void increasDublicate(){
        dublicat++;
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

    public Integer getDublicat() {
        return dublicat;
    }

    public void setDublicat(Integer dublicat) {
        this.dublicat = dublicat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataChangeLog that = (DataChangeLog) o;

        if (firstResult != null ? !firstResult.equals(that.firstResult) : that.firstResult != null) return false;
        if (secondResult != null ? !secondResult.equals(that.secondResult) : that.secondResult != null) return false;
        return dublicat != null ? dublicat.equals(that.dublicat) : that.dublicat == null;
    }

    @Override
    public int hashCode() {
        int result = firstResult != null ? firstResult.hashCode() : 0;
        result = 31 * result + (secondResult != null ? secondResult.hashCode() : 0);
        result = 31 * result + (dublicat != null ? dublicat.hashCode() : 0);
        return result;
    }
}
