CREATE TABLE IF NOT EXISTS TS_Execute_Operate_Monitor_Result
(
    itemCode INTEGER,
    fundCode CHAR(250),
    businessDate INTEGER,
    recordId CHAR(100),
    dataName CHAR(1000),
    dataValue CHAR(25),
    dataOrder INTEGER
);



CREATE TABLE IF NOT EXISTS ts_checkItemInfo
(
   itemCode INTEGER,
   itemName CHAR(100),
   checkPoint CHAR(8),
   checkType CHAR(10),
   alertLevel CHAR(10),
   isPublic CHAR(3),
   relationBusiness CHAR(100),
   menuName CHAR(50),
   checkDesc CHAR(250),
   resultDesc CHAR(250),
   indicatorDesc CHAR(250),
   indicator1 CHAR(10),
   indicator2 CHAR(10)
);