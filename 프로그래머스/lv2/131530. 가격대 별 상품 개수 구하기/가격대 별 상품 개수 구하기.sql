-- 코드를 입력하세요
SELECT
    price DIV 10000 * 10000 AS PRICE_GROUP,
    COUNT(product_id) AS PRODUCTS
FROM product
GROUP BY price DIV 10000
ORDER BY price_group ASC