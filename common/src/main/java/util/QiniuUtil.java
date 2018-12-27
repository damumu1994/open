package util;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;
import org.apache.commons.io.IOUtils;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/6/8 0008.
 */
public class QiniuUtil {

    private static final String AK = MyConstants.QINIU_ACCESS_KEY;
    private static final String SK = MyConstants.QINIU_SECRET_KEY;
    private static final Auth auth = Auth.create(AK, SK);
    private static final Configuration cfg = new Configuration(Zone.zone2());
    private static final BucketManager bucketManager = new BucketManager(auth, cfg);
    private static final String bucketName = "gongyitech-app";

    /**
     * get Uptoken
     *
     * @return
     */
    public static String getUpToken() {
        return auth.uploadToken(bucketName);
    }

    /**
     *
     *upfile
     * @param fileName
     * @param file
     * @return
     */
    public static boolean uploadFile(String fileName, File file) {
        boolean b = false;
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(file.toURI()));
            b = uploadFile(fileName, bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    /**
     *
     *upfile
     * @param fileName
     * @param is
     * @return
     */
    public static boolean uploadFile(String fileName, InputStream is) {
        boolean b = false;
        try {
            byte[] bytes = IOUtils.toByteArray(is);
            b = uploadFile(fileName, bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    /**
     * upfile
     *
     * @param fileName
     * @param bytes
     * @return
     */
    public static boolean uploadFile(String fileName, byte[] bytes) {
        boolean bol = false;
        if (bytes != null && fileName != null) {
            UploadManager uploadManager = new UploadManager(cfg);
            String token = auth.uploadToken(bucketName);
            try {
                Response r = uploadManager.put(bytes, fileName, token);
                bol = r.isOK();
            } catch (QiniuException e) {
                e.printStackTrace();
            }
        }
        return bol;
    }

    /**
     * delfile
     *
     * @param key
     * @return
     */
    public static boolean delFile(String key) {
        try {
            bucketManager.delete(bucketName, key);
            return true;
        } catch (Exception e) {
            System.out.println("Qiniu Error Key - " + key);
            return false;
        }
    }

    /**
     * get file list
     *
     * @param prefix qianzui
     * @return
     */
    public static List<FileInfo> getFileList(String prefix) {
        List<FileInfo> list = new ArrayList<>();
        try {
            BucketManager.FileListIterator it = bucketManager.createFileListIterator(bucketName, prefix, 1000, null);
            while (it.hasNext()) {
                FileInfo[] items = it.next();
                if (items == null) {
                    break;
                }
                for (FileInfo item : items) {
                    if (item != null) {
                        list.add(item);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        String name= MyConstants.idWorkerUtil.nextId()+".png";
        String testName="test_"+MyConstants.idWorkerUtil.nextId()+".png";
        //chuan

        List<FileInfo> list = QiniuUtil.getFileList("boy_");
      //  System.out.printf(JsonUtil.getJson(list.get(0)));
    }
}
