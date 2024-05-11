insert into user_tb(username, password, email, name, role, is_check, student_id, created_at, is_teacher, sign)
values('ssar', '1234', 'ssar@nate.com', '최주호', 'teacher', true, null, now(), true, 'data:image/png;base64,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');
insert into user_tb(username, password, email, name, role, is_check, student_id, created_at, is_teacher)
values('cos', '1234', 'cos@nate.com', '박동기', 'student', true, 3, now(), false);


insert into course_tb(code, course_status, start_date, end_date, level, purpose, round, main_teacher_name, title, total_day, total_time, create_date)
values('C1004', 'NOT_STARTED', '2024-06-01', '2025-03-07', 5, '마이크로 아키텍쳐에 대해서 이해한다.', 1, '최주호', 'MSA기반 자바과정', 150, 1200, now());


insert into subject_tb(teacher_name, code, course_id, start_date, end_date, evaluation_date,  revaluation_date, evaluation_way, grade, gubun, learning_way, no, purpose, title, total_time, create_date)
values('최주호', 'S2001', 1, '2024-06-01', '2024-06-07', '2024-06-07', '2024-06-08', '서술형시험', 3, 'NCS', '실습', 1, '객체지향을 학습하는 능력이다', '자바', 50, now());
insert into subject_tb(teacher_name, code, course_id, start_date, end_date, evaluation_date,  revaluation_date, evaluation_way, grade, gubun, learning_way, no, purpose, title, total_time, create_date)
values('최주호', 'S2002', 1, '2024-06-08', '2024-06-13', '2024-06-13', '2024-06-14', '서술형시험', 3, 'NCS', '실습', 2, 'HTTP를 학습하는 능력이다', '스프링부트', 50, now());


insert into student_tb(birthday, course_id, create_date, name, state)
values('900101', 1, now(), '김주혁', 'ENROLLED');
insert into student_tb(birthday, course_id, create_date, name, state)
values('800101', 1, now(), '설동훈', 'ENROLLED');
insert into student_tb(birthday, course_id, create_date, name, state)
values('700101', 1, now(), '박동기', 'ENROLLED');
insert into student_tb(birthday, course_id, create_date, name, state)
values('600101', 1, now(), '최주호', 'ENROLLED');


insert into subject_element_tb(create_date, no, subject_id, subtitle)
values(now(), 1, 1, '연산자');
insert into subject_element_tb(create_date, no, subject_id, subtitle)
values(now(), 2, 1, '객체지향');

insert into subject_element_tb(create_date, no, subject_id, subtitle)
values(now(), 1, 2, 'DI');
insert into subject_element_tb(create_date, no, subject_id, subtitle)
values(now(), 2, 2, 'IoC');
insert into subject_element_tb(create_date, no, subject_id, subtitle)
values(now(), 3, 2, '어노테이션');
insert into subject_element_tb(create_date, no, subject_id, subtitle)
values(now(), 4, 2, '리플렉션');
insert into subject_element_tb(create_date, no, subject_id, subtitle)
values(now(), 5, 2, '컨트롤러');

insert into paper_tb(subject_id, create_date, count, paper_state)
values(1, now(), 2, '본평가');
insert into paper_tb(subject_id, create_date, count, paper_state)
values(2, now(), 5, '본평가');
insert into paper_tb(subject_id, create_date, count, paper_state)
values(1, now(), 2, '재평가');

insert into question_tb(no, title, point, answer_number, paper_id, create_date, subject_element_id)
values(1, '다음 중 for문 설명으로 틀린것은?', 50, 4, 1, now(), 1);
insert into question_tb(no, title, point, answer_number, paper_id, create_date, subject_element_id)
values(2, '다음 중 while문 설명으로 틀린것은?', 50, 4, 1, now(), 2);

insert into question_tb(no, title, point, answer_number, paper_id, create_date, subject_element_id)
values(1, '다음 중 select 설명으로 틀린것은?', 20, 4, 2, now(), 3);
insert into question_tb(no, title, point, answer_number, paper_id, create_date, subject_element_id)
values(2, '다음 중 insert 설명으로 틀린것은?', 20, 4, 2, now(), 4);
insert into question_tb(no, title, point, answer_number, paper_id, create_date, subject_element_id)
values(3, '다음 중 update 설명으로 틀린것은?', 20, 4, 2, now(), 5);
insert into question_tb(no, title, point, answer_number, paper_id, create_date, subject_element_id)
values(4, '다음 중 delete 설명으로 틀린것은?', 20, 4, 2, now(), 6);
insert into question_tb(no, title, point, answer_number, paper_id, create_date, subject_element_id)
values(5, '다음 중 dml 설명으로 틀린것은?', 20, 4, 2, now(), 7);

insert into question_tb(no, title, point, answer_number, paper_id, create_date, subject_element_id)
values(1, '다음 중 스레드 설명으로 틀린것은?', 50, 4, 3, now(), 1);

insert into question_tb(no, title, point, answer_number, paper_id, create_date, subject_element_id)
values(2, '다음 중 소켓 설명으로 틀린것은?', 50, 4, 3, now(), 2);

insert into question_option_tb(no, content, question_id, create_date, is_right)
values(1, '반복문이다', 1, now(), false);
insert into question_option_tb(no, content, question_id, create_date, is_right)
values(2, '표현식이아니다', 1, now(), false);
insert into question_option_tb(no, content, question_id, create_date, is_right)
values(3, '한번만실행할수있다', 1, now(), false);
insert into question_option_tb(no, content, question_id, create_date, is_right)
values(4, '반복되지않는다', 1, now(), true);

insert into question_option_tb(no, content, question_id, create_date, is_right)
values(1, '반복문이다', 2, now(), false);
insert into question_option_tb(no, content, question_id, create_date, is_right)
values(2, '표현식이아니다', 2, now(), false);
insert into question_option_tb(no, content, question_id, create_date, is_right)
values(3, '한번만실행할수있다', 2, now(), false);
insert into question_option_tb(no, content, question_id, create_date, is_right)
values(4, '반복되지않는다', 2, now(), true);

insert into question_option_tb(no, content, question_id, create_date, is_right)
values(1, '반복문이다', 3, now(), false);
insert into question_option_tb(no, content, question_id, create_date, is_right)
values(2, '표현식이아니다', 3, now(), false);
insert into question_option_tb(no, content, question_id, create_date, is_right)
values(3, '한번만실행할수있다', 3, now(), false);
insert into question_option_tb(no, content, question_id, create_date, is_right)
values(4, '반복되지않는다', 3, now(), true);

insert into question_option_tb(no, content, question_id, create_date, is_right)
values(1, '반복문이다', 4, now(), false);
insert into question_option_tb(no, content, question_id, create_date, is_right)
values(2, '표현식이아니다', 4, now(), false);
insert into question_option_tb(no, content, question_id, create_date, is_right)
values(3, '한번만실행할수있다', 4, now(), false);
insert into question_option_tb(no, content, question_id, create_date, is_right)
values(4, '반복되지않는다', 4, now(), true);

insert into question_option_tb(no, content, question_id, create_date, is_right)
values(1, '반복문이다', 5, now(), false);
insert into question_option_tb(no, content, question_id, create_date, is_right)
values(2, '표현식이아니다', 5, now(), false);
insert into question_option_tb(no, content, question_id, create_date, is_right)
values(3, '한번만실행할수있다', 5, now(), false);
insert into question_option_tb(no, content, question_id, create_date, is_right)
values(4, '반복되지않는다', 5, now(), true);

insert into question_option_tb(no, content, question_id, create_date, is_right)
values(1, '반복문이다', 6, now(), false);
insert into question_option_tb(no, content, question_id, create_date, is_right)
values(2, '표현식이아니다', 6, now(), false);
insert into question_option_tb(no, content, question_id, create_date, is_right)
values(3, '한번만실행할수있다', 6, now(), false);
insert into question_option_tb(no, content, question_id, create_date, is_right)
values(4, '반복되지않는다', 6, now(), true);

insert into question_option_tb(no, content, question_id, create_date, is_right)
values(1, '반복문이다', 7, now(), false);
insert into question_option_tb(no, content, question_id, create_date, is_right)
values(2, '표현식이아니다', 7, now(), false);
insert into question_option_tb(no, content, question_id, create_date, is_right)
values(3, '한번만실행할수있다', 7, now(), false);
insert into question_option_tb(no, content, question_id, create_date, is_right)
values(4, '반복되지않는다', 7, now(), true);

insert into question_option_tb(no, content, question_id, create_date, is_right)
values(1, '반복문이다', 8, now(), false);
insert into question_option_tb(no, content, question_id, create_date, is_right)
values(2, '표현식이아니다', 8, now(), false);
insert into question_option_tb(no, content, question_id, create_date, is_right)
values(3, '한번만실행할수있다', 8, now(), false);
insert into question_option_tb(no, content, question_id, create_date, is_right)
values(4, '반복되지않는다', 8, now(), true);

insert into question_option_tb(no, content, question_id, create_date, is_right)
values(1, '반복문이다', 9, now(), false);
insert into question_option_tb(no, content, question_id, create_date, is_right)
values(2, '표현식이아니다', 9, now(), false);
insert into question_option_tb(no, content, question_id, create_date, is_right)
values(3, '한번만실행할수있다', 9, now(), false);
insert into question_option_tb(no, content, question_id, create_date, is_right)
values(4, '반복되지않는다', 9, now(), true);

insert into exam_tb
(create_date, exam_state, grade, paper_id, pass_state, re_exam_reason, score, student_id, teacher_comment, teacher_name)
values
(now(), '본평가', 5, 1, '통과', '', 100, 3, '아주 잘했어요. 굳입니다.', '최주호');

insert into exam_tb
(create_date, exam_state, grade, paper_id, pass_state, re_exam_reason, score, student_id, teacher_comment, teacher_name)
values
(now(), '본평가', 4, 2, '통과', '', 80, 3, '조금 부족했어요. 굳입니다.', '최주호');

insert into exam_answer_tb
(exam_id, is_correct, question_id, question_no, selected_option_no)
values(1, true, 1, 1, 4);
insert into exam_answer_tb
(exam_id, is_correct, question_id, question_no, selected_option_no)
values(1, true, 2, 2, 4);


insert into exam_answer_tb
(exam_id, is_correct, question_id, question_no, selected_option_no)
values(2, true, 3, 1, 4);
insert into exam_answer_tb
(exam_id, is_correct, question_id, question_no, selected_option_no)
values(2, true, 4, 2, 4);
insert into exam_answer_tb
(exam_id, is_correct, question_id, question_no, selected_option_no)
values(2, true, 5, 3, 4);
insert into exam_answer_tb
(exam_id, is_correct, question_id, question_no, selected_option_no)
values(2, true, 6, 4, 4);
insert into exam_answer_tb
(exam_id, is_correct, question_id, question_no, selected_option_no)
values(2, false, 7, 5, 1);