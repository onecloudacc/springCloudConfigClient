### Config Client:

Create a new, separate Spring Boot application. Use a version of Boot > 1.5.x. Name the project "springCloudConfigClientDemo", and use this value for the Artifact. Add the web dependency. You can make this a JAR or WAR project, but the instructions here will assume JAR.

Add a bootstrap.properties) file in the root of your classpath (src/main/resources recommended). Add the following key/values using the appropriate format: spring.application.name=configuration (name of the property file in github) spring.cloud.config.uri=http://localhost:8001
server.port=8002

(Note that this file must be "boostrap" -- not "application" -- so that it is read early in the application startup process. The server.port could be specified in either file, but the URI to the config server affects the startup sequence.)

Add a REST controller to obtain and display the configuration:


@RestController
public class ClientConfigController {
	
	private static final Logger log = LoggerFactory.getLogger(ClientConfigController.class);
	
	@Value("${appName}")  // Printing the fieldnames from http://localhost:8001/configuration/default
	String myAppName;
	
	@Value("${desc}") 
	String description;
	
	@RequestMapping(method=RequestMethod.GET,value="/fetchConfig")
	public String getConfigDetails()
	{
		log.info("ClientConfig app is calling the ServerConfig app");
		log.info("Printing the config from the serverConfig app");
		log.info("AppName= " +myAppName  + "  Desc= "+description);
		return "AppName= " +myAppName  + "  Desc= "+description;
	}

}


Start your client. Open http://localhost:8002/resourcename in controller. You should see the corresponding value  message in your browser.
http://localhost:8002/fetchConfig