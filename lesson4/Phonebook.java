package lesson4;

import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

import lesson4.models.Login;

public class Phonebook {
    Map<Login, ArrayList<String>> db;
    
    public Phonebook()
    {
        db = new HashMap<Login,ArrayList<String>>();
    }

    public void addPhone(Login login, String number)
    {
        if(db.containsKey(login))
        {
            db
             .get(login)
             .add(number);
        }
        else
        {
            db.put(login, new ArrayList<String>(Arrays.asList(number)));
        }
    }

    public void removePhone(Login login, String number)
    {
        var loginPhones = db.getOrDefault(login, new ArrayList<>());
        loginPhones.remove(number);
    }

    public ArrayList<String> getPhonesByLogin(Login login) throws Exception
    {
        if(db.containsKey(login))
        {
           var loginPhones = db.get(login);
          
           if(loginPhones.isEmpty())
                 throw new Exception("Doesn't have phones");
           
           return loginPhones;
        } 
        throw new Exception(String.format("In phones database user %s is absent", login.showInfo()));
    }
}
