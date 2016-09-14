package configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import play.Logger;
import play.Play;

import java.beans.PropertyVetoException;
import java.util.HashMap;

@Configuration
@EnableTransactionManagement
public class DataConfig {

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(false);
        vendorAdapter.setGenerateDdl(true);
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setPackagesToScan("models");
        entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
        entityManagerFactory.setDataSource(dataSource());
//        entityManagerFactory.setJpaPropertyMap(new HashMap<String, String>(){{
//            put("hibernate.hbm2ddl.auto", "create-drop");
//        }});
        entityManagerFactory.afterPropertiesSet();
        return entityManagerFactory.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager(entityManagerFactory());

        return transactionManager;
    }

    @Bean
    public DataSource dataSource() {
//        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(Play.application().configuration().getString("db.default.driver"));
//        dataSource.setUrl(Play.application().configuration().getString("db.default.url"));
//        dataSource.setUsername(Play.application().configuration().getString("db.default.username"));
//        dataSource.setPassword(Play.application().configuration().getString("db.default.password"));
                
        
        final ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass(Play.application().configuration().getString("db.default.driver"));
        } catch (PropertyVetoException e) {
            System.out.println("*****************************************\n****************************************\n*****************************");
            e.printStackTrace();
        }
        dataSource.setJdbcUrl(Play.application().configuration().getString("db.default.url"));
        dataSource.setUser(Play.application().configuration().getString("db.default.username"));
        dataSource.setPassword(Play.application().configuration().getString("db.default.password"));
        Logger.debug("user name = " + Play.application().configuration().getString("db.default.username") + "\tpassword = "  + Play.application().configuration().getString("db.default.password"));
        
        dataSource.setInitialPoolSize(Play.application().configuration().getInt("db.default.initialPoolSize"));
        dataSource.setMinPoolSize(Play.application().configuration().getInt("db.default.minPoolSize"));
        dataSource.setMaxPoolSize(Play.application().configuration().getInt("db.default.maxPoolSize"));
        dataSource.setMaxIdleTime(Play.application().configuration().getInt("db.default.maxIdleTime"));
        dataSource.setNumHelperThreads(Play.application().configuration().getInt("db.default.numHelperThreads"));
        dataSource.setAcquireIncrement(Play.application().configuration().getInt("db.default.acquireIncrement"));
        dataSource.setMaxStatementsPerConnection(Play.application().configuration().getInt("db.default.maxStatementsPerConnection"));
        

        
        
        return dataSource;
    }

}