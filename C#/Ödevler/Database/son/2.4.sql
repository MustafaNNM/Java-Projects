select u.userid, u.first_name,u.last_name,u.webAddFriendLink
from USERPROF�LE as u
where userid in (select f.userid
					from FAVOUR�TES as f 
					where (f.movies='Angela' or f.movies='Batman') )