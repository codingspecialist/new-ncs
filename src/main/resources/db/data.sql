insert into user_tb(username, password, email, name, role, is_check, student_id, created_at, is_teacher, sign)
values('ssar', '1234', 'ssar@nate.com', '최주호', 'teacher', true, null, now(), true, 'data:image/png;base64,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');
insert into user_tb(username, password, email, name, role, is_check, student_id, created_at, is_teacher)
values('cos', '1234', 'cos@nate.com', '박동기', 'student', true, 3, now(), false);


insert into course_tb(code, course_status, start_date, end_date, level, purpose, round, main_teacher_name, title, total_day, total_time, create_date)
values('A1001', 'NOT_STARTED', '2024-06-01', '2025-03-07', 5, '마이크로 아키텍쳐에 대해서 이해한다.', 1, '최주호', 'MSA기반 자바과정', 150, 1200, now());


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