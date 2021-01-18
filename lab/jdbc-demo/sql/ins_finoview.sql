insert into account (iban,holder,swift,accountnumber,bankcode)
values ('ATxxxxxxxxxxxxxxxxxx', 'Someone','ULNPZA2LXXX', 0 ,30006);

insert into payment(id, paymentdate,amount,currency,bookinginfo,accountiban)
values(0, '1980-12-08',6969.69,'EUR','Some details','ATxxxxxxxxxxxxxxxxxx');
--values(0, '08-DEC-80',6969.69,'EUR','Some details','ATxxxxxxxxxxxxxxxxxx');

insert into booking (id, amount, paymentid, bookingdate)
values (0, 1000, 0,  '1980-12-08');
--values (0, 1000, 0,  '8-DEC-80');

insert into booking (id, amount, paymentid, bookingdate)
values (1, 5969.69, 0,  '1980-12-31');
--values (1, 5969.69, 0,  '31-DEC-80');

insert into category (abbr,name)
values('inc','income');

insert into bookingcategory (categoryabbr, bookingid)
values ('inc', 0);

insert into bookingcategory (categoryabbr, bookingid)
values ('inc', 1);
