ADD JAR hdfs://ip-10-0-0-207.us-west-1.compute.internal:8020/user/rvaseev/customUdfs.jar;

DROP FUNCTION net_to_struct;
DROP FUNCTION ip_to_int;
CREATE FUNCTION net_to_struct AS 'com.griddynamics.hive.udf.NetStringToStructSimple';
CREATE FUNCTION ip_to_int AS 'com.griddynamics.hive.udf.IpStringToIntSimple';
CREATE TEMPORARY TABLE masks(mask TINYINT);

insert into masks (mask)
values
(1), (2), (3), (4), (5), (6), (7), (8), (9), (10), (11), (12), (13), (14), (15), (16),
(17), (18), (19), (20), (21), (22), (23), (24), (25), (26), (27), (28), (29), (30), (31);

select sum(e.product_price) country_spent, t.country_name
from events tablesample(50000 rows) e, masks m
join (select cb.network, net_to_struct(network) net, cl.country_name
  from country_locations cl
  join country_blocks cb on cb.geoname_id = cl.geoname_id) as t
  on m.mask = t.net.mask and ip_to_int(e.client_ip) & m.mask = t.net.net & t.net.mask
group by t.country_name
order by country_spent desc
limit 10;

--  3000  56
--  10000 1:05
--  20000 1:20
--  33724 1:25
--  50000 1:42