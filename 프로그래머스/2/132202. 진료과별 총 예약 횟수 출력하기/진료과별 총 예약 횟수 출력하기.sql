-- 코드를 입력하세요
SELECT
     mcdp_cd AS 진료과코드
     ,COUNT(*) AS 5월예약건수
FROM appointment
WHERE apnt_ymd BETWEEN '2022-05-01' AND '2022-05-31'
GROUP BY mcdp_cd
ORDER BY 5월예약건수 ASC, mcdp_cd ASC;