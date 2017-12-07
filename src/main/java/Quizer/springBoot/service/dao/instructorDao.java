package Quizer.springBoot.service.dao;

import Quizer.springBoot.service.model.instructor;
import Quizer.springBoot.service.model.user;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Repository
public interface instructorDao extends CrudRepository<instructor, Integer> {
    public List<instructor> findAll();
    public instructor findByUid(Integer integer);
    public List<instructor> findByName(String name);
}
