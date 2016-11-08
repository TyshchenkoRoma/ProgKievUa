package com.company.prog;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;


/**
 * Created by roman on 30.10.16.
 */
@XmlRootElement(name = "train")
public class Train {

    private int id;
    private String from;
    private String to;
    private Date data;
    private Date departure;

    public Train() {
    }


    public Train(int id, Date data, Date departure, String to, String from) {
        this.id = id;
        this.departure = departure;
        this.data = data;
        this.to = to;
        this.from = from;
    }

   // @XmlAttribute
    public int getId() {
        return id;
    }

    //   @XmlElement
// @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

   // @XmlElement
    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }


    public void setTo(String to) {
        this.to = to;
    }

    @XmlElement
    @XmlJavaTypeAdapter(DateConverter.class)
    public Date getData() {
        return data;
    }


    public void setDate(Date data) {
        this.data = data;
    }
    @XmlElement
    @XmlJavaTypeAdapter(DateConverter.class)
    public Date getDeparture() {
        return departure;
    }

    @XmlElement
    @XmlJavaTypeAdapter(TimeConverter.class)
    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    //   SimpleDateFormat sdfDate = new SimpleDateFormat("dd.MM.yyyy");//dd/MM/yyyy
//    SimpleDateFormat stfDate = new SimpleDateFormat("HH:mm");//dd/MM/yyyy
//    @Override
//    public String toString() {
//        return "["+id+" " + from + ", " + to + ", " + sdfDate.format(data) + ", " + stfDate.format(departure) + "]";
//    }


    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", data=" + data +
                ", time='" + departure + '\'' +
                "}\n";
    }
}
