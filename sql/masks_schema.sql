DROP TABLE masks;
CREATE EXTERNAL TABLE masks(
        mask INT)
    COMMENT 'All options for Ip mask'
    ROW FORMAT DELIMITED
    STORED AS TEXTFILE
    LOCATION '/user/rvaseev/events/tmp/masks.csv';