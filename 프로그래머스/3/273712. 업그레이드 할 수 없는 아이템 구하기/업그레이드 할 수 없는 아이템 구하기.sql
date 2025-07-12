-- 코드를 작성해주세요
SELECT
    I.ITEM_ID,
    I.ITEM_NAME,
    I.RARITY
FROM item_info I
LEFT JOIN item_tree T ON I.item_id = T.parent_item_id
WHERE T.item_id IS NULL
ORDER BY I.item_id DESC