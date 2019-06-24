# Clean Code Workshop #1
This is the repository for our first Clean Code workshop. It has the starter bits that everyone at the workshop should fork and work on.

## Requirements
You need the following tools to run and compile this project:
- [Git](https://git-scm.com/)
- [Oracle Java 1.8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) or [OpenJDK 8](https://jdk.java.net/)
- [Maven](https://maven.apache.org/)
- **Optional**: one of these IDE softwares:
  - [IntelliJ IDEA](https://www.jetbrains.com/idea/)
  - [VS Code](https://code.visualstudio.com)
  - [Eclipse](https://www.eclipse.org/)

## Setup environment variables
Set the `JAVA_HOME` and `MVN_HOME` variable via the command line:

- Open Command Prompt/Terminal (make sure you Run as administrator so you're able to add a system environment variable).
- Set the value of the environment variables to your installation paths as follows:

**Windows:**
```
setx -m JAVA_HOME "C:\Progra~1\Java\jdk1.8.0_XXX\bin"
setx -m MVN_HOME "C:\Progra~1\apache-maven-3.X.X\bin"
```
**Linux:**
```
setenv JAVA_HOME jdk-install-dir
setenv MVN_HOME mvn-install-dir

setenv PATH $JAVA_HOME/bin:$PATH
export PATH=$JAVA_HOME/bin:$PATH

setenv PATH $MVN_HOME/bin:$PATH
export PATH=$MVN_HOME/bin:$PATH
```

- Restart Command Prompt/Terminal to reload the environment variables then use the following command to check that they've been added correctly. 

```
echo %JAVA_HOME%
echo %MVN_HOME%
```

You should see the path to your installation paths.

> **Note for Windows users on 64-bit systems**
>
> Progra~1 = 'Program Files'
>
> Progra~2 = 'Program Files (x86)'

## Build & Test
Open Command Prompt/Terminal and run the following command:

```
mvn clean install
```

It will download the necessary dependencies, run the junit tests and compile the project.

When the build is success, then generate a .jar file under the `targer` folder.

You can the .jar file run with the following command:

```
java -jar clean-code-workshop-1-1.0-SNAPSHOT.jar
```
