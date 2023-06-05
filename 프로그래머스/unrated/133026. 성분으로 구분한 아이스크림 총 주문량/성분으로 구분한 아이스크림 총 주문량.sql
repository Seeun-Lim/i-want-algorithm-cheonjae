-- 코드를 입력하세요
SELECT i.INGREDIENT_TYPE, SUM(h.TOTAL_ORDER) AS TOTAL_ORDER
FROM FIRST_HALF h JOIN ICECREAM_INFO i
ON h.flavor = i.flavor
GROUP BY i.INGREDIENT_TYPE
ORDER BY TOTAL_ORDER;