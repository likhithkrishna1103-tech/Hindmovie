package p2;

import android.media.MediaCodecInfo;
import android.os.Build;
import android.util.Pair;
import f9.b0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import ua.f0;
import ua.i0;
import ua.z0;
import v1.m0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap f9976a = new HashMap();

    public static void a(String str, ArrayList arrayList) {
        if ("audio/raw".equals(str)) {
            if (Build.VERSION.SDK_INT < 26 && Build.DEVICE.equals("R9") && arrayList.size() == 1 && ((o) arrayList.get(0)).f9925a.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                arrayList.add(o.i("OMX.google.raw.decoder", "audio/raw", "audio/raw", null, false, true, false, false));
            }
            Collections.sort(arrayList, new s(0, new j()));
        }
        if (Build.VERSION.SDK_INT >= 32 || arrayList.size() <= 1 || !"OMX.qti.audio.decoder.flac".equals(((o) arrayList.get(0)).f9925a)) {
            return;
        }
        arrayList.add((o) arrayList.remove(0));
    }

    public static String b(v1.p pVar) {
        Pair pairB;
        String str = pVar.f12946n;
        String str2 = pVar.f12946n;
        if ("audio/eac3-joc".equals(str)) {
            return "audio/eac3";
        }
        if ("video/dolby-vision".equals(str2) && (pairB = y1.e.b(pVar)) != null) {
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

    public static synchronized List d(String str, boolean z10, boolean z11) {
        try {
            t tVar = new t(str, z10, z11);
            HashMap map = f9976a;
            List list = (List) map.get(tVar);
            if (list != null) {
                return list;
            }
            ArrayList arrayListE = e(tVar, new ag.o(z10, z11, str.equals("video/mv-hevc")));
            if (z10 && arrayListE.isEmpty() && Build.VERSION.SDK_INT <= 23) {
                arrayListE = e(tVar, new b0(20));
                if (!arrayListE.isEmpty()) {
                    y1.b.p("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + ((o) arrayListE.get(0)).f9925a);
                }
            }
            a(str, arrayListE);
            i0 i0VarK = i0.k(arrayListE);
            map.put(tVar, i0VarK);
            return i0VarK;
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
    public static java.util.ArrayList e(p2.t r20, p2.v r21) throws p2.u {
        /*
            Method dump skipped, instruction units count: 364
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p2.x.e(p2.t, p2.v):java.util.ArrayList");
    }

    public static z0 f(j jVar, v1.p pVar, boolean z10, boolean z11) {
        List listA = jVar.a(pVar.f12946n, z10, z11);
        String strB = b(pVar);
        List listA2 = strB == null ? z0.f12413z : jVar.a(strB, z10, z11);
        f0 f0VarJ = i0.j();
        f0VarJ.d(listA);
        f0VarJ.d(listA2);
        return f0VarJ.g();
    }

    public static boolean g(MediaCodecInfo mediaCodecInfo, String str, boolean z10, String str2) {
        if (mediaCodecInfo.isEncoder()) {
            return false;
        }
        if (!z10 && str.endsWith(".secure")) {
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
        String strO = android.support.v4.media.session.b.O(mediaCodecInfo.getName());
        if (strO.startsWith("arc.")) {
            return false;
        }
        if (strO.startsWith("omx.google.") || strO.startsWith("omx.ffmpeg.")) {
            return true;
        }
        if ((strO.startsWith("omx.sec.") && strO.contains(".sw.")) || strO.equals("omx.qcom.video.decoder.hevcswvdec") || strO.startsWith("c2.android.") || strO.startsWith("c2.google.")) {
            return true;
        }
        return (strO.startsWith("omx.") || strO.startsWith("c2.")) ? false : true;
    }
}
