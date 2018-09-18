INSERT OVERWRITE DIRECTORY '/user/rvaseev/results/purchased_categories'
ROW FORMAT DELIMITED
FIELDS TERMINATED BY '\t'
select product_category, count(*) as purchases
from events 
group by product_category
order by purchases desc 
limit 10;