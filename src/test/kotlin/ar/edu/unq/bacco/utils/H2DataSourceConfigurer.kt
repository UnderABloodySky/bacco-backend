import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableJpaRepositories
@Profile("development")
class H2DataSourceConfigurer {
    // Configuración de la base de datos H2 en memoria
    // ...
}
