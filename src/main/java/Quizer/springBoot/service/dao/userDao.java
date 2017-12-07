package Quizer.springBoot.service.dao;

import Quizer.springBoot.service.model.user;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface userDao extends CrudRepository<user, Integer> {
    public List<user> findAll();
    public user findByUid(Integer integer);
}
