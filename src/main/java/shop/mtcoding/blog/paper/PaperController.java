package shop.mtcoding.blog.paper;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 1. 시험지
 */

@RequiredArgsConstructor
@Controller
public class PaperController {
    private final HttpSession session;
    private final PaperService paperService;

    @GetMapping("/api/paper")
    public String list(Model model, @PageableDefault(size = 10, direction = Sort.Direction.DESC, sort = "id", page = 0) Pageable pageable){
        PaperResponse.PagingDTO respDTO = paperService.시험지목록(pageable);
        model.addAttribute("paging", respDTO);
        return "paper/list";
    }

    @GetMapping("/api/paper/{paperId}")
    public String detail(@PathVariable(value = "paperId") Long paperId, Model model){
        PaperResponse.QuestionListDTO respDTO = paperService.문제목록(paperId);
        model.addAttribute("model", respDTO);
        return "paper/detail";
    }


}
