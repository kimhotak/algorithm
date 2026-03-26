SELECT i.REST_ID, REST_NAME, FOOD_TYPE, FAVORITES, ADDRESS,
    ROUND(AVG(r.review_score), 2) AS 'SCORE'
FROM rest_info i
JOIN rest_review r ON i.rest_id = r.rest_id
WHERE i.address LIKE '서울%'
GROUP BY rest_id
ORDER BY score DESC, favorites DESC