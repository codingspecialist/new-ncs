package shop.mtcoding.blog.course;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

        CourseResponse.Paging respDTO = courseService.과정목록(pageable);
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

}
