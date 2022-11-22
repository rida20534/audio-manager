SELECT *FROM coordinate;
    insert into coordinate(id,country,ville,address,zipcode,latitude,logitude)
values(1,'maroc','casablanca','dar bouzza ould azouz quartier industrielle','72223',33.573109,-7.589843);
SELECT *FROM INVENTORY;
INSERT INTO INVENTORY(ID,INVENTORY_NAME,QUANTITY,CREATED_AT,COORDINATE_ID,LASTUPDATE_AT,DELETED_AT)
VALUES(0,'CENTRAL STOCKS OF CASA',100,NULL,1,NULL,NULL);
INSERT INTO PRODUCT_CATEGORY(ID,CATEGORY_NAME)VALUES(1,'Electronics');
