package shop.mtcoding.blog.document;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class DocumentController {

    private final DocumentService documentService;

    @GetMapping("/api/teacher/document/course/{courseId}/subject/{subjectId}/no1")
    public String no1(@PathVariable Long courseId, @PathVariable Long subjectId, Model model){
        DocumentResponse.No1DTO respDTO = documentService.no1(subjectId);
        model.addAttribute("model", respDTO);
        return "document/no1";
    }

    @GetMapping("/api/teacher/document/course")
    public String course(Model model){

        List<DocumentResponse.CourseDTO> respDTOs = documentService.과정목록();
        model.addAttribute("models", respDTOs);
        return "document/course-list";
    }

    @GetMapping("/api/teacher/document/course/{courseId}/subject")
    public String subject(@PathVariable("courseId") Long courseId, Model model){

        List<DocumentResponse.SubjectDTO> respDTOs = documentService.교과목목록(courseId);
        model.addAttribute("models", respDTOs);
        return "document/subject-list";
    }

    @GetMapping("/api/teacher/document/course/{courseId}/subject/{subjectId}")
    public String subject(@PathVariable("courseId") Long courseId, @PathVariable("subjectId") Long subjectId, Model model){
        model.addAttribute("courseId", courseId);
        model.addAttribute("subjectId", subjectId);
        return "document/document-list";
    }
}
