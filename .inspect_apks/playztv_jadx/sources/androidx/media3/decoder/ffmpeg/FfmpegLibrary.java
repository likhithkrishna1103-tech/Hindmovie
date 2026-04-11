package androidx.media3.decoder.ffmpeg;

import p1.h0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class FfmpegLibrary {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f1542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f1543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f1544c;

    static {
        h0.a("media3.decoder.ffmpeg");
        f1542a = new e(0, new String[]{"ffmpegJNI"});
        f1544c = -1;
    }

    public static String a(String str) {
        str.getClass();
        switch (str) {
            case "audio/eac3-joc":
            case "audio/eac3":
                return "eac3";
            case "video/hevc":
                return "hevc";
            case "audio/amr-wb":
                return "amrwb";
            case "audio/vnd.dts":
            case "audio/vnd.dts.hd":
                return "dca";
            case "audio/vorbis":
                return "vorbis";
            case "audio/mpeg-L1":
            case "audio/mpeg-L2":
            case "audio/mpeg":
                return "mp3";
            case "audio/mp4a-latm":
                return "aac";
            case "audio/ac3":
                return "ac3";
            case "video/avc":
                return "h264";
            case "audio/3gpp":
                return "amrnb";
            case "audio/alac":
                return "alac";
            case "audio/flac":
                return "flac";
            case "audio/opus":
                return "opus";
            case "audio/true-hd":
                return "truehd";
            case "audio/g711-alaw":
                return "pcm_alaw";
            case "audio/g711-mlaw":
                return "pcm_mulaw";
            default:
                return null;
        }
    }

    public static int b() {
        if (!f1542a.a()) {
            return -1;
        }
        if (f1544c == -1) {
            f1544c = ffmpegGetInputBufferPaddingSize();
        }
        return f1544c;
    }

    public static String c() {
        if (!f1542a.a()) {
            return null;
        }
        if (f1543b == null) {
            f1543b = ffmpegGetVersion();
        }
        return f1543b;
    }

    public static boolean d(String str) {
        String strA;
        if (!f1542a.a() || (strA = a(str)) == null) {
            return false;
        }
        if (ffmpegHasDecoder(strA)) {
            return true;
        }
        s1.b.p("FfmpegLibrary", "No " + strA + " decoder available. Check the FFmpeg build configuration.");
        return false;
    }

    private static native int ffmpegGetInputBufferPaddingSize();

    private static native String ffmpegGetVersion();

    private static native boolean ffmpegHasDecoder(String str);
}
