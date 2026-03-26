-- 코드를 입력하세요
SELECT
    o.ANIMAL_ID,
    o.NAME
FROM animal_ins i
right JOIN animal_outs o ON  o.animal_id = i.animal_id
WHERE i.animal_id IS NULL