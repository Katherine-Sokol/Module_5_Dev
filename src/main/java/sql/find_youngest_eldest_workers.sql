SELECT 'YOUNGEST' AS type, name, birthday 
FROM worker
GROUP BY name 
HAVING TIMESTAMPDIFF(DAY, birthday, CURRENT_DATE) = (
       SELECT MIN(TIMESTAMPDIFF(DAY, birthday, CURRENT_DATE)) 
       FROM worker
)
UNION
SELECT 'ELDEST' AS type, name, birthday
FROM worker
GROUP BY name 
HAVING TIMESTAMPDIFF(DAY, birthday, CURRENT_DATE) = (
       SELECT MAX(TIMESTAMPDIFF(DAY, birthday, CURRENT_DATE)) 
       FROM worker
);