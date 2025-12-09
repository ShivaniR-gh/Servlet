package com.xworkz.coreapp.internet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CoreRunner {

    public static void main(String[] args) {

        System.out.println("main started");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(CoreConfigure.class);

        Internet internet = applicationContext.getBean(Internet.class);
        internet.setInternetId(1);
        internet.setName("Jio");
        System.out.println(internet);

        Tea tea = applicationContext.getBean(Tea.class);
        tea.setId(1);
        tea.setName("Malgudies Tea");
        System.out.println(tea);

        Laptop laptop = applicationContext.getBean(Laptop.class);
        laptop.setId(2);
        laptop.setName("Dell");
        System.out.println(laptop);

        Mobile mobile = applicationContext.getBean(Mobile.class);
        mobile.setId(3);
        mobile.setName("Samsung");
        System.out.println(mobile);

        Speaker speaker = applicationContext.getBean(Speaker.class);
        speaker.setId(4);
        speaker.setName("Boat");
        System.out.println(speaker);

        Book book = applicationContext.getBean(Book.class);
        book.setId(6);
        book.setName("Java");
        System.out.println(book);

        Pen pen = applicationContext.getBean(Pen.class);
        pen.setId(7);
        pen.setName("Cello");
        System.out.println(pen);

        Pencil pencil = applicationContext.getBean(Pencil.class);
        pencil.setId(8);
        pencil.setName("Apsara");
        System.out.println(pencil);

        Keyboard keyboard = applicationContext.getBean(Keyboard.class);
        keyboard.setId(9);
        keyboard.setName("Logitech");
        System.out.println(keyboard);

        Mouse mouse = applicationContext.getBean(Mouse.class);
        mouse.setId(10);
        mouse.setName("HP");
        System.out.println(mouse);

        Charger charger = applicationContext.getBean(Charger.class);
        charger.setId(11);
        charger.setName("Fast Charger");
        System.out.println(charger);

        Bag bag = applicationContext.getBean(Bag.class);
        bag.setId(12);
        bag.setName("Wildcraft");
        System.out.println(bag);

        Bottle bottle = applicationContext.getBean(Bottle.class);
        bottle.setId(13);
        bottle.setName("Milton");
        System.out.println(bottle);

        Table table = applicationContext.getBean(Table.class);
        table.setId(14);
        table.setName("Wooden Table");
        System.out.println(table);

        Chair chair = applicationContext.getBean(Chair.class);
        chair.setId(15);
        chair.setName("Office Chair");
        System.out.println(chair);

        Fan fan = applicationContext.getBean(Fan.class);
        fan.setId(16);
        fan.setName("Usha");
        System.out.println(fan);

        AC ac = applicationContext.getBean(AC.class);
        ac.setId(17);
        ac.setName("LG AC");
        System.out.println(ac);

        TV tv = applicationContext.getBean(TV.class);
        tv.setId(18);
        tv.setName("Sony Bravia");
        System.out.println(tv);

        Refrigerator refrigerator = applicationContext.getBean(Refrigerator.class);
        refrigerator.setId(19);
        refrigerator.setName("Whirlpool");
        System.out.println(refrigerator);

        WashingMachine washingMachine = applicationContext.getBean(WashingMachine.class);
        washingMachine.setId(20);
        washingMachine.setName("Bosch");
        System.out.println(washingMachine);

        Headphone headphone = applicationContext.getBean(Headphone.class);
        headphone.setId(21);
        headphone.setName("JBL");
        System.out.println(headphone);

        Watch watch = applicationContext.getBean(Watch.class);
        watch.setId(22);
        watch.setName("Titan");
        System.out.println(watch);

        Shoes shoes = applicationContext.getBean(Shoes.class);
        shoes.setId(23);
        shoes.setName("Nike");
        System.out.println(shoes);

        Wallet wallet = applicationContext.getBean(Wallet.class);
        wallet.setId(24);
        wallet.setName("Leather Wallet");
        System.out.println(wallet);

        Cycle cycle = applicationContext.getBean(Cycle.class);
        cycle.setId(25);
        cycle.setName("Hero");
        System.out.println(cycle);

        Car car = applicationContext.getBean(Car.class);
        car.setId(26);
        car.setName("Hyundai");
        System.out.println(car);

        Bike bike = applicationContext.getBean(Bike.class);
        bike.setId(27);
        bike.setName("Royal Enfield");
        System.out.println(bike);

        Train train = applicationContext.getBean(Train.class);
        train.setId(28);
        train.setName("Vande Bharat");
        System.out.println(train);

        Bus bus = applicationContext.getBean(Bus.class);
        bus.setId(29);
        bus.setName("KSRTC");
        System.out.println(bus);

        Flight flight = applicationContext.getBean(Flight.class);
        flight.setId(30);
        flight.setName("IndiGo");
        System.out.println(flight);

        Ship ship = applicationContext.getBean(Ship.class);
        ship.setId(31);
        ship.setName("Cargo Ship");
        System.out.println(ship);

        System.out.println("main ended");
    }
}
