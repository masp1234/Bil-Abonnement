/* VIGTIGT

Der er ikke en måde at oprette brugere på gennem vores hjemmeside,
så her er der logins til de 3 forskellige roller:

Dataregistrering
username: data
password: data

Skade og udbedring
username: skade
password: skade

Forretningsudvikler
username: forretningsudvikler
password: forretningsudvikler

Der er heller ikke en måde at se en liste med oprettede kunder,
hvilke man skal bruge CPR-numrene på, når man opretter en lejeaftale.
Her er der en liste med CPR-numre:
1212982352
1010996523
0808728534
0101702352
0102753452

Når man opretter en kunde, skal man bruge et postnummer, så her er der en liste med gyldige numre:

2000
2100
2200
2300

*/
-- Users

INSERT INTO user (user_username, user_password, user_role)
VALUES ('data', 'data', 'dataregistrering');
INSERT INTO user(user_username, user_password, user_role)
VALUES ('skade', 'skade', 'skade');
INSERT INTO user (user_username, user_password, user_role)
VALUES ('forretningsudvikler', 'forretningsudvikler', 'forretningsudvikler');

-- Postnumre

INSERT INTO zipcode (`zipcode`, `country`, `city`)
VALUES ('1301', 'Danmark', 'København K');
INSERT INTO zipcode (`zipcode`, `country`, `city`)
VALUES ('2000', 'Danmark', 'Frederiksberg');
INSERT INTO zipcode (`zipcode`, `country`, `city`)
VALUES ('2100', 'Danmark', 'København Ø');
INSERT INTO zipcode (`zipcode`, `country`, `city`)
VALUES ('2200', 'Danmark', 'København N');
INSERT INTO zipcode (`zipcode`, `country`, `city`)
VALUES ('2300', 'Danmark', 'København S');
INSERT INTO zipcode (`zipcode`, `country`, `city`)
VALUES ('2400', 'Danmark', 'København NV');
INSERT INTO zipcode (`zipcode`, `country`, `city`)
VALUES ('2450', 'Danmark', 'København SV');
INSERT INTO zipcode (`zipcode`, `country`, `city`)
VALUES ('2500', 'Danmark', 'Valby');
INSERT INTO zipcode (`zipcode`, `country`, `city`)
VALUES ('2600', 'Danmark', 'Glostrup');
INSERT INTO zipcode (`zipcode`, `country`, `city`)
VALUES ('2605', 'Danmark', 'Brøndby');
INSERT INTO zipcode (`zipcode`, `country`, `city`)
VALUES ('2610', 'Danmark', 'Rødovre');
INSERT INTO zipcode (`zipcode`, `country`, `city`)
VALUES ('2625', 'Danmark', 'Vallensbæk');
INSERT INTO zipcode (`zipcode`, `country`, `city`)
VALUES ('2630', 'Danmark', 'Taastrup');
INSERT INTO zipcode (`zipcode`, `country`, `city`)
VALUES ('2635', 'Danmark', 'Ishøj');
INSERT INTO zipcode (`zipcode`, `country`, `city`)
VALUES ('2640', 'Danmark', 'Hedehusene');
INSERT INTO zipcode (`zipcode`, `country`, `city`)
VALUES ('2660', 'Danmark', 'Brøndby Strand');
INSERT INTO zipcode (`zipcode`, `country`, `city`)
VALUES ('2665', 'Danmark', 'Vallensbæk Strand');
INSERT INTO zipcode (`zipcode`, `country`, `city`)
VALUES ('2670', 'Danmark', 'Greve');
INSERT INTO zipcode (`zipcode`, `country`, `city`)
VALUES ('4600', 'Danmark', 'Køge');
INSERT INTO zipcode (`zipcode`, `country`, `city`)
VALUES ('5000', 'Danmark', 'Odense C');
INSERT INTO zipcode (`zipcode`, `country`, `city`)
VALUES ('5200', 'Danmark', 'Odense V');


-- Kunder

INSERT INTO customer (customer_cpr_number, customer_firstname, customer_lastname, customer_email, customer_phone, customer_zipcode, customer_address)
VALUES ('1212982352', 'Peter', 'Petersem', 'Peter@gmail.com', '63432563', '2670', 'Blåbærsvej 13');
INSERT INTO customer (customer_cpr_number, customer_firstname, customer_lastname, customer_email, customer_phone, customer_zipcode, customer_address)
VALUES ('1010996523', 'Karl', 'Karlsen', 'Karl@gmail.com', '64236234', '2670', 'Blåbærsvej 12');
INSERT INTO customer (customer_cpr_number, customer_firstname, customer_lastname, customer_email, customer_phone, customer_zipcode, customer_address)
VALUES ('0808728534', 'Jens', 'Jensen', 'Jens@gmail.com', '53426345', '2670', 'Blåbærsvej 14');
INSERT INTO customer (customer_cpr_number, customer_firstname, customer_lastname, customer_email, customer_phone, customer_zipcode, customer_address)
VALUES ('0101702352', 'Daniel', 'Danielsen', 'Daniel@gmail.com', '52356345', '2670', 'Blåbærsvej 15');
INSERT INTO customer (customer_cpr_number, customer_firstname, customer_lastname, customer_email, customer_phone, customer_zipcode, customer_address)
VALUES ('0102753452', 'Mads', 'Madsen', 'Mads@gmail.com', '2345234523', '2670', 'Blåbærsvej 16');


-- Biler

INSERT INTO car (`car_reg_number`, `car_chassis_number`, `car_make`, `car_model`, `car_color`, `car_equipment_level`, `car_reg_fee`, `car_emission`, `car_status`, `car_url`)
VALUES ('991235REGNUMBER', '991235CHASSIS', 'Ford', 'Mustang Fastback', 'Sort', 'Ekstra +', '45000', '100.5', 'reserved', 'https://cdn.pixabay.com/photo/2014/11/08/07/56/ford-mustang-521841_960_720.jpg');
INSERT INTO car (`car_reg_number`, `car_chassis_number`, `car_make`, `car_model`, `car_color`, `car_equipment_level`, `car_reg_fee`, `car_emission`, `car_status`, `car_url`)
VALUES ('R212EG233NUMBER', 'CAHA122323321', 'Ford', 'Mustang Fastback', 'Sølv', 'Ekstra +', '45000', '100.5', 'reserved', 'https://cdn.pixabay.com/photo/2014/04/29/01/38/auto-334159_960_720.jpg');
INSERT INTO car (`car_reg_number`, `car_chassis_number`, `car_make`, `car_model`, `car_color`, `car_equipment_level`, `car_reg_fee`, `car_emission`, `car_status`, `car_url`)
VALUES ('99ADADFE121212', '92189289129', 'Ford', 'Mustang Fastback', 'Sølv', 'Ekstra +', '45000', '100.5', 'available', 'https://cdn.pixabay.com/photo/2014/04/29/01/38/auto-334159_960_720.jpg');
INSERT INTO car (`car_reg_number`, `car_chassis_number`, `car_make`, `car_model`, `car_color`, `car_equipment_level`, `car_reg_fee`, `car_emission`, `car_status`, `car_url`)
VALUES ('91233DAS1DASD12', '1229393U24', 'Ford', 'Mustang Fastback', 'Sølv', 'Ekstra +', '45000', '100.5', 'workshop', 'https://cdn.pixabay.com/photo/2014/04/29/01/38/auto-334159_960_720.jpg');
INSERT INTO car (`car_reg_number`, `car_chassis_number`, `car_make`, `car_model`, `car_color`, `car_equipment_level`, `car_reg_fee`, `car_emission`, `car_status`, `car_url`)
VALUES ('32321DSSADSDSADA', '121239434U9', 'Ford', 'Mustang Fastback', 'Sort', 'Ekstra +', '45000', '100.5', 'workshop', 'https://cdn.pixabay.com/photo/2014/11/08/07/56/ford-mustang-521841_960_720.jpg');
INSERT INTO car (`car_reg_number`, `car_chassis_number`, `car_make`, `car_model`, `car_color`, `car_equipment_level`, `car_reg_fee`, `car_emission`, `car_status`, `car_url`)
VALUES ('1212DSSDADASD', '12030430944', 'Ford', 'Mustang Fastback', 'Sort', 'Ekstra +', '45000', '100.5', 'workshop', 'https://cdn.pixabay.com/photo/2014/11/08/07/56/ford-mustang-521841_960_720.jpg');
INSERT INTO car (`car_reg_number`, `car_chassis_number`, `car_make`, `car_model`, `car_color`, `car_equipment_level`, `car_reg_fee`, `car_emission`, `car_status`, `car_url`)
VALUES ('1232488FGDDFFD', '991235ASSIS', 'Ford', 'Mustang Fastback', 'Sort', 'Ekstra +', '45000', '100.5', 'workshop', 'https://cdn.pixabay.com/photo/2014/11/08/07/56/ford-mustang-521841_960_720.jpg');
INSERT INTO car (`car_reg_number`, `car_chassis_number`, `car_make`, `car_model`, `car_color`, `car_equipment_level`, `car_reg_fee`, `car_emission`, `car_status`, `car_url`)
VALUES ('91233D323232323', '1222344552', 'Ford', 'Mustang Fastback', 'Sølv', 'Ekstra +', '45000', '100.5', 'available', 'https://cdn.pixabay.com/photo/2014/04/29/01/38/auto-334159_960_720.jpg');
INSERT INTO car (`car_reg_number`, `car_chassis_number`, `car_make`, `car_model`, `car_color`, `car_equipment_level`, `car_reg_fee`, `car_emission`, `car_status`, `car_url`)
VALUES ('91234324324234', '134234242343', 'Ford', 'Mustang Fastback', 'Sølv', 'Ekstra +', '45000', '100.5', 'available', 'https://cdn.pixabay.com/photo/2014/04/29/01/38/auto-334159_960_720.jpg');
INSERT INTO car (`car_reg_number`, `car_chassis_number`, `car_make`, `car_model`, `car_color`, `car_equipment_level`, `car_reg_fee`, `car_emission`, `car_status`, `car_url`)
VALUES ('91232312321312', '12323234342', 'Ford', 'Mustang Fastback', 'Sølv', 'Ekstra +', '45000', '100.5', 'workshop', 'https://cdn.pixabay.com/photo/2014/04/29/01/38/auto-334159_960_720.jpg');
INSERT INTO car (`car_reg_number`, `car_chassis_number`, `car_make`, `car_model`, `car_color`, `car_equipment_level`, `car_reg_fee`, `car_emission`, `car_status`, `car_url`)
VALUES ('91233D43FDSFJDF', '13245565643', 'Ford', 'Mustang Fastback', 'Sølv', 'Ekstra +', '45000', '100.5', 'workshop', 'https://cdn.pixabay.com/photo/2014/04/29/01/38/auto-334159_960_720.jpg');
INSERT INTO car (car_reg_number, car_chassis_number, car_make, car_model, car_color, car_equipment_level, car_reg_fee, car_emission, car_status, car_url)
VALUES ('jy43523', 'ht545fg445f', 'Kia', 'Picanto', 'Rød', 'Intet', '20000', '1000', 'reserved', 'https://fdm.dk/sites/default/files/2020-06/Kia-PICANTO-roed-for.jpg');
INSERT INTO car (car_reg_number, car_chassis_number, car_make, car_model, car_color, car_equipment_level, car_reg_fee, car_emission, car_status, car_url)
VALUES ('jy23651', 'ef34f23f2df2', 'Kia', 'Picanto', 'Rød', 'Intet', '20000', '1000', 'available', 'https://fdm.dk/sites/default/files/2020-06/Kia-PICANTO-roed-for.jpg');
INSERT INTO car (car_reg_number, car_chassis_number, car_make, car_model, car_color, car_equipment_level, car_reg_fee, car_emission, car_status, car_url)
VALUES ('aw23453', 'afsdf34f34', 'Kia', 'Picanto', 'Rød', 'Intet', '20000', '1000', 'reserved', 'https://fdm.dk/sites/default/files/2020-06/Kia-PICANTO-roed-for.jpg');
INSERT INTO car (car_reg_number, car_chassis_number, car_make, car_model, car_color, car_equipment_level, car_reg_fee, car_emission, car_status, car_url)
VALUES ('hr53453', 'sgdfaw34a3w', 'Kia', 'Rio', 'Hvid', 'Ekstra', '30000', '1000', 'available', 'https://upload.wikimedia.org/wikipedia/commons/thumb/6/60/2018_Kia_Rio_EX_-_Side.jpg/1200px-2018_Kia_Rio_EX_-_Side.jpg');
INSERT INTO car (car_reg_number, car_chassis_number, car_make, car_model, car_color, car_equipment_level, car_reg_fee, car_emission, car_status, car_url)
VALUES ('lu34263', 'asdfagrewrgwe', 'Kia', 'ev6', 'Grå', 'Ekstra', '50000', '1000', 'reserved', 'https://www.ujs-biler.dk/wp-content/uploads/2021/03/kia-cv-gallery-three-quarter-front-low.jpg');
INSERT INTO car (car_reg_number, car_chassis_number, car_make, car_model, car_color, car_equipment_level, car_reg_fee, car_emission, car_status, car_url)
VALUES ('zi34234', 'asf43wf3f234f', 'Kia', 'ev6', 'Grå', 'Ekstra', '50000', '1000', 'available', 'https://www.ujs-biler.dk/wp-content/uploads/2021/03/kia-cv-gallery-three-quarter-front-low.jpg');
INSERT INTO car (car_reg_number, car_chassis_number, car_make, car_model, car_color, car_equipment_level, car_reg_fee, car_emission, car_status, car_url)
VALUES ('me73453', '45g543g3d2', 'Kia', 'ev6', 'Grå', 'Ekstra', '50000', '1000', 'available', 'https://www.ujs-biler.dk/wp-content/uploads/2021/03/kia-cv-gallery-three-quarter-front-low.jpg');
INSERT INTO car (car_reg_number, car_chassis_number, car_make, car_model, car_color, car_equipment_level, car_reg_fee, car_emission, car_status, car_url)
VALUES ('jy34535', 'ze34534', 'Kia', 'Sorento', 'Blå', 'Ekstra', '50000', '1000', 'workshop', 'https://www.kia.com/content/dam/kwcms/kme/global/en/assets/vehicles/sorento-mq4-phev-my21/discover/kia-sorento-phev-my22-trimline.png');
INSERT INTO car (car_reg_number, car_chassis_number, car_make, car_model, car_color, car_equipment_level, car_reg_fee, car_emission, car_status, car_url)
VALUES ('cu45354', 'trer6eww', 'Kia', 'Sorento', 'Blå', 'Ekstra', '50000', '1000', 'reserved', 'https://www.kia.com/content/dam/kwcms/kme/global/en/assets/vehicles/sorento-mq4-phev-my21/discover/kia-sorento-phev-my22-trimline.png');
INSERT INTO car (car_reg_number, car_chassis_number, car_make, car_model, car_color, car_equipment_level, car_reg_fee, car_emission, car_status, car_url)
VALUES ('ff23442', 'asgasd23r324', 'Citroen', 'c4', 'Orange', 'Ekstra +', '45000', '100.5', 'reserved', 'https://www.altomdata.dk/wp-content/uploads/2020/06/citroen-e-c4-3.jpg');
INSERT INTO car (car_reg_number, car_chassis_number, car_make, car_model, car_color, car_equipment_level, car_reg_fee, car_emission, car_status, car_url)
VALUES ('gt34532', '23fdef2352ef', 'Citroen', 'c4', 'Orange', 'Ekstra +', '45000', '100.5', 'available', 'https://www.altomdata.dk/wp-content/uploads/2020/06/citroen-e-c4-3.jpg');
INSERT INTO car (car_reg_number, car_chassis_number, car_make, car_model, car_color, car_equipment_level, car_reg_fee, car_emission, car_status, car_url)
VALUES ('hy23452', 'ff34f3edf3', 'Citroen', 'c4', 'Orange', 'Ingen', '40000', '100', 'workshop', 'https://www.altomdata.dk/wp-content/uploads/2020/06/citroen-e-c4-3.jpg');
INSERT INTO car (car_reg_number, car_chassis_number, car_make, car_model, car_color, car_equipment_level, car_reg_fee, car_emission, car_status, car_url)
VALUES ('læ46325', 'ku5467g45g', 'Citroen', 'c4', 'Sort', 'Ingen', '45000', '100.5', 'reserved', 'https://www.bilhusetelmer.dk/media/2053/ny_c4_modeller_130_feel.jpg');
INSERT INTO car (car_reg_number, car_chassis_number, car_make, car_model, car_color, car_equipment_level, car_reg_fee, car_emission, car_status, car_url)
VALUES ('nu35634', 'lk46g4g4', 'Citroen', 'c4', 'Sort', 'Ingen', '45000', '100.5', 'reserved', 'https://www.bilhusetelmer.dk/media/2053/ny_c4_modeller_130_feel.jpg');
INSERT INTO car (car_reg_number, car_chassis_number, car_make, car_model, car_color, car_equipment_level, car_reg_fee, car_emission, car_status, car_url)
VALUES ('ku255612', '2gfg245', 'Citroen', 'c3', 'Sort', 'Ingen', '35000', '100.5', 'available', 'https://pchristensen.dk/wp-content/uploads/2021/09/kategori_Citroen_ny_c3_aircross_sort-400x181.png');
INSERT INTO car (car_reg_number, car_chassis_number, car_make, car_model, car_color, car_equipment_level, car_reg_fee, car_emission, car_status, car_url)
VALUES ('jy14623', 'kghkfg464352b2', 'Citroen', 'c1', 'Hvid', 'Ekstra ++', '30000', '80', 'available', 'https://upload.wikimedia.org/wikipedia/commons/thumb/3/3f/Citroen_C1_front_20080417.jpg/1200px-Citroen_C1_front_20080417.jpg');
INSERT INTO car (car_reg_number, car_chassis_number, car_make, car_model, car_color, car_equipment_level, car_reg_fee, car_emission, car_status, car_url)
VALUES ('ju57456', 'mncsdfs5463f34', 'Audi', 'a3', 'Blå', 'Ekstra', '50000', '1200', 'reserved', 'https://fdm.dk/sites/default/files/2020-03/Audi-A3-2020-for.jpg');
INSERT INTO car (car_reg_number, car_chassis_number, car_make, car_model, car_color, car_equipment_level, car_reg_fee, car_emission, car_status, car_url)
VALUES ('li34534', '1fdf13f413f', 'Audi', 'a3', 'Blå', 'Ekstra', '50000', '1200', 'available', 'https://fdm.dk/sites/default/files/2020-03/Audi-A3-2020-for.jpg');
INSERT INTO car (car_reg_number, car_chassis_number, car_make, car_model, car_color, car_equipment_level, car_reg_fee, car_emission, car_status, car_url)
VALUES ('ku35343', '1df1f3gf1f134', 'Audi', 'a3', 'Rød', 'Ekstra++', '55000', '1200', 'available', 'https://upload.wikimedia.org/wikipedia/commons/thumb/5/51/Audi_A3_8V_1.4_TFSI_Ambiente_Misanorot.JPG/1200px-Audi_A3_8V_1.4_TFSI_Ambiente_Misanorot.JPG');
INSERT INTO car (car_reg_number, car_chassis_number, car_make, car_model, car_color, car_equipment_level, car_reg_fee, car_emission, car_status, car_url)
VALUES ('lu34794', 'nmtj35h35g34', 'Audi', 'a1', 'Hvid', 'Ekstra', '30000', '1000', 'available', 'https://picture2.biltorvet.dk/article/e5cf058909fa4edfa90b05b2bf61fb6a.jpg?aid=781&width=1600&height=900&mode=crop&scale=both');
INSERT INTO car (car_reg_number, car_chassis_number, car_make, car_model, car_color, car_equipment_level, car_reg_fee, car_emission, car_status, car_url)
VALUES ('li4645', '1d3d134d13d', 'Audi', 'a1', 'Hvid', 'Ekstra', '30000', '1000', 'reserved', 'https://picture2.biltorvet.dk/article/e5cf058909fa4edfa90b05b2bf61fb6a.jpg?aid=781&width=1600&height=900&mode=crop&scale=both');
INSERT INTO car (car_reg_number, car_chassis_number, car_make, car_model, car_color, car_equipment_level, car_reg_fee, car_emission, car_status, car_url)
VALUES ('lo37654', 'sdfhsd4s2d', 'Hyundai', 'i10', 'Blå', 'Intet', '20000', '1000', 'reserved', 'https://media.hyundai.dk/media/wnvkt10x/minibil.png');
INSERT INTO car (car_reg_number, car_chassis_number, car_make, car_model, car_color, car_equipment_level, car_reg_fee, car_emission, car_status, car_url)
VALUES ('ku45432', '2sdg2sdg2e43', 'Hyundai', 'i10', 'Blå', 'Intet', '20000', '1000', 'reserved', 'https://media.hyundai.dk/media/wnvkt10x/minibil.png');
INSERT INTO car (car_reg_number, car_chassis_number, car_make, car_model, car_color, car_equipment_level, car_reg_fee, car_emission, car_status, car_url)
VALUES ('xf35432', '2gdgsdg2dg2eg2', 'Hyundai', 'i10', 'Blå', 'Intet', '20000', '1000', 'reserved', 'https://media.hyundai.dk/media/wnvkt10x/minibil.png');

-- Skadesrapporter

INSERT INTO damage_report (`damage_report_id`, `damage_report_date`, `damage_report_description`, `damage_report_car_chassis_number`) VALUES (10, '2022-01-01', 'Kørt ind i træ', '991235CHASSIS');
INSERT INTO damage_report (`damage_report_id`, `damage_report_date`, `damage_report_description`, `damage_report_car_chassis_number`) VALUES (20, '2007-01-01', 'Sammenstød', 'ht545fg445f');
INSERT INTO damage_report (`damage_report_id`, `damage_report_date`, `damage_report_description`, `damage_report_car_chassis_number`) VALUES (30, '2011-01-01', 'Torpderet', 'kghkfg464352b2');
INSERT INTO damage_report (`damage_report_id`, `damage_report_date`, `damage_report_description`, `damage_report_car_chassis_number`) VALUES (40, '2015-01-01', 'Kørt igennem et hus', 'sdfhsd4s2d');
INSERT INTO damage_report (`damage_report_id`, `damage_report_date`, `damage_report_description`, `damage_report_car_chassis_number`) VALUES (50, '2014-01-01', 'Væltet rundt', '1d3d134d13d');
INSERT INTO damage_report (`damage_report_id`, `damage_report_date`, `damage_report_description`, `damage_report_car_chassis_number`) VALUES (60, '2012-01-01', 'Kørt ind i træ', '991235CHASSIS');
INSERT INTO damage_report (`damage_report_id`, `damage_report_date`, `damage_report_description`, `damage_report_car_chassis_number`) VALUES (70, '2020-03-16', 'Kørt ud over klippe', '991235CHASSIS');
INSERT INTO damage_report (`damage_report_id`, `damage_report_date`, `damage_report_description`, `damage_report_car_chassis_number`) VALUES (80, '2011-01-01', 'Kørt ind i træ', '1d3d134d13d');
INSERT INTO damage_report (`damage_report_id`, `damage_report_date`, `damage_report_description`, `damage_report_car_chassis_number`) VALUES (90, '2011-01-01', 'Kørt ind i træ', '1d3d134d13d');

-- Skader

INSERT INTO damage (`damage_description`, `damage_price`, `damage_report_id`)
VALUES ('Forrude', '2000', '10');
INSERT INTO damage (`damage_description`, `damage_price`, `damage_report_id`)
VALUES ('Motor', '6000', '10');
INSERT INTO damage (`damage_description`, `damage_price`, `damage_report_id`)
VALUES ('Dør', '1000', '10');
INSERT INTO damage (`damage_description`, `damage_price`, `damage_report_id`)
VALUES ('Sidespejl', '2000', '10');
INSERT INTO damage (`damage_description`, `damage_price`, `damage_report_id`)
VALUES ('Forrude', '2000', '20');
INSERT INTO damage (`damage_description`, `damage_price`, `damage_report_id`)
VALUES ('Motor', '6000', '20');
INSERT INTO damage (`damage_description`, `damage_price`, `damage_report_id`)
VALUES ('Dør', '1000', '20');
INSERT INTO damage (`damage_description`, `damage_price`, `damage_report_id`)
VALUES ('Sidespejl', '2000', '20');
INSERT INTO damage (`damage_description`, `damage_price`, `damage_report_id`)
VALUES ('Sidespejl', '2000', '30');
INSERT INTO damage (`damage_description`, `damage_price`, `damage_report_id`)
VALUES ('Lak', '500', '30');
INSERT INTO damage (`damage_description`, `damage_price`, `damage_report_id`)
VALUES ('Sæde', '6000', '30');
INSERT INTO damage (`damage_description`, `damage_price`, `damage_report_id`)
VALUES ('Sidespejl', '2000', '40');
INSERT INTO damage (`damage_description`, `damage_price`, `damage_report_id`)
VALUES ('Motor', '11000', '40');
INSERT INTO damage (`damage_description`, `damage_price`, `damage_report_id`)
VALUES ('Kofanger', '10000', '40');
INSERT INTO damage (`damage_description`, `damage_price`, `damage_report_id`)
VALUES ('Kofanger', '10000', '50');
INSERT INTO damage (`damage_description`, `damage_price`, `damage_report_id`)
VALUES ('Bagagerum', '6000', '60');
INSERT INTO damage (`damage_description`, `damage_price`, `damage_report_id`)
VALUES ('Rat', '1000', '60');
INSERT INTO damage (`damage_description`, `damage_price`, `damage_report_id`)
VALUES ('Radio', '2000', '60');
INSERT INTO damage (`damage_description`, `damage_price`, `damage_report_id`)
VALUES ('Radio', '2000', '70');
INSERT INTO damage (`damage_description`, `damage_price`, `damage_report_id`)
VALUES ('Dør', '2000', '80');
INSERT INTO damage (`damage_description`, `damage_price`, `damage_report_id`)
VALUES ('Radio', '2000', '80');
INSERT INTO damage (`damage_description`, `damage_price`, `damage_report_id`)
VALUES ('Motor', '22000', '80');
INSERT INTO damage (`damage_description`, `damage_price`, `damage_report_id`)
VALUES ('Sidespejl', '3000', '80');
INSERT INTO damage (`damage_description`, `damage_price`, `damage_report_id`)
VALUES ('Rude', '3000', '90');

-- Lejeaftaler

INSERT INTO lease (`lease_car_reg_number`, `lease_price`, `lease_customer_cpr_number`, `lease_account_number`, `lease_reg_number`, `lease_start_date`, `lease_end_date`)
VALUES ('991235REGNUMBER', '6500', '1212982352', '2221', '22321323', '2018-05-21', '2019-06-20');
INSERT INTO lease (`lease_car_reg_number`, `lease_price`, `lease_customer_cpr_number`, `lease_account_number`, `lease_reg_number`, `lease_start_date`, `lease_end_date`)
VALUES ('R212EG233NUMBER', '5700', '1212982352', '2221', '22321323', '2018-05-21', '2019-06-20');
INSERT INTO lease (`lease_car_reg_number`, `lease_price`, `lease_customer_cpr_number`, `lease_account_number`, `lease_reg_number`, `lease_start_date`, `lease_end_date`)
VALUES ('jy43523', '2000', '1010996523', '2221', '22321323', '2018-05-21', '2019-06-20');
INSERT INTO lease (`lease_car_reg_number`, `lease_price`, `lease_customer_cpr_number`, `lease_account_number`, `lease_reg_number`, `lease_start_date`, `lease_end_date`)
VALUES ('lu34263', '3500', '1010996523', '2221', '22321323', '2018-05-21', '2019-06-20');
INSERT INTO lease (`lease_car_reg_number`, `lease_price`, `lease_customer_cpr_number`, `lease_account_number`, `lease_reg_number`, `lease_start_date`, `lease_end_date`)
VALUES ('ff23442', '11500', '1010996523', '2221', '22321323', '2018-05-21', '2019-06-20');
INSERT INTO lease (`lease_car_reg_number`, `lease_price`, `lease_customer_cpr_number`, `lease_account_number`, `lease_reg_number`, `lease_start_date`, `lease_end_date`)
VALUES ('læ46325', '2500', '1010996523', '2221', '22321323', '2018-05-21', '2019-06-20');
INSERT INTO lease (`lease_car_reg_number`, `lease_price`, `lease_customer_cpr_number`, `lease_account_number`, `lease_reg_number`, `lease_start_date`, `lease_end_date`)
VALUES ('cu45354', '4235', '1010996523', '2221', '22321323', '2018-05-21', '2019-06-20');
INSERT INTO lease (`lease_car_reg_number`, `lease_price`, `lease_customer_cpr_number`, `lease_account_number`, `lease_reg_number`, `lease_start_date`, `lease_end_date`)
VALUES ('nu35634', '5222', '1010996523', '2221', '22321323', '2018-05-21', '2019-06-20');
INSERT INTO lease (`lease_car_reg_number`, `lease_price`, `lease_customer_cpr_number`, `lease_account_number`, `lease_reg_number`, `lease_start_date`, `lease_end_date`)
VALUES ('ju57456', '1222', '1010996523', '2221', '22321323', '2018-05-21', '2019-06-20');
INSERT INTO lease (`lease_car_reg_number`, `lease_price`, `lease_customer_cpr_number`, `lease_account_number`, `lease_reg_number`, `lease_start_date`, `lease_end_date`)
VALUES ('li4645', '5454', '1010996523', '2221', '22321323', '2018-05-21', '2019-06-20');
INSERT INTO lease (`lease_car_reg_number`, `lease_price`, `lease_customer_cpr_number`, `lease_account_number`, `lease_reg_number`, `lease_start_date`, `lease_end_date`)
VALUES ('lo37654', '3599', '1010996523', '2221', '22321323', '2018-05-21', '2019-06-20');
INSERT INTO lease (`lease_car_reg_number`, `lease_price`, `lease_customer_cpr_number`, `lease_account_number`, `lease_reg_number`, `lease_start_date`, `lease_end_date`)
VALUES ('xf35432', '3228', '1010996523', '2221', '22321323', '2018-05-21', '2019-06-20');
INSERT INTO lease (`lease_car_reg_number`, `lease_price`, `lease_customer_cpr_number`, `lease_account_number`, `lease_reg_number`, `lease_start_date`, `lease_end_date`)
VALUES ('ku45432', '8999', '1010996523', '2221', '22321323', '2018-05-21', '2019-06-20');
INSERT INTO lease (`lease_car_reg_number`, `lease_price`, `lease_customer_cpr_number`, `lease_account_number`, `lease_reg_number`, `lease_start_date`, `lease_end_date`)
VALUES ('aw23453', '4555', '1010996523', '2221', '22321323', '2018-05-21', '2019-06-20');





