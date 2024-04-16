-- 코드를 입력하세요
SELECT PRODUCT_CODE , sum(SALES_AMOUNT) * PRICE AS SALES
from product as P natural join offline_sale as O
group by product_code
order by SALES DESC , PRODUCT_CODE ASC