-- 코드를 입력하세요
SELECT
    f.flavor
FROM first_half as f
JOIN (
    SELECT
        flavor,
        SUM(total_order) as total_order
    FROM july
    GROUP BY flavor
) as j ON f.flavor = j.flavor
ORDER BY f.total_order + j.total_order DESC
LIMIT 3
