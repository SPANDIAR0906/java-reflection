import java.lang.reflect.Array;

public class Main {

	public static void main(String[] args) {
		
		int [] intArray = {1, 2, 3};
		int [][] twoDArray = {{1,3},{2,3},{3,3}};
		
		exploreArrayObj(intArray);
		inspectArrayObj(twoDArray);
		
	}
	
	public static void inspectArrayObj(Object instance) {
		
		final int length = Array.getLength(instance);
		
		System.out.print("[");
		for(int i=0; i<length; i++) {
			final Object element = Array.get(instance, i);
			
			if(element.getClass().isArray()) {
				inspectArrayObj(element);
			} else {
				System.out.print(element);
				if(i < length-1) {
					System.out.print(",");
				}
			}
			
		}
		System.out.print("]");

		
	}
	
	
	public static void exploreArrayObj(Object instance) {
		
		final Class<?> classz = instance.getClass();
		
		if(classz.isArray()) {
			
			final Class<?> componentType = classz.getComponentType();
			
			System.out.println(String.format("Class Name is: %s"
					+ " Array Type is : %s - %s ", 
					classz.getSimpleName(), 
					componentType,
					componentType.getTypeName()));
			
		}
		
	}

}
