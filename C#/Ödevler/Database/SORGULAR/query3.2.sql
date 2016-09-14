/*Hiç birşeyi beğenmemiş veya hiç bir yere abone olmamış kullanıcıların listelenmesi*/
SELECT Name_first,Name_last
FROM USERINFO 
WHERE NOT EXISTS ( SELECT * 
                   FROM STATUSS
                   WHERE USERINFO.email_id=STATUSS.email_id AND thumb_up='Yes')
      OR EXISTS (SELECT * 
                  FROM PROFILEINFO
                  WHERE USERINFO.email_id=PROFILEINFO.email_id AND subscriptions=NULL)