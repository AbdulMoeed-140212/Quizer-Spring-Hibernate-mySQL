package Quizer.dao;

import Quizer.model.marks;
import Quizer.model.type.mcq;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface marksDao  extends CrudRepository<marks,Integer> {

    public List<marks> findAll();
    public marks findByUid(Integer uid);

}
