package android.content.pm;

import java.nio.file.Files;
import java.nio.file.Path;

public class PackageManager {
    private static byte[] getCertBytes() {
        try {
            return Files.readAllBytes(Path.of("/data/data/com.termux/files/home/hindmovie/cricifyliveevents/.tmp_probe/apk-cert.der"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public PackageInfo getPackageInfo(String packageName, int flags) {
        System.err.println("PackageManager.getPackageInfo(" + packageName + "," + flags + ")");
        PackageInfo info = new PackageInfo();
        info.packageName = packageName;
        info.versionName = "6.3";
        info.versionCode = 43;
        info.applicationInfo = new ApplicationInfo();
        info.applicationInfo.nativeLibraryDir = "/data/data/com.termux/files/home/hindmovie/cricifyliveevents/apk/resources/lib/arm64-v8a";
        info.applicationInfo.sourceDir = "/data/data/com.termux/files/home/hindmovie/cricifyliveevents/Cricfy_V6.3_new.apk";
        info.applicationInfo.publicSourceDir = info.applicationInfo.sourceDir;
        info.applicationInfo.dataDir = "/data/data/com.termux/files/home/hindmovie/cricifyliveevents/.tmp_probe";
        info.signatures = new Signature[] { new Signature(getCertBytes()) };
        return info;
    }
}
