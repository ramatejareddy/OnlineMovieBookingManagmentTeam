Insert into LPU_MOVIE_THEATRE(theatre_Id,theatre_Name,theatre_City,manager_Name,manager_Contact) values(2001, 'VIVA','Jalandhar','Ram',9875642548);
Insert into LPU_MOVIE_THEATRE(theatre_Id,theatre_Name,theatre_City,manager_Name,manager_Contact) values(2002, 'MBR','Jalandhar','Sam',7896541256);
Insert into LPU_MOVIE_THEATRE(theatre_Id,theatre_Name,theatre_City,manager_Name,manager_Contact) values(2003, 'PVR','Phagwara','Shyam',7568945211);
Insert into LPU_MOVIE_THEATRE(theatre_Id,theatre_Name,theatre_City,manager_Name,manager_Contact) values(2004, 'ASIAN','Phagwara','Singh',8974561258);
Insert into LPU_MOVIE_THEATRE(theatre_Id,theatre_Name,theatre_City,manager_Name,manager_Contact) values(2005, 'MBD MALL','Amritsar','Harpal',6548974586);

select * from LPU_MOVIE_THEATRE;


insert into LPU_MOVIE_MOVIE(movie_Id,movie_Name,language,director,genre) values(1001,'bahubali','telugu','ssr','action');
insert into LPU_MOVIE_MOVIE(movie_Id,movie_Name,language,director,genre) values(1002,'war','hindi','karan','action');
insert into LPU_MOVIE_MOVIE(movie_Id,movie_Name,language,director,genre) values(1003,'kgf','kannada','prashanth','action');
insert into LPU_MOVIE_MOVIE(movie_Id,movie_Name,language,director,genre) values(1004,'wfl','telugu','vd','Romantic');
insert into LPU_MOVIE_MOVIE(movie_Id,movie_Name,language,director,genre) values(1005,'hit','telugu','sudheer','thriller');

select * from LPU_MOVIE_MOVIE;

insert into lpu_movie_customer(customerid,customer_name,customer_contact,dateof_birth,password) values(1,'sai krishna',9482136421,To_Date('1998/07/21','yyyy/mm/dd'),'krishna');
insert into lpu_movie_customer(customerid,customer_name,customer_contact,dateof_birth,password) values(2,'hemanth',9482136421,To_Date('1996/09/20','yyyy/mm/dd'),'hemanth');
select * from lpu_movie_customer;

insert into lpu_movie_user(user_id,name,username,userpassword,isadmin,dateof_birth,contact) values(1001,'Javvadi Sai Krishna','KRISHNA','krishna',1,To_Date('1998/07/21','yyyy/mm/dd'),7889290843);
insert into lpu_movie_user(user_id,name,username,userpassword,isadmin,dateof_birth,contact) values(2000,'Chityala Hemanth Reddy','HEMANTH','hemanth',0,To_Date('1998/09/12','yyyy/mm/dd'),9515958234);
select * from lpu_movie_user;
