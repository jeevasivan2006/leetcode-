# Write your MySQL query statement below
SELECT c.name as Customers
from Customers c
left join Orders o
on c.id=o.customerId
where o.CustomerId is NULL; 