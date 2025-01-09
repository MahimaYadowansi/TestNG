package reRunFailedTest;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class Retry implements IRetryAnalyzer {
	/*int retrycount = 0;
	 int maxretyrcount =1;
	
	 @Override
		public boolean retry(ITestResult result) {
		 
		 
			// TODO Auto-generated method stub
			if (retrycount<maxretyrcount){
				System.out.println("Retrying test " + result.getName() + " with status "
	                    + getResultStatusName(result.getStatus()) + " for the " + (retrycount+1) + " time(s).");
				retrycount++;
	            return true;
			}
			
			return false;
		
	}

	 public String getResultStatusName(int status) {
	    	String resultName = null;
	    	if(status==1)
	    		resultName = "SUCCESS";
	    	if(status==2)
	    		resultName = "FAILURE";
	    	if(status==3)
	    		resultName = "SKIP";
			return resultName;
	    }*/
	
	
	
	
	 private int retrycount = 0; // Current retry attempt
	    private final int maxretyrcount = 2; // Maximum retry attempts

	    @Override
	    public boolean retry(ITestResult result) {
	        // Retry logic
	        if (retrycount < maxretyrcount) {
	            retrycount++;
	            System.out.println("Retrying test '" + result.getName() + "' with status: "
	                    + getResultStatusName(result.getStatus()) + ". Attempt: " + retrycount);
	            return true;
	        }
	        System.out.println("Test '" + result.getName() + "' failed after " + maxretyrcount + " attempts.");
	        return false;
	    }

	    
	    private String getResultStatusName(int status) {
	        switch (status) {
	            case ITestResult.SUCCESS:
	                return "SUCCESS";
	            case ITestResult.FAILURE:
	                return "FAILURE";
	            case ITestResult.SKIP:
	                return "SKIP";
	            default:
	                return "UNKNOWN";
	        }
	
	
	
	
	    }
}
