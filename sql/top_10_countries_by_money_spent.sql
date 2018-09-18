ADD JAR hdfs://ip-10-0-0-207.us-west-1.compute.internal:8020/user/rvaseev/customUdfs.jar;

DROP FUNCTION net_to_struct;
DROP FUNCTION ip_to_int;
CREATE FUNCTION net_to_struct AS 'com.griddynamics.hive.udf.NetStringToStructSimple';
CREATE FUNCTION ip_to_int AS 'com.griddynamics.hive.udf.IpStringToIntSimple';

INSERT OVERWRITE DIRECTORY '/user/rvaseev/results/countries_by_money_spent'
ROW FORMAT DELIMITED
FIELDS TERMINATED BY '\t'
select sum(e.product_price) country_spent, t.country_name
from events tablesample(3000 rows) e, masks m
join (select net_to_struct(network).net net, net_to_struct(network).mask mask, cl.country_name
      from country_locations cl
      join country_blocks cb on cb.geoname_id = cl.geoname_id) as t
  on m.mask = t.mask and ip_to_int(e.client_ip) & m.mask = t.net & t.mask
group by t.country_name
order by country_spent desc
limit 10;

--  3000  56
--  10000 1:05
--  20000 1:20
--  33724 1:25
--  50000 1:42