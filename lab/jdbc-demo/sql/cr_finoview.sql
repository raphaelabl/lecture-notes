create table account (
    iban varchar(40),
    holder varchar(40),
    swift varchar(40),
    accountnumber numeric(10),
    bankcode numeric(10),
    constraint pk_account primary key (iban)
);

create table payment (
    id numeric(10),
    paymentdate  date,
    amount  numeric(10,2),
    currency varchar(3),
    bookinginfo varchar(100),
    accountiban varchar(40),
    constraint pk_payment primary key (id),
    constraint fk_payment_account foreign key (accountiban)
        references account(iban)
);

create table booking (
    id numeric(10),
    amount numeric(10,2),
    paymentid numeric(10),
    bookingdate date,
    constraint pk_booking primary key (id),
    constraint fk_booking_payment foreign key(paymentid)
        references payment(id)
);

create table category (
    abbr varchar(10),
    name varchar(40),
    constraint pk_category primary key (abbr)
);

create table bookingcategory(
    categoryabbr varchar(10),
    bookingid numeric(10),
    constraint pk_bookingcategory primary key (categoryabbr, bookingid),
    constraint fk_bookingcategory_category foreign key (categoryabbr)
        references category(abbr) on delete cascade,
    constraint fk_bookingcategory_booking foreign key (bookingid)
        REFERENCES booking(id) on delete cascade
);


