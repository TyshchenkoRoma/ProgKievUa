package com.company.prog;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*Есть список поездов, представленный с виде XML. Вывести на экран информацию о тех поездах, которые
        отправляются сегодня с 15:00 до 19:00.
        <?xml version="1.0" encoding="UTF-8"?>
        <trains>
        <train id=“1”>
        <from>Kyiv</from>
        <to>Donetsk</to>
        <date>19.12.2013</date>
        <departure>15:05</departure>
        </train>
        <train id=“2”>
        <from>Lviv</from>
        <to>Donetsk</to>
        <date>19.12.2013</date>
        <departure>19:05</departure>
        </train>
        </trains>
        Написать код для добавления новых поездов в существующий XML.*/
public class Main {

    public static void main(String[] args) throws  Exception {
        Trains trains = new Trains();

        Converter converter = new Converter();
        try {
            File file = new File("/home/roman/ROMA/JAVA/ProgKievUa/HW2/Trains/src/com/company/prog/train.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Trains.class);

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            trains = (Trains) unmarshaller.unmarshal(file);
            addTrains(trains);

            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);


        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(trains);
        System.out.println();
        trains.printTodayTrains(trains);
        saveTrainsToFile(trains);

    }

//    public static Double getDoubleFromDate(Date date) {
//        SimpleDateFormat timeFormat = new SimpleDateFormat("kk");
//        return Double.parseDouble(timeFormat.format(date));
//    }

    private static void addTrains(Trains trains) throws Exception {
        DateConverter dateConverter = new DateConverter();
        TimeConverter timeConverter = new TimeConverter();
        try {
            trains.addTr(new Train(3, timeConverter.unmarshal("15:02"),
                    dateConverter.unmarshal("19.12.2013"), "Kyiv", "Kharkiv"));
            trains.addTr(new Train(4, timeConverter.unmarshal("15:00"),
                    dateConverter.unmarshal("19.12.2013"), "Lviv", "Kyiv"));
            trains.addTr(new Train(5, timeConverter.unmarshal("15:20"),
                    dateConverter.unmarshal("19.12.2013"), "Kyiv", "Kharkiv"));
            trains.addTr(new Train(6, timeConverter.unmarshal("19:20"),
                    dateConverter.unmarshal("19.12.2013"), "Kyiv", "Lviv"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void saveTrainsToFile(Trains trains) {
        try {
            File file = new File("/home/roman/ROMA/JAVA/ProgKievUa/HW2/Trains/src/com/company/prog/trainNew.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Trains.class);
            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(trains, file);
            marshaller.marshal(trains, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
