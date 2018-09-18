DROP TABLE Events;
CREATE EXTERNAL TABLE Events(
        productName STRING,
        productPrice FLOAT,
        purchaseTime TIMESTAMP,
        productCategory STRING,
        clientIp STRING)
    COMMENT 'Generated random data'
    PARTITIONED BY (purchaseDate STRING)
    ROW FORMAT DELIMITED
    FIELDS TERMINATED BY ','
    STORED AS TEXTFILE
    location '/user/rvaseev/events/external/';
ALTER TABLE events ADD PARTITION (purchasedate='2007-09-20') LOCATION '/user/flume/rvaseev/events/2007/09/20';
ALTER TABLE events ADD PARTITION (purchasedate='2007-09-21') LOCATION '/user/flume/rvaseev/events/2007/09/21';
ALTER TABLE events ADD PARTITION (purchasedate='2007-09-22') LOCATION '/user/flume/rvaseev/events/2007/09/22';
ALTER TABLE events ADD PARTITION (purchasedate='2007-09-23') LOCATION '/user/flume/rvaseev/events/2007/09/23';
ALTER TABLE events ADD PARTITION (purchasedate='2007-09-24') LOCATION '/user/flume/rvaseev/events/2007/09/24';
ALTER TABLE events ADD PARTITION (purchasedate='2007-09-25') LOCATION '/user/flume/rvaseev/events/2007/09/25';
ALTER TABLE events ADD PARTITION (purchasedate='2007-09-26') LOCATION '/user/flume/rvaseev/events/2007/09/26';
