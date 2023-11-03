-- 코드를 입력하세요
SELECT F.FLAVOR
# SELECT *, (F.TOTAL_ORDER + J.TOTAL_ORDER) AS TOTAL
FROM FIRST_HALF F
JOIN JULY J ON F.FLAVOR = J.FLAVOR
GROUP BY F.FLAVOR
ORDER BY (SUM(F.TOTAL_ORDER) + SUM(J.TOTAL_ORDER)) DESC
LIMIT 3;