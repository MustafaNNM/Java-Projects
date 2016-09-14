/*Dili ingilizce olan kullanicilarin isim ve soyisimleri*/

SELECT Name_first,Name_last 
FROM USERINFO AS U ,LANGUAGEINFO AS L 
WHERE U.email_id =L.email_id AND lang = 'english'