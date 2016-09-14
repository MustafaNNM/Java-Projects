/*Herhangi bir grupta üye olan ve  user_id=2 olan kiþiyle arkadas olan kullanýcýnýn adý ve soyadý*/
select u.first_name,u.last_name
from USERPROFÝLE as u
where exists (select *
			from GROUP_MEMBERS as g
			where u.userid=g.userid)
			AND
		    exists
			(select *
			from FRIEND_RELATIONS as f
			where f.userid1=2 And f.userid2=u.userid)