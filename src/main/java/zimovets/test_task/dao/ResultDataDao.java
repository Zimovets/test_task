package zimovets.test_task.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zimovets.test_task.entity.ResultData;

@Repository
public interface ResultDataDao extends CrudRepository<ResultData, Long>{
}
