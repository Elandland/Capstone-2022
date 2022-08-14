package ten_steps.login.service;

import org.springframework.transaction.annotation.Transactional;
import ten_steps.login.domain.User;

import org.springframework.stereotype.Service;
import ten_steps.login.repository.UserRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        //dependency injection 자기가 memberRepository를 만드는게 아니라 외부에서 받아옴.
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
    public Long join(User user){

        //같은 이름이 있는 중복 회원은 안된다 ->우리는 같은 PN으로 하면 됨 (UID를 걍 PN으로 할까)
        validateDuplicateMember(user);    //중복회원 검증
        userRepository.save(user);
        return user.getSid();

    }
    private void validateDuplicateMember(User user) {
        userRepository.findByName(user.getUser_name())       //이미 findByName()의 반환 값이 Optional이므로
                .ifPresent(member1 ->{    //ifPresent -> result의 값이 NULL이 아니면
                    throw new IllegalStateException("이미 존재하는 회원 입니다");
                });
    }

    public List<User> findOne() {
        return userRepository.findOne();
    }
}