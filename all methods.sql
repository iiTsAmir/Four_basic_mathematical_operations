create database library

use library

create table books(
[id] int primary key identity(100,1),
[name] nvarchar(50) not null,
)

create table members(
[id] int primary key identity(0,1),
[name] nvarchar(50),
)

create table Borrows(
[id] int primary key identity(1000,1),
[date] datetime2,
[member_id] int foreign key references members(id),
[book_id] int foreign key references books(id),
)


ALTER TABLE books
ADD stock int

EXEC sp_rename 'members.[name]',  'mname', 'COLUMN';

INSERT INTO members VALUES
('davood');



select* from books

SELECT DISTINCT [name] FROM books;

select * from members,Borrows
where mid = member_id

select bname,member_id from books,Borrows
where bid = book_id

select mid,mname,bname,[date] from members,books,Borrows
where mid = member_id and bid = book_id and mname like 'sh%az'
ORDER BY mid

select count(*)from Borrows

select DISTINCT mname from Borrows,members
where members.mid = member_id

select sum(stock)from books

select bname,stock from books
where stock<5



drop table books
truncate table books