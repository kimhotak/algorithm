-- 코드를 입력하세요
SELECT
    BOOK_ID,
    date_format(published_date,'%Y-%m-%d') AS PUBLISHED_DATE
FROM book
WHERE YEAR(published_date) = 2021 AND category = '인문'
ORDER BY published_date