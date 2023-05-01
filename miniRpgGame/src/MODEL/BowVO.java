package MODEL;

public class BowVO extends ItemVO{
//	활 VO (아이템 상속)
	
	private int durability; //고유속성 : 내구도
	
	public BowVO(int itemNum, String name, int attackPower, int durability) {
		super(itemNum, name, attackPower);
		this.durability = durability;
	}

	public int getDurability() {
		return durability;
	}

	public void setDurability(int durability) {
		this.durability = durability;
	}
	
	

}
