package templet;

public class ServiceImpi implements Service {

	@Override
	public boolean ticketing(String id, String pw) {
		if ("root".equals(id) && "1234".equals(pw)) {

			return true;
		} else {
			return false;

		}

	}
}