package com.undefined.platz.configuration

import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactory",
        transactionManagerRef = "transactionManager",
        basePackages = ["com.undefined.platz"]
)
class DataSourceConfig(
        private val applicationPropertiesConfig: ApplicationConfigurationProperties,
        private val parameterStoreConfigurationProperties: ParameterStoreConfigurationProperties
) {

    protected fun getDataSourceConfigProperties(): ParameterStoreConfigurationProperties =
            when (applicationPropertiesConfig.profiles) {
                "dev", "prod" -> parameterStoreConfigurationProperties
                else -> ParameterStoreConfigurationProperties(
                        host = "localhost",
                        port = "13306",
                        name = "platz",
                        password = "platz"
                )
            }

    @Bean
    @ConfigurationProperties("spring.datasource")
    fun dataSource(): DataSource {
        val (host, port, name, password) = getDataSourceConfigProperties()

        if (listOf(host, name, password).any { it.isBlank() }) {
            throw IllegalArgumentException("RDS 접속 정보를 받아올 수 없습니다. aws credentials을 확인해주세요.")
        }

        val dataSourceBuilder = DataSourceBuilder.create()
        dataSourceBuilder.url("jdbc:mysql://${"$host:"}${port}/platz?useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false")
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver")
        dataSourceBuilder.username(name)
        dataSourceBuilder.password(password)
        dataSourceBuilder.type(HikariDataSource::class.java)
        return dataSourceBuilder.build()
    }

    protected fun jpaProperties(): Map<String, String> {
        return mapOf(
                "hibernate.physical_naming_strategy" to SpringPhysicalNamingStrategy::class.java.name,
                "hibernate.implicit_naming_strategy" to SpringImplicitNamingStrategy::class.java.name
        )
    }

    @Bean
    fun entityManagerFactory(
            builder: EntityManagerFactoryBuilder): LocalContainerEntityManagerFactoryBean {
        return builder
                .dataSource(this.dataSource())
                .packages("com.undefined.platz")
                .persistenceUnit("platzPersistenceUnit")
                .properties(jpaProperties())
                .build()
    }

    @Bean
    fun transactionManager(builder: EntityManagerFactoryBuilder): JpaTransactionManager {
        return JpaTransactionManager(entityManagerFactory(builder).`object`!!)
    }
}
