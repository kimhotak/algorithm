-- 코드를 입력하세요
SELECT
    LEFT(product_code,2) AS CATEGORY
    ,COUNT(product_code) AS PRODUCTS
FROM product
GROUP BY LEFT(product_code,2)