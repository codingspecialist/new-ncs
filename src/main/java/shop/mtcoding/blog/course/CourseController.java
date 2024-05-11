package shop.mtcoding.blog.course;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import shop.mtcoding.blog.user.User;

@RequiredArgsConstructor
@Controller
public class CourseController {

    private final HttpSession session;
    private final CourseService courseService;

    // TODO: 진행상태 -> 스케쥴 등록할지, 직접 변경하는 로직 만들지, 화면 들어올때 연산할지
    // /api/course?page=0
    @GetMapping({"/", "/api/teacher/course"})
    public String list(Model model, @PageableDefault(size = 10, direction = Sort.Direction.DESC, sort = "id", page = 0) Pageable pageable){
        // 인터셉터에서 / 주소 때문에 이 부분만 예외로 세션 인증 처리하기
        User sessionUser = (User) session.getAttribute("sessionUser");
        if(sessionUser==null) return "redirect:/login-form";

        CourseResponse.PagingDTO respDTO = courseService.과정목록(pageable);
        model.addAttribute("paging", respDTO);

        return "course/list";
    }

    @GetMapping("/api/teacher/course/save-form")
    public String saveForm(){
        return "course/save-form";
    }

    @PostMapping("/api/teacher/course/save")
    public String save(CourseRequest.SaveDTO reqDTO){
        courseService.과정등록(reqDTO);
        return "redirect:/api/teacher/course";
    }

    @GetMapping("/api/teacher/course/{courseId}")
    public String detail(@PathVariable(value = "courseId") Long courseId, @RequestParam(value = "tabNum", required = false, defaultValue = "0") Integer tabNum, Model model){
        CourseResponse.DetailDTO respDTO = courseService.과정상세(courseId);
        model.addAttribute("model", respDTO);

        // 과정 상세보기에서 무슨 학생등록 버튼 클릭하면 리다이렉션되면, 탭번호가 1, 교과목등록이면 탭번호 0
        model.addAttribute("tabNum", tabNum);
        return "course/detail";
    }

}
