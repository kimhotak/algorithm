-- 코드를 입력하세요
SELECT
    ORDER_ID,
    PRODUCT_ID,
    DATE_FORMAT(OUT_DATE,'%Y-%m-%d') AS OUT_DATE,
    CASE
        WHEN out_date IS NULL THEN '출고미정'
        WHEN out_date < '2022-05-02' THEN '출고완료'
        ELSE '출고대기'
    END AS 출고여부
FROM food_order
ORDER BY order_id ASC;