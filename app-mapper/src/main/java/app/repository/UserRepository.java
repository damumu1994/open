package app.repository;

import app.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @Auther: lxb
 * @Date: 2018/12/27 0027
 * @Description:
 */
public interface UserRepository extends CrudRepository<User, String> {
    User findByUsername(String username);
    User findAllByMobile(String mobile);
    User findByUserId(String userId);
    List<User> findAllByUsernameAndDeleteStatus(String userName, Integer deleteStatus);
}