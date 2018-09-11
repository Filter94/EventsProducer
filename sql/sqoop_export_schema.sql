DROP TABLE IF EXISTS purchased_categories;
CREATE TABLE purchased_categories (
   product_category VARCHAR(255),
   times_purchased INT
   );
DROP TABLE IF EXISTS top_10_product_sells_by_category;
CREATE TABLE top_10_product_sells_by_category (
   product_category VARCHAR(255),
   product_name VARCHAR(255),
   sells FLOAT
   );
DROP TABLE IF EXISTS countries_by_money_spent;
CREATE TABLE countries_by_money_spent (
    sells DECIMAL,
	country VARCHAR(255)
    );