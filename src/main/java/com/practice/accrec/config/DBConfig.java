package com.practice.accrec.config;

import com.practice.accrec.repositories.impl.BaseEntityRepoImpl;
import io.micrometer.core.lang.Nullable;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.practice.accrec.entities"})
@EnableJpaRepositories(
        entityManagerFactoryRef = "accEntityManagerFactory",
        transactionManagerRef = "accTransactionManager",
        basePackages = {"com.practice.accrec.repositories"},
        repositoryBaseClass = BaseEntityRepoImpl.class)
@EnableTransactionManagement
@Primary
@Slf4j
public class DBConfig {

    @Value("${spring.datasource.url}")
    private String stagingDatasourceUrl;

    @Value("${spring.datasource.username}")
    private String stagingDatasourceUsername;

    @Value("${spring.datasource.password}")
    private String stagingDatasourcePassword;

    @Value("${spring.datasource.driverClassName}")
    private String stagingDatasourceDriverClassName = "com.mysql.cj.jdbc.Driver";

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddlAuto;

    @Value("${spring.jpa.hibernate.generate-ddl}")
    private String ddlGeneration;

    @Value("${spring.jpa.properties.hibernate.dialect}")
    private String hibernateDialect;

      @Value("${spring.jpa.hibernate.show_sql}")
      private String showSql;

    @Value("${spring.jpa.hibernate.naming.physical-strategy}")
    private String physicalStrategy;

    @Value("${spring.jpa.hibernate.naming.implicit-strategy}")
    private String implicitStrategy;

    @Value("${spring.jpa.properties.hibernate.jdbc.batch:20}")
    private String jdbcBatchSize;

    @Value("${spring.jpa.properties.hibernate.order_updates: true}")
    private String orderUpdates;
    @Value("${spring.jpa.properties.hibernate.batch_versioned_data: true}")
    private String versionedData;

    @Value("${spring.jpa.properties.hibernate.format_sql}")
    private String formatSql;

    @Autowired
    private Environment env;

    @Primary
    @Bean(name="accDataSource")
    public DataSource accDataSourceProperties() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(stagingDatasourceUrl);
        dataSource.setUsername(stagingDatasourceUsername);
        dataSource.setPassword(stagingDatasourcePassword);
        dataSource.setDriverClassName(stagingDatasourceDriverClassName);
        return dataSource;
    }

    @Primary
    @Bean(name = "accEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean accEntityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                          @Qualifier("accDataSource") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setPackagesToScan("com.practice.accrec.entities");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);

        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", ddlAuto);
        properties.setProperty("hibernate.generate-ddl", ddlGeneration);
        properties.setProperty("hibernate.dialect", hibernateDialect);
        properties.setProperty("hibernate.show_sql",showSql);
        properties.setProperty("hibernate.physical_naming_strategy", physicalStrategy);
        properties.setProperty("hibernate.implicit_naming_strategy", implicitStrategy);
        properties.setProperty("hibernate.jdbc.batch_size", jdbcBatchSize.trim());
        properties.setProperty("hibernate.order_updates", orderUpdates);
        properties.setProperty("hibernate.batch_versioned_data", versionedData);

        properties.setProperty("hibernate.format_sql", formatSql);
        properties.setProperty("hibernate.connection.characterEncoding", "utf8");
        properties.setProperty("hibernate.connection.CharSet", "utf8mb3");
        properties.setProperty("hibernate.connection.useUnicode", "true");
        entityManagerFactoryBean.setJpaProperties(properties);
        entityManagerFactoryBean.afterPropertiesSet();
        return entityManagerFactoryBean;
    }

    @Primary
    @Bean(name="accTransactionManager")
    public PlatformTransactionManager accTransactionManager(
            final
            @NonNull
            @Qualifier("accEntityManagerFactory") LocalContainerEntityManagerFactoryBean accEntityManagerFactory) {
        if(accEntityManagerFactory.getObject() == null){
            return null;
        }
        return new JpaTransactionManager(accEntityManagerFactory.getObject());
    }

}
