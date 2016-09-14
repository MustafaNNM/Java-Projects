/* Cinsiyeti Bekar olan ve ilişki durumu Bekar olan kişilerin soyisimlerine göre listelenmesi*/

SELECT        USERINFO.Name_last, USERINFO.Name_first, USERINFO.sex, PROFILEINFO.relationship
FROM            USERINFO INNER JOIN
                         PROFILEINFO ON USERINFO.email_id = PROFILEINFO.email_id
WHERE        (USERINFO.sex = 'M') AND (PROFILEINFO.relationship = 'bekar')
ORDER BY USERINFO.Name_last