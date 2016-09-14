public class Movie {
	private String name;
	int id;
	String movieType;
	double price = 0;

	public Movie(String name, String type) {
		this.name = name;
		this.movieType = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice(int day) {
		price = 0;
		switch (movieType) {
		case "regular":
			price += 2;
			if (day > 2)
				price += 4;
			break;
		case "childrens":
			price = 5.0;
			break;
		}
		return price;

	}
}
