package tech.csm.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DButil {

	@Bean
 DataSource dataSource() {
		 DriverManagerDataSource dataSource = new DriverManagerDataSource();
         dataSource.setUrl("jdbc:mysql://localhost:3306/collegeadmission");
         dataSource.setUsername("root");
         dataSource.setPassword("mypassword");
         dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
     return dataSource;
		
	}
}
