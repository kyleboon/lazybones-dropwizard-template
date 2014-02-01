import org.apache.commons.io.FileUtils

def filterProperties = [:]
filterProperties.group = ask("Define value for 'group': ")
filterProperties.version = ask("Define value for 'version' [0.1]: ", "0.1")

filterProperties.packageName = ask("Define value for package structure: ")
filterProperties.serviceName = ask("Define value for the name of the service: ")

processTemplates("gradle.properties", filterProperties)
processTemplates("src/main/groovy/packageName/ServiceNameService.groovy", filterProperties)
processTemplates("src/main/groovy/packageName/ServiceNameConfiguration.groovy", filterProperties)

// move to user specified directory structure
def packageDirectoryStructure = filterProperties.packageName.replace('.', '/')
def existingDirectory = new File("${targetDir}/src/main/groovy/packageName")
def newDirectory = new File("${targetDir}/src/main/groovy/${packageDirectoryStructure}")

FileUtils.moveDirectory(existingDirectory, newDirectory)

// move to user specified service name
def serviceFile = new File("${targetDir}/src/main/groovy/${packageDirectoryStructure}/ServiceNameService.groovy")
serviceFile.renameTo("${targetDir}/src/main/groovy/${packageDirectoryStructure}/${filterProperties.serviceName}Service.groovy")

def configurationFile = new File("${targetDir}/src/main/groovy/${packageDirectoryStructure}/ServiceNameConfiguration.groovy")
configurationFile.renameTo("${targetDir}/src/main/groovy/${packageDirectoryStructure}/${filterProperties.serviceName}Configuration.groovy")