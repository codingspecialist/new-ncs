package shop.mtcoding.blog.course.subject;

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
public class SubjectController {

    private final HttpSession session;
    private final SubjectService subjectService;
    private final CourseService courseService;

    @GetMapping("/api/subject")
    public String list(Model model, @PageableDefault(size = 10, direction = Sort.Direction.DESC, sort = "id", page = 0) Pageable pageable){
        SubjectResponse.PagingDTO respDTO = subjectService.모든교과목목록(pageable);
        model.addAttribute("paging", respDTO);
        return "course/subject/list";
    }

    @GetMapping("/api/subject/save-form")
    public String saveForm(@RequestParam(value = "courseId", required = false) Long courseId, Model model){
        CourseResponse.SelectedDTO respDTO = courseService.선택된과정목록(courseId);
        model.addAttribute("model", respDTO);

        // detail에서 왔는지 header의 nav를 바로 클릭했는지 여부 파악
        session.setAttribute("beforeCourseId", courseId);

        return "course/subject/save-form";
    }

    @PostMapping("/api/course/{courseId}/subject/save")
    public String save(@PathVariable Long courseId, SubjectRequest.SaveDTO reqDTO){
        subjectService.교과목등록(courseId, reqDTO);

        Long beforeCourseId = (Long) session.getAttribute("beforeCourseId");

        if(beforeCourseId != null){ // 과정선택 후 교과목 등록 클릭
            session.removeAttribute("beforeCourseId");
            // 어떤 tab을 선택해서 화면을 초기화 할지 결정하기 (0 교과목, 1 학생)
            return "redirect:/api/course/"+beforeCourseId+"?tabNum=0";
        }else{ // 바로 교과목 등록 버튼 클릭
            return "redirect:/api/subject";
        }
    }

}
