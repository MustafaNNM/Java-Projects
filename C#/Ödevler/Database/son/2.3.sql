/*memleketi hatay olan bir kullanýcýnýn calýstýgý sirket bilgileri , sirket ismine göre alfabetik olarak azalan sýrada listeler */
(select w.company_name,w.startDate,w.pozition
from WORKPLACE as w	
where w.workplace_id in (select l.Location_id
						from LOCATION as l ,ADRESS_home as a
						where l.City ='Hatay' and a.home=l.Location_id
						
					))
order by 	w.company_name DESC

