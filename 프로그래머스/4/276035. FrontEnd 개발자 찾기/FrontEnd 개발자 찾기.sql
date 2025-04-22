SELECT DISTINCT
    ID,
    EMAIL,
    FIRST_NAME,
    LAST_NAME
FROM developers d JOIN skillcodes s ON s.code & d.skill_code
WHERE s.category = 'Front End'
ORDER BY ID