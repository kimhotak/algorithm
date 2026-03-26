SELECT
    b.YEAR,
    b.max_size_year - size_of_colony AS YEAR_DEV,
    a.ID
FROM ECOLI_DATA a
JOIN (
    SELECT
        YEAR(differentiation_date) AS year,
        MAX(size_of_colony) AS max_size_year
    FROM ECOLI_DATA
    GROUP BY year
) AS b ON YEAR(differentiation_date) = b.year
ORDER BY YEAR ASC, YEAR_DEV ASC