package org.example;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args)  {
        String url = "jdbc:mysql://localhost:3306/sweet";
        String username="root";
        String password = "Shivani@2025";

        try(Connection connection = DriverManager.getConnection(DBConstant.URL.getS(), DBConstant.USERNAME.getS(), DBConstant.SECRET.getS());
        ) {

            Statement statement = connection.createStatement();
            String selectAll = "select * from sweet";
            ResultSet resultSet = statement.executeQuery(selectAll);
            System.out.println(resultSet);

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String type = resultSet.getString("type");
                String flavour = resultSet.getString("flavor");
                int price = resultSet.getInt("price");
                int weight = resultSet.getInt("weight");
                String brand = resultSet.getString("brand");


                System.out.println("The id is " +id);
                System.out.println("The name is " + name);
                System.out.println("The type is " + type);
                System.out.println("The flavour is " + flavour);
                System.out.println("The price is " + price);
                System.out.println("The weight is " + weight);
                System.out.println("The brand is " + brand);

            }

            //one row
            String oneRow = "select * from sweet where id = 1";
            ResultSet resultSet1 = statement.executeQuery(oneRow);
            System.out.println(resultSet1);
            while(resultSet1.next()){
                String name = resultSet1.getNString("name");
                System.out.println("name "+ name );

                 System.out.println("---------------------------------------------");

            }
//one row one column
            String row1column1="Select name from sweet where id=10";
            ResultSet resultSet3=statement.executeQuery(row1column1);
            System.out.println("Resultset:"+resultSet3);

            while (resultSet3.next()){
                String sweet=resultSet3.getString("name");
                System.out.println("Sweet name :"+sweet);
                System.out.println(".......................................................");
            }

            //Select two rows
            String selectrow2="Select * from sweet where id=3 or id=1";
            ResultSet resultSet4=statement.executeQuery(selectrow2);
            System.out.println("ResultSet:"+resultSet4);

            while (resultSet4.next()) {
                int id=resultSet4.getInt("id");
                String name = resultSet4.getString("name");
                System.out.println("Sweet id is: " + id + " Sweet name is: " + name);
            }
            System.out.println(".......................................................");

            //Select three rows
            String selectrow3 ="select * from sweet where id IN(6,10,12)";
            ResultSet resultSet5=statement.executeQuery(selectrow3);
            System.out.println("Resultset:"+resultSet5);

            while (resultSet5.next()){
                int sweet_id=resultSet5.getInt("id");
                String sweet_name = resultSet5.getString("name");
                String sweet_type = resultSet5.getString("type");
                System.out.println("Sweet id is: " + sweet_id + " Sweet name is: " + sweet_name + " Sweet type is: " +sweet_type);
            }
            System.out.println(".......................................................");

            //Select one column all rows
            String columnallrows = "Select name from sweet";
            ResultSet resultSet6 = statement.executeQuery(columnallrows);
            System.out.println("ResultSet: " + resultSet6);

            while (resultSet6.next()) {
                String sweet_name = resultSet6.getString("name");
                System.out.println("Sweet Name: " + sweet_name);
            }

//            String sql = " insert into sweet values (4,'Jalebi','Fried Sweet','Saffron',15,80,'Bikanervala'),"+
//            "(5,'Kaju Katli','Barfi','Cashew',40,100,'Haldirams'),"+
//            "(6,'Mysore Pak','Ghee Sweet','Gram Flour',35,110,'Sri Krishna Sweets'),"+
//            "(7,'Ladoo (Boondi)','Ladoo','Cardamom',20,90,'Haldirams'),"+
//                     "(8,'Motichoor Ladoo','Ladoo','Cardamom',25,100,'Bikaji'),"+
//            "(9,'Besan Ladoo','Ladoo','Gram Flour',22,95,'Haldirams'),"+
//            "(10,'Rava Ladoo','Ladoo','Semolina',18,85,'Homemade'),"+
//            "(11,'Coconut Ladoo','Ladoo','Coconut',20,100,'Homemade'),"+
//            "(12,'Dry Fruit Ladoo','Ladoo','Mixed Dry Fruits',45,150,'Chitale'),"+
//            "(13,'Badam Halwa','Halwa','Almond',55,120,'Sri Krishna'),"+
//            "(14,'Carrot Halwa','Halwa','Carrot',30,130,'Homemade'),"+
//            "(15,'Moong Dal Halwa','Halwa','Dal',35,130,'Haldirams'),"+
//            "(16,'Sohan Halwa','Halwa','Wheat',25,90,'Bikanervala'),"+
//            "(17,'Milk Cake','Milk Sweet','Milk',30,110,'Haldirams'),"+
//                    "(18,'Kalakand','Milk Sweet','Cardamom',28,100,'Bikaji'),"+
//            "(19,'Peda (Mathura)','Milk Sweet','Milk',20,70,'Mathura Special'),"+
//            "(20,'Dharwad Peda','Milk Sweet','Milk',22,80,'Dharwad Special'),"+
//            "(21,'Sandesh','Bengali Sweet','Milk',25,80,'K.C. Das'),"+
//                    "(22,'Chandrakala','Fried Sweet','Khoa',35,150,'Bikanervala'),"+
//                    "(23,'Balushahi','Fried Sweet','Sugar',15,70,'Homemade'),"+
//                    "(24,'Malpua','Fried Sweet','Cardamom',20,120,'Homemade'),"+
//                    "(25,'Rabri','Milk Sweet','Kesar',40,150,'Haldirams'),"+
//                    "(26,'Shrikhand','Milk Sweet','Kesar',30,140,'Amul'),"+
//                    "(27,'Basundi','Milk Sweet','Cardamom',35,150,'Homemade'),"+
//                    "(28,'Kheer','Milk Sweet','Rice',28,160,'Homemade'),"+
//                    "(29,'Phirni','Milk Sweet','Kesar',25,120,'Bikanervala'),"+
//                    "(30,'Double Ka Meetha','Bread Sweet','Cardamom',30,140,'Hyderabad House'),"+
//                    "(31,'Sheera','Halwa','Sooji',15,100,'Homemade'),"+
//                    "(32,'Payasam','Milk Sweet','Jaggery',25,130,'Homemade'),"+
//                    "(33,'Obbattu (Holige)','Special Sweet','Jaggery',20,80,'Udupi Special'),"+
//                    "(34,'Pineapple Sheera','Halwa','Pineapple',20,110,'Homemade'),"+
//                    "(35,'Mango Barfi','Barfi','Mango',30,100,'Haldirams'),"+
//                    "(36,'Pista Barfi','Barfi','Pista',35,120,'Bikanervala'),"+
//                    "(37,'Rose Barfi','Barfi','Rose',28,100,'Haldirams'),"+
//                    "(38,'Chocolate Barfi','Barfi','Chocolate',25,110,'Haldirams'),"+
//                    "(39,'Khoya Barfi','Barfi','Milk',30,120,'Chitale'),"+
//                    "(40,'Dry Fruit Barfi','Barfi','Mixed Nuts',45,150,'Bikanervala'),"+
//                    "(41,'Badusha','Fried Sweet','Sugar',18,90,'Homemade'),"+
//                    "(42,'Til Laddu','Ladoo','Sesame',12,60,'Homemade'),"+
//                    "(43,'Chikki','Sweet Bar','Peanut',10,50,'Lonavala'),"+
//                    "(44,'Peanut Laddu','Ladoo','Peanut',15,70,'Homemade'),"+
//                    "(45,'Adhirasam','South Sweet','Jaggery',20,90,'Tamil Nadu Special'),"+
//                    "(46,'Kozhukattai Sweet','South Sweet','Coconut',15,80,'Udupi Special'),"+
//                    "(47,'Sweet Pongal','South Sweet','Jaggery',25,130,'Homemade'),"+
//                    "(48,'Unniyappam','South Sweet','Banana',18,90,'Kerala Special'),"+
//                    "(49,'Ariselu','South Sweet','Rice & Jaggery',20,100,'Andhra Special'),"+
//                    "(50,'Bobbatlu Sweet','South Sweet','Dal',20,120,'Andhra Special'),"+
//                    "(51,'Mishti Doi','Curd Sweet','Caramel',20,100,'K.C. Das'),"+
//                    "(52,'Nankhatai','Biscuit Sweet','Cardamom',10,60,'Homemade'),"+
//                    "(53,'Sweet Samosa','Fried Sweet','Khoa',15,90,'Bikanervala'),"+
//                    "(54,'Shahi Tukda','Bread Sweet','Kesar',30,140,'Hyderabad House'),"+
//                    "(55,'Gajar Barfi','Barfi','Carrot',20,90,'Haldirams'),"+
//                    "(56,'Khasta Gaja','Bihari Sweet','Sugar',18,100,'Bihar Special'),"+
//                    "(57,'Petha','Dry Sweet','Ash Gourd',20,100,'Agra Petha'),"+
//                    "(58,'Agra Petha Kesar','Dry Sweet','Kesar',25,120,'Agra Petha'),"+
//                    "(59,'Jalebi Rabdi','Combo Sweet','Kesar',35,150,'Bikanervala'),"+
//                    "(60,'Kesari','Halwa','Saffron',15,100,'Homemade'),"+
//                    "(61,'Boora Sweet','Sugar Sweet','Powdered Sugar',12,60,'Homemade'),"+
//                    "(62,'Lapsi','Halwa','Broken Wheat',20,120,'Homemade'),"+
//                    "(63,'Sweet Poha','Light Sweet','Jaggery',10,70,'Homemade'),"+
//                    "(64,'Sakkarai Pongal','South Sweet','Jaggery',25,130,'Homemade'),"+
//                    "(65,'Banaras Kalakand','Milk Sweet','Cardamom',32,110,'Banaras Sweet House'),"+
//                    "(66,'Dry Fruit Halwa','Halwa','Mixed Nuts',45,130,'Sri Krishna'),"+
//                    "(67,'Fig Barfi','Barfi','Fig',40,120,'Haldirams'),"+
//                    "(68,'Anjeer Roll','Dry Fruit Sweet','Fig',50,150,'Bikanervala'),"+
//                    "(69,'Kesar Katli','Barfi','Saffron',45,120,'Haldirams'),"+
//                    "(70,'Kaddu Ka Halwa','Halwa','Pumpkin',25,130,'Hyderabad House'),"+
//                    "(71,'Sweet Modak','Modak','Coconut',20,100,'Ganesh Special'),"+
//                    "(72,'Stuffed Gulab Jamun','Milk Sweet','Kesar',30,140,'Haldirams'),"+
//                    "(73,'Black Jamun','Bengali Sweet','Rose',30,120,'K.C. Das'),"+
//                    "(74,'Malai Sandwich','Bengali Sweet','Milk',32,130,'K.C. Das'),"+
//                    "(75,'Rasgulla Premium','Bengali Sweet','Milk',30,140,'K.C. Das')";


//            String sql1 = "insert into streets values (76,'MG Road','Bengaluru','Karnataka','India',560001,2.5,20,true,true,'High','Commercial',35000),"+
//                    "(2,'Brigade Road','Bengaluru','Karnataka','India',560025,1.8,18,true,true,'High','Commercial',33000)," +
//                            "(3,'Church Street','Bengaluru','Karnataka','India',560001,1.2,12,true,true,'Medium','Commercial',30000)," +
//                            "(4,'Residency Road','Bengaluru','Karnataka','India',560025,3.1,16,true,true,'High','Commercial',32000)," +
//                            "(5,'Indiranagar 100 Feet Road','Bengaluru','Karnataka','India',560038,4.0,22,true,true,'High','Residential',28000)," +
//                            "(6,'CMH Road','Bengaluru','Karnataka','India',560038,2.0,14,true,true,'Medium','Commercial',26000)," +
//                            "(7,'Koramangala 80 Feet Road','Bengaluru','Karnataka','India',560034,3.5,20,true,true,'High','Commercial',30000)," +
//                            "(8,'Sarjapur Main Road','Bengaluru','Karnataka','India',560102,15.0,24,true,true,'High','Mixed',25000)," +
//                            "(9,'Bellandur Main Road','Bengaluru','Karnataka','India',560103,6.0,18,true,true,'High','Mixed',24000)," +
//                            "(10,'Outer Ring Road Marathahalli','Bengaluru','Karnataka','India',560037,12.0,30,true,true,'High','Highway',27000)," +
//                            "(11,'Marathahalli Bridge Road','Bengaluru','Karnataka','India',560037,2.0,16,true,true,'High','Commercial',25000)," +
//                            "(12,'Old Airport Road','Bengaluru','Karnataka','India',560017,10.0,26,true,true,'High','Mixed',27000)," +
//                            "(13,'HAL Road','Bengaluru','Karnataka','India',560017,4.0,18,true,true,'Medium','Mixed',24000)," +
//                            "(14,'Domlur Flyover Road','Bengaluru','Karnataka','India',560071,3.0,20,true,true,'High','Mixed',23000)," +
//                            "(15,'Ejipura Main Road','Bengaluru','Karnataka','India',560047,2.2,14,true,true,'Medium','Residential',21000)," +
//                            "(16,'Sony World Signal Road','Bengaluru','Karnataka','India',560034,1.6,16,true,true,'High','Commercial',29000)," +
//                            "(17,'HSR Layout 27th Main','Bengaluru','Karnataka','India',560102,3.0,18,true,true,'Medium','Residential',22000)," +
//                            "(18,'HSR Layout 17th Cross','Bengaluru','Karnataka','India',560102,1.8,14,true,true,'Medium','Residential',20000)," +
//                            "(19,'BTM Layout 16th Main','Bengaluru','Karnataka','India',560076,2.0,15,true,true,'Medium','Residential',21000)," +
//                            "(20,'Bannerghatta Road','Bengaluru','Karnataka','India',560076,18.0,28,true,true,'High','Mixed',26000)," +
//                            "(21,'Jayanagar 4th Block Road','Bengaluru','Karnataka','India',560011,3.5,18,true,true,'Medium','Residential',20000)," +
//                            "(22,'Jayanagar 9th Block Road','Bengaluru','Karnataka','India',560069,2.8,16,true,true,'Medium','Residential',21000)," +
//                            "(23,'JP Nagar 15th Cross','Bengaluru','Karnataka','India',560078,2.5,14,true,true,'Medium','Residential',20000)," +
//                            "(24,'JP Nagar ORR','Bengaluru','Karnataka','India',560078,5.0,26,true,true,'High','Highway',23000)," +
//                            "(25,'Kanakapura Main Road','Bengaluru','Karnataka','India',560062,14.0,24,true,true,'High','Mixed',22000)," +
//                            "(26,'Bull Temple Road','Bengaluru','Karnataka','India',560004,2.2,14,true,true,'Medium','Residential',19000)," +
//                            "(27,'Gandhi Bazaar Road','Bengaluru','Karnataka','India',560004,1.8,12,true,true,'High','Commercial',25000)," +
//                            "(28,'Sajjan Rao Road','Bengaluru','Karnataka','India',560004,1.5,10,true,true,'Medium','Residential',18000)," +
//                            "(29,'Vijayanagar 1st Main','Bengaluru','Karnataka','India',560040,3.0,16,true,true,'Medium','Residential',20000)," +
//                            "(30,'Chandra Layout Main Road','Bengaluru','Karnataka','India',560040,2.5,14,true,true,'Medium','Residential',19000)," +
//                            "(31,'Nagarbhavi 2nd Stage Road','Bengaluru','Karnataka','India',560072,4.0,18,true,true,'Medium','Residential',22000)," +
//                            "(32,'Rajajinagar Dr Rajkumar Road','Bengaluru','Karnataka','India',560010,3.5,20,true,true,'High','Commercial',27000)," +
//                            "(33,'Rajajinagar 6th Block Road','Bengaluru','Karnataka','India',560010,2.0,14,true,true,'Medium','Residential',20000)," +
//                            "(34,'Malleshwaram 8th Cross','Bengaluru','Karnataka','India',560003,1.2,12,true,true,'High','Commercial',30000)," +
//                            "(35,'Sampige Road','Bengaluru','Karnataka','India',560003,2.0,16,true,true,'High','Commercial',31000)," +
//                            "(36,'Sadashivanagar Main Road','Bengaluru','Karnataka','India',560080,2.5,18,true,true,'Medium','Residential',22000)," +
//                            "(37,'Hebbal ORR','Bengaluru','Karnataka','India',560024,10.0,28,true,true,'High','Highway',26000)," +
//                            "(38,'Hebbal Kempapura Road','Bengaluru','Karnataka','India',560024,3.2,16,true,true,'Medium','Residential',21000)," +
//                            "(39,'Yelahanka New Town Main Road','Bengaluru','Karnataka','India',560064,6.0,18,true,true,'Medium','Residential',20000)," +
//                            "(40,'Yeshwanthpur Tumkur Road','Bengaluru','Karnataka','India',560022,15.0,30,true,true,'High','Highway',25000)," +
//                            "(41,'Peenya Industrial Road','Bengaluru','Karnataka','India',560058,8.0,24,true,true,'High','Industrial',24000)," +
//                            "(42,'RT Nagar Main Road','Bengaluru','Karnataka','India',560032,3.0,14,true,true,'Medium','Residential',20000)," +
//                            "(43,'Frazer Town Mosque Road','Bengaluru','Karnataka','India',560005,1.8,12,true,true,'Medium','Commercial',23000)," +
//                            "(44,'Cox Town Wheeler Road','Bengaluru','Karnataka','India',560005,2.2,14,true,true,'Medium','Residential',21000)," +
//                            "(45,'Ulsoor Bazaar Street','Bengaluru','Karnataka','India',560008,1.5,10,true,true,'Medium','Commercial',22000)," +
//                            "(46,'Ulsoor Lake Road','Bengaluru','Karnataka','India',560008,2.5,12,true,true,'Medium','Recreational',16000)," +
//                            "(47,'Whitefield Main Road','Bengaluru','Karnataka','India',560066,12.0,26,true,true,'High','Mixed',27000)," +
//                            "(48,'ITPL Road','Bengaluru','Karnataka','India',560066,8.0,24,true,true,'High','Commercial',26000)," +
//                            "(49,'Varthur Main Road','Bengaluru','Karnataka','India',560087,10.0,22,true,true,'High','Mixed',25000)," +
//                            "(50,'KR Puram Tin Factory Road','Bengaluru','Karnataka','India',560036,3.8,18,true,true,'High','Commercial',24000)," +
//                            "(51,'Ramamurthy Nagar Road','Bengaluru','Karnataka','India',560016,5.0,16,true,true,'Medium','Residential',21000)," +
//                            "(52,'Banaswadi Main Road','Bengaluru','Karnataka','India',560043,3.2,14,true,true,'High','Mixed',22000)," +
//                            "(53,'Horamavu Main Road','Bengaluru','Karnataka','India',560043,4.0,16,true,true,'Medium','Residential',20000)," +
//                            "(54,'Kammanahalli Main Road','Bengaluru','Karnataka','India',560084,2.8,14,true,true,'High','Commercial',24000)," +
//                            "(55,'Hennur Main Road','Bengaluru','Karnataka','India',560043,5.5,16,true,true,'Medium','Residential',20000)," +
//                            "(56,'Thanisandra Main Road','Bengaluru','Karnataka','India',560077,7.0,20,true,true,'High','Residential',23000)," +
//                            "(57,'Nagawara Main Road','Bengaluru','Karnataka','India',560045,3.5,18,true,true,'High','Mixed',22000)," +
//                            "(58,'Bagalur Main Road','Bengaluru','Karnataka','India',560063,9.0,24,true,true,'Medium','Mixed',19000)," +
//                            "(59,'Jakkur Main Road','Bengaluru','Karnataka','India',560064,4.0,16,true,true,'Medium','Residential',18000)," +
//                            "(60,'Sahakar Nagar Main Road','Bengaluru','Karnataka','India',560092,3.0,16,true,true,'Medium','Residential',20000)," +
//                            "(61,'Kodigehalli Main Road','Bengaluru','Karnataka','India',560092,2.8,14,true,true,'Medium','Residential',17000)," +
//                            "(62,'New BEL Road','Bengaluru','Karnataka','India',560054,3.5,18,true,true,'High','Commercial',26000)," +
//                            "(63,'Mathikere Main Road','Bengaluru','Karnataka','India',560054,3.0,16,true,true,'Medium','Residential',20000)," +
//                            "(64,'Gorguntepalya Main Road','Bengaluru','Karnataka','India',560022,2.5,16,true,true,'Medium','Industrial',22000)," +
//                            "(65,'Tumkur Road','Bengaluru','Karnataka','India',560073,25.0,32,true,true,'High','Highway',27000)," +
//                            "(66,'Kengeri Main Road','Bengaluru','Karnataka','India',560060,8.0,20,true,true,'Medium','Residential',18000)," +
//                            "(67,'Mysore Road','Bengaluru','Karnataka','India',560026,18.0,28,true,true,'High','Highway',26000)," +
//                            "(68,'Vijayanagar Chord Road','Bengaluru','Karnataka','India',560040,4.0,20,true,true,'High','Mixed',24000)," +
//                            "(69,'Attiguppe Main Road','Bengaluru','Karnataka','India',560040,2.1,14,true,true,'Medium','Residential',18000)," +
//                            "(70,'Banashankari Ring Road','Bengaluru','Karnataka','India',560050,6.0,20,true,true,'Medium','Mixed',19000)," +
//                            "(71,'Banashankari 2nd Stage Road','Bengaluru','Karnataka','India',560070,2.4,14,true,true,'Medium','Residential',18500)," +
//                            "(72,'Banashankari 3rd Stage Main Road','Bengaluru','Karnataka','India',560085,3.1,16,true,true,'Medium','Residential',19500)," +
//                            "(73,'Kathriguppe Main Road','Bengaluru','Karnataka','India',560070,2.0,12,true,true,'High','Commercial',24000)," +
//                            "(74,'Uttarahalli Main Road','Bengaluru','Karnataka','India',560061,5.0,18,true,true,'Medium','Residential',20000)," +
//                            "(75,'Subramanyapura Main Road','Bengaluru','Karnataka','India',560061,4.0,16,true,true,'Medium','Residential',19000)";
//            ;

//            String sql2 = "INSERT INTO sports1 VALUES (1,'Cricket',11,'England','Outdoor','Bat & Ball',false,true,1,true)," +
//                            "(2,'Football',11,'England','Outdoor','Football',false,true,2,true)," +
//                            "(3,'Hockey',11,'India','Outdoor','Stick & Ball',false,true,6,true)," +
//                            "(4,'Basketball',5,'USA','Indoor','Basketball',true,true,4,true)," +
//                            "(5,'Volleyball',6,'USA','Outdoor','Volleyball',true,true,5,true)," +
//                            "(6,'Badminton',2,'India','Indoor','Racquet',true,false,3,true)," +
//                            "(7,'Tennis',2,'France','Outdoor','Racquet',false,true,7,true)," +
//                            "(8,'Table Tennis',2,'England','Indoor','Table & Bat',true,false,9,true)," +
//                            "(9,'Kabaddi',7,'India','Outdoor','None',false,true,8,true)," +
//                            "(10,'Kho Kho',9,'India','Outdoor','None',false,true,11,false)," +
//                            "(11,'Baseball',9,'USA','Outdoor','Bat & Ball',false,true,12,true)," +
//                            "(12,'Rugby',15,'England','Outdoor','Ball',false,true,10,true)," +
//                            "(13,'Swimming',1,'Global','Indoor','Pool',true,false,13,true)," +
//                            "(14,'Athletics',1,'Greece','Outdoor','Track',false,true,14,true)," +
//                            "(15,'Boxing',1,'USA','Indoor','Gloves',true,false,15,true)," +
//                            "(16,'Wrestling',2,'Greece','Indoor','Mat',true,false,16,true)," +
//                            "(17,'Judo',1,'Japan','Indoor','Gi Uniform',true,false,17,true)," +
//                            "(18,'Karate',1,'Japan','Indoor','Gi Uniform',true,false,18,false)," +
//                            "(19,'Taekwondo',1,'Korea','Indoor','Protective Gear',true,false,19,true)," +
//                            "(20,'Cycling',1,'France','Outdoor','Bicycle',false,true,20,true)," +
//                            "(21,'Golf',1,'Scotland','Outdoor','Golf Clubs',false,true,21,true)," +
//                            "(22,'Shooting',1,'USA','Indoor','Gun',true,false,22,true)," +
//                            "(23,'Archery',1,'Mongolia','Outdoor','Bow & Arrow',false,true,23,true)," +
//                            "(24,'Fencing',1,'Spain','Indoor','Sword',true,false,24,true)," +
//                            "(25,'Skating',1,'Netherlands','Indoor','Skates',true,false,25,true)," +
//                            "(26,'Gymnastics',1,'Greece','Indoor','Equipment',true,false,26,true)," +
//                            "(27,'Weightlifting',1,'Europe','Indoor','Weights',true,false,27,true)," +
//                            "(28,'Powerlifting',1,'USA','Indoor','Weights',true,false,28,false)," +
//                            "(29,'Snooker',2,'India','Indoor','Cue Stick',true,false,29,false)," +
//                            "(30,'Carrom',2,'India','Indoor','Striker & Coins',true,false,30,false)," +
//                            "(31,'Chess',2,'India','Indoor','Chess Board',true,false,31,true)," +
//                            "(32,'Polo',4,'Iran','Outdoor','Horse & Mallet',false,true,32,true)," +
//                            "(33,'Surfing',1,'Hawaii','Outdoor','Surf Board',false,true,33,true)," +
//                            "(34,'Skateboarding',1,'USA','Outdoor','Skateboard',false,true,34,true)," +
//                            "(35,'Ice Hockey',6,'Canada','Indoor','Stick & Skates',true,false,35,true)," +
//                            "(36,'Skiing',1,'Norway','Outdoor','Skis',false,true,36,true)," +
//                            "(37,'Snowboarding',1,'USA','Outdoor','Snowboard',false,true,37,true)," +
//                            "(38,'Rowing',8,'Egypt','Outdoor','Row Boat',false,true,38,true)," +
//                            "(39,'Canoeing',1,'Canada','Outdoor','Canoe',false,true,39,true)," +
//                            "(40,'Kayaking',1,'Germany','Outdoor','Kayak',false,true,40,true)," +
//                            "(41,'Diving',1,'Greece','Indoor','Pool',true,false,41,true)," +
//                            "(42,'Water Polo',7,'USA','Indoor','Ball',true,false,42,true)," +
//                            "(43,'Handball',7,'Germany','Indoor','Ball',true,false,43,true)," +
//                            "(44,'Racquetball',2,'USA','Indoor','Racquet',true,false,44,false)," +
//                            "(45,'Squash',2,'England','Indoor','Racquet',true,false,45,true)," +
//                            "(46,'Field Archery',1,'Asia','Outdoor','Bow & Arrow',false,true,46,false)," +
//                            "(47,'Kickboxing',1,'Thailand','Indoor','Gloves',true,false,47,false)," +
//                            "(48,'Muay Thai',1,'Thailand','Indoor','Gear',true,false,48,false)," +
//                            "(49,'Mixed Martial Arts',2,'USA','Indoor','Protective Gear',true,false,49,false)," +
//                            "(50,'Formula Racing',1,'Germany','Outdoor','Race Car',false,true,50,true)," +
//                            "(51,'Motocross',1,'USA','Outdoor','Bike',false,true,51,false)," +
//                            "(52,'E-Sports',1,'Korea','Indoor','Computer',true,false,52,false)," +
//                            "(53,'Para Athletics',1,'Global','Outdoor','Equipment',false,true,53,true)," +
//                            "(54,'Para Swimming',1,'Global','Indoor','Equipment',true,false,54,true)," +
//                            "(55,'Beach Volleyball',2,'USA','Outdoor','Volleyball',false,true,55,true)," +
//                            "(56,'Beach Soccer',5,'Brazil','Outdoor','Football',false,true,56,false)," +
//                            "(57,'Softball',9,'USA','Outdoor','Bat & Ball',false,true,57,true)," +
//                            "(58,'Bowling',1,'USA','Indoor','Balls & Pins',true,false,58,false)," +
//                            "(59,'Billiards',2,'India','Indoor','Cue Stick',true,false,59,false)," +
//                            "(60,'Roller Hockey',5,'USA','Indoor','Skates',true,false,60,false)," +
//                            "(61,'Drone Racing',1,'USA','Indoor','Drone',true,false,61,false)," +
//                            "(62,'Parkour',1,'France','Outdoor','None',false,true,62,false)," +
//                            "(63,'Yoga Sports',1,'India','Indoor','Mat',true,false,63,false)," +
//                            "(64,'Mallakhamba',1,'India','Indoor','Pole',true,false,64,false)," +
//                            "(65,'Silambam',1,'India','Outdoor','Stick',false,true,65,false)," +
//                            "(66,'Kalaripayattu',1,'India','Outdoor','Weapons',false,true,66,false)," +
//                            "(67,'Lawn Tennis',2,'UK','Outdoor','Racquet',false,true,67,true)," +
//                            "(68,'Cricket T10',11,'Global','Outdoor','Bat & Ball',false,true,68,false)," +
//                            "(69,'Cricket T20',11,'Global','Outdoor','Bat & Ball',false,true,69,false)," +
//                            "(70,'Hand Cricket',2,'India','Indoor','None',true,false,70,false)," +
//                            "(71,'Street Football',5,'Brazil','Outdoor','Football',false,true,71,false)," +
//                            "(72,'Street Basketball',3,'USA','Outdoor','Basketball',false,true,72,false)," +
//                            "(73,'Ultimate Frisbee',7,'USA','Outdoor','Frisbee',false,true,73,false)," +
//                            "(74,'Dodgeball',6,'USA','Indoor','Balls',true,false,74,false)," +
//                            "(75,'Four Square',4,'USA','Outdoor','Ball',false,true,75,false)";
//

//            String sql3 = "INSERT INTO president VALUES (1,'Narendra Modi',72,'India','BJP',2014,2024,'Jashodaben',0,'Gujarat','MA Political Science','Best CM Award','Chief Minister',280000000,78,true)," +
//                            "(2,'Rahul Gandhi',53,'India','INC',NULL,NULL,'Unmarried',0,'New Delhi','MPhil Cambridge','Youth Icon Award','MP',150000000,55,true)," +
//                            "(3,'Amit Shah',59,'India','BJP',2019,2024,'Sonal Shah',1,'Gujarat','B.Sc','Best Parliamentarian','Home Minister',300000000,74,true)," +
//                            "(4,'Arvind Kejriwal',55,'India','AAP',2015,2025,'Sunita Kejriwal',2,'Haryana','IIT Kharagpur','Ramon Magsaysay Award','IRS Officer',50000000,70,true)," +
//                            "(5,'Sonia Gandhi',77,'India','INC',1998,2022,'Rajiv Gandhi',2,'Italy','Languages Diploma','Best Political Leader','INC President',250000000,58,true)," +
//                            "(6,'Yogi Adityanath',51,'India','BJP',2017,2027,'Unmarried',0,'Uttarakhand','BA Mathematics','Best CM Award','MP',85000000,75,true)," +
//                            "(7,'Mamata Banerjee',69,'India','TMC',2011,2026,'Unmarried',0,'West Bengal','BA History','Best Leader Award','Railway Minister',60000000,60,true)," +
//                            "(8,'Pinarayi Vijayan',78,'India','CPM',2016,2026,'Kamala Vijayan',2,'Kerala','BA Economics','Kerala Ratna','Politburo Member',20000000,72,true)," +
//                            "(9,'MK Stalin',71,'India','DMK',2021,2026,'Durga Stalin',2,'Chennai','BA Political Science','Kalaimamani','Deputy CM',90000000,68,true)," +
//                            "(10,'Nitish Kumar',73,'India','JDU',2005,2025,'Manju Kumari',1,'Bihar','B.Sc','Best CM Award','Railway Minister',70000000,62,true)," +
//                            "(11,'Uddhav Thackeray',62,'India','Shiv Sena',2019,2022,'Rashmi Thackeray',2,'Mumbai','College Dropout','Photography Award','Party President',150000000,57,true)," +
//                            "(12,'Sharad Pawar',83,'India','NCP',1999,2020,'Pratibha Pawar',1,'Maharashtra','BA Law','Padma Vibhushan','Defense Minister',350000000,64,true)," +
//                            "(13,'Devendra Fadnavis',53,'India','BJP',2014,2019,'Amruta Fadnavis',1,'Nagpur','LLB','Best CM Award','Mayor',120000000,61,true)," +
//                            "(14,'K Chandrashekar Rao',70,'India','BRS',2014,2023,'Shobha Rao',2,'Telangana','BA','State Formation Award','Union Minister',180000000,66,true)," +
//                            "(15,'Jagan Mohan Reddy',51,'India','YSRCP',2019,2024,'Bharathi Reddy',2,'Andhra Pradesh','MBA','Business Excellence Award','MP',3700000000,63,true)," +
//                            "(16,'Chandrababu Naidu',74,'India','TDP',1995,2019,'Bhuvaneshwari',1,'Andhra Pradesh','MBA','IT Visionary Award','CM',2000000000,65,true)," +
//                            "(17,'Basavaraj Bommai',63,'India','BJP',2021,2023,'Chennamma Bommai',2,'Karnataka','B.Tech Engineering','Best Legislator','Home Minister',90000000,59,true)," +
//                            "(18,'Siddaramaiah',75,'India','INC',2013,2018,'Parvathi',2,'Karnataka','LLB','Best CM Award','Deputy CM',70000000,70,true)," +
//                            "(19,'HD Kumaraswamy',64,'India','JDS',2006,2019,'Anita Kumaraswamy',1,'Karnataka','PUC','Film Producer Award','CM',450000000,55,true)," +
//                            "(20,'DK Shivakumar',62,'India','INC',1999,2024,'Usha Shivakumar',2,'Karnataka','PUC','Political Excellence Award','Karnataka Minister',800000000,67,true)," +
//
//                            "(21,'Kamala Harris',58,'USA','Democratic',2021,2025,'Doug Emhoff',2,'California','Juris Doctor','Role Model Award','Senator',100000000,60,true)," +
//                            "(22,'Joe Biden',81,'USA','Democratic',2021,2025,'Jill Biden',4,'Pennsylvania','JD Law','Medal of Freedom','Vice President',900000000,55,true)," +
//                            "(23,'Donald Trump',78,'USA','Republican',2017,2021,'Melania Trump',5,'New York','B.Sc Economics','Business Awards','Businessman',3100000000,45,false)," +
//                            "(24,'Barack Obama',63,'USA','Democratic',2008,2016,'Michelle Obama',2,'Hawaii','Harvard Law','Nobel Peace Prize','Senator',700000000,68,false)," +
//                            "(25,'Bernie Sanders',82,'USA','Independent',NULL,NULL,'Jane O’Meara',1,'New York','BA Political Science','Leadership Award','Senator',30000000,60,true)," +
//
//                            "(26,'Rishi Sunak',44,'UK','Conservative',2022,2024,'Akshata Murthy',2,'Southampton','MBA Stanford','Finance Leader Award','Chancellor',850000000,58,true)," +
//                            "(27,'Boris Johnson',60,'UK','Conservative',2019,2022,'Carrie Johnson',2,'New York','Oxford','Journalism Award','Mayor of London',350000000,52,false)," +
//                            "(28,'Keir Starmer',62,'UK','Labour',2024,2028,'Victoria Starmer',2,'London','Law Degree','Legal Excellence','Barrister',40000000,65,true)," +
//
//                            "(29,'Justin Trudeau',53,'Canada','Liberal',2015,2025,'Sophie Trudeau',3,'Ottawa','BA Literature','Best Leader Award','Teacher',12000000,56,true)," +
//                            "(30,'Pierre Poilievre',45,'Canada','Conservative',NULL,NULL,'Anaida Poilievre',2,'Calgary','BA International Relations','Oratory Award','MP',15000000,55,true)," +
//
//                            "(31,'Emmanuel Macron',46,'France','LREM',2017,2027,'Brigitte Macron',0,'Amiens','Masters in Philosophy','Leadership Award','Economy Minister',80000000,62,true)," +
//                            "(32,'Marine Le Pen',56,'France','National Rally',NULL,NULL,'Unmarried',2,'Neuilly-sur-Seine','Law Degree','Political Impact Award','MP',60000000,50,true)," +
//
//                            "(33,'Olaf Scholz',66,'Germany','SPD',2021,2025,'Britta Ernst',0,'Osnabrück','Law Degree','Finance Excellence','Vice Chancellor',30000000,58,true)," +
//                            "(34,'Angela Merkel',70,'Germany','CDU',2005,2021,'Joachim Sauer',0,'Hamburg','Quantum Chemistry PhD','Global Leadership Award','Scientist',20000000,80,false)," +
//
//                            "(35,'Vladimir Putin',71,'Russia','Independent',2000,2024,'Lyudmila',2,'Leningrad','Law Degree','Military Award','KGB Officer',80000000000,55,true)," +
//                            "(36,'Volodymyr Zelenskyy',46,'Ukraine','Servant of the People',2019,2024,'Olena Zelenska',2,'Kryvyi Rih','Law Degree','Courage Award','Actor',100000000,85,true)," +
//
//                            "(37,'Xi Jinping',71,'China','CPC',2013,2030,'Peng Liyuan',1,'Beijing','Chemical Engineering','Leadership Award','Governor',1500000000,90,true)," +
//                            "(38,'Li Qiang',65,'China','CPC',2023,2028,'Unmarried',0,'Zhejiang','Economics','Civil Service Award','Premier',500000000,70,true)," +
//
//                            "(39,'Fumio Kishida',67,'Japan','LDP',2021,2025,'Yuko Kishida',3,'Hiroshima','Law Degree','Diplomacy Award','Foreign Minister',20000000,53,true)," +
//                            "(40,'Shinzo Abe',67,'Japan','LDP',2012,2020,'Akie Abe',0,'Tokyo','Political Science','Leadership Award','PM',50000000,72,false)," +
//
//                            "(41,'Anthony Albanese',61,'Australia','Labor',2022,2026,'Jodie Haydon',1,'Sydney','Economics','Social Reform Award','Deputy PM',10000000,54,true)," +
//                            "(42,'Scott Morrison',56,'Australia','Liberal',2018,2022,'Jenny Morrison',2,'Sydney','Economic Geography','Tourism Award','Treasurer',15000000,48,false)," +
//
//                            "(43,'Lionel Zinsou',70,'Benin','FCBE',2015,2016,'Nathalie Zinsou',2,'Paris','Economics','Public Service Award','Prime Minister',2000000,45,false)," +
//                            "(44,'Macky Sall',62,'Senegal','APR',2012,2024,'Marieme Sall',3,'Fatick','Geology','National Medal','Prime Minister',3000000,58,true)," +
//
//                            "(45,'Imran Khan',72,'Pakistan','PTI',2018,2022,'Bushra Bibi',3,'Lahore','Politics & Economics','Cricket Awards','Cricketer',500000000,50,false)," +
//                            "(46,'Shehbaz Sharif',73,'Pakistan','PML-N',2022,2024,'Nusrat Shehbaz',4,'Lahore','LLB','Civil Service Award','Chief Minister',200000000,48,true)," +
//
//                            "(47,'Bangladesh Sheikh Hasina',76,'Bangladesh','AL',2009,2024,'M A Wazed',2,'Tungipara','Economics','Peace Award','Opposition Leader',4000000,70,true)," +
//                            "(48,'Khaleda Zia',78,'Bangladesh','BNP',1991,2001,'Ziaur Rahman',2,'Dinajpur','Intermediate','Democracy Award','PM',3000000,42,false)," +
//
//                            "(49,'Sri Lanka Ranil Wickremesinghe',75,'Sri Lanka','UNP',2022,2027,'Maithree Wickramasinghe',0,'Colombo','BA Law','Governance Award','PM',5000000,55,true)," +
//                            "(50,'Mahinda Rajapaksa',79,'Sri Lanka','SLPP',2005,2015,'Shiranthi Rajapaksa',3,'Hambantota','Law Degree','National Award','President',10000000,45,false)," +
//
//                            "(51,'Nepal Pushpa Dahal',69,'Nepal','Maoist',2022,2024,'Sita Dahal',3,'Kaski','Philosophy','Revolution Award','PM',2000000,50,true)," +
//                            "(52,'KP Oli',72,'Nepal','UML',2015,2021,'Radhika Shakya',0,'Jhapa','BA','Leadership Award','PM',10000000,48,true)," +
//
//                            "(53,'Bhutan Lotay Tshering',55,'Bhutan','DNT',2018,2023,'Unmarried',0,'Haa','MBBS','Health Service Award','Doctor',500000,70,true)," +
//                            "(54,'Tshering Tobgay',59,'Bhutan','PDP',2013,2018,'Aum Kunzang',2,'Haa','Mechanical Engineering','Governance Award','PM',800000,60,true)," +
//
//                            "(55,'Maldives Ibrahim Solih',62,'Maldives','MDP',2018,2023,'Fazna Solih',2,'Hithadhoo','Islamic Studies','Peace Award','Opposition MP',700000,55,true)," +
//                            "(56,'Mohamed Nasheed',57,'Maldives','MDP',2008,2012,'Laila Ali',1,'Male','BA English','Democracy Award','MP',500000,60,true)," +
//
//                            "(57,'Israel Benjamin Netanyahu',75,'Israel','Likud',2009,2024,'Sara Netanyahu',3,'Tel Aviv','Business','Security Award','Finance Minister',150000000,58,true)," +
//                            "(58,'Yair Lapid',61,'Israel','Yesh Atid',2022,2023,'Lihi Lapid',2,'Tel Aviv','Media Studies','Journalism Award','Journalist',9000000,62,true)," +
//
//                            "(59,'Saudi Arabia Mohammed bin Salman',39,'Saudi Arabia','Independent',2017,2035,'Princess Sara',2,'Riyadh','Law','Royal Award','Defense Minister',50000000000,75,true)," +
//                            "(60,'UAE Mohammed bin Zayed',63,'UAE','Independent',2022,2030,'Salama bint Hamdan',5,'Abu Dhabi','Military','Leadership Medal','Crown Prince',70000000000,78,true)," +
//
//                            "(61,'Egypt Abdel Fattah el-Sisi',69,'Egypt','Independent',2014,2024,'Entissar Amer',3,'Cairo','Military Academy','National Medal','Defense Minister',1000000000,50,true)," +
//                            "(62,'Turkey Recep Tayyip Erdoğan',70,'Turkey','AKP',2014,2028,'Emine Erdogan',4,'Istanbul','Business','Leadership Award','PM',500000000,55,true)," +
//
//                            "(63,'Brazil Lula da Silva',79,'Brazil','PT',2023,2027,'Rosangela Silva',1,'Pernambuco','Sociology','Freedom Award','Union Leader',5000000,65,true)," +
//                            "(64,'Bolsonaro Jair',69,'Brazil','PL',2019,2022,'Michelle Bolsonaro',5,'Sao Paulo','Army Training','Patriot Award','Army Captain',4000000,40,false)," +
//
//                            "(65,'Argentina Javier Milei',54,'Argentina','LLA',2023,2027,'Unmarried',0,'Buenos Aires','Economics','Debate Award','Economist',2500000,52,true)," +
//                            "(66,'Chile Gabriel Boric',38,'Chile','Social Left',2022,2026,'Irina Karamanos',0,'Punta Arenas','Anthropology','Youth Award','Student Leader',2000000,55,true)," +
//
//                            "(67,'Mexico AMLO',71,'Mexico','Morena',2018,2024,'Beatriz Muller',4,'Tabasco','Political Science','People’s Leader Award','Mayor',400000,68,true)," +
//                            "(68,'Peru Dina Boluarte',61,'Peru','Independent',2022,2024,'Unmarried',1,'Apurimac','Law Degree','Women Leadership Award','Minister',800000,45,true)," +
//
//                            "(69,'South Africa Cyril Ramaphosa',71,'South Africa','ANC',2018,2029,'Tshepo Motsepe',4,'Johannesburg','Law','Peace Award','Businessman',4500000,58,true)," +
//                            "(70,'Nigeria Bola Tinubu',72,'Nigeria','APC',2023,2027,'Oluremi Tinubu',3,'Lagos','Business','Political Achievement','Governor',5000000,40,true)," +
//
//                            "(71,'Kenya William Ruto',58,'Kenya','UDA',2022,2027,'Rachel Ruto',6,'Uasin Gishu','Botany','Best Leader Award','Deputy President',2000000,55,true)," +
//                            "(72,'Ethiopia Abiy Ahmed',48,'Ethiopia','Prosperity',2018,2027,'Zinash Tayachew',4,'Beshasha','MBA','Nobel Peace Prize','Intel Officer',300000,70,true)," +
//                            "(73,'New Zealand Chris Hipkins',46,'New Zealand','Labour',2023,2027,'Jana Hipkins',2,'Wellington','Political Science','Education Award','Minister',1000000,62,true)," +
//                            "(74,'Jacinda Ardern',44,'New Zealand','Labour',2017,2023,'Clarke Gayford',1,'Hamilton','Communications','UN Award','MP',1500000,85,false)," +
//                            "(75,'Fiji Sitiveni Rabuka',76,'Fiji','PAP',2022,2026,'Sulueti Rabuka',3,'Cakaudrove','Military','Peace Medal','Army Commander',500000,48,true)";


//            String sql4 = "INSERT INTO hospital VALUES (1,'Apollo Hospital','Bengaluru','Multi-Specialty',500,200,400,20,1983,4.8)," +
//                            "(2,'Fortis Hospital','Bengaluru','Multi-Specialty',450,180,350,18,2001,4.7)," +
//                            "(3,'Manipal Hospital','Bengaluru','Multi-Specialty',600,220,420,22,1991,4.6)," +
//                            "(4,'Narayana Hrudayalaya','Bengaluru','Cardiac',800,250,500,25,2000,4.9)," +
//                            "(5,'Columbia Asia','Bengaluru','General',300,120,200,12,2004,4.3)," +
//                            "(6,'Aster CMI','Bengaluru','Multi-Specialty',550,210,350,15,2010,4.5)," +
//                            "(7,'Sakra Hospital','Bengaluru','Multi-Specialty',400,160,260,14,2013,4.4)," +
//                            "(8,'Bowring Hospital','Bengaluru','Government',700,300,600,30,1868,4.1)," +
//                            "(9,'Victoria Hospital','Bengaluru','Government',900,350,800,25,1900,4.0)," +
//                            "(10,'St. John''s Hospital','Bengaluru','Teaching',750,280,500,20,1968,4.5)," +
//                            "(11,'Rainbow Children''s Hospital','Bengaluru','Children',250,100,180,10,2005,4.6)," +
//                            "(12,'Cloudnine Hospital','Bengaluru','Maternity',200,80,150,6,2007,4.7)," +
//                            "(13,'Sparsh Hospital','Bengaluru','Orthopedic',300,120,170,8,2006,4.5)," +
//                            "(14,'Ramaiah Hospital','Bengaluru','Teaching',650,220,480,16,1985,4.2)," +
//                            "(15,'KIMS Hospital','Bengaluru','General',550,200,350,15,2000,4.3)," +
//                            "(16,'ESI Hospital','Bengaluru','Government',1000,400,900,20,1975,3.9)," +
//                            "(17,'Jayadeva Hospital','Bengaluru','Cardiac',900,300,700,15,1973,4.8)," +
//                            "(18,'NIMHANS','Bengaluru','Neuro',800,320,600,12,1974,4.9)," +
//                            "(19,'Kidwai Oncology','Bengaluru','Cancer',850,330,500,14,1973,4.7)," +
//                            "(20,'HBS Hospital','Bengaluru','General',240,90,140,7,2009,4.1)," +
//                            "(21,'Apollo Hospital','Chennai','Multi-Specialty',600,250,500,18,1985,4.6)," +
//                            "(22,'MIOT International','Chennai','Multi-Specialty',650,280,520,20,1999,4.5)," +
//                            "(23,'Global Hospital','Chennai','Transplant',550,210,400,15,1996,4.7)," +
//                            "(24,'Stanley Hospital','Chennai','Government',1000,420,900,30,1799,4.0)," +
//                            "(25,'Rajiv Gandhi Hospital','Chennai','Government',1200,500,1000,32,1954,4.1)," +
//                            "(26,'Fortis Malar','Chennai','Cardiac',450,170,230,10,1992,4.3)," +
//                            "(27,'Sankara Nethralaya','Chennai','Eye',300,100,150,5,1978,4.9)," +
//                            "(28,'Vijaya Hospital','Chennai','General',350,140,210,10,1972,4.4)," +
//                            "(29,'SRM Hospital','Chennai','Teaching',800,300,600,18,1995,4.2)," +
//                            "(30,'Chettinad Hospital','Chennai','Teaching',750,280,500,15,2005,4.3)," +
//                            "(31,'AIIMS Delhi','Delhi','Government',2000,900,1600,50,1956,4.9)," +
//                            "(32,'Safdarjung Hospital','Delhi','Government',1800,750,1500,40,1942,4.2)," +
//                            "(33,'Max Hospital','Delhi','Multi-Specialty',700,250,420,18,2006,4.5)," +
//                            "(34,'BLK Hospital','Delhi','Multi-Specialty',600,220,360,14,1959,4.4)," +
//                            "(35,'Sir Ganga Ram Hospital','Delhi','General',800,300,480,16,1954,4.6)," +
//                            "(36,'Apollo Hospital','Delhi','Multi-Specialty',750,240,450,15,1995,4.5)," +
//                            "(37,'Fortis Shalimar Bagh','Delhi','Multi-Specialty',650,230,350,12,2010,4.4)," +
//                            "(38,'Holy Family Hospital','Delhi','General',400,150,250,10,1953,4.3)," +
//                            "(39,'LHMC Hospital','Delhi','Teaching',1200,450,900,25,1916,4.1)," +
//                            "(40,'Kailash Hospital','Delhi','General',350,120,180,8,1982,4.0)," +
//                            "(41,'Ruby Hall Clinic','Pune','Multi-Specialty',600,240,420,14,1959,4.4)," +
//                            "(42,'Jehangir Hospital','Pune','General',500,200,350,12,1946,4.3)," +
//                            "(43,'Sahyadri Hospital','Pune','Multi-Specialty',650,230,400,10,2004,4.5)," +
//                            "(44,'Deenanath Mangeshkar Hospital','Pune','Teaching',800,280,500,18,2001,4.6)," +
//                            "(45,'Noble Hospital','Pune','General',450,150,280,10,2007,4.2)," +
//                            "(46,'Aditya Birla Hospital','Pune','Multi-Specialty',700,260,410,15,2006,4.5)," +
//                            "(47,'Inamdar Hospital','Pune','General',350,130,200,8,2004,4.1)," +
//                            "(48,'Yashwantrao Chavan Hospital','Pune','Government',1200,500,1000,30,1980,3.9)," +
//                            "(49,'Sancheti Hospital','Pune','Orthopedic',300,100,150,5,1965,4.8)," +
//                            "(50,'AV Hospital','Pune','General',200,90,120,6,2012,4.0)," +
//                            "(51,'Kokilaben Hospital','Mumbai','Multi-Specialty',850,300,500,20,2010,4.7)," +
//                            "(52,'Lilavati Hospital','Mumbai','Multi-Specialty',650,250,400,15,1978,4.6)," +
//                            "(53,'Tata Memorial Hospital','Mumbai','Cancer',950,350,800,22,1941,4.9)," +
//                            "(54,'Hinduja Hospital','Mumbai','General',700,270,420,14,1951,4.6)," +
//                            "(55,'Breach Candy Hospital','Mumbai','Specialty',400,120,200,10,1950,4.5)," +
//                            "(56,'SevenHills Hospital','Mumbai','Multi-Specialty',1300,500,900,28,2010,4.4)," +
//                            "(57,'Nanavati Hospital','Mumbai','General',750,280,450,18,1950,4.5)," +
//                            "(58,'Sion Hospital','Mumbai','Government',1800,650,1200,40,1926,4.0)," +
//                            "(59,'KEM Hospital','Mumbai','Government',2000,850,1600,45,1926,4.2)," +
//                            "(60,'JJ Hospital','Mumbai','Government',2200,900,1700,50,1845,4.1)," +
//                            "(61,'Care Hospital','Hyderabad','Multi-Specialty',650,260,420,18,1997,4.5)," +
//                            "(62,'Yashoda Hospital','Hyderabad','General',800,300,500,20,1989,4.6)," +
//                            "(63,'AIG Hospital','Hyderabad','Gastro',600,220,400,12,2019,4.8)," +
//                            "(64,'KIMS Hospital','Hyderabad','Multi-Specialty',900,350,600,22,2004,4.6)," +
//                            "(65,'Osmania Hospital','Hyderabad','Government',1500,600,1000,30,1846,4.0)," +
//                            "(66,'Gandhi Hospital','Hyderabad','Government',1800,700,1300,35,1851,4.1)," +
//                            "(67,'Himagiri Hospital','Hyderabad','General',300,120,180,8,2003,4.2)," +
//                            "(68,'Lotus Hospital','Hyderabad','Children',250,100,150,6,2004,4.5)," +
//                            "(69,'Sunshine Hospital','Hyderabad','Ortho',500,200,300,12,2009,4.6)," +
//                            "(70,'Rainbow Hospital','Hyderabad','Children',350,140,200,10,2007,4.7)," +
//                            "(71,'Amrita Hospital','Kochi','Multi-Specialty',1300,500,900,25,1998,4.8)," +
//                            "(72,'Aster Medcity','Kochi','Multi-Specialty',800,320,500,18,2014,4.7)," +
//                            "(73,'KIMS Kerala','Kochi','General',600,240,380,14,2003,4.4)," +
//                            "(74,'Medical Trust Hospital','Kochi','General',700,260,420,16,1973,4.3)," +
//                            "(75,'Lakeshore Hospital','Kochi','Multi-Specialty',850,330,500,20,2003,4.6)";



            //int rowsAffectedForSweets = statement.executeUpdate(sql);
           // System.out.println("Number of rows affected " + rowsAffectedForSweets);

//            String s1 =  "update sweet set price = 10000 where id=1 ";
//            int r1 = statement.executeUpdate(s1);
//            System.out.println(" row affected " + r1);
//
//            String s2 =  "UPDATE sweet SET flavor = 'Rose' WHERE id = 2";
//            int r2 = statement.executeUpdate(s2);
//            System.out.println("Updated rows = " + r2);
//
//            String s3 =  "UPDATE sweet SET brand = 'Haldirams Premium' WHERE id = 3";
//            int r3 = statement.executeUpdate(s3);
//            System.out.println("Updated rows = " + r3);
//
//            String s4 =  "UPDATE sweet SET name = 'Dry Fruit Laddu', type = 'Ladoo' WHERE id = 4";
//            int r4 = statement.executeUpdate(s4);
//            System.out.println("Updated rows = " + r4);
//
//            String d1 = "delete from sweet where id = 10 ";
//            int d = statement.executeUpdate(d1);
//            System.out.println("Updated row " + d);
//
//            String d2 = "DELETE FROM sweet WHERE flavor = 'Kesar'";
//            int dRows2 = statement.executeUpdate(d2);
//            System.out.println("Deleted = " + dRows2);


            //int rowsAffectedForStreets = statement.executeUpdate(sql1);
            //System.out.println("Number of rows affected " + rowsAffectedForStreets);

            //int rowsAffectedForSports = statement.executeUpdate(sql2);
            //System.out.println("Number of rows affected " + rowsAffectedForSports);

            //int rowsAffectedForPresident = statement.executeUpdate(sql3);
            //System.out.println("Number of rows affected " + rowsAffectedForPresident);

           // int rowsAffectedForHospital = statement.executeUpdate(sql4);
            //System.out.println("Number of rows affected " + rowsAffectedForHospital);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

