package com.example.demo.configuration;

import com.example.demo.mapper.MainDataBaseMapper;
import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.inject.Named;
import javax.sql.DataSource;

@Configuration
public class MyBatisConfiguration {

    private static final String MAIN_SESSION_FACTORY = "mainSessionFactory";

    @Bean(name = MAIN_SESSION_FACTORY, destroyMethod = "")
    @Primary
    public SqlSessionFactoryBean sqlSessionFactory(@Named(DatabaseConfiguration.MAIN_DATASOURCE) final DataSource mainDataSource) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

//        String password = AESUtil.druidDecrypt(publicKey, ((HikariDataSource) mainDataSource).getPassword());
        String password = ((HikariDataSource) mainDataSource).getPassword();
        ((HikariDataSource) mainDataSource).setPassword(password);
        sqlSessionFactoryBean.setDataSource(mainDataSource);
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.addMapper(MainDataBaseMapper.class);
        sqlSessionFactoryBean.setConfiguration(configuration);
        sqlSessionFactoryBean.getObject();
        return sqlSessionFactoryBean;
    }

    @Bean
    public MapperFactoryBean<MainDataBaseMapper> etrMapper(@Named(MAIN_SESSION_FACTORY) final SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception{
        MapperFactoryBean<MainDataBaseMapper> factoryBean = new MapperFactoryBean<>(MainDataBaseMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactoryBean.getObject());
        return  factoryBean;
    }

}
