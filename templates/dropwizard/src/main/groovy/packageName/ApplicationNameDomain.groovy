package ${packageName}.db

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import groovy.transform.ToString

/**
 * Created by lazybones dw template.
 */
@Entity
@Table(name = 'lazybones')
@ToString
class ${applicationName}Domain {

    @Id
    String name

    @Column
    String email

}
