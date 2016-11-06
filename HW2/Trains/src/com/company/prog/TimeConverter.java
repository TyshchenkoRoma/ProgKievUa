package com.company.prog;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by roman on 31.10.16.
 */
public class TimeConverter extends XmlAdapter<String, Date> {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");

    @Override
    public String marshal(Date v) throws Exception {
        synchronized (dateFormat) {
            return dateFormat.format(v);
        }
    }

    @Override
    public Date unmarshal(String v) throws Exception {
        synchronized (dateFormat) {
            return dateFormat.parse(v);
        }
    }
}
