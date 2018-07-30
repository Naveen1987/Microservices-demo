package Singleton;

public class DesignSilton {
	public static void main(String[] args) {
		InnerSiglton a = InnerSiglton.getIntance();
		System.out.println(" A " + a.hashCode());
		InnerSiglton aa = InnerSiglton.getIntance();
		System.out.println(" A " + aa.hashCode());
	}

}

class InnerSiglton{
	static InnerSiglton a = new InnerSiglton();
	private InnerSiglton(){}
	static InnerSiglton getIntance()
 	{return a;}
 	
}
