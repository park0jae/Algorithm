-- 코드를 입력하세요
SELECT animal_type ,
CASE
WHEN NAME is NULL THEN 'No name'  
ELSE NAME
END AS 'NAME',
SEX_UPON_INTAKE FROM animal_ins;