SELECT client.name, COUNT(project.id) AS project_count 
FROM client 
JOIN project ON (client.id = project.client_id)
GROUP BY client.name 
HAVING project_count = (
       SELECT MAX(project_count) 
       FROM (
            SELECT COUNT(*) AS project_count 
            FROM project 
            GROUP BY client_id
       ) AS temp
);


