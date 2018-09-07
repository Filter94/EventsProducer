select productCategory, count(*) as purchases 
from events 
group by productCategory 
order by purchases desc 
limit 10;