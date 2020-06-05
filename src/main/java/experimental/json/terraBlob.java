package experimental.json;

import com.uber.terrablob.client.*;

import java.io.File;

public class terraBlob {

    static final Integer PUT_TIMEOUT_SEC = 10;
    static final Integer GET_TIMEOUT_SEC = 10;


    public static void main(String[] args) {

        TerraBlobClient tbClient = new TerraBlobCliWrapper("tb-cli -s").withCerberus(true);
        upload(tbClient);
        download(tbClient);

    }

    private static void streamDownload(TerraBlobClient tbClient) {

        File downloadFile = new File("/Users/sudhanshu/Documents/practice/src/main/java/experimental/json/sample2.json");
        TerraBlobEntity entity = TerraBlobEntity.blob("/staging/sudhanshu/Glove_sample.json");
        GetOptions optsGet = new GetOptions().withTimeout(GET_TIMEOUT_SEC).withKraken(false);

        try {
            tbClient.get(entity, downloadFile, optsGet);
        } catch (TerraBlobException e) {
            System.out.println("Error downloading blob" + e);

            //LOG.error("Error downloading blob", e);
        }
    }

    private static void download(TerraBlobClient tbClient) {
        File downloadFile = new File("/Users/sudhanshu/Documents/practice/src/main/java/experimental/json/sample2.json");
        TerraBlobEntity entity = TerraBlobEntity.blob("/staging/sudhanshu/sample.json");
        GetOptions optsGet = new GetOptions().withTimeout(GET_TIMEOUT_SEC).withKraken(false);

        try {
            tbClient.get(entity, downloadFile, optsGet);
        } catch (TerraBlobException e) {
            System.out.println("Error downloading blob" + e);

            //LOG.error("Error downloading blob", e);
        }
    }

    private static void upload(TerraBlobClient tbClient) {
        File file = new File("/Users/sudhanshu/Documents/practice/src/main/java/experimental/json/sample.json");

        TerraBlobEntity entity = TerraBlobEntity.blob("/staging/sudhanshu/sample.json");
        PutOptions opts = new PutOptions().withTimeout(PUT_TIMEOUT_SEC).withKraken(false);

        try {
            tbClient.put(file, entity, opts);
        } catch (TerraBlobException e) {
            System.out.println("Error uploading blob" + e);
            //LOG.error("Error uploading blob", e);
        }
    }
}
