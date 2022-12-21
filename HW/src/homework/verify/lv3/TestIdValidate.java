package homework.verify.lv3;

import com.practice.idVerify.IdVerifyHelper;

public class TestIdValidate {

	public static void main(String[] args) {
		String fileName = "idList3.txt";
		IdVerifyHelper idVerifyHelper = new IdVerifyHelper(fileName);
		IdVerifyHelper idVerifyHelper1 = new VerifyHelperC01(fileName);
		IdVerifyHelper idVerifyHelper2 = new VerifyHelperC02(fileName);

		System.out.println(idVerifyHelper.validate(fileName));
		System.out.println("========================================================================");
		System.out.println(idVerifyHelper1.validate(fileName));
		System.out.println("========================================================================");
		System.out.println(idVerifyHelper2.validate(fileName));
	}

}
