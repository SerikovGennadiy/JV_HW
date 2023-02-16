package lesson2;

public class Program {
    
    public static void main(String[] args) {
        String str = "Добрый      день                Как  дела   Все                 хорошо";
        System.out.println(str);
        String result = "";
        try {
            StringEditor strEditor = new StringEditor(str);
            result = strEditor
                        .removeSpaces()
                        .dotInEnd()
                        .editCapitals()
                        .getResult();
        } 
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(result);
    }
}

