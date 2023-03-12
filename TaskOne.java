// Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, 
// используя StringBuilder. Данные для фильтрации приведены ниже в виде json строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: 
// {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
/**
 * TaskOne
 */
import java.util.HashMap;
import java.util.Map;


public class TaskOne {
    public static void main(String[] args) {
        Map <String, String> params1 = new HashMap <String, String>();
        params1.put("name","John");
        params1.put("country","USA");
        params1.put("city","Bolton");
        params1.put("age",null);
        System.out.println(getQuery(params1));
    }
    public static String getQuery(Map<String, String> params)
    {
        StringBuilder s = new StringBuilder();
        for (Map.Entry<String,String> pair : params.entrySet())
        {
            if (pair.getValue() != null)
            {
                s.append(pair.getKey() +" = '" + pair.getValue()+"' and ");
            }
        }
        s.delete(s.toString().length()-5,s.toString().length());
        return s.toString();
    }

}