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
    location '/user/rvaseev/geolite/external/country_locations'
    TBLPROPERTIES ('skip.header.line.count'='1','store.charset'='UTF-8');