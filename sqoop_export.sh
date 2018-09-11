#!/usr/bin/env bash
sqoop export --connect jdbc:mysql://localhost/sqoop_test,charset=UTF8 \
--username root \
--table purchased_categories \
--export-dir hdfs:///user/cloudera/results/purchased_categories \
--password-file hdfs:///user/cloudera/.password \
--fields-terminated-by '\t' \
-m 1
sqoop export --connect jdbc:mysql://localhost/sqoop_test,charset=UTF8 \
--username root \
--table top_10_product_sells_by_category \
--export-dir hdfs:///user/cloudera/results/top_10_product_sells_by_category \
--password-file hdfs:///user/cloudera/.password \
--fields-terminated-by '\t' \
-m 1
sqoop export --connect jdbc:mysql://localhost/sqoop_test,charset=UTF8 \
--username root \
--table countries_by_money_spent \
--export-dir hdfs:///user/cloudera/results/countries_by_money_spent \
--password-file hdfs:///user/cloudera/.password \
--fields-terminated-by '\t' \
-m 1