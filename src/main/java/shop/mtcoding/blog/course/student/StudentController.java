package shop.mtcoding.blog.course.student;

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
import shop.mtcoding.blog.course.CourseResponse;
import shop.mtcoding.blog.course.CourseService;

@RequiredArgsConstructor
@Controller
public class StudentController {
    private final HttpSession session;
    private final CourseService courseService;
    private final StudentService studentService;

    @GetMapping("/api/student")
    public String list(Model model, @PageableDefault(size = 10, direction = Sort.Direction.DESC, sort = "id", page = 0) Pageable pageable){
        StudentResponse.PagingDTO respDTO = studentService.모든학생목록(pageable);
        model.addAttribute("paging", respDTO);
        return "course/student/list";
    }

    @GetMapping("/api/student/save-form")
    public String saveForm(@RequestParam(value = "courseId", required = false) Long courseId, Model model) {
        CourseResponse.SelectedDTO respDTO = courseService.선택된과정목록(courseId);
        model.addAttribute("model", respDTO);

        // detail에서 왔는지 header의 nav를 바로 클릭했는지 여부 파악
        session.setAttribute("beforeCourseId", courseId);

        return "course/student/save-form";
    }

    @PostMapping("/api/course/{courseId}/student/save")
    public String save(@PathVariable Long courseId, StudentRequest.SaveDTO reqDTO){
        studentService.학생등록(courseId, reqDTO);

        Long beforeCourseId = (Long) session.getAttribute("beforeCourseId");
        if(beforeCourseId != null){ // 과정선택 후 교과목 등록 클릭
            session.removeAttribute("beforeCourseId");
            return "redirect:/api/course/"+beforeCourseId+"?tabNum=1";
        }else{ // 바로 교과목 등록 버튼 클릭
            return "redirect:/api/student";
        }
    }
}