-- 코드를 입력하세요
SELECT
    I.ANIMAL_ID,
    I.NAME
FROM animal_ins I
LEFT JOIN animal_outs O ON I.animal_id = O.animal_id
WHERE O.datetime < I.datetime
ORDER BY I.datetime ASC