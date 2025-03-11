-- 코드를 입력하세요
SELECT
    I.name,
    I.datetime
FROM animal_ins I
LEFT JOIN animal_outs O ON I.animal_id = O.animal_id
WHERE O.datetime IS NULL
ORDER BY I.datetime ASC
LIMIT 3