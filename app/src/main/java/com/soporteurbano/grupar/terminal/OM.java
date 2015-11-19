package com.soporteurbano.grupar.terminal;
import java.util.Map;

public interface OM {

    public Map<String, String> getCustomerByPan(String pan);
    public Map<String, String> getCustomerByDni(String dni);

}
