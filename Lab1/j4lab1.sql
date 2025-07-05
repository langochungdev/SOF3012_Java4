CREATE DATABASE j4lab1
GO

USE j4lab1
GO

CREATE TABLE Users (
    Id NVARCHAR(20) NOT NULL,
    Password NVARCHAR(50) NOT NULL,
    Fullname NVARCHAR(50) NOT NULL,
    Email NVARCHAR(50) NOT NULL,
    Admin BIT NOT NULL,
    PRIMARY KEY(Id)
)

INSERT INTO Users (Id, Password, Fullname, Email, Admin) VALUES
('hung', '123', N'hung admin', 'a@example.com', 1),
('hung2', '123', N'hung client', 'b@example.com', 0),
('user03', '123', N'user03', 'user03@example.com', 0),
('user04', '123', N'user04', 'user04@example.com', 0),
('user05', '123', N'user05', 'user05@example.com', 0),
('user06', '123', N'user06', 'user06@example.com', 0),
('user07', '123', N'user07', 'user07@example.com', 0),
('user08', '123', N'user08', 'user08@example.com', 0),
('user09', '123', N'user09', 'user09@example.com', 0),
('user10', '123', N'user10', 'user10@example.com', 0),
('user11', '123', N'user11', 'user11@example.com', 0),
('user12', '123', N'user12', 'user12@example.com', 0),
('user13', '123', N'user13', 'user13@example.com', 0),
('user14', '123', N'user14', 'user14@example.com', 0),
('user15', '123', N'user15', 'user15@example.com', 0);



