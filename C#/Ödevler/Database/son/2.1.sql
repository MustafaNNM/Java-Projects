/*ad� g�khan olan kullan�c�n�n  kurdugu gruplar*/
select GROUPS.name
from  GROUPS
where creator in (select userid
			from USERPROF�LE
			where first_name='G�khan')