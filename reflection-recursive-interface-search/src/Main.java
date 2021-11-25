import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
	

	public static void main(String[] args) {
		
		List<String> strList = new ArrayList<>();
		Set<Class<?>> interfaceSet = getUnderlyingInterface(strList.getClass());
		
		interfaceSet.stream().forEach(System.out::println);
		
	}
	
	private static Set<Class<?>> getUnderlyingInterface(Class<?> classz) {
		
		Set<Class<?>> interfaceSet = new HashSet<>();
		
		Class<?>[] interfaces = classz.getInterfaces();
		
		for(Class<?> ifc : interfaces) {
			
			interfaceSet.add(ifc);
			interfaceSet.addAll(getUnderlyingInterface(ifc));
		}
		
		return interfaceSet;
		
	}

}
