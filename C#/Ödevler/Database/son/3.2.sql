
/*gökhana yada ertunça mesaj atan kullanýcýlarýn duvarýna yazýlmýs paylasýmlar*/


select p.post
from Post as p
where p.post_id in(select pt.post_id
					from Post_Properties as pt
					where pt.wall_id in(select m.userid
										from MESSAGE_ as m
										where m.to_user in (select u.userid
															from USERPROFÝLE as u
															where u.first_name='Ertunç')
															
															or
															 m.to_user in
														   (select u.userid
															from USERPROFÝLE as u
															where u.first_name='Gökhan')))
order by p.post DESC ;