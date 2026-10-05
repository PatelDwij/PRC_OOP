import java.util.regex.*;

class TemplateFiller
{
    public static String fillTemplate(String template, String[] names, String[] values)
    {
        Pattern p = Pattern.compile("\\{(\\w+)\\}");
        Matcher m = p.matcher(template);

        StringBuffer result = new StringBuffer();

        while (m.find())
        {
            String placeholder = m.group(1);
            String value = "[?]";

            for (int i = 0; i < names.length; i++)
            {
                if (names[i].equals(placeholder))
                {
                    value = values[i];
                    break;
                }
            }

            m.appendReplacement(result, value);
        }

        m.appendTail(result);

        return result.toString();
    }
}
