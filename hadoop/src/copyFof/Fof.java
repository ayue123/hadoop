package copyFof;
//去除相同项。
public class Fof {
	public String Format(String friend1,String friend2){
		int c = friend1.compareTo(friend2);
		
		if(c<0){
			return friend1 +"-"+friend2;
		}
		return friend2 +"-"+friend1;
	}
}
