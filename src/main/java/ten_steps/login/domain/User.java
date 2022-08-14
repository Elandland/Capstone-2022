package ten_steps.login.domain;

//주로 jpa에서 hibernate만 쓸거임(다른것도 많음)

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //db가 id값을 알아서 생성 ->indentity 전략

    private Long sid;             // PK
    private String user_email;    // 사용자 이메일 (ID개념)
    private String user_name;     // 사용자 이름
    private String user_pw;       // 사용자 pw           //우리는 id, 이름, 핸드폰 번호 ,비밀번호 필요. 핸드폰 인증은 꼭 안넣어도 될거 같긴 함

}
