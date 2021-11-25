import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Random;

public class Main {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		
		Movie lotr = new Movie("LOTR", "Lord of the rings", LocalDate.of(2001, 06, 15), true, Category.ADVENTURE);
		exploreFieldProperties(lotr.getClass(), lotr);

	}
	
	public static <T> void exploreFieldProperties(Class<? extends T> classz, T instance) throws IllegalArgumentException, IllegalAccessException {
		
		final Field[] declaredFields = classz.getFields();
		
		for(Field field : declaredFields) {
			
			System.out.println(String.format("Class is: %s and Field Name is : %s with Field Type %s"
					+ " Value is %s ",
					classz.getSimpleName(), 
					field.getName(), 
					field.getGenericType().getTypeName(),
					field.get(instance)
					));
		}
		
	}
	
	public enum Category {
		ACTION, ADVENTURE, ROMANCE, COMEDY
	}
	
	
	public static class Product {
		
		private String id;
		private String name;
		private LocalDate effectiveFrom;
		public static final String GREETMESSAGE = "Greetings...";
		
		private Product() {
			super();
			// TODO Auto-generated constructor stub
		}

		private Product(String id, String name, LocalDate effectiveFrom) {
			super();
			this.id = id;
			this.name = name;
			this.effectiveFrom = effectiveFrom;
		}
		
	}
	
	public static class Movie extends Product {
		
		private boolean isReleased;
		private Category category;
		private final double MIN_PRICE = 10.99;
		private Random random = new Random();
		public static final String MESSAGE = "WELCOME";
		
		public Movie(String id, String name, LocalDate effectiveFrom, boolean isReleased, Category category) {
			super(id, name, effectiveFrom);
			this.isReleased = isReleased;
			this.category = category;
		}	
		
		
		public Movie(boolean isReleased, Category category) {
			super();
			this.isReleased = isReleased;
			this.category = category;
		}
		
	}
	
}
