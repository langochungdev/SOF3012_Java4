CREATE DATABASE j4lab3;
GO

USE j4lab3;
GO

CREATE TABLE [User] (
    Id BIGINT PRIMARY KEY,
    Password NVARCHAR(255),
    Email NVARCHAR(255),
    Fullname NVARCHAR(255),
    Admin BIT
);

CREATE TABLE Video (
    Id NVARCHAR(50) PRIMARY KEY,
    Title NVARCHAR(255),
    Poster NVARCHAR(255),
    Views INT,
    Description NVARCHAR(MAX),
    Active BIT
);

CREATE TABLE Favorite (
    Id BIGINT PRIMARY KEY,
    UserId BIGINT,
    VideoId NVARCHAR(50),
    LikeDate DATE,
    FOREIGN KEY (UserId) REFERENCES [User](Id),
    FOREIGN KEY (VideoId) REFERENCES Video(Id)
);

CREATE TABLE Share (
    Id BIGINT PRIMARY KEY,
    userId BIGINT,
    VideoId NVARCHAR(50),
    Emails NVARCHAR(255),
    ShareDate DATE,
    FOREIGN KEY (UserId) REFERENCES [User](Id),
    FOREIGN KEY (VideoId) REFERENCES Video(Id)
);


-- Insert into [User]
INSERT INTO [User] (Id, Password, Email, Fullname, Admin) VALUES
(1, 'pass123', 'user1@example.com', 'Nguyen Van A', 0),
(2, 'pass456', 'user2@example.com', 'Tran Thi B', 0),
(3, 'pass789', 'user3@example.com', 'Le Van C', 1),
(4, 'pass101', 'user4@example.com', 'Pham Thi D', 0),
(5, 'pass202', 'user5@example.com', 'Hoang Van E', 0),
(6, 'pass303', 'user6@example.com', 'Do Thi F', 1),
(7, 'pass404', 'user7@example.com', 'Vu Van G', 0),
(8, 'pass505', 'user8@example.com', 'Ngo Thi H', 0),
(9, 'pass606', 'user9@example.com', 'Dang Van I', 0),
(10, 'pass707', 'user10@example.com', 'Trinh Thi K', 1);

-- Insert into Video
INSERT INTO Video (Id, Title, Poster, Views, Description, Active) VALUES
('V001', 'Video 1', 'poster1.jpg', 100, 'Description 1', 1),
('V002', 'Video 2', 'poster2.jpg', 150, 'Description 2', 1),
('V003', 'Video 3', 'poster3.jpg', 200, 'Description 3', 0),
('V004', 'Video 4', 'poster4.jpg', 250, 'Description 4', 1),
('V005', 'Video 5', 'poster5.jpg', 300, 'Description 5', 1),
('V006', 'Video 6', 'poster6.jpg', 350, 'Description 6', 0),
('V007', 'Video 7', 'poster7.jpg', 400, 'Description 7', 1),
('V008', 'Video 8', 'poster8.jpg', 450, 'Description 8', 1),
('V009', 'Video 9', 'poster9.jpg', 500, 'Description 9', 0),
('V010', 'Video 10', 'poster10.jpg', 550, 'Description 10', 1);

-- Insert into Favorite
INSERT INTO Favorite (Id, UserId, VideoId, LikeDate) VALUES
(1, 1, 'V001', '2025-05-01'),
(2, 2, 'V002', '2025-05-02'),
(3, 3, 'V003', '2025-05-03'),
(4, 4, 'V004', '2025-05-04'),
(5, 5, 'V005', '2025-05-05'),
(6, 6, 'V006', '2025-05-06'),
(7, 7, 'V007', '2025-05-07'),
(8, 8, 'V008', '2025-05-08'),
(9, 9, 'V009', '2025-05-09'),
(10, 10, 'V010', '2025-05-10');

-- Insert into Share
INSERT INTO Share (Id, UserId, VideoId, Emails, ShareDate) VALUES
(1, 1, 'V001', 'friend1@example.com', '2025-05-01'),
(2, 2, 'V002', 'friend2@example.com', '2025-05-02'),
(3, 3, 'V003', 'friend3@example.com', '2025-05-03'),
(4, 4, 'V004', 'friend4@example.com', '2025-05-04'),
(5, 5, 'V005', 'friend5@example.com', '2025-05-05'),
(6, 6, 'V006', 'friend6@example.com', '2025-05-06'),
(7, 7, 'V007', 'friend7@example.com', '2025-05-07'),
(8, 8, 'V008', 'friend8@example.com', '2025-05-08'),
(9, 9, 'V009', 'friend9@example.com', '2025-05-09'),
(10, 10, 'V010', 'friend10@example.com', '2025-05-10');