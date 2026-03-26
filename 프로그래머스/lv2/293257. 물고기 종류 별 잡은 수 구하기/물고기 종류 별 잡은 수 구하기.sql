-- 코드를 작성해주세요
SELECT
    COUNT(id) AS FISH_COUNT,
    FISH_NAME
FROM fish_info fi
LEFT JOIN fish_name_info fn
    ON fi.fish_type = fn.fish_type
GROUP BY fish_name
ORDER BY FISH_COUNT DESC