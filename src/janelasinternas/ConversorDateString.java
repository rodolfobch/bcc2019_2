/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janelasinternas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Laboratorio
 */
public class ConversorDateString 
        extends org.jdesktop.beansbinding.Converter<Date,String>{

    private SimpleDateFormat df;
    public ConversorDateString(){
        df = new SimpleDateFormat("dd/MM/yyyy");
    }
    
    @Override
    public String convertForward(Date s) {
        return df.format(s);
    }

    @Override
    public Date convertReverse(String t) {
        try{
            return df.parse(t);
        }catch(ParseException e){
            return null;
        }
    }
    
}
