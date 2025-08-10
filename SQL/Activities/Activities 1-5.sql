--Create the salesman table
CREATE TABLE salesman(salesman_id int PRIMARY KEY, salesman_name varchar(20), salesman_city varchar(20),commission int);
DESCRIBE salesman;

--Activity 2:Insert data into Salesman table
-- Insert multiple rows at once
INSERT ALL
    INTO salesman VALUES(5002, 'Nail Knite', 'Paris', 13)
    INTO salesman VALUES(5001, 'James Hoog', 'New York', 15)
    INTO salesman VALUES(5005, 'Pit Alex', 'London', 11)
    INTO salesman VALUES(5006, 'McLyon', 'Paris', 14)
    INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13)
    INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12)
SELECT 1 FROM DUAL;
-- View data from all columns
SELECT * FROM salesman;

--Activity 3:To display the data from the salesman table
--Show data from the salesman_id and salesman_city columns
SELECT salesman_id, salesman_city FROM salesman;
--show data of slaesman from Paris
SELECT * FROM salesman Where salesman_city ='Paris';
-- show salesman_id and commission of Paul Adam
SELECT salesman_id, commission FROM salesman WHERE salesman_name='Paul Adam';

--Activity 4 :Adding a new colum to the salesman table
ALTER TABLE salesman ADD grade int;
UPDATE salesman SET grade=100;
SELECT * FROM salesman;

--Activity 5 :Update data in salesman table
-- update the grade score of salesman from Rome to 200
UPDATE salesman SET grade=200 WHERE salesman_city='Rome';
--upadte the grade score of james hoog to 300
UPDATE salesman SET grade=300 WHERE salesman_name='James Hoog';
--Update the name McLyon to Pierre
UPADTE salesman SETsalesman_name='Pierre' WHERE salesman_name='McLyon';
SELECT * FROM salesman;
