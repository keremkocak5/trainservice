 	CREATE TABLE TrainSchedule (
   trainNumber INT AUTO_INCREMENT  PRIMARY KEY,
   initialCapacity INT NOT NULL,
   driverName VARCHAR(250) NOT NULL,
   departureDate Date DEFAULT NULL
 );
