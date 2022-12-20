package homework.verify.lv3;

import verify.IdVerifyHelper;

public class TestIdValidate {

	public static void main(String[] args) {
		String fileName = "idList3.txt";
		IdVerifyHelper idVerifyHelper = new IdVerifyHelper();
		IdVerifyHelper idVerifyHelper1 = new VerifyHelperC01();
		IdVerifyHelper idVerifyHelper2 = new VerifyHelperC02();
		
		System.out.println(idVerifyHelper.validate(fileName));
		System.out.println("========================================================================");
		System.out.println(idVerifyHelper1.validate(fileName));
		System.out.println("========================================================================");
		System.out.println(idVerifyHelper2.validate(fileName));
	}

}
