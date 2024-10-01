
    create sequence Flashcard_SEQ start with 1 increment by 50;

    create table Flashcard (
        date_added date,
        target_language smallint check (target_language between 0 and 1),
        id bigint not null,
        translation varchar(100),
        word varchar(100),
        primary key (id)
    );
INSERT INTO Flashcard (id, word, translation, target_language, date_added) VALUES (1001, 'också', 'myös', 0, DATE '2024-08-02');
INSERT INTO Flashcard (id, word, translation, target_language, date_added) VALUES (1002, 'här', 'tällä', 0, DATE '2024-08-02');
INSERT INTO Flashcard (id, word, translation, target_language, date_added) VALUES (1003, 'glass', 'jäätelö', 0, DATE '2024-08-02');
INSERT INTO Flashcard (id, word, translation, target_language, date_added) VALUES (1004, 'dörr', 'ovi', 0, DATE '2024-08-02');
INSERT INTO Flashcard (id, word, translation, target_language, date_added) VALUES (1005, 'klocka', 'kello', 0, DATE '2024-08-02');
INSERT INTO Flashcard (id, word, translation, target_language, date_added) VALUES (1006, 'bord', 'pöytä', 0, DATE '2024-08-02');
INSERT INTO Flashcard (id, word, translation, target_language, date_added) VALUES (1007, 'rum', 'huone', 0, DATE '2024-08-02');
INSERT INTO Flashcard (id, word, translation, target_language, date_added) VALUES (1008, 'äta', 'syödä', 0, DATE '2024-08-02');
INSERT INTO Flashcard (id, word, translation, target_language, date_added) VALUES (1009, 'tala', 'puhua', 0, DATE '2024-08-02');
INSERT INTO Flashcard (id, word, translation, target_language, date_added) VALUES (1010, 'sten', 'kivi', 0, DATE '2024-08-02');
INSERT INTO Flashcard (id, word, translation, target_language, date_added) VALUES (1011, 'gå', 'mennä', 0, DATE '2024-08-02');
