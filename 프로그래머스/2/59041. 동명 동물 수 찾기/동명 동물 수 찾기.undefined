-- 코드를 입력하세요
SELECT name, COUNT(*)
FROM animal_ins
GROUP BY name
HAVING COUNT(*) > 1 AND NOT name IS NULL
ORDER BY name ASC