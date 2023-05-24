package homework.verify.lv2;

import com.practice.idVerify.IdVerifyHelper;

public class TestIdValidate {

    public static void main(String[] args) {
        IdVerifyHelper idVerifyHelper = new IdVerifyHelper("idList.txt");
        System.out.println(idVerifyHelper.validate());
        System.out.println(idVerifyHelper.validate("idList1.txt"));
    }
}
