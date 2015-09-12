package com.jason.algrithm.other;
import java.math.BigInteger;

//大数相除，使用减法模拟，提高效率，可以将除数x100试，若大于被除数，则x50试一下，以此类推

public class BigNumberDiv {

	// 判断是否需要下一次循环
	public boolean hasNext(StringBuilder sba, StringBuilder sbb) {
		if(sba.length() > sbb.length())
			return true;
		
		if(sba.toString().compareTo(sbb.toString()) >=0){
			return true;
		}else{
			return false;
		}

	}

	// 相减
	public StringBuilder minus(StringBuilder sba, StringBuilder sbb) {

		int borrow = 0;
		int i = 0;
		for (i = 1; i <= sbb.length(); i++) {
			int bita = sba.charAt(sba.length() - i) - '0';
			int bitb = sbb.charAt(sbb.length() - i) - '0';

			if (bita < bitb) {
				bita = bita + 10 - bitb - borrow;
				borrow = 1;
			} else {
				bita = bita - bitb - borrow;
				borrow = 0;
			}

			char cBita = (char) ('0' + bita);
			sba.setCharAt(sba.length() - i, cBita);
		}
		// 最高位有借位
		while (borrow == 1) {
			int index = sba.length() - i;
			int bita = sba.charAt(index) - '0';
			if (bita > 0) {
				bita -= borrow;
				borrow = 0;
			} else {
				bita = bita + 10 - borrow;
				borrow = 1;
			}
			char cBita = (char) ('0' + bita);

			sba.setCharAt(index, cBita);
			i++;
		}
		
		sba = deleteStartZero(sba);
		
		return sba;
	}

	//去除最高位的0
	public StringBuilder deleteStartZero(StringBuilder sb){
		boolean startWithZero = true;
		int j=0;
		while(startWithZero){
			if(sb.charAt(j)=='0'){
				sb.deleteCharAt(j);
			}else{
				startWithZero = false;
			}
		}
		return sb;
	}
	
	public String division(String a, String b) {
		StringBuilder sba = new StringBuilder(a);
		StringBuilder sbb = new StringBuilder(b);

		sba = deleteStartZero(sba);
		sbb = deleteStartZero(sbb);
		
//		BigInteger result = new BigInteger("0");
//		BigInteger add = new BigInteger("1");
		
		long result = 0;
		
		while (hasNext(sba,sbb)) {
			minus(sba,sbb);
		//	result= result.add(add);
			result +=1;
		}
		if(sba.length()==0)
			sba.append("0");
		
		String resultStr = result+" "+sba.toString();
		System.out.println(resultStr);
		
		return resultStr;
	}
	
	public static void main(String [] args){
		BigNumberDiv solution = new BigNumberDiv();
	//	solution.division("7321", "98");
		
		String s1 = "123";
		String s2 = "12";
		System.out.println(s1.compareTo(s2));
	}
}