-- 코드를 입력하세요
SELECT
    B.category AS CATEGORY,
    SUM(BS.sales) AS TOTAL_SALES
FROM book B
LEFT JOIN book_sales BS ON B.book_id = BS.book_id
WHERE DATE_FORMAT(BS.sales_date,'%Y-%m') = '2022-01'
GROUP BY B.category
ORDER BY CATEGORY ASC