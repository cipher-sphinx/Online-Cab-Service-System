create database cabservicedatabase;

use cabservicedatabase;

CREATE TABLE customer (
  CustomerID INT AUTO_INCREMENT,
  CustomerNIC VARCHAR(50) UNIQUE NOT NULL,
  CustomerUsername VARCHAR(50) UNIQUE NOT NULL,
  CustomerPassword VARCHAR(50) NOT NULL,
  CustomerFirstName VARCHAR(50) NOT NULL,
  CustomerLastName VARCHAR(50) NOT NULL,
  CustomerEmail VARCHAR(70) NOT NULL,
  CustomerPhoneNumber INT(10) NOT NULL,
  CustomerLoginStatus VARCHAR(20) NOT NULL,
  CustomerStatus VARCHAR(20) NOT NULL,
  CONSTRAINT c_cid_pk PRIMARY KEY (CustomerID)
);

ALTER TABLE customer AUTO_INCREMENT = 32001;

CREATE TABLE admin (
  AdminID INT AUTO_INCREMENT,
  AdminNIC VARCHAR(50) UNIQUE NOT NULL,
  AdminUsername VARCHAR(50) UNIQUE NOT NULL,
  AdminPassword VARCHAR(50) NOT NULL,
  AdminFirstName VARCHAR(50) NOT NULL,
  AdminLastName VARCHAR(50) NOT NULL,
  AdminEmail VARCHAR(70) NOT NULL,
  AdminPhoneNumber INT(10) NOT NULL,
  AdminLoginStatus VARCHAR(20) NOT NULL,
  CONSTRAINT a_aid_pk PRIMARY KEY (AdminID)
);

ALTER TABLE admin AUTO_INCREMENT = 42001;

CREATE TABLE city (
  CityID INT AUTO_INCREMENT,
  CityName VARCHAR(50) NOT NULL,
  CityPhoneNumber INT(10) UNIQUE NOT NULL,
  CityEmail VARCHAR(70) NOT NULL,
  CONSTRAINT c_cid_pk PRIMARY KEY (CityID)
);

ALTER TABLE city AUTO_INCREMENT = 65001;

CREATE TABLE driver (
  DriverID INT AUTO_INCREMENT,
  DriverNIC VARCHAR(50) UNIQUE NOT NULL ,
  DriverUsername VARCHAR(50) UNIQUE NOT NULL,
  DriverPassword VARCHAR(50) NOT NULL,
  DriverFirstName VARCHAR(50) NOT NULL,
  DriverLastName VARCHAR(50) NOT NULL,
  DriverEmail VARCHAR(70) NOT NULL,
  DriverPhoneNumber INT(10) NOT NULL,
  DriverLoginStatus VARCHAR(20) NOT NULL,
  DriverStatus VARCHAR(20) NULL,
  CityID INT,
  CONSTRAINT d_did_pk PRIMARY KEY (DriverID),
  CONSTRAINT d_cid_fk FOREIGN KEY (CityID) REFERENCES city(CityID)
);

ALTER TABLE driver AUTO_INCREMENT = 52001;

CREATE TABLE street (
  StreetID INT AUTO_INCREMENT,
  StreetName VARCHAR(50) NOT NULL,
  CityID INT,
  CONSTRAINT s_sid_pk PRIMARY KEY (StreetID),
  CONSTRAINT s_cid_fk FOREIGN KEY (CityID) REFERENCES city(CityID)
);

ALTER TABLE street AUTO_INCREMENT = 75001;

CREATE TABLE vehicle (
  VehicleID INT AUTO_INCREMENT,
  VehicleRegisterID VARCHAR(50) NOT NULL,
  VehicleType VARCHAR(50) NULL,
  VehicleCapacity INT(20) NULL,
  VehicleStatus VARCHAR(20) NULL,
  DriverID INT,
  CONSTRAINT v_vid_pk PRIMARY KEY (VehicleID),
  CONSTRAINT v_did_fk FOREIGN KEY (DriverID) REFERENCES driver(DriverID)
);

ALTER TABLE vehicle AUTO_INCREMENT = 27001;

CREATE TABLE bookinglocation (
  BkLocationID INT AUTO_INCREMENT,
  BkSourceID INT,
  BkDestinationID INT,
  BkDistanceInKm INT NOT NULL,
  CONSTRAINT bk_bkLocID_pk PRIMARY KEY (BkLocationID),
  CONSTRAINT bk_bkSourceID_fk FOREIGN KEY (BkSourceID) REFERENCES street(StreetID),
  CONSTRAINT bk_bkDestinationID_fk FOREIGN KEY (BkDestinationID) REFERENCES street(StreetID)
);

ALTER TABLE bookinglocation AUTO_INCREMENT = 83001;

CREATE TABLE booking (
  BookingID INT AUTO_INCREMENT,
  BookingStatus VARCHAR(20) NOT NULL,
  BookingDateTime VARCHAR(100) NOT NULL,
  Feedback VARCHAR(2000) NULL,
  PriceInLKR INT NOT NULL,
  IfAcceptedByDriver VARCHAR(20) NOT NULL,
  CustomerID INT,
  DriverID INT,
  VehicleID INT,
  BkLocationID INT,
  CONSTRAINT b_bid_pk PRIMARY KEY (BookingID),
  CONSTRAINT b_cid_fk FOREIGN KEY (CustomerID) REFERENCES customer(CustomerID),
  CONSTRAINT b_did_fk FOREIGN KEY (DriverID) REFERENCES driver(DriverID),
  CONSTRAINT b_vid_fk FOREIGN KEY (VehicleID) REFERENCES vehicle(VehicleID),
  CONSTRAINT b_bklID_fk FOREIGN KEY (BkLocationID) REFERENCES bookinglocation(BkLocationID)
);

ALTER TABLE booking AUTO_INCREMENT = 93001;

INSERT INTO `cabservicedatabase`.`city` (`CityName`, `CityPhoneNumber`, `CityEmail`) VALUES ('Galle', '0117585829', 'galle@onlinecabservice.com');
INSERT INTO `cabservicedatabase`.`city` (`CityName`, `CityPhoneNumber`, `CityEmail`) VALUES ('Kandy', '0113782647', 'kandy@onlinecabservice.com');
INSERT INTO `cabservicedatabase`.`city` (`CityName`, `CityPhoneNumber`, `CityEmail`) VALUES ('Nugegoda', '0115379258', 'nugegoda@onlinecabservice.com');
INSERT INTO `cabservicedatabase`.`city` (`CityName`, `CityPhoneNumber`, `CityEmail`) VALUES ('Gampaha', '0116385367', 'gampaha@onlinecabservice.com');
INSERT INTO `cabservicedatabase`.`city` (`CityName`, `CityPhoneNumber`, `CityEmail`) VALUES ('Kurunegala', '0116482995', 'kurunegala@onlinecabservice.com');
INSERT INTO `cabservicedatabase`.`city` (`CityName`, `CityPhoneNumber`, `CityEmail`) VALUES ('Jaffna', '0119534562', 'jaffna@onlinecabservice.com');


INSERT INTO `cabservicedatabase`.`street` (`StreetName`, `CityID`) VALUES ('Rampart Street', '65001');
INSERT INTO `cabservicedatabase`.`street` (`StreetName`, `CityID`) VALUES ('Hospital Street', '65001');
INSERT INTO `cabservicedatabase`.`street` (`StreetName`, `CityID`) VALUES ('Lighthouse Street', '65001');
INSERT INTO `cabservicedatabase`.`street` (`StreetName`, `CityID`) VALUES ('Church Street', '65001');
INSERT INTO `cabservicedatabase`.`street` (`StreetName`, `CityID`) VALUES ('Leyn Baan Street', '65001');
INSERT INTO `cabservicedatabase`.`street` (`StreetName`, `CityID`) VALUES ('Piachaud Gardens', '65002');
INSERT INTO `cabservicedatabase`.`street` (`StreetName`, `CityID`) VALUES ('Nittawela Road', '65002');
INSERT INTO `cabservicedatabase`.`street` (`StreetName`, `CityID`) VALUES ('Asgiriya Road', '65002');
INSERT INTO `cabservicedatabase`.`street` (`StreetName`, `CityID`) VALUES ('Old Colombo Road', '65002');
INSERT INTO `cabservicedatabase`.`street` (`StreetName`, `CityID`) VALUES ('President House Road', '65002');
INSERT INTO `cabservicedatabase`.`street` (`StreetName`, `CityID`) VALUES ('St. Joseph Road', '65003');
INSERT INTO `cabservicedatabase`.`street` (`StreetName`, `CityID`) VALUES ('Jayasinghe Road', '65003');
INSERT INTO `cabservicedatabase`.`street` (`StreetName`, `CityID`) VALUES ('Melder Place', '65003');
INSERT INTO `cabservicedatabase`.`street` (`StreetName`, `CityID`) VALUES ('Park View Square', '65003');
INSERT INTO `cabservicedatabase`.`street` (`StreetName`, `CityID`) VALUES ('Trevine Gardens', '65003');
INSERT INTO `cabservicedatabase`.`street` (`StreetName`, `CityID`) VALUES ('Rest House Road', '65004');
INSERT INTO `cabservicedatabase`.`street` (`StreetName`, `CityID`) VALUES ('Seram Lane', '65004');
INSERT INTO `cabservicedatabase`.`street` (`StreetName`, `CityID`) VALUES ('Main Drive', '65004');
INSERT INTO `cabservicedatabase`.`street` (`StreetName`, `CityID`) VALUES ('YMBA Road', '65004');
INSERT INTO `cabservicedatabase`.`street` (`StreetName`, `CityID`) VALUES ('Agriculture road', '65004');
INSERT INTO `cabservicedatabase`.`street` (`StreetName`, `CityID`) VALUES ('Athugala Road', '65005');
INSERT INTO `cabservicedatabase`.`street` (`StreetName`, `CityID`) VALUES ('Vijayaba Mawatha', '65005');
INSERT INTO `cabservicedatabase`.`street` (`StreetName`, `CityID`) VALUES ('Fair Road', '65005');
INSERT INTO `cabservicedatabase`.`street` (`StreetName`, `CityID`) VALUES ('St. Anne Street', '65005');
INSERT INTO `cabservicedatabase`.`street` (`StreetName`, `CityID`) VALUES ('Perakumba Street', '65005');
INSERT INTO `cabservicedatabase`.`street` (`StreetName`, `CityID`) VALUES ('Front Street', '65006');
INSERT INTO `cabservicedatabase`.`street` (`StreetName`, `CityID`) VALUES ('Mohideen Mosque Road', '65006');
INSERT INTO `cabservicedatabase`.`street` (`StreetName`, `CityID`) VALUES ('Grand Bazaar Road', '65006');
INSERT INTO `cabservicedatabase`.`street` (`StreetName`, `CityID`) VALUES ('Jummah Mosque Lane', '65006');
INSERT INTO `cabservicedatabase`.`street` (`StreetName`, `CityID`) VALUES ('Clock Tower Road', '65006');


INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75001', '75002', '17');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75001', '75003', '15');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75001', '75004', '12');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75001', '75005', '19');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75002', '75001', '15');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75002', '75003', '13');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75002', '75004', '21');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75002', '75005', '20');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75003', '75001', '26');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75003', '75002', '12');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75003', '75004', '13');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75003', '75005', '12');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75004', '75001', '9');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75004', '75002', '16');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75004', '75003', '18');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75004', '75005', '14');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75005', '75001', '10');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75005', '75002', '11');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75005', '75003', '10');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75005', '75004', '14');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75006', '75007', '15');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75006', '75008', '14');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75006', '75009', '12');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75006', '75010', '21');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75007', '75006', '17');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75007', '75008', '16');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75007', '75009', '18');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75007', '75010', '23');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75008', '75006', '23');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75008', '75007', '16');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75008', '75009', '15');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75008', '75010', '10');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75009', '75006', '12');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75009', '75007', '22');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75009', '75008', '17');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75009', '75010', '22');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75010', '75006', '10');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75010', '75007', '23');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75010', '75008', '22');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75010', '75009', '17');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75011', '75012', '16');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75011', '75013', '17');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75011', '75014', '12');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75011', '75015', '16');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75012', '75011', '24');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75012', '75013', '23');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75012', '75014', '23');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75012', '75015', '10');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75013', '75011', '18');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75013', '75012', '12');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75013', '75014', '24');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75013', '75015', '24');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75014', '75011', '23');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75014', '75012', '14');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75014', '75013', '22');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75014', '75015', '18');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75015', '75011', '21');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75015', '75012', '10');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75015', '75013', '15');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75015', '75014', '22');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75016', '75017', '12');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75016', '75018', '22');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75016', '75019', '24');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75016', '75020', '14');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75017', '75016', '17');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75017', '75018', '10');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75017', '75019', '12');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75017', '75020', '17');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75018', '75016', '14');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75018', '75017', '21');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75018', '75019', '23');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75018', '75020', '10');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75019', '75016', '22');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75019', '75017', '24');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75019', '75018', '18');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75019', '75020', '23');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75020', '75016', '23');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75020', '75017', '15');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75020', '75018', '16');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75020', '75019', '17');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75021', '75022', '12');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75021', '75023', '18');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75021', '75024', '22');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75021', '75025', '10');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75022', '75021', '24');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75022', '75023', '15');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75022', '75024', '12');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75022', '75025', '21');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75023', '75021', '22');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75023', '75022', '21');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75023', '75024', '23');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75023', '75025', '12');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75024', '75021', '18');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75024', '75022', '24');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75024', '75023', '17');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75024', '75025', '24');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75025', '75021', '24');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75025', '75022', '23');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75025', '75023', '14');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75025', '75024', '18');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75026', '75027', '18');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75026', '75028', '12');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75026', '75029', '13');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75026', '75030', '14');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75027', '75026', '21');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75027', '75028', '11');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75027', '75029', '9');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75027', '75030', '8');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75028', '75026', '22');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75028', '75027', '15');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75028', '75029', '10');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75028', '75030', '24');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75029', '75026', '17');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75029', '75027', '16');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75029', '75028', '14');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75029', '75030', '26');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75030', '75026', '14');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75030', '75027', '18');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75030', '75028', '15');
INSERT INTO `cabservicedatabase`.`bookinglocation` (`BkSourceID`, `BkDestinationID`, `BkDistanceInKm`) VALUES ('75030', '75029', '12');








