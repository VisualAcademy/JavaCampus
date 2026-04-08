-- data.sql
DELETE FROM Garnishes;
DELETE FROM Noodles;
DELETE FROM Broths;

INSERT INTO Broths (Id, Name, IsVegan) VALUES (1, '콩국물', TRUE);
INSERT INTO Broths (Id, Name, IsVegan) VALUES (2, '멸치국물', FALSE);
INSERT INTO Broths (Id, Name, IsVegan) VALUES (3, '라면국물', TRUE);

INSERT INTO Noodles (Id, Name, BrothId) VALUES (1, '우동', 2);
INSERT INTO Noodles (Id, Name, BrothId) VALUES (2, '쌀국수', 1);
INSERT INTO Noodles (Id, Name, BrothId) VALUES (3, '라면', 3);

INSERT INTO Garnishes (Id, Name, NoodleId) VALUES (1, '달걀', 1);
INSERT INTO Garnishes (Id, Name, NoodleId) VALUES (2, '초고추장', 3);
