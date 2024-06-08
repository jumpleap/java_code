-- 链接：https://www.nowcoder.com/practice/009199576d094b56807a8368058841ee?tpId=298&tqId=2363165&ru=/exam/oj/ta&qru=/ta/sql-teach-yourself/question-ranking&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D298
-- 【问题】
-- 编写 SQL 语句，从 Customers 表中检索所有的cust_id
-- 【示例答案】
-- 返回cust_id列的内容
select cust_id from Customers;


-- 链接：https://www.nowcoder.com/practice/9e4741b77f4244149a069883bc0d23be?tpId=298&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D298
-- 【问题】编写SQL 语句，检索并列出所有已订购商品（prod_id）的去重后的清单。
select distinct prod_id from OrderItems;


-- 链接：https://www.nowcoder.com/practice/cf0e3919ba8e4fa2ba19ea09df7fb756?tpId=298&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D298
-- 【问题】需要编写 SQL语句，检索所有列。
-- 【示例结果】
-- 返回所有列cust_id和cust_name。
select * from Customers;


-- 链接：https://www.nowcoder.com/practice/6cfabb1b49554c4c8d8f9977bf6a3a5d?tpId=298&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D298
-- 【问题】从 Customers 中检索所有的顾客名称（cust_name），并按从 Z 到 A 的顺序显示结果。
select cust_name from Customers order by cust_name desc;


-- 链接：https://www.nowcoder.com/practice/fa4eb4880d124a4ead7a9b025fe75b70?tpId=298&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D298
-- 【问题】编写 SQL 语句，从 Orders 表中检索顾客 ID（cust_id）和订单号（order_num），并先按顾客 ID 对结果进行排序，再按订单日期倒序排列。
-- 对cust_id 进行降序，再cust_id的排序的情况下，再对order_date 进行排序
select cust_id, order_num from Orders order by cust_id, order_date desc;