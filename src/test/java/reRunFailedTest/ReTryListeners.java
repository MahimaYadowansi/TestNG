package reRunFailedTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class ReTryListeners implements IAnnotationTransformer {
	 @Override
	    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
	       System.out.println("Transform called for method: " + (testMethod != null ? testMethod.getName() : "null"));
	       // Get the retry analyzer class from the annotation
	        Class<? extends IRetryAnalyzer> analyzer = annotation.getRetryAnalyzerClass();
	        if (analyzer == null) {
	            System.out.println("Setting RetryAnalyzer for: " + (testMethod != null ? testMethod.getName() : "null method"));
	            annotation.setRetryAnalyzer(Retry.class);
		 
		 
		
		}

	}

}
