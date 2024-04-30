insert into user_tb(username, password, email, name, created_at) values('ssar', '1234', 'ssar@nate.com', '쌀',now());
insert into user_tb(username, password, email, name, created_at) values('cos', '1234', 'cos@nate.com', '코스',now());
insert into user_tb(username, password, email, name, created_at) values('love', '1234', 'love@nate.com', '러브',now());

insert into course_tb(code, course_status, create_date, end_date, level, purpose, round, start_date, teacher_name, title, total_day, total_time)
values('C1001', 'RUNNING', now(), '2024-11-01', 5, '플러터를 통해 크로스 플랫폼을 학습한다', 1, '2024-05-01', '홍길동', '자바 크로스 플랫폼 과정', 120, 900);

insert into course_tb(code, course_status, create_date, end_date, level, purpose, round, start_date, teacher_name, title, total_day, total_time)
values('C1002', 'RUNNING', now(), '2024-11-01', 5, '리엑트를 통해 크로스 플랫폼을 학습한다', 1, '2024-05-01', '장보고', '리엑트 크로스 플랫폼 과정', 120, 900);

insert into course_tb(code, course_status, create_date, end_date, level, purpose, round, start_date, teacher_name, title, total_day, total_time)
values('C1003', 'NOT_STARTED', now(), '2025-02-01', 3, '플러터를 통해 크로스 플랫폼을 학습한다', 2, '2024-08-01', '홍길동', '자바 크로스 플랫폼 과정', 120, 900);

insert into subject_tb(code, course_id, create_date, end_date, evaluation_date, evaluation_way, grade, gubun, learning_way, no, purpose, revaluation_date, start_date, title, total_time)
values('S1001', 1, now(), '2024-05-10', '2024-05-10', '서술형시험', 3, 'NCS', '실습', 1, '자바 for, if, 객체지향을 학습하여 프로그래밍의 기본기를 배양하는 능력이다', '2024-05-11', '2024-05-01', '자바', 80);

insert into subject_tb(code, course_id, create_date, end_date, evaluation_date, evaluation_way, grade, gubun, learning_way, no, purpose, revaluation_date, start_date, title, total_time)
values('S1002', 1, now(), '2024-05-20', '2024-05-20', '서술형시험', 5, '비NCS', '실습', 2, '디비 CRUD를 학습하여 SQL의 기본기를 배양하는 능력이다', '2024-05-21', '2024-05-10', 'SQL', 40);

insert into student_tb(birthday, course_id, create_date, name, state)
values('860221', 1, now(), '김성훈', 'ENROLLED');

insert into student_tb(birthday, course_id, create_date, name, state)
values('900101', 1, now(), '김주혁', 'ENROLLED');

insert into student_tb(birthday, course_id, create_date, name, state)
values('950501', 1, now(), '설동훈', 'ENROLLED');

insert into student_tb(birthday, course_id, create_date, name, state)
values('950501', 1, now(), '이종한', 'ENROLLED');

insert into student_tb(birthday, comment, course_id, create_date, drop_out_date, drop_out_reason, grade, name, state)
values('800825', '탈락자 총평없음', 1, now(), '2024-07-01', '몸이아픔', 0, '이종환', 'DROPOUT');

insert into subject_element_tb(create_date, no, subject_id, subtitle)
values(now(), 1, 1, '연산자');

insert into subject_element_tb(create_date, no, subject_id, subtitle)
values(now(), 2, 1, '객체지향');

insert into subject_element_tb(create_date, no, subject_id, subtitle)
values(now(), 3, 1, '오버로딩');

insert into subject_element_tb(create_date, no, subject_id, subtitle)
values(now(), 4, 1, '스레드');

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

