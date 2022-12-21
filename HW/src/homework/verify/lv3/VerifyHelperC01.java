package homework.verify.lv3;

import com.practice.idVerify.IdVerifyHelper;
import com.practice.idVerify.VerifyResult;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class VerifyHelperC01 extends IdVerifyHelper {

    public VerifyHelperC01(String filename) {
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
            Boolean extent = id.length() == 10;
            Boolean format = id.matches("[A-Z]\\d{2}(\\d{4})\\d{3}");

            if (extent.equals(false) && format.equals(false)) {
                verifyResult.setVerifySuccess(false);
                verifyResult.setId(id);
                verifyResult.setMessage("證號長度不為10、證號格式錯誤");
                dataList.add(verifyResult);
            } else if (extent && format) {
                if (check(id)) {
                    verifyResult.setVerifySuccess(true);
                    verifyResult.setId(id);
                    verifyResult.setMessage("驗證成功");
                } else {
                    verifyResult.setVerifySuccess(false);
                    verifyResult.setId(id);
                    verifyResult.setMessage("驗證失敗");
                }
                dataList.add(verifyResult);
            } else if (extent.equals(false)) {
                verifyResult.setVerifySuccess(false);
                verifyResult.setId(id);
                verifyResult.setMessage("證號長度不為10");
                dataList.add(verifyResult);
            } else if (format.equals(false)) {
                verifyResult.setVerifySuccess(false);
                verifyResult.setId(id);
                verifyResult.setMessage("證號格式錯誤");
                dataList.add(verifyResult);
            }
        }

        return dataList;
    }

}
