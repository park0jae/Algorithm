-- 평균 대여 기간이 7일 이상인 자동차들의 자동차 ID와 평균 대여 기간 출력 (소숫점 두번째 자리에서 반올림) 
-- 평균 대여기간 기준 내림차순 , 자동차 ID 내림차순

SELECT CAR_ID , ROUND(AVG(DATEDIFF(END_DATE,START_DATE)+1),1) AS AVERAGE_DURATION
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
HAVING AVERAGE_DURATION >= 7
ORDER BY AVERAGE_DURATION DESC, CAR_ID DESC

# SELECT CAR_ID, ROUND(AVG(DATEDIFF(END_DATE,START_DATE)+1),1) AS AVERAGE_DURATION
# FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
# GROUP BY CAR_ID
# HAVING AVERAGE_DURATION >= 7
# ORDER BY AVERAGE_DURATION DESC, CAR_ID DESC