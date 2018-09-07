DROP TABLE city_locations;
CREATE EXTERNAL TABLE city_locations (
  geoname_id INT,
  locale_code STRING,
  continent_code STRING,
  continent_name STRING,
  country_iso_code STRING,
  country_name STRING,
  subdivision_1_iso_code STRING,
  subdivision_1_name STRING,
  subdivision_2_iso_code STRING,
  subdivision_2_name STRING,
  city_name STRING,
  metro_code INT,
  time_zone STRING,
  is_in_european_union INT)
    COMMENT 'City locations data from geolite'
    ROW FORMAT DELIMITED
    FIELDS TERMINATED BY ','
    STORED AS TEXTFILE
    location '/user/cloudera/geolite/external/city_locations'
    TBLPROPERTIES ('skip.header.line.count'='1');
load data inpath '/user/cloudera/geolite/GeoLite2-City-Locations-en.csv' into table city_locations;
    