# Introduction

You have created an dropwizard application using lazybones. This application uses dropwizard 0.7.0 version.
Use previous versions of the lazybone templates for previous versions.

The application will start and will have sample resource impl, that you can hit to verify the application.
For more detailed documentation about a dropwizard application refer to http://dropwizard.github.io/dropwizard/getting-started.html.

This application is configure to use hibernate for database access, liquibase for migrations and dropwizard asset bundle.

The build uses the gradle shadow and application plugins. These plugins work together to create runnable jar. Please see their respective documentation for more information.

Enjoy!

    <proj>
        +- src
            +- main
            |   +- groovy
            |   |     +- your.package.structure
            |   |           +- core
            |   |           +- db
            |   |           +- healthchecks
            |   |           +- resources
            |   +- resources
            |
            +- test
                +- groovy
                |     +- // Spock tests in here!
                +- resources
                      +- fixtures

# Running The Application

To test the example application run the following commands.

* To run the tests run

        gradle test

* To package the example run. 

        gradle shadowJar


* To run the application run.

        gradle runShadow
