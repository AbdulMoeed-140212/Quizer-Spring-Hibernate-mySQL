package Quizer.springBoot.service.dao;

import Quizer.springBoot.service.model.student;
import Quizer.springBoot.service.model.totalscore;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface totalscoreDao extends CrudRepository<totalscore, Integer>{
    public List<totalscore> findAll();
}
