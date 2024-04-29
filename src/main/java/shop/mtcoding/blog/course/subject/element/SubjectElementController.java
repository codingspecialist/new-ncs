package shop.mtcoding.blog.course.subject.element;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import shop.mtcoding.blog.course.subject.SubjectRequest;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class SubjectElementController {
    private final HttpSession session;
    private final SubjectElementService subjectElementService;

    @GetMapping("/api/subject/{subjectId}/element")
    public String list(@PathVariable Long subjectId, Model model){
        SubjectElementResponse.ListDTO respDTO = subjectElementService.교과목요소목록(subjectId);
        model.addAttribute("model", respDTO);
        return "course/subject/element/list";
    }

    @GetMapping("/api/subject/{subjectId}/save-form")
    public String saveForm(@PathVariable Long subjectId, Model model){
        model.addAttribute("subjectId", subjectId);
        return "course/subject/element/save-form";
    }

    @PostMapping("/api/subject/{subjectId}/save")
    public String save(@PathVariable Long subjectId, List<SubjectRequest.SaveDTO> reqDTOs){
        return "redirect:/api/subject/"+subjectId+"/element";
    }
}
