/*Bu veritabanındaki kaç kullanıcının hangi eğitim düzeyinde olduğunun listelenmesi*/

SELECT education, COUNT(*) AS BuEgitimDuzeyindekiKullaniciSayisi
FROM KNOWLEDGE AS K,USERINFO AS U,PROFILEINFO AS P
WHERE K.profile_id=P.profile_id AND P.email_id=U.email_id 
GROUP BY education
HAVING COUNT (*) > 1
