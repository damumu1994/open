package app.repository;


import app.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Auther: lxb
 * @Date: 2018/12/25 0025
 * @Description:
 */
@Repository
public interface TestRepository extends JpaRepository<Test,Integer> {

}
