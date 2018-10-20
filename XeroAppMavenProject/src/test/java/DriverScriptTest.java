
import java.lang.reflect.Method;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.testng.annotations.Test;

public class DriverScriptTest extends AutomationScripts{
	@Test
	public static void mainMethod() throws Exception{
/*String dt_Path= "C:\\Users\\Anup\\workspace\\XeroAppMavenProject\\src\\test\\resources\\DataFiles\\TestSuite.xls";
		
		String[][] recdata=ReusableMethods.readxlData(dt_Path,"Sheet1");
		String testCase=null;
		
		initializeExtentReport("XeroExeReport");
		for(int i=1;i<recdata.length;i++){
			testCase=recdata[1][0];
			Method testScript = AutomationScripts.class.getMethod(testCase);
			testScript.invoke(testScript);
		}
		extent.flush();
	}
}
*/



		//String cur_dir=System.getProperty("user.dir");
		String dt_Path = "C:\\Users\\Anup\\workspace\\XeroAppMavenProject\\src\\test\\resources\\DataFiles\\TestSuite.xls";
		String testCase =null;
		String flag = null;
		System.out.println("execution started from driverfile");
		initializeExtentReport("XeroTestscriptsReport");
		String[][] recdata =ReusableMethods.readxlData(dt_Path,"Sheet1");
		for(int i = 1; i<recdata.length; i++) {
			flag = recdata[i][1];
			if(flag.equalsIgnoreCase("Y")) {
					testCase = recdata[i][0];
					System.out.println("TestCase:" + testCase + "Helllooo123");
					try {
						Method testScript = AutomationScripts.class.getMethod(testCase);
						System.out.println("TestScrit:" + testScript + "Helllooo");
						testScript.invoke(testScript);
						System.out.println("AAAAAAAABBBBBBBb");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					System.out.println("**********Row  number "+ i+" test case Name "+ recdata[i][0]+" is not Executed*********");
				}
				
			
			
			
		}
		
		endExtentReport();
	}

}
/*String dt_Path= "C:\\Users\\Anup\\Google_Drive\\QA_Automation\\Framework\\ExecutionSystem\\TestSuit.xls";

String[][] recdata=SFReuseableMethods.readSheet(dt_Path,"Sheet3");
String testCase=null;

/*String flag=null;
System.out.println();
executionReport("Salesforce4");
for(int i=1;i<recdata.length;i++){
	flag = recdata[i][1];
	if(flag.equalsIgnoreCase("Y")) {
		testCase = recdata[i][2];*/