package lesson2;

import java.util.regex.Pattern;

public class StringEditor {
    private String _str = null;
    public StringEditor(String str) throws Exception
    {
        if(str == null || str.trim().isEmpty())
            throw new Exception("StringEdidor ctor arg (str) is null or empty");
        _str = str;
    }
    
    public StringEditor removeSpaces()
    {
        _str = _str.replaceAll("\\s+", " ");
        return this;
    }

    public StringEditor dotInEnd()
    {
        _str = _str + ".";
        return this;
    }

    public StringEditor editCapitals()
    {
        _str = Pattern
                .compile("(\\s+)([A-ZА-Я])")
                .matcher(_str)
                .replaceAll(gr -> ".\s" + gr.group(2));
        return this;
    }

    public String getResult()
    {
        return this._str;
    }
   
}
