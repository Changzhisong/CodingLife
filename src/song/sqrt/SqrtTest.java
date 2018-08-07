package song.sqrt;

import java.util.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.NetworkInterface;

public class SqrtTest {

	public static void main(String[] args) {
//		BinarySqrt();

//		// digui //求卡特兰数
//		for (int i = 1; i <= 50; i++) {
//			System.out.println(i + "'s Catalan Number is " + CatalanNumber(i).toBigInteger());
//		}

//		//
//		int numberOfCatalan = 1010; // 要求多少个卡特兰数
//		BigInteger[] digis = new BigInteger[numberOfCatalan];
//		digis = generateCatalan(numberOfCatalan);
//		Scanner scanner = new Scanner(System.in);
//		int number;
//		while (true) {
//			number = scanner.nextInt();
//			if (number == -1)
//				break;
//			String answer = digis[number].toString();
//			System.out.println(answer);
//		}
		
		
//		System.out.println(Math.pow(0, -1));
		
		
		
//		System.out.println(new BigInteger("6").gcd(new BigInteger("-6")));//6和9的最大公约数
//		System.out.println(calPrime(10));
	
		
		System.out.println(getMacAddress());
	}
	
	
	public static String getMacAddress() {
	    try {
	      Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
	      byte[] mac = null;
	      while (allNetInterfaces.hasMoreElements()) {
	        NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
	        if (netInterface.isLoopback() || netInterface.isVirtual() || !netInterface.isUp()) {
	          continue;
	        } else {
	          mac = netInterface.getHardwareAddress();
	          if (mac != null) {
	            StringBuilder sb = new StringBuilder();
	            for (int i = 0; i < mac.length; i++) {
	              sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
	            }
	            if (sb.length() > 0) {
	              return sb.toString();
	            }
	          }
	        }
	      }
	    } catch (Exception e) {
	      
	    }
	    return "";
	  }


	public static void BinarySqrt() {
		int A = 10;
		System.out.println(Math.sqrt(A)); // 底层是c实现的

		double a = 0;
		double b = A + 0.25;
		double p = 0.00001;
		int n = 5;
		while ((b - a) > p) {
			double mid = (a + b) / 2;
			if ((mid * mid - A) * (b * b - A) < 0) {
				a = mid;
			} else {
				b = mid;
			}
		}
		// System.out.println(1/p);
		System.out.println(a);
		System.out.println(b);
		System.out.println(b - a);
		System.out.println((int) ((a) * Math.pow(10, n) % 10));

	}
	
	// 递推循环产生卡特兰数
	static BigInteger[] generateCatalan(int numberOfCatalan) {
		BigInteger digis[] = new BigInteger[numberOfCatalan + 1];
		BigInteger x = new BigInteger("1"); // 第一个卡特兰数为1
		digis[1] = x;
		int y = 0;
		int z = 0;
		
		for (int counter = 2; counter <= numberOfCatalan; ++counter) {
			y = 4 * counter - 2;
			z = counter + 1;
			digis[counter] = digis[counter - 1].multiply(new BigInteger("" + y));
			digis[counter] = digis[counter].divide(new BigInteger("" + z));
		}
		return digis;
	}

	// 使用递归的方式产生卡特兰数
	public static BigDecimal CatalanNumber(int n) {
		if (n == 1) {
			return new BigDecimal("1");
		} else {
			return CatalanNumber(n - 1).multiply(new BigDecimal( 2 * (2 * n - 1) / ((1.0)*(n + 1))+""));
		}
	}
   
	
	public static int calPrime(int n){
        if(n<=1){
            return 0;
        }
        byte[] origin = new byte[n+1];
        int count = 0;
        for(int i=2;i<n+1;i++){
            if(origin[i] == 0){
                count++;
                int k = 2;
                while(i*k<=n){
                    origin[i*k] = 1; 
                    k++;
                }
            }else{
                continue;
            }
        }
        for(byte b:origin){
        	System.out.println(b);
        }
        return count;
    }
}
