/* Bahar Demir isimli kullanicin arkadaslarinin listelenmesi*/
SELECT U.Name_first,U.Name_last,F.name
FROM USERINFO AS U,FRIEND AS F
WHERE U.email_id=F.email_id AND U.Name_first='Bahar' AND U.Name_last='Demir'
ORDER BY F.name;