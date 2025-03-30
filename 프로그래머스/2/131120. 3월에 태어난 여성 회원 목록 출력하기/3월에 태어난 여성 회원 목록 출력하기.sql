-- 코드를 입력하세요
SELECT
    MEMBER_ID,
    MEMBER_NAME,
    GENDER,
    date_format(date_of_birth,'%Y-%m-%d') AS DATE_OF_BIRTH
FROM member_profile
WHERE MONTH(date_of_birth) = 3 AND NOT tlno IS  NULL AND gender = 'W'
ORDER BY member_id ASC