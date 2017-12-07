package Quizer.springBoot.service.dao;

import Quizer.springBoot.service.model.quiz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface quizDao extends CrudRepository<quiz, Integer> {
    public List<quiz> findAll();
    public quiz findByQuizid(Integer integer);
}
