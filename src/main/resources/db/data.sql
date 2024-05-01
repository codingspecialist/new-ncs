insert into user_tb(username, password, email, name, role, student_id, created_at) values('ssar', '1234', 'ssar@nate.com', '최주호', 'teacher', null, now());


insert into course_tb(code, course_status, start_date, end_date, level, purpose, round, teacher_name, title, total_day, total_time, create_date)
values('C1004', 'NOT_STARTED', '2024-06-01', '2025-03-07', 5, '마이크로 아키텍쳐에 대해서 이해한다.', 1, '최주호', 'MSA기반 자바과정', 150, 1200, now());


insert into subject_tb(code, course_id, start_date, end_date, evaluation_date,  revaluation_date, evaluation_way, grade, gubun, learning_way, no, purpose, title, total_time, create_date)
values('S2001', 1, '2024-06-01', '2024-06-07', '2024-06-07', '2024-06-08', '서술형시험', 3, 'NCS', '실습', 1, '객체지향을 학습하는 능력이다', '자바', 50, now());
insert into subject_tb(code, course_id, start_date, end_date, evaluation_date,  revaluation_date, evaluation_way, grade, gubun, learning_way, no, purpose, title, total_time, create_date)
values('S2002', 1, '2024-06-08', '2024-06-13', '2024-06-13', '2024-06-14', '서술형시험', 3, 'NCS', '실습', 2, 'HTTP를 학습하는 능력이다', '스프링부트', 50, now());


insert into student_tb(birthday, course_id, create_date, name, state)
values('900101', 1, now(), '김성재', 'ENROLLED');
insert into student_tb(birthday, course_id, create_date, name, state)
values('800101', 1, now(), '류재성', 'ENROLLED');
insert into student_tb(birthday, course_id, create_date, name, state)
values('700101', 1, now(), '박동기', 'ENROLLED');


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

insert into paper_tb(subject_id, create_date, count)
values(1, now(), 2);
insert into paper_tb(subject_id, create_date, count)
values(2, now(), 5);

insert into question_tb(no, title, point, answer_number, paper_id, create_date)
values(1, '다음 중 for문 설명으로 틀린것은?', 50, 4, 1, now());
insert into question_tb(no, title, point, answer_number, paper_id, create_date)
values(2, '다음 중 while문 설명으로 틀린것은?', 50, 4, 1, now());

insert into question_tb(no, title, point, answer_number, paper_id, create_date)
values(1, '다음 중 select 설명으로 틀린것은?', 20, 4, 2, now());
insert into question_tb(no, title, point, answer_number, paper_id, create_date)
values(2, '다음 중 insert 설명으로 틀린것은?', 20, 4, 2, now());
insert into question_tb(no, title, point, answer_number, paper_id, create_date)
values(3, '다음 중 update 설명으로 틀린것은?', 20, 4, 2, now());
insert into question_tb(no, title, point, answer_number, paper_id, create_date)
values(4, '다음 중 delete 설명으로 틀린것은?', 20, 4, 2, now());
insert into question_tb(no, title, point, answer_number, paper_id, create_date)
values(5, '다음 중 dml 설명으로 틀린것은?', 20, 4, 2, now());


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

