package ten_steps.login.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import ten_steps.login.domain.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface UserRepository {

    User save(User user);
    Optional<User> findBySid(Long sid); //findby로 찾았는데 NULL일때 대비해서 Optional씀 (sid로 회원찾는거)
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String user_email);
    Optional<User> findByName(String user_name);
    List<User> findAll();
    List<User> findOne();

}
