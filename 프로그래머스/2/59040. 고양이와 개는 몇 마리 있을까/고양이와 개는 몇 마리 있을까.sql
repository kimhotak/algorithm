-- 코드를 입력하세요
SELECT
    ANIMAL_TYPE,
    COUNT(*) AS count
FROM animal_ins
WHERE animal_type In ('Cat', 'Dog')
GROUP BY animal_type
ORDER BY animal_type ASC