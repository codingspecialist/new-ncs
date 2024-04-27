insert into user_tb(username, password, email, name, created_at) values('ssar', '1234', 'ssar@nate.com', '쌀',now());
insert into user_tb(username, password, email, name, created_at) values('cos', '1234', 'cos@nate.com', '코스',now());
insert into user_tb(username, password, email, name, created_at) values('love', '1234', 'love@nate.com', '러브',now());

insert into course_tb
(code, course_status, create_date, end_date, level, purpose, round, start_date, teacher_name, title, total_day, total_time)
values
    ('1001', 'RUNNING', now(), '2024-11-01', 5, '플러터를 통해 크로스 플랫폼을 학습한다', 1, '2024-05-01', '홍길동', '자바 크로스 플랫폼 과정', 120, 900);

insert into course_tb
(code, course_status, create_date, end_date, level, purpose, round, start_date, teacher_name, title, total_day, total_time)
values
    ('1002', 'RUNNING', now(), '2024-11-01', 5, '리엑트를 통해 크로스 플랫폼을 학습한다', 1, '2024-05-01', '장보고', '리엑트 크로스 플랫폼 과정', 120, 900);


insert into course_tb
(code, course_status, create_date, end_date, level, purpose, round, start_date, teacher_name, title, total_day, total_time)
values
    ('1003', 'NOT_STARTED', now(), '2025-02-01', 3, '플러터를 통해 크로스 플랫폼을 학습한다', 2, '2024-08-01', '홍길동', '자바 크로스 플랫폼 과정', 120, 900);
