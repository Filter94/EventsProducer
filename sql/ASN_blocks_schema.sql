DROP TABLE asn_blocks;
CREATE EXTERNAL TABLE asn_blocks (
  network STRING,
  autonomous_system_number INT,
  autonomous_system_organization STRING)
    COMMENT 'ASN data from geolite'
    ROW FORMAT DELIMITED
    FIELDS TERMINATED BY ','
    STORED AS TEXTFILE
    location '/user/cloudera/geolite/external/asn_blocks'
    TBLPROPERTIES ('skip.header.line.count'='1');
load data inpath '/user/cloudera/geolite/GeoLite2-ASN-Blocks-IPv4.csv' into table asn_blocks;
    