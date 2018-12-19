package zimovets.test_task.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "result_data")
public class ResultData {

    public ResultData() {
    }

    public ResultData(Long num, String result, LocalDateTime createTime) {
        this.num = num;
        this.result = result;
        this.createTime = createTime;
    }

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "num")
    private Long num;

    @Column(name = "result")
    private String result;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResultData that = (ResultData) o;

        if (!id.equals(that.id)) return false;
        if (!num.equals(that.num)) return false;
        if (!result.equals(that.result)) return false;
        return createTime.equals(that.createTime);
    }

    @Override
    public int hashCode() {
        int result1 = id.hashCode();
        result1 = 31 * result1 + num.hashCode();
        result1 = 31 * result1 + result.hashCode();
        result1 = 31 * result1 + createTime.hashCode();
        return result1;
    }
}
