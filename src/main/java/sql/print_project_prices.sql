SELECT CONCAT('Project ', project_worker.project_id) AS name, SUM(worker.salary)*TIMESTAMPDIFF (MONTH, start_date, finish_date) AS price
FROM project_worker 
JOIN worker ON (worker.id = project_worker.worker_id)
JOIN project ON (project.id = project_worker.project_id)
GROUP BY project.id 
ORDER BY price DESC;
