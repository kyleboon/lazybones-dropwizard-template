package ${packageName}

import io.dropwizard.Application
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment
import io.dropwizard.db.DataSourceFactory
import io.dropwizard.hibernate.HibernateBundle
import io.dropwizard.migrations.MigrationsBundle
import groovy.util.logging.Slf4j
import ${packageName}.db.*
import ${packageName}.resources.*

@Slf4j
class ${applicationName}Application extends Application<${applicationName}Configuration> {

    private final String name = '${applicationName}'

    public static void main(String[] args) throws Exception {
        new ${applicationName}Application().run(args)
    }

    @Override
    public void run(HelloWorldConfiguration configuration,
                    Environment environment) throws ClassNotFoundException {
        log.debug('Running ...' + name)
        environment.jersey().register(new ${applicationName}Resource())
    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
        bootstrap.with {
            addBundle migrationsBundle
            addBundle hibernateBundle
        }
    }

    private final HibernateBundle<${applicationName}Configuration> hibernateBundle =
        new HibernateBundle<${applicationName}Configuration>(${applicationName}Domain, ${applicationName}Domain) {
            @Override
            public DataSourceFactory getDataSourceFactory(${applicationName}Configuration configuration) {
                return configuration.database
            }
        }

    private final MigrationsBundle<${applicationName}Configuration> migrationsBundle =
        new MigrationsBundle<${applicationName}Configuration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(${applicationName}Configuration configuration) {
                return configuration.database
            }
        }

}
