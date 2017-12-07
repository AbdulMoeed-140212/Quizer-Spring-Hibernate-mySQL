package hello.dao;

import hello.HelloLog;
import hello.Questions;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface QuestionsDao extends CrudRepository<Questions, Integer> {
    public List<Questions> findAll();
    public Questions findByUid(Integer uid);
    public List<Questions> findByQuestion(String question);
}
