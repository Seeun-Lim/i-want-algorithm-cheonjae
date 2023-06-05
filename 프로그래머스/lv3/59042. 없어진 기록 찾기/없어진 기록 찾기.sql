-- 입양을 간 기록은 있는데 보호소에 들어온 기록이 없는 동물의 ID
-- ANIMAL_INS : 동물 보호소에서 들어온 동물의 정보
-- ANIMAL_OUTS : 동물 보호소에서 입양 보낸 동물의 정보

SELECT ao.ANIMAL_ID, ao.NAME
FROM ANIMAL_INS ai RIGHT OUTER JOIN ANIMAL_OUTS ao
ON ai.ANIMAL_ID = ao.ANIMAL_ID
WHERE ai.ANIMAL_ID IS NULL
ORDER BY ao.ANIMAL_ID;