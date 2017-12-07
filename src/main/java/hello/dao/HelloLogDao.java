package  hello.dao;

import hello.HelloLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Repository
public interface HelloLogDao extends  CrudRepository<HelloLog , Integer>{
    public List<HelloLog> findAll();
    public HelloLog findByUid(Integer uid);
    public List<HelloLog> findByName(String name);
}