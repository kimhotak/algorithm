-- 코드를 작성해주세요
SELECT
    COUNT(id) AS FISH_COUNT,
    CAST(date_format(time,'%m') AS SIGNED) AS MONTH
FROM fish_info
GROUP BY month
ORDER BY month ASC