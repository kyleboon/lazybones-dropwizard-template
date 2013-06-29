package ${packageName}

import com.yammer.dropwizard.Service
import com.yammer.dropwizard.assets.AssetsBundle
import com.yammer.dropwizard.config.Bootstrap
import com.yammer.dropwizard.config.Environment
import com.yammer.dropwizard.db.DatabaseConfiguration
import com.yammer.dropwizard.hibernate.HibernateBundle
import com.yammer.dropwizard.migrations.MigrationsBundle

class ${serviceName}Service extends Service<${serviceName}Configuration> {
    public static void main(String[] args) throws Exception {
        new ${serviceName}Service().run(args)
    }

    HibernateBundle<${serviceName}Configuration> hibernateBundle =
        new HibernateBundle<${serviceName}Configuration>([]) {
            @Override
            public DatabaseConfiguration getDatabaseConfiguration(${serviceName}Configuration configuration) {
                return configuration.databaseConfiguration
            }
        }

    MigrationsBundle<${serviceName}Configuration> migrationsBundle =
        new MigrationsBundle<${serviceName}Configuration>() {
            @Override
            public DatabaseConfiguration getDatabaseConfiguration(${serviceName}Configuration configuration) {
                return configuration.databaseConfiguration
            }
        }

    AssetsBundle assetsBundle = new AssetsBundle()

    @Override
    public void initialize(Bootstrap<${serviceName}Configuration> bootstrap) {
        bootstrap.with {
            name = '${serviceName}'
            addBundle migrationsBundle
            addBundle hibernateBundle
        }
    }

    @Override
    public void run(${serviceName}Configuration configuration,
                    Environment environment) throws ClassNotFoundException {
    }
}
