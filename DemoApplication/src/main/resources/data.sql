--Envanter tablosu create kısmı
CREATE TABLE IF NOT EXISTS Envanter (
    kod VARCHAR(255) PRIMARY KEY,
    isim VARCHAR(255),
    barkod VARCHAR(255),
    adet INT
);

INSERT INTO Envanter (isim, kod, barkod, adet) VALUES ('Kalem', '001', 'A001', 50);
INSERT INTO Envanter (isim, kod, barkod, adet) VALUES ('Defter', '002', 'A002', 20);
INSERT INTO Envanter (isim, kod, barkod, adet) VALUES ('Silgi', '003', 'A003', 30);
INSERT INTO Envanter (isim, kod, barkod, adet) VALUES ('Kalem Kutusu', '004', 'A004', 10);
INSERT INTO Envanter (isim, kod, barkod, adet) VALUES ('Suluk', '005', 'B001', 25);
INSERT INTO Envanter (isim, kod, barkod, adet) VALUES ('Açacak', '006', 'A006', 40);
INSERT INTO Envanter (isim, kod, barkod, adet) VALUES ('A4 Kağıdı', '007', 'C001', 100);
INSERT INTO Envanter (isim, kod, barkod, adet) VALUES ('Boya Fırçası', '008', 'A007', 15);
INSERT INTO Envanter (isim, kod, barkod, adet) VALUES ('Sulu Boya', '009', 'A008', 5);

--Kullanıcı tablosu create kısmı
