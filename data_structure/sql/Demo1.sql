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

-- https://www.nowcoder.com/practice/bd05a6684e534bd1bf2d9ebbda475333?tpId=298&tqId=2366897&ru=/exam/oj/ta&qru=/ta/sql-teach-yourself/question-ranking&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D298
-- 编写 SQL 语句，显示 OrderItems 表中的数量（quantity）和价格（item_price），并按数量由多到少、价格由高到低排序。
-- 【示例答案】
-- 返回quantity和item_price
select quantity, item_price from OrderItems order by quantity desc,  item_price desc;

-- https://www.nowcoder.com/practice/ba2d42708239429e870fa80db81c07da?tpId=298&tqId=2366897&ru=%2Fexam%2Foj%2Fta&qru=%2Fta%2Fsql-teach-yourself%2Fquestion-ranking&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D298
-- 【问题】下面的 SQL 语句有问题吗？尝试将它改正确，使之能够正确运行，并且返回结果根据vend_name逆序排列
-- SELECT vend_name,
-- FROM Vendors
-- ORDER vend_name DESC;
-- 【示例展示】
-- 返回vend_name
SELECT vend_name FROM Vendors order by vend_name DESC;

-- https://www.nowcoder.com/practice/9949bfb933614abe8bd2bc26c129843e?tpId=298&tqId=2366897&ru=%2Fexam%2Foj%2Fta&qru=%2Fta%2Fsql-teach-yourself%2Fquestion-ranking&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D298
-- 【问题】从 Products 表中检索产品 ID（prod_id）和产品名称（prod_name），只返回价格为 9.49 美元的产品。
-- 【示例结果】返回prod_id和prod_name
select prod_id, prod_name from Products where prod_price = 9.49;

-- https://www.nowcoder.com/practice/f6153be7485448cdb444279dcc105cb8?tpId=298&tqId=2366897&ru=%2Fexam%2Foj%2Fta&qru=%2Fta%2Fsql-teach-yourself%2Fquestion-ranking&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D298
-- 【问题】编写 SQL 语句，从 Products 表中检索产品 ID（prod_id）和产品名称（prod_name），只返回价格为 9 美元或更高的产品。
-- 【示例答案】返回prod_id商品id和prod_name商品名称
select prod_id, prod_name from Products where prod_price >= 9;

-- https://www.nowcoder.com/practice/560c94bf434e4e77911982e2d7ca0abb?tpId=298&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D298
-- 【问题】编写 SQL 语句，返回 Products 表中所有价格在 3 美元到 6 美元之间的产品的名称（prod_name）和价格（prod_price），然后按价格对结果进行排序
-- 【示例结果】返回商品名称prod_name和商品价格prod_price
select prod_name, prod_price from Products where prod_price >= 3 and prod_price <= 6 order by prod_price asc;

-- https://www.nowcoder.com/practice/dc91b7d2de3c4603a55995e83210f605?tpId=298&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D298
-- 【问题】从 OrderItems 表中检索出所有不同且不重复的订单号（order_num），其中每个订单都要包含 100 个或更多的产品。
-- 【示例结果】返回订单号列order_num
select distinct order_num from OrderItems where quantity >= 100;

-- https://www.nowcoder.com/practice/c4d520ed6a264ad3900eff95e4195d59?tpId=298&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D298
-- 【问题】编写 SQL 语句，从 Vendors 表中检索供应商名称（vend_name），仅返回加利福尼亚州的供应商（这需要按国家[USA]和州[CA]进行过滤，没准其他国家也存在一个CA）
-- 【示例答案】返回供应商名称vend_name
select vend_name from Vendors where vend_country = 'USA' and vend_state = 'CA';