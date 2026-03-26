-- 코드를 입력하세요
SELECT 
    DISTINCT C.car_id AS CAR_ID
FROM car_rental_company_car C
LEFT JOIN car_rental_company_rental_history RH ON C.car_id = RH.car_id
WHERE C.car_type = '세단' AND DATE_FORMAT(RH.start_date,'%m') = '10'
ORDER BY CAR_ID DESC