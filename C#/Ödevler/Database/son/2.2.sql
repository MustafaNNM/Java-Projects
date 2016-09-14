/*Herhangi bir grupta �ye olan ve  user_id=2 olan ki�iyle arkadas olan kullan�c�n�n ad� ve soyad�*/
select u.first_name,u.last_name
from USERPROF�LE as u
where exists (select *
			from GROUP_MEMBERS as g
			where u.userid=g.userid)
			AND
		    exists
			(select *
			from FRIEND_RELATIONS as f
			where f.userid1=2 And f.userid2=u.userid)