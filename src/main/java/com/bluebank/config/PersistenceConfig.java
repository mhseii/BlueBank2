package main.java.com.bluebank.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "main.java.com.bluebank.repository")
@EnableTransactionManagement
public class PersistenceConfig {

	private EmbeddedDatabase ed;
	
	@Bean(name="H2DS")
	public EmbeddedDatabase dataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		this.ed = builder.setType(EmbeddedDatabaseType.H2).build();
		return this.ed; 
	}

	@Bean
	@PersistenceContext
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
/*
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setShowSql(true);
		vendorAdapter.setGenerateDdl(true);
		vendorAdapter.setDatabase(Database.H2);
*/
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSource());
		factory.setPackagesToScan(new String[]{"main.java.com.bluebank.model"});
		factory.setPersistenceUnitName("hibernatePersistence");
		factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		//factory.setJpaVendorAdapter(vendorAdapter);
		factory.setJpaDialect(new HibernateJpaDialect());
		factory.setJpaPropertyMap(hibernateJPAProperties());
		factory.afterPropertiesSet();
		return factory;
	}

	private Map<String, ?> hibernateJPAProperties() {
		HashMap<String, String> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", "create");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.hbm2ddl.import_files", "insert-data.sql");
		properties.put("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");
		properties.put("hibernate.c3p0.min_size", "2");
		properties.put("hibernate.c3p0.max_size", "5");
		properties.put("hibernate.c3p0.timeout", "60"); // 5mins
		return properties;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return txManager;
	}
}
