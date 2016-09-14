
	/*Yaþadýðý þehirin baþ harfi 'B' veya yaþadýðý ülkenin son harfi 'Y' olan kiþilerin şehir,ülke ve ad soyadlarının listelenmesi*/
	
	SELECT	U.Name_first,U.Name_last,K.city,K.country
	FROM	KNOWLEDGE AS K,USERINFO AS U,PROFILEINFO AS P
	WHERE   K.profile_id=P.profile_id AND P.email_id=U.email_id AND K.city LIKE 'B%' AND K.country LIKE '%y' ;