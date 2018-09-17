DROP TABLE country_locations;
CREATE EXTERNAL TABLE country_locations (
  geoname_id INT,
  locale_code STRING,
  continent_code STRING,
  continent_name STRING,
  country_iso_code STRING,
  country_name STRING,
  is_in_european_union INT)
    COMMENT 'Country locations data from geolite'
    ROW FORMAT DELIMITED
    FIELDS TERMINATED BY ','
    STORED AS TEXTFILE
    location '/user/cloudera/geolite/external/country_locations'
    TBLPROPERTIES ('skip.header.line.count'='1');
load data inpath '/user/cloudera/geolite/GeoLite2-Country-Locations-ru.csv' into table country_locations;
