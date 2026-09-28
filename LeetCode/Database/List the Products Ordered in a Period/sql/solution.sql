SELECT product_name, SUM(unit) AS unit FROM Products p
JOIN Orders o
ON p.product_id = o.product_id
WHERE YEAR(order_date) = 2020 AND MONTH(order_date) = 2
GROUP BY o.product_id
HAVING SUM(unit) >=100;