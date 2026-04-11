package com.google.android.gms.common.api;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.File;

public class GoogleScopes {
    static {
        System.load("/data/data/com.termux/files/home/hindmovie/cricifyliveevents/apk/resources/lib/arm64-v8a/libnative-lib.so");
    }

    public static native byte[] Ninty(Object context, String str);

    public static final class FakeContext {
        public String getPackageName() {
            return "app.cricfy.tv";
        }

        public FakeContext getApplicationContext() {
            return this;
        }

        public ClassLoader getClassLoader() {
            return FakeContext.class.getClassLoader();
        }

        public String getPackageResourcePath(Object ignored) {
            return getPackageCodePath();
        }

        public String getOpPackageName() {
            return getPackageName();
        }

        public File getFilesDir() {
            return new File("/data/data/com.termux/files/home/hindmovie/cricifyliveevents/.tmp_probe");
        }

        public File getCacheDir() {
            return new File("/data/data/com.termux/files/home/hindmovie/cricifyliveevents/.tmp_probe");
        }

        public String getPackageCodePath() {
            return "/data/data/com.termux/files/home/hindmovie/cricifyliveevents/Cricfy_V6.3_new.apk";
        }

        public String getPackageResourcePath() {
            return getPackageCodePath();
        }

        public android.content.pm.PackageManager getPackageManager() {
            System.err.println("FakeContext.getPackageManager()");
            return new android.content.pm.PackageManager();
        }

        public android.content.pm.ApplicationInfo getApplicationInfo() {
            android.content.pm.ApplicationInfo info = new android.content.pm.ApplicationInfo();
            info.nativeLibraryDir = "/data/data/com.termux/files/home/hindmovie/cricifyliveevents/apk/resources/lib/arm64-v8a";
            info.sourceDir = getPackageCodePath();
            info.publicSourceDir = getPackageCodePath();
            info.dataDir = "/data/data/com.termux/files/home/hindmovie/cricifyliveevents/.tmp_probe";
            return info;
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            throw new IllegalArgumentException("expected path to encoded file");
        }

        String encoded = Files.readString(Path.of(args[0]), StandardCharsets.UTF_8).trim();
        byte[] decoded = Ninty(new FakeContext(), encoded);
        System.out.println(decoded.length);
        System.out.println(new String(decoded, StandardCharsets.UTF_8));
    }
}
