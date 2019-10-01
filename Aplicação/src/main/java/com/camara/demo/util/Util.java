package com.camara.demo.util;

public class Util {
	
	public Util() {
		
	}
	
	public boolean verificaDni(String dni) {
		// TODO Auto-generated method stub
		if(dni.length() != 11) {
			return false;
		}
		for(int i = 0; i < dni.length(); i++) {
			if((dni.charAt(i) != '0' && dni.charAt(i) != '1'
					&& dni.charAt(i) != '2' && dni.charAt(i) != '3'
					&& dni.charAt(i) != '4' && dni.charAt(i) != '5'
					&& dni.charAt(i) != '6' && dni.charAt(i) != '7'
					&& dni.charAt(i) != '8' && dni.charAt(i) != '9') && dni.charAt(i) != '-') {
				return false;
			}
		}
		return true;
	}
	
	public boolean verificaData(String data) {
		// TODO Auto-generated method stub
		for(int i = 0; i < data.length(); i++) {
			if((data.charAt(i) != '0' && data.charAt(i) != '1'
					&& data.charAt(i) != '2' && data.charAt(i) != '3'
					&& data.charAt(i) != '4' && data.charAt(i) != '5'
					&& data.charAt(i) != '6' && data.charAt(i) != '7'
					&& data.charAt(i) != '8' && data.charAt(i) != '9') && data.charAt(i) != '/') {
				return false;
			}
		}
		return true;
	}

}
