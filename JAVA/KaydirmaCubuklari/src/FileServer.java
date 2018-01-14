
public class FileServer {

	private static KaydirmaCubuklari a;

	public static void main(String[] args) {
		setA(new KaydirmaCubuklari());
		
		
	}

	public static KaydirmaCubuklari getA() {
		return a;
	}

	public static void setA(KaydirmaCubuklari a) {
		FileServer.a = a;
	}

}
