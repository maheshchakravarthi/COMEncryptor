package com.encryptor.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GetPropertyUsingJasyptStarter {
 
   /* If you want to use a decrypted property in the project, 
    * 1. Uncomment the below piece of code
    * 2. Add the properties encrypted.property and jasypt.encryptor.password in application.properties file. 
    */  
	
	/*@Value("${encrypted.property}")
    private String property;
 
    public String getProperty() {
        return property;
    }*/
}
