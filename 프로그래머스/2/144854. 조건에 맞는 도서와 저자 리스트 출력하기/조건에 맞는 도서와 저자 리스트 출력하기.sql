-- BOOK , AUTHOR 
-- '경제' 카테고리에 속하는 도서들의 도서 ID, 저자명, 출판일 출력 (출판일 기준 오름차순)

SELECT B.BOOK_ID, A.AUTHOR_NAME, Date_Format(B.PUBLISHED_DATE, "%Y-%m-%d") AS PUBLISHED_DATE
FROM BOOK AS B JOIN AUTHOR AS A USING(AUTHOR_ID)
WHERE B.CATEGORY = '경제' 
ORDER BY PUBLISHED_DATE