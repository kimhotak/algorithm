-- 코드를 입력하세요
SELECT
    PRODUCT_CODE,
    P.price * SUM(OS.sales_amount) AS SALES
FROM product P
RIGHT JOIN offline_sale OS ON P.product_id = OS.product_id
GROUP BY P.product_code
ORDER BY SALES DESC, P.product_code ASC