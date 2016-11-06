package com.company.prog;


import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by roman on 31.10.16.
 */
public class Converter extends XmlAdapter <String, Date> {
  //  private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");



    @Override
    public Date unmarshal(String v) throws Exception {
        return null;
    }

    @Override
    public String marshal(Date v) throws Exception {
        return null;
    }
}
