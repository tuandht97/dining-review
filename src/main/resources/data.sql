INSERT INTO RESTAURANT(ID,NAME,ZIP_CODE,CUISINE,PEANUT,EGG,DIARY,SCORE) VALUES (1,'Sergios','BS1','Italian',4,4.2,3.9,4.03);
INSERT INTO RESTAURANT(ID,NAME,ZIP_CODE,CUISINE,PEANUT,EGG,DIARY,SCORE) VALUES (2,'Bar 44','BS8','Tapas',5,5,5,5);
INSERT INTO RESTAURANT(ID,NAME,ZIP_CODE,CUISINE,PEANUT,EGG,DIARY,SCORE) VALUES (3,'Joy Raj','BS8','Indian',4.2,4.2,4.2,4.2);
INSERT INTO USERS(ID,USER_NAME,CITY,STATE,ZIP_CODE,PEANUT_ALLERGY,EGG_ALLERGY,DAIRY_ALLERGY) VALUES (1,'BilboBaggins','London','Westminster','SE1',true,false,false);
INSERT INTO USERS(ID,USER_NAME,CITY,STATE,ZIP_CODE,PEANUT_ALLERGY,EGG_ALLERGY,DAIRY_ALLERGY) VALUES (2,'BigJock','Bristol','Clifton','BS8',false,true,false);
INSERT INTO USERS(ID,USER_NAME,CITY,STATE,ZIP_CODE,PEANUT_ALLERGY,EGG_ALLERGY,DAIRY_ALLERGY) VALUES (3,'NorthernSoul','Manchester','Hulme','M1',false,false,false);
INSERT INTO DINING_REVIEW(ID,REVIEWED_BY,RESTAURANT_ID,PEANUT_SCORE,EGG_SCORE,DAIRY_SCORE,COMMENTARY,REVIEW_STATUS) VALUES (1,'BigJock',2,3,5,5,'Good food','PENDING');
INSERT INTO DINING_REVIEW(ID,REVIEWED_BY,RESTAURANT_ID,PEANUT_SCORE,EGG_SCORE,DAIRY_SCORE,COMMENTARY,REVIEW_STATUS) VALUES (2,'NorthernSoul',1,4,5,3,'Okay food','APPROVED');
INSERT INTO DINING_REVIEW(ID,REVIEWED_BY,RESTAURANT_ID,PEANUT_SCORE,EGG_SCORE,DAIRY_SCORE,COMMENTARY,REVIEW_STATUS) VALUES (3,'BilboBaggins',3,3,3,3,'Good Service','REJECTED');

