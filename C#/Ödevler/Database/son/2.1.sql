/*adý gökhan olan kullanýcýnýn  kurdugu gruplar*/
select GROUPS.name
from  GROUPS
where creator in (select userid
			from USERPROFÝLE
			where first_name='Gökhan')