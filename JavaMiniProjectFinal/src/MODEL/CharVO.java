package MODEL;

public class CharVO {

	
	private String nick;
	private int hp;
	private int stress;
	private int exp;
	
	public CharVO(String nick, int exp, int stress, int hp) {
		this.nick = nick;
		this.hp = hp;
		this.stress = stress;
		this.exp = exp;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getStress() {
		return stress;
	}

	public void setStress(int stress) {
		this.stress = stress;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}
	
}
