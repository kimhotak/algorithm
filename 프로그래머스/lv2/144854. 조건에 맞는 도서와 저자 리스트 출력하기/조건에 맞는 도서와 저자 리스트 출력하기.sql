-- 코드를 입력하세요
SELECT
    B.BOOK_ID,
    A.AUTHOR_NAME,
    DATE_FORMAT(B.PUBLISHED_DATE,'%Y-%m-%d')
FROM book B
LEFT JOIN author A on B.author_id = A.author_id
WHERE category = '경제'
ORDER BY published_date ASC