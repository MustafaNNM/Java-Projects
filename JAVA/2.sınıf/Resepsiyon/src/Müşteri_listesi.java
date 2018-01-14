public class Müþteri_listesi {
	private static String[] ad_listesi = { "ALÝ", "AYÞE", "AHMET", "ADNAN",
			"ARIF", "ALIM", "ADIL", "AKÝF", "ALEV", "AFET", "BELGIN", "BELKIS",
			"BETUL", "BURCU", "BENGU", "BASAK", "BARIKA", "BUSRA", "BINNUR",
			"BIHTER", "CANSU", "CANAN", "CAFER", "CEMIL", "CEMIL", "CEZMI",
			"CUMHUR", "DELIL", "DILA", "DILEK", "DOGAN", "BARIS", "ERHAN",
			"MEHMET", "SAID", "FATIH", "MUSTAFA", "YASIN", "RAMAZAN", "ILAYDA",
			"MUSLUM", "BUSE", "YUSUF", "BEYZA", "HILAL", "ESRA", "NEJLA",
			"BUREYDE", "OMER", "OMAR", "ABRAHAM", "CAHID", "KEMAL", "GOZDE",
			"OZGE", "ILYAS", "ILAYDA", "IREM", "GIZEM", "KIYMET", "FULYA",
			"GUL", "GOKCE", "SEBNEM", "ECE", "SIMGE", "MELTEM", "OYKU",
			"DENIZ", "CEREN", "AYDAN", "ESIN", "FATMA", "PINAR", "IKBAL",
			"RABIA", "TAHA", "CAGRI", "MESUT", "ERCAN", "NURAN", "NURCAN",
			"NAZAN", "BERAT", "SALIH", "YIGIT", "CETIN", "ERMAN", "HALIL",
			"CEM", "CAGDAS", "ERTAN", "MUZAFFER", "ENGIN", "BURAK", "SULEYMAN",
			"UGUR", "DENIZ", "BUYANDELGER", "BAHTIYAR" };
	private static String[] soyad_listesi = { "AKARSU", "GURSES", "ATATURK",
			"ERSOY", "TATLISES", "GUNAY", "SALMAN", "TAHSIN", "BORAN",
			"TAYLAN", "DOSTER", "UNALAN", "SARANAYEV", "ALTINBAS", "ERDEN",
			"ÝLYASOÐULLARI", "KAPTANOGULLARI", "FIRINCIOGULLARI", "KARAARSLAN",
			"KARAASLAN", "CINAL", "AYKUT", "SONMEZ", "SEKER", "BALCI", "CETIN",
			"SADIGOV", "GUL", "ERDOGAN", "INCECAY", "MEMILI", "DABAN",
			"AHMADSOY", "KOKTURK", "TURK", "TUTUNCU", "SARI", "MUTI", "KAYA",
			"COSKUNER", "KONUK", "BAYRAKTAR", "CELEGEN", "ABACI", "KUPELI",
			"GULTEKIN", "SARICAM", "OZMEN", "KARADON", "KAPTIKACTI", "PAR",
			"PEKACAR", "YIGIT", "YUCEL", "YUKSEL", "AYGUN", "DOGAN", "TUYJI",
			"YAZAL", "OZTURK", "OZEN", "AYAZ", "NEHIR", "TUREMIS", "ISIK",
			"ERCAN", "CICEK", "BAL", "CILEK", "GENERAL", "AVEA", "ARIA",
			"TURKSELIM", "KANDEMIR", "BILMUH", "EGE", "IZMIRLI", "MARASLI",
			"TARAKCIOGLU", "SOZEN", "NEHIR", "CALISKAN", "OZCALISKAN", "CAVUS",
			"ALTANBAGANA", "KANDEMIR", "CANDEMIR", "BUDA", "GELIR", "GECER",
			"EKIZ", "YALCIN", "ERGUVAN", "DALKIRAN", "UNVER", "BERBER",
			"KUCUK", "KIZILAY", "KIZILKAYA", "GOKTURK" };

	public String random_ad() {
		// Rastgele ad üretir
		return ad_listesi[Random.random(ad_listesi.length)];
	}

	public String random_soyad() {
		// Rastgele soyad üretir
		return soyad_listesi[Random.random(soyad_listesi.length)];
	}

	public static String[] getAd_listesi() {
		return ad_listesi;
	}

	public static void setAd_listesi(String[] ad_listesi) {
		Müþteri_listesi.ad_listesi = ad_listesi;
	}

	public static String[] getSoyad_listesi() {
		return soyad_listesi;
	}

	public static void setSoyad_listesi(String[] soyad_listesi) {
		Müþteri_listesi.soyad_listesi = soyad_listesi;
	}

}
