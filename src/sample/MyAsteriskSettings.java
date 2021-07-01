package sample;


import org.asteriskjava.pbx.DefaultAsteriskSettings;

public class MyAsteriskSettings extends DefaultAsteriskSettings {

    @Override
    public String getManagerPassword()
    {
        // this password MUST match the password (secret=) in manager.conf
        return "test123";
    }

    @Override
    public String getManagerUsername()
    {
        // this MUST match the section header '[myconnection]' in manager.conf
        return "[myconnection]";
    }

    @Override
    public String getAsteriskIP()
    {
        // The IP address or FQDN of your Asterisk server.
        return "192.168.1.115";
    }

    @Override
    public String getAgiHost()
    {
        // The IP Address or FQDN of you asterisk-java application.
        return "192.168.1.54";
    }


}
