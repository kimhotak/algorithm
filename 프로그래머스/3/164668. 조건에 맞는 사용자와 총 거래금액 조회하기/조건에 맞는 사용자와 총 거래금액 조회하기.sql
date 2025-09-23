-- 코드를 입력하세요
SELECT
    U.user_id AS USER_ID,
    U.nickname AS NICKNAME,
    SUM(B.price) AS TOTAL_SALES
FROM used_goods_board B
LEFT JOIN used_goods_user U ON B.writer_id = U.user_id
WHERE B.status = 'DONE'
GROUP BY B.writer_id
HAVING SUM(B.price) >= 700000
ORDER BY TOTAL_SALES ASC