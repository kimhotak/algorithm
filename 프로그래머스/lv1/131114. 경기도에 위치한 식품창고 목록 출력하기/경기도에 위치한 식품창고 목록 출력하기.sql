-- 코드를 입력하세요
SELECT WAREHOUSE_ID,WAREHOUSE_NAME,ADDRESS,
    CASE
        WHEN freezer_yn IS NULL THEN 'N'
        ELSE freezer_yn
    END FREEZER_YN
FROM food_warehouse
WHERE warehouse_name LIKE '%경기%'
ORDER BY WAREHOUSE_ID