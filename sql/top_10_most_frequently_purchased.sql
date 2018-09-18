select product_category, product_name, product_sells from (
  select t.*, row_number() over (partition by product_category order by product_sells desc) as row_number from (
    select product_category, product_name, count(*) as product_sells
    from events
    group by product_category, product_name
    ) t
  ) t1
where t1.row_number <= 10
order by product_category, product_sells desc;