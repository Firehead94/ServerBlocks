package com.firehead.serverblocks.utils;

public class Colors {
	public static final int WHITE = 15790320;
	public static final int ORANGE = 15435844;
	public static final int MAGENTA = 12801229;
	public static final int LIGHT_BLUE = 6719955;
	public static final int YELLOW = 14602026;
	public static final int LIME = 4312372;
	public static final int PINK = 14188952;
	public static final int GRAY = 4408131;
	public static final int LIGHT_GRAY = 11250603;
	public static final int CYAN = 2651799;
	public static final int PURPLE = 8073150;
	public static final int BLUE = 2437522;
	public static final int BROWN = 5320730;
	public static final int GREEN = 3887386;
	public static final int RED = 11743532;
	public static final int BLACK = 1973019;
	
	public String getColorRGBToHex(int r, int g, int b) {
		return String.format("#%02x%02x%02x", r, g, b);
	}
	
	public String getColorIntToHex(int num) {
		return String.format("%06X", (0xFFFFFF & num));
	}
	
	public int getColorHexToInt(String hex) {
		return Integer.parseInt(hex, 16);
	}
	 public int getColorRGBToInt(int r, int g, int b) {
		 return getColorHexToInt(getColorRGBToHex(r, g, b));
	 }

}
