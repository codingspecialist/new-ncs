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
