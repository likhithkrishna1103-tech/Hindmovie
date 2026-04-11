package j2;

import aa.c1;
import aa.g0;
import aa.j0;
import android.media.MediaCodecInfo;
import android.os.Build;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import p1.m0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap f6759a = new HashMap();

    public static void a(String str, ArrayList arrayList) {
        if ("audio/raw".equals(str)) {
            if (Build.VERSION.SDK_INT < 26 && Build.DEVICE.equals("R9") && arrayList.size() == 1 && ((p) arrayList.get(0)).f6710a.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                arrayList.add(p.i("OMX.google.raw.decoder", "audio/raw", "audio/raw", null, false, true, false, false));
            }
            Collections.sort(arrayList, new t(0, new k()));
        }
        if (Build.VERSION.SDK_INT >= 32 || arrayList.size() <= 1 || !"OMX.qti.audio.decoder.flac".equals(((p) arrayList.get(0)).f6710a)) {
            return;
        }
        arrayList.add((p) arrayList.remove(0));
    }

    public static String b(p1.q qVar) {
        Pair pairB;
        String str = qVar.f10023n;
        String str2 = qVar.f10023n;
        if ("audio/eac3-joc".equals(str)) {
            return "audio/eac3";
        }
        if ("video/dolby-vision".equals(str2) && (pairB = s1.e.b(qVar)) != null) {
            int iIntValue = ((Integer) pairB.first).intValue();
            if (iIntValue == 16 || iIntValue == 256) {
                return "video/hevc";
            }
            if (iIntValue == 512) {
                return "video/avc";
            }
            if (iIntValue == 1024) {
                return "video/av01";
            }
        }
        if ("video/mv-hevc".equals(str2)) {
            return "video/hevc";
        }
        return null;
    }

    public static String c(MediaCodecInfo mediaCodecInfo, String str, String str2) {
        for (String str3 : mediaCodecInfo.getSupportedTypes()) {
            if (str3.equalsIgnoreCase(str2)) {
                return str3;
            }
        }
        if (str2.equals("video/dolby-vision")) {
            if ("OMX.MS.HEVCDV.Decoder".equals(str)) {
                return "video/hevcdv";
            }
            if ("OMX.RTK.video.decoder".equals(str) || "OMX.realtek.video.decoder.tunneled".equals(str)) {
                return "video/dv_hevc";
            }
            return null;
        }
        if (str2.equals("video/mv-hevc")) {
            if ("c2.qti.mvhevc.decoder".equals(str) || "c2.qti.mvhevc.decoder.secure".equals(str)) {
                return "video/x-mvhevc";
            }
            return null;
        }
        if (str2.equals("audio/alac") && "OMX.lge.alac.decoder".equals(str)) {
            return "audio/x-lg-alac";
        }
        if (str2.equals("audio/flac") && "OMX.lge.flac.decoder".equals(str)) {
            return "audio/x-lg-flac";
        }
        if (str2.equals("audio/ac3") && "OMX.lge.ac3.decoder".equals(str)) {
            return "audio/lg-ac3";
        }
        return null;
    }

    public static synchronized List d(String str, boolean z2, boolean z10) {
        try {
            u uVar = new u(str, z2, z10);
            HashMap map = f6759a;
            List list = (List) map.get(uVar);
            if (list != null) {
                return list;
            }
            boolean zEquals = str.equals("video/mv-hevc");
            e6.i iVar = new e6.i();
            iVar.f4522u = (z2 || z10 || zEquals) ? 1 : 0;
            ArrayList arrayListE = e(uVar, iVar);
            if (z2 && arrayListE.isEmpty() && Build.VERSION.SDK_INT <= 23) {
                arrayListE = e(uVar, new t7.j(14));
                if (!arrayListE.isEmpty()) {
                    s1.b.p("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + ((p) arrayListE.get(0)).f6710a);
                }
            }
            a(str, arrayListE);
            j0 j0VarR = j0.r(arrayListE);
            map.put(uVar, j0VarR);
            return j0VarR;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0119 A[Catch: Exception -> 0x0163, TRY_ENTER, TryCatch #4 {Exception -> 0x0163, blocks: (B:3:0x000a, B:5:0x001f, B:7:0x0029, B:77:0x0138, B:10:0x0035, B:13:0x0040, B:71:0x0111, B:74:0x0119, B:76:0x011f, B:78:0x0140, B:79:0x0161), top: B:92:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0140 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList e(j2.u r20, j2.w r21) throws j2.v {
        /*
            Method dump skipped, instruction units count: 364
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j2.y.e(j2.u, j2.w):java.util.ArrayList");
    }

    public static c1 f(k kVar, p1.q qVar, boolean z2, boolean z10) {
        List listA = kVar.a(qVar.f10023n, z2, z10);
        String strB = b(qVar);
        List listA2 = strB == null ? c1.f650y : kVar.a(strB, z2, z10);
        g0 g0VarN = j0.n();
        g0VarN.d(listA);
        g0VarN.d(listA2);
        return g0VarN.g();
    }

    public static boolean g(MediaCodecInfo mediaCodecInfo, String str, boolean z2, String str2) {
        if (mediaCodecInfo.isEncoder()) {
            return false;
        }
        if (!z2 && str.endsWith(".secure")) {
            return false;
        }
        int i = Build.VERSION.SDK_INT;
        if (i < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && "samsung".equals(Build.MANUFACTURER))) {
            String str3 = Build.DEVICE;
            if (str3.startsWith("zeroflte") || str3.startsWith("zerolte") || str3.startsWith("zenlte") || "SC-05G".equals(str3) || "marinelteatt".equals(str3) || "404SC".equals(str3) || "SC-04G".equals(str3) || "SCV31".equals(str3)) {
                return false;
            }
        }
        return (i <= 23 && "audio/eac3-joc".equals(str2) && "OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str)) ? false : true;
    }

    public static boolean h(MediaCodecInfo mediaCodecInfo, String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            return mediaCodecInfo.isSoftwareOnly();
        }
        if (m0.k(str)) {
            return true;
        }
        String strX = com.bumptech.glide.d.X(mediaCodecInfo.getName());
        if (strX.startsWith("arc.")) {
            return false;
        }
        if (strX.startsWith("omx.google.") || strX.startsWith("omx.ffmpeg.")) {
            return true;
        }
        if ((strX.startsWith("omx.sec.") && strX.contains(".sw.")) || strX.equals("omx.qcom.video.decoder.hevcswvdec") || strX.startsWith("c2.android.") || strX.startsWith("c2.google.")) {
            return true;
        }
        return (strX.startsWith("omx.") || strX.startsWith("c2.")) ? false : true;
    }
}
