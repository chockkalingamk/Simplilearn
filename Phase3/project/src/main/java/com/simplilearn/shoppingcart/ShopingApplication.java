package com.simplilearn.shoppingcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.core.env.Environment;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class })

/*
 * @EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class,
 * DataSourceTransactionManagerAutoConfiguration.class,
 * HibernateJpaAutoConfiguration.class })
 */public class ShopingApplication {

	@Autowired
	public Environment env;

	public static void main(String[] args) {
		SpringApplication.run(ShopingApplication.class, args);
	}

	/*
	 * @Bean(name = "dataSource") public DataSource dataSource() {
	 * DriverManagerDataSource dataSource = new DriverManagerDataSource();
	 * 
	 * 
	 * dataSource.setDriverClassName(env.getProperty(
	 * "spring.datasource.driver-class-name"));
	 * dataSource.setUrl(env.getProperty("spring.datasource.url"));
	 * dataSource.setUsername(env.getProperty("spring.datasource.username"));
	 * dataSource.setPassword(env.getProperty("spring.datasource.password"));
	 * 
	 * 
	 * dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	 * dataSource.setUrl("jdbc:mysql://localhost:3306/project");
	 * dataSource.setUsername("root"); dataSource.setPassword("root");
	 * 
	 * System.out.println("## getDataSource: " + dataSource);
	 * 
	 * return dataSource; }
	 * 
	 * //@Autowired
	 * 
	 * @Bean(name = "sessionFactory") public LocalSessionFactoryBean
	 * sessionFactory() { Properties hibernateProperties = new Properties();
	 * 
	 * hibernateProperties.put("hibernate.dialect",
	 * "org.hibernate.dialect.MySQL5Dialect");
	 * 
	 * hibernateProperties.put("hibernate.show_sql",
	 * env.getProperty("spring.jpa.show_sql"));
	 * 
	 * hibernateProperties.put("current_session_context_class", //
	 * "org.springframework.orm.hibernate5.SpringSessionContext");
	 * 
	 * 
	 * LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
	 * 
	 * factoryBean.setPackagesToScan("com");
	 * factoryBean.setDataSource(dataSource());
	 * factoryBean.setHibernateProperties(hibernateProperties);
	 * 
	 * System.out.println("## getSessionFactory" + factoryBean);
	 * 
	 * return factoryBean;
	 * 
	 * }
	 * 
	 * //@Autowired
	 * 
	 * @Bean(name = "transactionManager") public HibernateTransactionManager
	 * transactionManager() { return new
	 * HibernateTransactionManager(sessionFactory().getObject()); }
	 */}
