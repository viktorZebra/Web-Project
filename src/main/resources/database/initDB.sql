CREATE TABLE IF NOT EXISTS Roles (
    ID SERIAL NOT NULL,
    Name_ VARCHAR(25) NOT NULL,
    Description VARCHAR(256),
    PRIMARY KEY (ID));

CREATE TABLE IF NOT EXISTS Users (
                                     ID SERIAL NOT NULL,
                                     Username VARCHAR(25) NOT NULL,
    Email VARCHAR(32) NOT NULL,
    Password_ VARCHAR(256) NOT NULL,
    RoleID INT  NOT NULL REFERENCES Roles (ID),
    PRIMARY KEY (ID),
    UNIQUE (Email, Username));

CREATE TABLE IF NOT EXISTS Category (
                                        ID SERIAL NOT NULL,
                                        Name_ VARCHAR(25),
    Description VARCHAR(256) NOT NULL,
    PRIMARY KEY (ID));

CREATE TABLE IF NOT EXISTS Posts (
                                     ID SERIAL NOT NULL,
                                     Description VARCHAR(256) NOT NULL,
    Content_ TEXT NOT NULL,
    UserID INT  NOT NULL REFERENCES Users (ID),
    CategoryID INT NOT NULL REFERENCES Category (ID),
    Date_ Date,
    PRIMARY KEY (ID));

CREATE TABLE IF NOT EXISTS Comments (
                                        ID SERIAL NOT NULL,
                                        PostID INT NOT NULL REFERENCES Posts (ID),
    UserID INT NOT NULL REFERENCES Users (ID),
    Content_ TEXT NOT NULL,
    Date_ Date,
    PRIMARY KEY (ID));