package ${packageName}.resources

import com.codahale.metrics.annotation.Timed
import com.google.common.base.Optional
import io.dropwizard.jersey.caching.CacheControl
import groovy.util.logging.Slf4j
import javax.validation.Valid
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import java.util.concurrent.TimeUnit

/**
 * Created by lazybones dw template.
 */
@Path('/lazybones')
@Produces(MediaType.APPLICATION_JSON)
@Slf4j
class ${applicationName}Resource {

    @GET
    @Timed(name = 'get-requests')
    @CacheControl(maxAge = 1, maxAgeUnit = TimeUnit.DAYS)
    public Map echo(@QueryParam('name') Optional<String> name) {
        return [name: 'Created by lazy bones']
    }

    @POST
    public void receive(@Valid String name) {
        log.info('Created by lazybones.. Received a post..' + name)
    }

}
