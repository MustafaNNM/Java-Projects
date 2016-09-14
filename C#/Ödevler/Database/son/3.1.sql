select e.name,e.start_time ,e.end_time,e.description_
from EVENT_ as e
where e.creator in(select f.userid2
					from FRIEND_RELATIONS as f,GENDER as g
					where g.profileGender='Male' and g.userid=f.userid2 and f.userid1=2)
					
					or
					e.creator in(select g.userid
								from GROUP_MEMBERS as g
								where g.memberType='Admin')