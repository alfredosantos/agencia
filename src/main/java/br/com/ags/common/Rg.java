package br.com.ags.common;

public class Rg {
	String rg;

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		rg = rg;
	}

	private Rg (String rg){
		this.rg = rg;
	}

	public static Rg of (String rg) throws Exception{
		if (isRg(rg)){
			return new Rg(rg);
		}
		throw new Exception("Rg Inválido");
	}
	
	/**
	 * Validação de RG para região SSP
	 * @param num_rg
	 * @return
	 */
	private static boolean isRg(String num_rg) {
		num_rg = num_rg.replace(".", "");
		num_rg = num_rg.replace("-", "");

		if (num_rg.length() < 9) {
			return false;
		} else {
			int[] validador = new int[] { 2, 3, 4, 5, 6, 7, 8, 9, 100};
			int[] rg = new int[num_rg.length()];
			int soma = 0;

			for (int i = 0; i < rg.length; i++) {
				rg[i] = Integer.parseInt(String.valueOf(num_rg.charAt(i)));
				if (i < (rg.length)) {
					soma += (rg[i] * validador[i]);
				}
			}
			int result = soma % 11;
			if ((result) == 0) {
				return true;
			} else {
				return false;
			}
		}

	}

	@Override
	public String toString() {
		return "Rg [Rg=" + rg + "]";
	}

}
