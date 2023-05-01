package MODEL;

public abstract class Character extends Creature {
//캐릭터 추상 클래스
	
	public Character(int hp, int op, int dp) {
		super(hp, op, dp);
		// TODO Auto-generated constructor stub
	}
	
	public abstract void ItemUse();
	
	public abstract void ItemUnUse();

}
