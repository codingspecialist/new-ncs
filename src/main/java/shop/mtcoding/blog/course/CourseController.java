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

    // /api/course?page=0
    @GetMapping({"/", "/api/course"})
    public String list(Model model, @PageableDefault(size = 5, direction = Sort.Direction.DESC, sort = "id", page = 0) Pageable pageable){
        User sessionUser = (User) session.getAttribute("sessionUser");
        if(sessionUser==null) return "redirect:/login-form";

        CourseResponse.PagingDTO respDTO = courseService.과정목록(pageable);
        model.addAttribute("paging", respDTO);

        return "course/list";
    }

    @GetMapping("/api/course/save-form")
    public String saveForm(){
        return "course/save-form";
    }

    @PostMapping("/api/course/save")
    public String save(CourseRequest.SaveDTO reqDTO){
        courseService.과정등록(reqDTO);
        return "redirect:/api/course";
    }

    @GetMapping("/api/course/{courseId}")
    public String detail(@PathVariable Long courseId, @RequestParam(value = "tabNum", required = false, defaultValue = "0") Integer tabNum, Model model, @PageableDefault(size = 5, direction = Sort.Direction.DESC, sort = "id", page = 0) Pageable pageable){
        CourseResponse.DetailDTO respDTO = courseService.과정상세(courseId, pageable);
        model.addAttribute("model", respDTO);
        model.addAttribute("tabNum", tabNum);
        return "course/detail";
    }

}
