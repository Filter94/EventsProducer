select productCategory, productName, productPurchased from (
  select t.*, row_number() over (partition by productCategory order by productPurchased desc) as row_number from (
    select productCategory, productName, count(*) as productPurchased
    from events
    group by productCategory, productName
    ) t
  ) t1
where t1.row_number <= 10
order by productCategory, productSells desc;