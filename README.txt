To build the java classes representing the xsd schema we use the apache xml bean project that will 
compile a schema into XML Bean classes and metadata

Explanation of below:
Given an xsd the project will generate a jar file that we can then use to create an xml document that is represented by the xsd 
See http://xmlbeans.apache.org/ to get yourself the project

Windoze:
scomp D:\Users\edamphousse\my_workspace\TDGSRTBuilder\src\reference_schema\tdg_srt-1_0.xsd \
-out TDGSRT.jar \
-compiler D:\Java\jdk1.6.0_30\bin\javac.exe \
-out D:\Users\edamphousse\my_workspace\TDGSRTBuilder\lib\TDGSRT.jar \
-src D:\Users\edamphousse\my_workspace\TDGSRTBuilder\src

Linux:
scomp /Users/ericdamphousse/Workspaces/"MyEclipse 9"/TDGSRTBuilder/src/reference_schema/tdg_srt-1_0.xsd  \
-out TDGSRT.jar \
-compiler javac \
-out /Users/ericdamphousse/Workspaces/"MyEclipse 9"/TDGSRTBuilder/lib/TDGSRT.jar \
-src /Users/ericdamphousse/Workspaces/"MyEclipse 9"/TDGSRTBuilder/src

MAVEN
Copy to the maven repository the OMPC.jar and add it as a dependency

 <dependency>
  <groupId>com.thetdgroup</groupId>
  <artifactId>TDGSRT</artifactId>
  <version>1.0.0</version>
 </dependency>