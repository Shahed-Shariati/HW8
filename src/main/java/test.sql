select * from category;
ALTER SEQUENCE category_id_seq RESTART WITH 1


SELECT * FROM product p INNER JOIN category c on c.id = p.category_id WHERE c.category_id = 1

SELECT * FROM customer INNER JOIN users u on u.id = customer.user_id
WHERE u.id = 2

select * from shopping;


ALTER SEQUENCE shopping_id_seq RESTART WITH 1