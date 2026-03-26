SELECT
    DATE_FORMAT(sales_date,'%Y-%m-%d') AS SALES_DATE,
    PRODUCT_ID,
    USER_ID,
    SALES_AMOUNT
FROM online_sale
WHERE DATE_FORMAT(sales_date, '%Y%m') = '202203'

UNION

SELECT
    DATE_FORMAT(sales_date,'%Y-%m-%d') AS SALES_DATE,
    PRODUCT_ID,
    NULL AS USER_ID,
    SALES_AMOUNT
FROM offline_sale
WHERE DATE_FORMAT(sales_date,'%Y%m') = '202203'

ORDER BY sales_date ASC, product_id ASC, user_id ASC