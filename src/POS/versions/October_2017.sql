/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Guinness
 * Created: Oct 21, 2017
 */




2.0 | 199 | San Miguel Light | 65.00 | 0.00 | 130.00
1.0 | 199 | San Miguel Light | 65.00 | 3.25 | 61.75
1.0 | 199 | San Miguel Light | 65.00 | 16.25 | 48.75
1.0 | 199 | San Miguel Light | 65.00 | 0.00 | 65.00
1.0 | 199 | San Miguel Light | 32.50 | 16.25 | 16.25
1.0 | 199 | San Miguel Light | 32.50 | 16.25 | 16.25
1.0 | 199 | San Miguel Light | 80.00 | 0.00 | 80.00
1.0 | 199 | San Miguel Light | 80.00 | 0.00 | 80.00
1.0 | 2813 | House of Pandesal | 80.00 | 0.00 | 80.00
1.0 | 2813 | House of Pandesal | 80.00 | 0.00 | 80.00
1.0 | 1428 | Caipirinha | 250.00 | 0.00 | 250.00
1.0 | 1429 | Caipiroska | 185.00 | 0.00 | 185.00
1.0 | 2813 | Pizza | 420 | 0.00 | 420.00
1.0 | 6574 | black olives bagel | 0.00 | 0.00 | 0.00
1.0 | 2759 | chili bagel | 0.00 | 0.00 | 0.00


delete from stock_in;
delete from stock_in_main;

alter table stock_in add cost double default 0;
alter table stock_in add types varchar(255);
alter table stock_in add types_num varchar(255);
alter table stock_in add cat_id varchar(255);
alter table stock_in add stock_in_no varchar(255);
alter table stock_in add remarks varchar(255);
alter table stock_in add supplier varchar(255);

alter table stock_in_main add remarks varchar(255);
alter table stock_in_main add supplier varchar(255);



delete from stock_out;
delete from stock_out_main;

alter table stock_out add cost double default 0;
alter table stock_out add types varchar(255);
alter table stock_out add types_num varchar(255);
alter table stock_out add cat_id varchar(255);
alter table stock_out add stock_in_no varchar(255);
alter table stock_out add remarks varchar(255);
alter table stock_out add supplier varchar(255);

alter table stock_out_main add remarks varchar(255);
alter table stock_out_main add supplier varchar(255);


drop table if exists inventory_replenishments;
create table inventory_replenishments(
id int auto_increment primary key
,replenishment_no varchar(255)
,date_added datetime
,added_by varchar(255)
,remarks varchar(255)
,status int
,no_of_items int
);

drop table if exists inventory_replenishment_items;
create table inventory_replenishment_items(
id int auto_increment primary key
,replenishment_no varchar(255)
,item_code varchar(255)
,description varchar(255)
,product_qty double
,price double
,cost double
,category varchar(255)
,category_id varchar(255)
,sub_category varchar(255)
,sub_category_id varchar(255)
,is_active int
,item_package int
,status int
,date_added datetime
,added_by varchar(255)
,remarks varchar(255)
);

