#### DB #######
Use you Graph DB in PersonDBConfig.java in URL section
public static final String URL = System.getenv("NEO4J_URL") != null ? System.getenv("NEO4J_URL")
			: "<Neo4J URL>";
			
#### API Docs #######
Step 1. Import project to your IDE and run main class 'PersonApplication.java'

Step 2. Invoke URL 'http://localhost:8200/swagger-ui.html' To get all API documentations
 