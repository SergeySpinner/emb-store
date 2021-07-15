package projectFiles;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@ComponentScan(basePackages = "projectFiles")
@PropertySource("classpath:application.properties")
public class ApplicationConfiguration {

    @Autowired
    Environment env;

    @Bean
    public DataSource getDataSource() throws SQLException {
        PGSimpleDataSource pgSimpleDataSource = new PGSimpleDataSource();
        pgSimpleDataSource.setUser(env.getProperty("datasource.username"));
        pgSimpleDataSource.setUrl(env.getProperty("datasource.url"));
        pgSimpleDataSource.setPassword(env.getProperty("datasource.password"));

        return pgSimpleDataSource.unwrap(DataSource.class);
    }
}
