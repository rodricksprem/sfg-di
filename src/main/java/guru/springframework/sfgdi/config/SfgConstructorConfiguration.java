package guru.springframework.sfgdi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;


@ConfigurationProperties("guru")
@ConstructorBinding
public class SfgConstructorConfiguration {

    private final String userName;
    private final String password;
    private final String jdbcURL;

    public SfgConstructorConfiguration(String userName, String password, String jdbcURL) {
        this.userName = userName;
        this.password = password;
        this.jdbcURL = jdbcURL;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getJdbcURL() {
        return jdbcURL;
    }
}
