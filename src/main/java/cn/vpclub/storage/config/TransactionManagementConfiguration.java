package cn.vpclub.storage.config;

import com.atomikos.icatch.config.UserTransactionServiceImp;
import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;
import java.util.Properties;

/**
 * Created by vpclub on 16-3-22.
 */
@Configuration
@EnableTransactionManagement
public class TransactionManagementConfiguration {
    @Bean(name = "userTransactionServiceImp")
    public UserTransactionServiceImp userTransactionServiceImp() {
        Properties properties = new Properties();
        properties.setProperty("com.atomikos.icatch.max_timeout", "600000");
        UserTransactionServiceImp userTransactionServiceImp = new UserTransactionServiceImp(properties);
        return userTransactionServiceImp;
    }

    @Bean
    @DependsOn("userTransactionServiceImp")
    public UserTransaction userTransaction() {
        UserTransactionImp userTransactionImp = new UserTransactionImp();
        return userTransactionImp;
    }

    @Bean(initMethod = "init", destroyMethod = "close")
    @DependsOn("userTransactionServiceImp")
    public TransactionManager userTransactionManager() {
        UserTransactionManager userTransactionManager = new UserTransactionManager();
        userTransactionManager.setStartupTransactionService(true);
        // userTransactionManager.setForceShutdown(true);
        return userTransactionManager;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JtaTransactionManager(userTransaction(), userTransactionManager());
    }
}

