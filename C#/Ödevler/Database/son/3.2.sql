
/*g�khana yada ertun�a mesaj atan kullan�c�lar�n duvar�na yaz�lm�s paylas�mlar*/


select p.post
from Post as p
where p.post_id in(select pt.post_id
					from Post_Properties as pt
					where pt.wall_id in(select m.userid
										from MESSAGE_ as m
										where m.to_user in (select u.userid
															from USERPROF�LE as u
															where u.first_name='Ertun�')
															
															or
															 m.to_user in
														   (select u.userid
															from USERPROF�LE as u
															where u.first_name='G�khan')))
order by p.post DESC ;