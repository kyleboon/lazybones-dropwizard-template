import org.apache.commons.io.FileUtils

def props = [:]
props.group = ask("Define value for 'group': ", "group")
props.version = ask("Define value for your application 'version' [0.1]: ", "version", "0.1")
props.packageName = ask("Define value for package structure: ", "packageName")
props.applicationName = ask("Define value for the name of the application: ", "applicationName").capitalize()

processTemplates "gradle.properties", props
processTemplates "src/main/groovy/packageName/ApplicationName*.groovy", props

// new package structure
def packageDirectoryStructure = props.packageName.replace('.', '/')

def existingDirectory = new File("${targetDir}/src/main/groovy/packageName")


def resourceFile = new File("${targetDir}/src/main/groovy/packageName/ApplicationNameResource.groovy")
FileUtils.moveFile(resourceFile, new File("${targetDir}/src/main/groovy/${packageDirectoryStructure}/resources/${props.applicationName}Resource.groovy"))

def dbFile = new File("${targetDir}/src/main/groovy/packageName/ApplicationNameDomain.groovy")
FileUtils.moveFile(dbFile, new File("${targetDir}/src/main/groovy/${packageDirectoryStructure}/db/${props.applicationName}Domain.groovy"))

def configurationFile = new File("${targetDir}/src/main/groovy/packageName/ApplicationNameConfiguration.groovy")
FileUtils.moveFile(configurationFile, new File("${targetDir}/src/main/groovy/${packageDirectoryStructure}/${props.applicationName}Configuration.groovy"))

def appFile = new File("${targetDir}/src/main/groovy/packageName/ApplicationNameApplication.groovy")
FileUtils.moveFile(appFile, new File("${targetDir}/src/main/groovy/${packageDirectoryStructure}/${props.applicationName}Application.groovy"))

def coreDir = new File("${targetDir}/src/main/groovy/${packageDirectoryStructure}/core/")
FileUtils.forceMkdir(coreDir)

def healthCheckDir = new File("${targetDir}/src/main/groovy/${packageDirectoryStructure}/healthchecks/")
FileUtils.forceMkdir(healthCheckDir)

new File("${targetDir}/src/main/groovy/${packageDirectoryStructure}/core/.retain").createNewFile()
new File("${targetDir}/src/main/groovy/${packageDirectoryStructure}/healthchecks/.retain").createNewFile()


FileUtils.deleteDirectory(existingDirectory)
