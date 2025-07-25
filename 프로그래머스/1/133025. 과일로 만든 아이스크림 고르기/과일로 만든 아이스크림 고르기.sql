-- 코드를 입력하세요
SELECT
    f.flavor
FROM first_half f
WHERE f.flavor in
    (
        SELECT i.flavor
        FROM icecream_info i
        WHERE i.ingredient_type = 'fruit_based'
    )
    AND f.total_order > 3000