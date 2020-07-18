create database CustomerApp;

use CustomerApp;

create table product(
	product_code int primary key,
    product_name varchar(45),
    price float,
    quantity int
);

create table customer(
	customer_number int primary key,
    customer_name varchar(45),
    address varchar(100),
    city varchar(45),
    country varchar(25)
);

create table orders(
	order_number int primary key,
    customer_number int not null,
    product_code int not null,
    total_price float,
    order_quantity int,
    foreign key(customer_number) references customer(customer_number),
    foreign key(product_code) references product(product_code)
);

insert into product values(1, 'Twix Bar', 1.50, 100 );
insert into product values(2, 'Milk', 3.00, 30 );
insert into product values(3, 'Corn Flakes', 7.50, 15);

insert into customer values(1, 'Bob', '1234 Red Avenue', 'Boston', 'United States');
insert into customer values(2, 'Tim', '5678 Blue Street', 'Houston', 'United States');
insert into customer values(3, 'Matt', '35 Main Street', 'New York', 'United States');

insert into orders values(1, 1, 2, 6.00, 2);
insert into orders values(2, 1, 3, 7.50, 1);
insert into orders values(3, 2, 1, 4.50, 3);
insert into orders values(4, 3, 2, 3.00, 1);
insert into orders values(5, 1, 3, 37.50, 5);

