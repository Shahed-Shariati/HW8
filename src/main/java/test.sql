select * from category;
ALTER SEQUENCE category_id_seq RESTART WITH 1


SELECT * FROM product p INNER JOIN category c on c.id = p.category_id WHERE c.category_id = 1;

SELECT * FROM customer INNER JOIN users u on u.id = customer.user_id;
WHERE u.id = 2

select * from shopping;


ALTER SEQUENCE itemcart_id_seq RESTART WITH 1;
ALTER SEQUENCE shopping_id_seq RESTART WITH 1;


SELECT i.id,p.product_name,p.price,i.quantity,i.sum FROM shopping s INNER JOIN itemcart i on s.id = i.cart_id
INNER JOIN product p on p.id = i.product_id WHERE s.id = 1;

SELECT * FROM shopping WHERE customer_id = 1;

SELECT * FROM itemcart i INNER JOIN product p on p.id = i.product_id
WHERE i.cart_id = 1;