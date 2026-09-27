SELECT d.name as Department,e.name as Employee,e.salary as Salary
FROM Employee e
left JOIN Department d 
on e.departmentId=d.id 
where e.salary=(SELECT MAX(salary) FROM Employee e where e.departmentId=d.id ) ;