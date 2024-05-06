package shop.mtcoding.blog.paper;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.blog._core.errors.exception.Exception404;
import shop.mtcoding.blog.course.subject.Subject;
import shop.mtcoding.blog.course.subject.SubjectRepository;
import shop.mtcoding.blog.course.subject.element.SubjectElement;
import shop.mtcoding.blog.course.subject.element.SubjectElementRepository;
import shop.mtcoding.blog.paper.question.Question;
import shop.mtcoding.blog.paper.question.QuestionRepository;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class PaperService {
    private final PaperRepository paperRepository;
    private final QuestionRepository paperQuestionRepository;
    private final SubjectElementRepository subjectElementRepository;
    private final SubjectRepository subjectRepository;

    // 전체 시험지 목록
    public PaperResponse.PagingDTO 시험지목록(Pageable pageable){
        Page<Paper> paperPG = paperRepository.findAll(pageable);
        return new PaperResponse.PagingDTO(paperPG);
    }

    public PaperResponse.QuestionListDTO 문제목록(Long paperId) {
        Paper paperPS = paperRepository.findById(paperId)
                .orElseThrow(() -> new Exception404("시험지가 존재하지 않아요"));

        List<SubjectElement> subjectElementListPS =
                subjectElementRepository.findBySubjectId(paperPS.getSubject().getId());


        List<Question> questionListPS = paperQuestionRepository.findByPaperId(paperId);
        return new PaperResponse.QuestionListDTO(paperPS, subjectElementListPS, questionListPS);
    }

    @Transactional
    public void 시험지등록(PaperRequest.SaveDTO reqDTO) {
        Subject subjectPS = subjectRepository.findById(reqDTO.getSubjectId())
                        .orElseThrow(() -> new Exception404("해당 교과목을 찾을 수 없어요"));
        paperRepository.save(reqDTO.toEntity(subjectPS));
    }
}
