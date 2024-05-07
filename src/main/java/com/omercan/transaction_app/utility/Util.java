package com.omercan.transaction_app.utility;

import java.util.List;

import javax.swing.JOptionPane;

public final class Util 
{
	private static final int TCKN_HANE = 11;
	
	private Util() {}
	
	// kaynak: Ahmet Bütün
	public static boolean isValidTCKN(String TCKN) {
		if (null != TCKN && TCKN.matches("^([1-9]{1}[0-9]{10})$")) {
			return isValidTCKN(Long.valueOf(TCKN));
		}

		return false;
	}

	private static boolean isValidTCKN(Long TCKN) {
		String tmp = TCKN.toString();

		if (tmp.length() == TCKN_HANE) {
			int totalOdd = 0;

			int totalEven = 0;

			for (int i = 0; i < 9; i++) {
				int val = Integer.valueOf(tmp.substring(i, i + 1));

				if (i % 2 == 0) {
					totalOdd += val;
				} else {
					totalEven += val;
				}
			}

			int total = totalOdd + totalEven + Integer.valueOf(tmp.substring(9, 10));

			int lastDigit = total % 10;

			if (tmp.substring(10).equals(String.valueOf(lastDigit))) {
				int check = (totalOdd * 7 - totalEven) % 10;

				if (tmp.substring(9, 10).equals(String.valueOf(check))) {
					return true;
				}
			}
		}

		return false;
	}
	
	public static void showGeneralExceptionInfo(Exception e)
	{


		System.out.println(createGeneralExceptionInfo(e));
	}
	
	public static String createGeneralExceptionInfo(Exception e)
	{
		return e.getClass().getSimpleName() + " has been occured. Exception message: " + e.getMessage();
	}
	

	

	public static String getAddressInfo(Object obj)
	{
		return "hashcode: " + obj.hashCode() + " and address: " + Integer.toHexString(obj.hashCode());
	}
	
	public static <E> void showList(List<E> list)
	{
		if(list != null)
		{
			for (E entity : list) 
			{
				System.out.println(entity);
			}
		}
		else
		{
			System.out.println("List is null");
		}
	}
	
	public static <E> void showArray(E[] arr)
	{
		for (E entity : arr)
		{
			System.out.println(entity);
		}
	}
}
