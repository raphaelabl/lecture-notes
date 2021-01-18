select bc., b.
    from bookingcategory bc
    inner join booking b
        on bc.bookingid = b.id;

select  b.*, p.*
    from booking b
    inner join payment p
        on b.paymentid = p.id;