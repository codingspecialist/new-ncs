package shop.mtcoding.blog.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.blog._core.errors.exception.Exception400;
import shop.mtcoding.blog._core.errors.exception.Exception401;
import shop.mtcoding.blog._core.errors.exception.StudentCheckException;
import shop.mtcoding.blog._core.errors.exception.api.ApiException400;
import shop.mtcoding.blog.course.student.Student;
import shop.mtcoding.blog.course.student.StudentRepository;

import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service // IoC 등록
public class UserService {

    private final UserRepository userRepository;
    private final StudentRepository studentRepository;
    
    public User 로그인(UserRequest.LoginDTO reqDTO){
        User sessionUser = userRepository.findByUsernameAndPassword(reqDTO.getUsername(), reqDTO.getPassword())
                .orElseThrow(() -> new Exception401("인증되지 않았습니다"));
        return sessionUser;
    }

    @Transactional
    public User 회원가입(UserRequest.JoinDTO reqDTO){ // ssar
        // 1. 유저네임 중복검사 (서비스 체크) - DB연결이 필요한 것은 Controller에서 작성할 수 없다.
        Optional<User> userOP = userRepository.findByUsername(reqDTO.getUsername());

        if(userOP.isPresent()){
            throw new Exception400("중복된 유저네임입니다");
        }

        // 2. 회원가입
        return userRepository.save(reqDTO.toEntity());
    }

    @Transactional
    public User 학생인증(UserRequest.StudentCheckDTO reqDTO) {
        Student studentPS = studentRepository.findByNameAndBirthday(reqDTO.getName(), reqDTO.getBirthday());

        if(studentPS == null){
            throw new StudentCheckException("등록되지 않은 학생으로 인증되지 않았습니다. 관리자에게 문의하세요.");
        }
        User userPS = userRepository.findById(reqDTO.getUserId())
                .orElseThrow();
        userPS.setStudent(studentPS);
        userPS.setIsCheck(true);

        return userPS;
    } // 더티체킹 업데이트
}
