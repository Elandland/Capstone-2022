package ten_steps.login.repository;

import ten_steps.login.domain.User;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class JpaUserRepository implements UserRepository  {
    private final EntityManager em;         //jpa는 entitymanager라는 것으로 모두 동작

    public JpaUserRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public User save(User user) {
        em.persist(user);
        return user;
    }
    @Override
    public Optional<User> findBySid(Long sid) {
        User user = em.find(User.class,sid);       //(조회할 타입, 식별자)
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> findById(Long user_id) {
        User user = em.find(User.class,user_id);       //(조회할 타입, 식별자)
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> findByEmail(String user_email){
        List<User> result = em.createQuery("select u from User u where u.user_email = :email",User.class)
                .setParameter("email",user_email)
                .getResultList();

        return result.stream().findAny();
    }
    @Override
    public Optional<User> findByName(String user_name) {
        List<User> result = em.createQuery("select u from User u where u.user_name = :name",User.class)
                .setParameter("name",user_name)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<User> findAll() {
        return em.createQuery("select u from User u",User.class)            //객체를 대상하는 쿼리를 날림 (정확히는 entity) select m 은 객체 m 자체를 선택하는것
                .getResultList();

    }
    @Override
    public List<User> findOne() {
        return em.createQuery("select u from User u where u.user_name = :name",User.class)
                .getResultList();
    }
}
