public class chartfilter
{
    public static String filter(String[] logs,String value)
    {
        StringBuilder report = new StringBuilder();
        int count=0;
        String lowervalue= value.toLowerCase();

        for(String line : logs)
        {
            String parts[] = line.split(" ",3);

            if(parts.length<3)
            {
                continue;
            }

            String time = parts[0];
            String name = parts[1];
            String message = parts[2];

            if(message.toLowerCase().contains(lowervalue))
            {
                count++;
                report.append(time)
                .append(" ")
                .append(name)
                .append(":")
                .append(message)
                .append("\n");
            }
        }

        return ("matches : " + count +"\n"+ report);

    }
}