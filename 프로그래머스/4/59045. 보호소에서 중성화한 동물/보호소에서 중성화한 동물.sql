-- 코드를 입력하세요
SELECT
    I.ANIMAL_ID,
    I.ANIMAL_TYPE,
    I.NAME
FROM animal_ins I
RIGHT JOIN animal_outs O ON I.animal_id = O.animal_id
WHERE I.sex_upon_intake LIKE '%intact%'
    AND (O.sex_upon_outcome LIKE '%spayed%'
        OR O.sex_upon_outcome LIKE '%neutered%')