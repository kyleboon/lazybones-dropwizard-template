package ${packageName}

import com.fasterxml.jackson.annotation.JsonProperty
import io.dropwizard.Configuration
import io.dropwizard.db.DataSourceFactory
import javax.validation.Valid
import javax.validation.constraints.NotNull

/**
 * Created by lazybones dw template.
 */
class ${applicationName}Configuration extends Configuration {

    @Valid
    @NotNull
    @JsonProperty('database')
    private final DataSourceFactory database = new DataSourceFactory()

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                      .add('server', server)
                      .add('logging', logging)
                      .add('database', database)
                      .toString()
    }

}
