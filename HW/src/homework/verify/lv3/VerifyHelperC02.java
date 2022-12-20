package homework.verify.lv3;


import verify.IdVerifyHelper;
import verify.VerifyResult;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VerifyHelperC02 extends IdVerifyHelper {

	@Override
	public List<VerifyResult> validate(String fileName) {

		File file = new File(fileName);

		try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), "UTF-8");
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);) {

			String line = null;
			List<VerifyResult> dataList = new ArrayList<VerifyResult>();

			while ((line = bufferedReader.readLine()) != null) {
				
				VerifyResult verifyResult = new VerifyResult();

				if (line.matches("[a-zA-Z0-9]+")) {
					if (line.length() == 10 && check(line)) {
						verifyResult.setVerifySuccess(true);
						verifyResult.setId(line);
						verifyResult.setMessage("驗證成功");

						dataList.add(verifyResult);
					} else {
						verifyResult.setVerifySuccess(false);
						verifyResult.setId(line);
						verifyResult.setMessage("驗證失敗");

						dataList.add(verifyResult);
					}
				} else {
					verifyResult.setVerifySuccess(false);
					verifyResult.setId(line);
					verifyResult.setMessage("驗證失敗");

					dataList.add(verifyResult);
				}
			}

			return dataList;
		} catch (
		UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.validate(fileName);
	}

}
