CREATE DATABASE Management;
CREATE TABLE Management.Process
(
    ProcessName varchar(255),
    Description varchar(255),
    ID int NOT NULL AUTO_INCREMENT,
    Periodicity int,
    PRIMARY KEY (ID)
);
CREATE TABLE Management.Execution
(
    ID int NOT NULL,
    BeginAt DATETIME,
    InfoExecution varchar(255),
    FinalState varchar(255),
    FOREIGN KEY (ID) REFERENCES Process(ID)
);
