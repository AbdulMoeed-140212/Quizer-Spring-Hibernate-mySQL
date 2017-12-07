package Quizer.dao;

import Quizer.model.type.mcq;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface  McqDao extends CrudRepository<mcq,Integer> {
    public List<mcq> findAll();
    public mcq findByUid(Integer uid);
    public List<mcq> findByQuestion(String Question);
}
