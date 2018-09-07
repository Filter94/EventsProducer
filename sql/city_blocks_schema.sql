DROP TABLE city_blocks;
CREATE EXTERNAL TABLE city_blocks (
  network STRING,
  geoname_id INT,
  registered_country_geoname_id INT,
  represented_country_geoname_id INT,
  is_anonymous_proxy BOOLEAN,
  is_satellite_provider BOOLEAN,
  postal_code STRING,
  latitude FLOAT,
  longitude FLOAT,
  accuracy_radius INT)
    COMMENT 'City blocks data from geolite'
    ROW FORMAT DELIMITED
    FIELDS TERMINATED BY ','
    STORED AS TEXTFILE
    location '/user/cloudera/geolite/external/city_blocks'
    TBLPROPERTIES ('skip.header.line.count'='1');
load data inpath '/user/cloudera/geolite/GeoLite2-City-Blocks-IPv4.csv' into table city_blocks;
    