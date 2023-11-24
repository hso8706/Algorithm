-- 코드를 입력하세요
SELECT DISTINCT CAR.CAR_ID
FROM CAR_RENTAL_COMPANY_CAR CAR
JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY HIS ON CAR.CAR_ID = HIS.CAR_ID
WHERE CAR.CAR_TYPE = '세단'
AND MONTH(HIS.START_DATE) = 10
ORDER BY CAR_ID DESC;