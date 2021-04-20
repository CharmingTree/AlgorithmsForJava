import java.util.Optional;

class Member {
	private String name;
	private String position;
	
	Member() {
		
	}
	
	Member(String name, String position) {
		this.name = name;
		this.position = position;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", position=" + position + "]";
	}
	
	
}


public class OptionalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Optional<Member> member = Optional.of(new Member("KKK", "44"));
		Optional<Member> member = Optional.of(new Member());
		
		System.out.println(member.orElse(null));
		
	}

}
