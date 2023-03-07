package lesson4;

import java.util.ArrayList;

import lesson4.models.Login;

/**
 * Program
 */
public class Program {
    static Phonebook phonebook = new Phonebook();
    public static void main(String[] args) throws Exception {
        var login = new Login("Tom");
        phonebook.addPhone(login, "123-45-67");
        phonebook.addPhone(login, "213-54-67");
        phonebook.addPhone(login, "312-45-76");
        showPhones(login);

        login = new Login("Jo");
        phonebook.addPhone(login, "911-11-99");
        phonebook.removePhone(login, "911-11-99");
        phonebook.removePhone(login, "000-11-22");
        showPhones(login);

        login = new Login("Olaf");
        showPhones(login);

        login = new Login("Bill");
        phonebook.addPhone(login, "432-56-87");
        phonebook.addPhone(login, "324-65-78");
        phonebook.addPhone(login, "234-78-56");
        phonebook.removePhone(login, "432-56-87");
        showPhones(login);
    }


   public static void showPhones(Login login)
   {
       var user = login.showInfo();
       System.out.printf("User login: %s, phones: \n", user);
        try 
        {
            var phones = phonebook.getPhonesByLogin(login);
            for (var phone : phones) {
                System.out.printf("\t%s\n", phone);
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}