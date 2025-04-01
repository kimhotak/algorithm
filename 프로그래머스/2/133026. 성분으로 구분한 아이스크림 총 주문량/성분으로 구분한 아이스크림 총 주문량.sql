-- 코드를 입력하세요
SELECT
    I.INGREDIENT_TYPE,
    SUM(F.total_order) AS TOTAL_ORDER
FROM first_half F
LEFT JOIN icecream_info I ON F.flavor = I.flavor
GROUP BY I.INGREDIENT_TYPE