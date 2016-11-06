package com.company.prog;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException {
        Trains trains = new Trains();

        Converter converter = new Converter();
        try {
            File file = new File("/home/roman/ROMA/JAVA/ProgKievUa/HW2/Trains/src/com/company/prog/train.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Trains.class);

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            trains = (Trains) unmarshaller.unmarshal(file);

            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

//            marshaller.marshal(trains, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }


        System.out.println();
      // for (Train train : trains) {
        //    if (train.getData() == dateToday) {
         //       System.out.println("Ya ya");
           // }
       // }
      //System.out.println(trains);
        trains.printTodayTrains(trains);

      //  System.out.println(getDoubleFromDate(from));


    }
    public static Double getDoubleFromDate (Date date) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("kk");
        return Double.parseDouble(timeFormat.format(date));
    }
}
