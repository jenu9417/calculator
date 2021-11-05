help: ## You can always run this command to see whau options are available to you while running the make command
	@fgrep -h "##" $(MAKEFILE_LIST) | fgrep -v fgrep | sed -e 's/\\$$//' | sed -e 's/##//'

clean: ## Clean working directory and remove old existing jars
	rm -rf target
	
build: ## Build the project and Generate JAR file
	mvn clean install
	
test: ## Run Testcases
	mvn test
	
run: ## Run the jar present in 'target/calculator.jar' with args.  eg : make run ARGS='-Dinput="2+4/2*3-1"'
	java $(ARGS) -jar target/calculator.jar