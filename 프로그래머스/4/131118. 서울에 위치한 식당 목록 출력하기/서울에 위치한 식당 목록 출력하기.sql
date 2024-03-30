-- 식당 정보 : REST_INFO  (REST_ID, REST_NAME, FOOD_TYPE, VIEWS, FAVORITES, PARKINGLOT, ADDRESS , TEL)
-- 식당 리뷰 : REST_REVIEW (REVIEW_ID, REST_ID, MEMBER_ID, REVIEW_SCORE, REVIEW_TEXT, REVIEW_DATE)

-- 서울 위치 식당들의 REST_ID, REST_NAME, FOOD_TYPE, FAVORITES , ADDRESS, (AVG)REVIEW_SCORE- 소수점 세번쨰 반올림
-- 정렬 기준 : 평균 점수 기준 DESC , 즐겨찾기수 DESC

SELECT ri.REST_ID, REST_NAME, FOOD_TYPE, FAVORITES, ADDRESS, ROUND(AVG(rr.REVIEW_SCORE) , 2) as SCORE
from rest_info as ri 
Inner join rest_review as rr USING(rest_id)
where ri.ADDRESS like "서울%"
group by ri.rest_id
order by SCORE DESC , FAVORITES DESC;