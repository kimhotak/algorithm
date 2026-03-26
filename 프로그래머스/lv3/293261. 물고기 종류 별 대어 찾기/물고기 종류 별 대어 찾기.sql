SELECT
    ID,
    FISH_NAME,
    LENGTH
FROM FISH_NAME_INFO AS a
JOIN FISH_INFO AS b
ON a.fish_type = b.fish_type
JOIN (
    SELECT
        fish_type,
        MAX(length) as ml
    FROM FISH_INFO
    GROUP BY fish_type
) AS c
ON b.fish_type = c.fish_type
WHERE a.fish_type = c.fish_type and b.length = c.ml 
ORDER BY ID ASC