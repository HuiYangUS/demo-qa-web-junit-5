package pojos.api;

public class Joke {

	public String type;
	public String setup;
	public String punchline;
	public int id;

	public Joke() {
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return String.format("{type=%s, setup=%s, punchline=%s, id=%d}", type, setup, punchline, id);
	}

	public boolean equals(Object object) {
		if (object instanceof Joke)
			return object.toString().equals(this.toString());
		return false;
	}

}
