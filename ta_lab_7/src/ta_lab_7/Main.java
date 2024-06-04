package ta_lab_7;

import java.util.Random;

public class Main {
	public static String randomString(int bound) {
		StringBuffer sb = new StringBuffer();
		Random r = new Random();
		for(int i = 0; i < bound; ++i)
			sb.append((char)(r.nextInt((int)('z') - (int)('A')) + (int)'A'));
		return sb.toString();
	}
	
	
	 public static void main(String[] args) {
		HashStructure hs = new HashStructure(100);
		Pair p = new Pair(randomString(20), randomString(200));
		hs.insert(p);
		for(int i = 0; i < 100 - 1; ++i) {

			hs.insert(new Pair(randomString(20), randomString(200)));
		}
		Pair p1 = hs.search(p.key);
		System.out.println(p1.key + '\n' + p1.value );
		
		HashStructure hs1 = new HashStructure(100);
		hs1.insert(p);
		for(int i = 0; i < 1000 - 1; ++i) {

			hs1.insert(new Pair(randomString(20), randomString(200)));
		}
		p1 = hs.search(p.key);
		System.out.println(p1.key + '\n' + p1.value );		
		
		HashStructure hs2 = new HashStructure(100);
		hs2.insert(p);
		for(int i = 0; i < 5000 - 1; ++i) {

			hs2.insert(new Pair(randomString(20), randomString(200)));
		}
		p1 = hs2.search(p.key);
		System.out.println(p1.key + '\n' + p1.value );	
			
		HashStructure hs3 = new HashStructure(100);
		hs3.insert(p);
		for(int i = 0; i < 10000 - 1; ++i) {

			hs3.insert(new Pair(randomString(20), randomString(200)));
		}
		p1 = hs2.search(p.key);
		System.out.println(p1.key + '\n' + p1.value );		
		HashStructure hs4 = new HashStructure(100);
		hs4.insert(p);
		for(int i = 0; i < 20000 - 1; ++i) {

			hs4.insert(new Pair(randomString(20), randomString(200)));
		}
		p1 = hs4.search(p.key);
		System.out.println(p1.key + '\n' + p1.value );	
}
}
