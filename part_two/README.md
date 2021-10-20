# Rise Capital e2e Atumated test


## Steps to run: 
1) Clone the project      
2) From the Terminal navigate to the directory qa-exercise/part_two where you can see *pom.xml*
3) Run `mvn install -DskipTests`
4) Run:
   `mvn test -Dbrowser=Chrome` to run against Chrome browser,
   `mvn test -Dbrowser=Firefox` to run against Firefox browser, and
   `mvn test -Dbrowser=Edge` to run against Edge browser

**Note**: I assume you should have java and mvn installed in your system     
