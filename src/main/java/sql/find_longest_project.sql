SELECT CONCAT('Project ', id) AS name, TIMESTAMPDIFF(MONTH, start_date, finish_date) AS month_count 
FROM project
GROUP BY id 
HAVING month_count = (
       SELECT MAX(TIMESTAMPDIFF (MONTH, start_date, finish_date)) 
	   FROM project
); 