package observer1;

import java.util.HashSet;
import java.util.Set;

/**
 * @name: Observer
 * @author: IhaveBB
 * @date: 2024-11-07 20:09
 **/
public abstract class Observer {
	private Set<CategoryEnum> categories = new HashSet<>();
	private String name;
	public abstract void response(CategoryEnum e);

	public Set<CategoryEnum> getCategories() {
		return categories;
	}

	public void addCategories(CategoryEnum category) {
		categories.add(category);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
