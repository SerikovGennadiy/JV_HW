package lesson4.models;

/**
 * Login
 */
public class Login {
    int Id;   
    String Credential;
    
    {
        Id = _generateId();
        Credential = "undiefine";
    }
    
    public Login(String credential)
    {
        this.Credential = credential;
    }

    public String showInfo()
    {
        return String.format("%s (%d)", this.Credential, this.Id);
    }

    @Override
    public int hashCode()
    {
        return this.Id;
    }

    private static int _identNumber = 0;

    private static int _generateId()
    {
       return ++_identNumber;
    } 
}