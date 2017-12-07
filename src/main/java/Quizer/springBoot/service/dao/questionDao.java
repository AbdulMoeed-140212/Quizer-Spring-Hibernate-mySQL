package Quizer.springBoot.service.dao;

import Quizer.springBoot.service.model.question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface questionDao extends CrudRepository<question, Integer> {
    public List<question> findAll();
}
