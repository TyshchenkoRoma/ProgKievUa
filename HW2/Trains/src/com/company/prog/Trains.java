package com.company.prog;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by roman on 30.10.16.
 */
@XmlRootElement(name = "trains")
public class Trains {
    @XmlElement(name = "train")
    ArrayList<Train> trains = new ArrayList<Train>();

    public void add(Train train) {
        trains.add(train);
    }

    public void printTodayTrains(Trains trains1) throws ParseException {
        SimpleDateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatterTime = new SimpleDateFormat("hh:mm");
        Date dateToday = (Date) formatterDate.parse("2013-12-19");
        Date from = (Date) formatterTime.parse("15:00");
        Date to = (Date) formatterTime.parse("19:00");

        for (Train train : trains) {
            if (train.getData().equals(dateToday) && train.getDeparture().after(from) && train.getDeparture().before(to)) {
                System.out.println(train);
            }
        }
    }

    @Override
    public String toString() {
        return "Trains{" +
                "trains=" + trains +
                '}';
    }
}
