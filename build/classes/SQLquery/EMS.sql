create database DBEmployee

use DBEmployee

create table Employee (
	empCode varchar(10) primary key,
	empName varchar(30),
	empGender bit,
	empAge int,
	empAddress varchar(50) 
)