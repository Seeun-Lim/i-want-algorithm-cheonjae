-- 코드를 입력하세요
-- REST_ID	REST_NAME	FOOD_TYPE	FAVORITES	ADDRESS	SCORE
SELECT ri.REST_ID, ri.REST_NAME, ri.FOOD_TYPE, ri.FAVORITES, ri.ADDRESS, ROUND(avg(rr.REVIEW_SCORE), 2) as SCORE
FROM REST_INFO ri, REST_REVIEW rr
WHERE ri.REST_ID = rr.REST_ID
AND ri.ADDRESS LIKE '서울%'
GROUP BY ri.REST_ID
ORDER BY SCORE desc, FAVORITES desc;