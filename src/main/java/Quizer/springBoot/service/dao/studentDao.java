package Quizer.springBoot.service.dao;

import Quizer.springBoot.service.model.student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface studentDao extends CrudRepository<student, Integer>{
    public List<student> findAll();
    public student findByUid(Integer integer);
    public List<student> findByName(String name);
}
