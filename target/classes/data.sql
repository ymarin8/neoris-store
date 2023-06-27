--Insert for Brands
INSERT INTO BRAND(BRAND_NAME) VALUES('ZARA');
INSERT INTO BRAND(BRAND_NAME) VALUES('BERSHKA');
INSERT INTO BRAND(BRAND_NAME) VALUES('PULL & BEAR');

--Insert for products
INSERT INTO PRODUCT(PRODUCT_ID, START_DATE, END_DATE, PRICE_LIST, PRIORITY, FINAL_PRICE, BRAND_ID, ISO_CURRENCY)
VALUES(35455, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 35.5, 0, 40.5, 1, 'EUR');
INSERT INTO PRODUCT(PRODUCT_ID, START_DATE, END_DATE, PRICE_LIST, PRIORITY, FINAL_PRICE, BRAND_ID, ISO_CURRENCY)
VALUES(35455, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 25.45, 1, 30.45, 1, 'EUR');
INSERT INTO PRODUCT(PRODUCT_ID, START_DATE, END_DATE, PRICE_LIST, PRIORITY, FINAL_PRICE, BRAND_ID, ISO_CURRENCY)
VALUES(35455, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 30.5, 0, 35.5, 1, 'EUR');
INSERT INTO PRODUCT(PRODUCT_ID, START_DATE, END_DATE, PRICE_LIST, PRIORITY, FINAL_PRICE, BRAND_ID, ISO_CURRENCY)
VALUES(35455, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 38.95, 0, 43.95, 1, 'EUR');