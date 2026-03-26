-- 코드를 입력하세요
SELECT
    r1.FOOD_TYPE,
    REST_ID,
    REST_NAME,
    FAVORITES
FROM rest_info r1
LEFT JOIN (
    SELECT
        MAX(favorites) AS max_favorite,
        food_type
    FROM rest_info
    GROUP BY food_type
) r2
ON r1.food_type = r2.food_type
WHERE r1.favorites = r2.max_favorite
ORDER BY food_type DESC