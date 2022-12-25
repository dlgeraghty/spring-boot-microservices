insert into user_details(id,birth_date,name)
values(10001, current_date(), 'david');

insert into user_details(id,birth_date,name)
values(10002, current_date(), 'pepe');

insert into user_details(id,birth_date,name)
values(10003, current_date(), 'alfonso');

insert into post(id,description,user_id)
values(20001, 'I want to learn aws', 10001);

insert into post(id,description,user_id)
values(20002, 'I want to learn devops', 10001);

insert into post(id,description,user_id)
values(20003, 'I want to learn AWS Certified', 10002);

insert into post(id,description,user_id)
values(20004, 'I want to learn Multicloud', 10002);