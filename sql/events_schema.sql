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
    location '/user/cloudera/events/external/';
