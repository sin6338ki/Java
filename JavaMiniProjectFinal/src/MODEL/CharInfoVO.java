package MODEL;

public class CharInfoVO {
	
	private String nick;
	private String developer;
	private String dbEngineer;
	private String aiDeveloper;
	
	public CharInfoVO(String nick) {
		this.nick = nick;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	public String getDbEngineer() {
		return dbEngineer;
	}

	public void setDbEngineer(String dbEngineer) {
		this.dbEngineer = dbEngineer;
	}

	public String getAiDeveloper() {
		return aiDeveloper;
	}

	public void setAiDeveloper(String aiDeveloper) {
		this.aiDeveloper = aiDeveloper;
	}

}
