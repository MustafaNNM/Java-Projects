select u.userid, u.first_name,u.last_name,u.webAddFriendLink
from USERPROFİLE as u
where userid in (select f.userid
					from FAVOURİTES as f 
					where (f.movies='Angela' or f.movies='Batman') )