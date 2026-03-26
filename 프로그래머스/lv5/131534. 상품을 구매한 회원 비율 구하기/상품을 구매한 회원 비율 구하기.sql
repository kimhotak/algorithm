-- 코드를 입력하세요
SELECT
    YEAR(o.sales_date) AS YEAR,
    MONTH(o.sales_date) AS MONTH,
    COUNT(DISTINCT(u.user_id)) AS PURCHASED_USERS,
    ROUND(COUNT(DISTINCT(u.user_id))/(
        SELECT COUNT(*)
        FROM user_info
        WHERE DATE_FORMAT(joined,'%Y') = '2021'
    ),1) AS PUCHASED_RATIO
FROM user_info u
JOIN online_sale o ON u.user_id=o.user_id
WHERE DATE_FORMAT(u.joined,'%Y') = '2021' AND o.user_id is not null
GROUP BY DATE_FORMAT(o.sales_date,'%y%m')
ORDER BY year ASC, month ASC