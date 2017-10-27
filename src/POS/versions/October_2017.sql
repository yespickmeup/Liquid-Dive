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





