package allchapters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import allchapters.Animal.AnimalBuilder;

public class EdImmutableBuilderAnimal {

	public static void main(String[] args) {
		AnimalBuilder ab = new AnimalBuilder();
		Animal lion = ab
			.setAge(5)
			.setFavFoods(Arrays.asList("meat", "bones"))
			.build();
		System.out.println("Lion:" + lion);

		Animal tiger = new AnimalBuilder()
				.setAge(51)
				.setFavFoods(Arrays.asList("meats", "boneses"))
				.build();
		System.out.println("Tiger:" + tiger);
	}

}

class Animal {
	private final int age;
	private final List<String> favFoods;
	private Animal (int age, List<String> favFoods) {
		 this.age = age;
		 if (favFoods == null) {
			 throw new RuntimeException("Fav foods is required!");
		 } else {
			 this.favFoods = new ArrayList<String> (favFoods);
		 }
	 }
	public int getAge() {
		return age;
	}
	public int getFavFoodsCount() {
		return favFoods.size();
	}
	public String getFavFoods(int index) {
		return favFoods.get(index);
	}
	
	@Override
	public String toString() {
		return "Animal [age=" + age + ", favFoods=" + favFoods + "]";
	}

	public static class AnimalBuilder {
		private int age;
		private List<String> favFoods;
		
		public AnimalBuilder() {}
		
		public AnimalBuilder setAge(int age) {
			this.age = age;
			return this;
		}
		public AnimalBuilder setFavFoods(List<String> favFoods) {
			this.favFoods = favFoods;
			return this;
		}
		public Animal build() {
			return new Animal(age, favFoods);
		}

	}

}