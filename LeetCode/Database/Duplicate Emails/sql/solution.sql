# Write your MySQL query statement below
# Write your MySQL query statement bel
select email as Email
from Person
group by email
having count(email)>1;