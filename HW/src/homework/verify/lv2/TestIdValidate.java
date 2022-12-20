package homework.verify.lv2;

import verify.IdVerifyHelper;

public class TestIdValidate {

    public static void main(String[] args) {
        String filePath = "idList2.txt";
        IdVerifyHelper idVerifyHelper = new IdVerifyHelper();
        System.out.println(idVerifyHelper.validate(filePath));
    }
}
