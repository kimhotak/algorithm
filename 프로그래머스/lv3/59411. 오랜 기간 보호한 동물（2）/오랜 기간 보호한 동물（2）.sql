-- 코드를 입력하세요
SELECT
    I.animal_id AS ANIMAL_ID,
    I.name AS NAME
FROM animal_ins I
RIGHT JOIN animal_outs O ON I.animal_id = O.animal_id
ORDER BY O.datetime - I.datetime DESC
LIMIT 2;