/*Erkek kullanıcıların isim ve soyisim ve doğum tarihlerinin listelenmesi*/

	SELECT name_first,name_last,birthday
	FROM USERINFO
	WHERE sex='M' ;