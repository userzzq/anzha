use mysql;
CREATE USER 'test'@'%' IDENTIFIED BY 'Test4-sql';
GRANT ALL ON CDXP1688.* TO 'test'@'%';
GRANT ALL ON DemoDB.* TO 'test'@'%';
GRANT ALL ON TestDB.* TO 'test'@'%';
FLUSH PRIVILEGES;