-- 코드를 입력하세요
SELECT
    f1.CATEGORY,
    f1.price AS MAX_PRICE,
    f1.PRODUCT_NAME
FROM food_product f1
JOIN(
    SELECT
        MAX(price) AS max_price,
        category
    FROM food_product
    WHERE category in ('과자', '국', '김치', '식용유')
    GROUP BY category
) f2
WHERE f1.price = f2.max_price and f1.category = f2.category
ORDER BY MAX_PRICE DESC