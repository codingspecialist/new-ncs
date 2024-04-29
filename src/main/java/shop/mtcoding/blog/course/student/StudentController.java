package shop.mtcoding.blog.course.student;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import shop.mtcoding.blog.course.CourseResponse;
import shop.mtcoding.blog.course.CourseService;

@RequiredArgsConstructor
@Controller
public class StudentController {
    private final HttpSession session;
    private final CourseService courseService;
    private final StudentService studentService;

    @GetMapping("/api/course/{courseId}/student/save-form")
    public String saveForm(@PathVariable Long courseId, Model model) {
        CourseResponse.SelectedDTO respDTO = courseService.선택된과정목록(courseId);
        model.addAttribute("model", respDTO);

        return "course/student/save-form";
    }

    @PostMapping("/api/course/{courseId}/student/save")
    public String save(@PathVariable Long courseId, StudentRequest.SaveDTO reqDTO){
        studentService.학생등록(courseId, reqDTO);
        return "redirect:/api/course/"+courseId;
    }
}
