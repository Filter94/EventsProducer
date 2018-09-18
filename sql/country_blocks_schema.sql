DROP TABLE country_blocks;
CREATE EXTERNAL TABLE country_blocks (
  network STRING,
  geoname_id INT,
  registered_country_geoname_id INT,
  represented_country_geoname_id INT,
  is_anonymous_proxy INT,
  is_satellite_provider INT)
    COMMENT 'Country blocks data from geolite'
    ROW FORMAT DELIMITED
    FIELDS TERMINATED BY ','
    STORED AS TEXTFILE
    location '/user/rvaseev/geolite/external/country_blocks'
    TBLPROPERTIES ('skip.header.line.count'='1');
load data inpath '/user/rvaseev/geolite/GeoLite2-Country-Blocks-IPv4.csv' into table country_blocks;