package homework.verify.lv3;

import com.practice.idVerify.IdVerifyHelper;
import com.practice.idVerify.VerifyResult;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class VerifyHelperC02 extends IdVerifyHelper {

    public VerifyHelperC02(String filename) {
        super(filename);
    }

    @Override
    public List<VerifyResult> validate(String fileName) {
        String content = null;
        try {
            content = Files.readString(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] idList = content.split("\r\n");
        List<VerifyResult> dataList = new ArrayList<>();

        for (int i = 0; i < idList.length; i++) {
            String id = idList[i];
            VerifyResult verifyResult = new VerifyResult();

            if (id.matches("[a-zA-Z0-9]+")) {
                if (id.length() == 10 && check(id)) {
                    verifyResult.setVerifySuccess(true);
                    verifyResult.setId(id);
                    verifyResult.setMessage("驗證成功");

                    dataList.add(verifyResult);
                } else {
                    verifyResult.setVerifySuccess(false);
                    verifyResult.setId(id);
                    verifyResult.setMessage("驗證失敗");

                    dataList.add(verifyResult);
                }
            } else {
                verifyResult.setVerifySuccess(false);
                verifyResult.setId(id);
                verifyResult.setMessage("證號格式錯誤");

                dataList.add(verifyResult);
            }
        }

        return dataList;
    }


}
