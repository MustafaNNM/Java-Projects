
select l.City,l.Country,l.Street
from LOCATION as l
where l.Location_id in(
						select g.location_id
						from GROUPS as g
						where g.group_id in(select gp.group_id
											from USERPROF�LE as u,GROUP_MEMBERS as gp
											where u.first_name='G�khan' and gp.memberType='Admin' and gp.userid=u.userid))