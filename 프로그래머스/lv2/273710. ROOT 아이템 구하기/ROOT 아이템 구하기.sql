-- 코드를 작성해주세요
SELECT
    i.item_id AS ITEM_ID,
    i.item_name AS ITEM_NAME
FROM item_info i
JOIN item_tree t ON i.item_id=t.item_id
WHERE t.parent_item_id IS NULL