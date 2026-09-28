SELECT P.project_id, ROUND(AVG(CAST(E.experience_years AS DECIMAL(5,2))),2) AS average_years 
FROM Project P 
JOIN Employee E 
ON P.employee_id = E.employee_id 
GROUP BY P.project_id;