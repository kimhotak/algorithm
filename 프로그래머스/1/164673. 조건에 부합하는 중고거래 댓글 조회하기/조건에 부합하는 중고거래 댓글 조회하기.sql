SELECT
    b.title AS 'TITLE',
    b.board_id AS 'BOARD_ID',
    r.reply_id AS 'REPLY_ID',
    r.writer_id AS 'WRITER_ID',
    r.contents AS 'CONTENTS',
    DATE_FORMAT(r.created_date, '%Y-%m-%d') AS CREATED_DATE
FROM USED_GOODS_BOARD b
INNER JOIN USED_GOODS_REPLY r
ON b.board_id = r.board_id
WHERE DATE_FORMAT(b.created_date,'%Y%m') = '202210'
ORDER BY r.created_date ASC , b.title ASC