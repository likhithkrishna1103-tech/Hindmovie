package p2;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.os.Build;
import android.util.Pair;
import android.util.Range;
import java.util.HashMap;
import java.util.Objects;
import v1.m0;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9927c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MediaCodecInfo.CodecCapabilities f9928d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f9929e;
    public final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f9930g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f9931h;
    public final boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f9932j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f9933k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f9934l;

    public o(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        str.getClass();
        this.f9925a = str;
        this.f9926b = str2;
        this.f9927c = str3;
        this.f9928d = codecCapabilities;
        this.f9930g = z10;
        this.f9929e = z13;
        this.f = z14;
        this.f9931h = z15;
        this.i = m0.o(str2);
        this.f9934l = -3.4028235E38f;
        this.f9932j = -1;
        this.f9933k = -1;
    }

    public static boolean a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i10, double d10) {
        Range<Double> achievableFrameRatesFor;
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        Point point = new Point(a0.f(i, widthAlignment) * widthAlignment, a0.f(i10, heightAlignment) * heightAlignment);
        int i11 = point.x;
        int i12 = point.y;
        if (d10 == -1.0d || d10 < 1.0d) {
            return videoCapabilities.isSizeSupported(i11, i12);
        }
        double dFloor = Math.floor(d10);
        if (videoCapabilities.areSizeAndRateSupported(i11, i12, dFloor)) {
            return Build.VERSION.SDK_INT < 24 || (achievableFrameRatesFor = videoCapabilities.getAchievableFrameRatesFor(i11, i12)) == null || dFloor <= ((Double) achievableFrameRatesFor.getUpper()).doubleValue();
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static p2.o i(java.lang.String r11, java.lang.String r12, java.lang.String r13, android.media.MediaCodecInfo.CodecCapabilities r14, boolean r15, boolean r16, boolean r17, boolean r18) {
        /*
            p2.o r0 = new p2.o
            r1 = 0
            r2 = 1
            if (r14 == 0) goto L10
            java.lang.String r3 = "adaptive-playback"
            boolean r3 = r14.isFeatureSupported(r3)
            if (r3 == 0) goto L10
            r8 = r2
            goto L11
        L10:
            r8 = r1
        L11:
            if (r14 == 0) goto L19
            java.lang.String r3 = "tunneled-playback"
            boolean r3 = r14.isFeatureSupported(r3)
        L19:
            if (r18 != 0) goto L28
            if (r14 == 0) goto L26
            java.lang.String r3 = "secure-playback"
            boolean r3 = r14.isFeatureSupported(r3)
            if (r3 == 0) goto L26
            goto L28
        L26:
            r9 = r1
            goto L29
        L28:
            r9 = r2
        L29:
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 35
            if (r3 < r4) goto L6f
            if (r14 == 0) goto L6f
            java.lang.String r3 = "detached-surface"
            boolean r3 = r14.isFeatureSupported(r3)
            if (r3 == 0) goto L6f
            java.lang.String r3 = android.os.Build.MANUFACTURER
            java.lang.String r4 = "Xiaomi"
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L6f
            java.lang.String r4 = "OPPO"
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L6f
            java.lang.String r4 = "realme"
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L6f
            java.lang.String r4 = "motorola"
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L6f
            java.lang.String r4 = "LENOVO"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L64
            goto L6f
        L64:
            r10 = r2
            r1 = r11
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r2 = r12
            goto L79
        L6f:
            r10 = r1
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r1 = r11
        L79:
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p2.o.i(java.lang.String, java.lang.String, java.lang.String, android.media.MediaCodecInfo$CodecCapabilities, boolean, boolean, boolean, boolean):p2.o");
    }

    public final g2.g b(v1.p pVar, v1.p pVar2) {
        v1.p pVar3;
        v1.p pVar4;
        int i;
        String str = pVar.f12946n;
        v1.g gVar = pVar.D;
        String str2 = pVar2.f12946n;
        v1.g gVar2 = pVar2.D;
        int i10 = !Objects.equals(str, str2) ? 8 : 0;
        if (this.i) {
            if (pVar.f12958z != pVar2.f12958z) {
                i10 |= 1024;
            }
            boolean z10 = (pVar.f12953u == pVar2.f12953u && pVar.f12954v == pVar2.f12954v) ? false : true;
            if (!this.f9929e && z10) {
                i10 |= 512;
            }
            if ((!v1.g.e(gVar) || !v1.g.e(gVar2)) && !Objects.equals(gVar, gVar2)) {
                i10 |= 2048;
            }
            if (Build.MODEL.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(this.f9925a) && !pVar.b(pVar2)) {
                i10 |= 2;
            }
            int i11 = pVar.f12955w;
            if (i11 != -1 && (i = pVar.f12956x) != -1 && i11 == pVar2.f12955w && i == pVar2.f12956x && z10) {
                i10 |= 2;
            }
            if (i10 == 0) {
                return new g2.g(this.f9925a, pVar, pVar2, pVar.b(pVar2) ? 3 : 2, 0);
            }
            pVar3 = pVar;
            pVar4 = pVar2;
        } else {
            pVar3 = pVar;
            pVar4 = pVar2;
            if (pVar3.F != pVar4.F) {
                i10 |= 4096;
            }
            if (pVar3.G != pVar4.G) {
                i10 |= 8192;
            }
            if (pVar3.H != pVar4.H) {
                i10 |= 16384;
            }
            String str3 = this.f9926b;
            if (i10 == 0 && "audio/mp4a-latm".equals(str3)) {
                HashMap map = x.f9976a;
                Pair pairB = y1.e.b(pVar3);
                Pair pairB2 = y1.e.b(pVar4);
                if (pairB != null && pairB2 != null) {
                    int iIntValue = ((Integer) pairB.first).intValue();
                    int iIntValue2 = ((Integer) pairB2.first).intValue();
                    if (iIntValue == 42 && iIntValue2 == 42) {
                        return new g2.g(this.f9925a, pVar3, pVar4, 3, 0);
                    }
                }
            }
            if (!pVar3.b(pVar4)) {
                i10 |= 32;
            }
            if ("audio/opus".equals(str3)) {
                i10 |= 2;
            }
            if (i10 == 0) {
                return new g2.g(this.f9925a, pVar3, pVar4, 1, 0);
            }
        }
        return new g2.g(this.f9925a, pVar3, pVar4, 0, i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00c6 A[PHI: r2
      0x00c6: PHI (r2v2 android.util.Pair) = (r2v1 android.util.Pair), (r2v1 android.util.Pair), (r2v1 android.util.Pair), (r2v14 android.util.Pair) binds: [B:3:0x0011, B:5:0x0019, B:10:0x002d, B:40:0x00c5] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(v1.p r19, boolean r20) {
        /*
            Method dump skipped, instruction units count: 564
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p2.o.c(v1.p, boolean):boolean");
    }

    public final boolean d(v1.p pVar) {
        return (Objects.equals(pVar.f12946n, "audio/flac") && pVar.H == 22 && Build.VERSION.SDK_INT < 34 && this.f9925a.equals("c2.android.flac.decoder")) ? false : true;
    }

    public final boolean e(v1.p pVar) {
        int i;
        String str = pVar.f12946n;
        String str2 = this.f9926b;
        if ((!str2.equals(str) && !str2.equals(x.b(pVar))) || !c(pVar, true) || !d(pVar)) {
            return false;
        }
        if (this.i) {
            int i10 = pVar.f12953u;
            if (i10 > 0 && (i = pVar.f12954v) > 0) {
                return g(i10, i, pVar.f12957y);
            }
        } else {
            int i11 = pVar.G;
            MediaCodecInfo.CodecCapabilities codecCapabilities = this.f9928d;
            if (i11 != -1) {
                if (codecCapabilities == null) {
                    h("sampleRate.caps");
                    return false;
                }
                MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
                if (audioCapabilities == null) {
                    h("sampleRate.aCaps");
                    return false;
                }
                if (!audioCapabilities.isSampleRateSupported(i11)) {
                    h("sampleRate.support, " + i11);
                    return false;
                }
            }
            int i12 = pVar.F;
            if (i12 != -1) {
                if (codecCapabilities == null) {
                    h("channelCount.caps");
                    return false;
                }
                MediaCodecInfo.AudioCapabilities audioCapabilities2 = codecCapabilities.getAudioCapabilities();
                if (audioCapabilities2 == null) {
                    h("channelCount.aCaps");
                    return false;
                }
                int maxInputChannelCount = audioCapabilities2.getMaxInputChannelCount();
                if (maxInputChannelCount <= 1 && ((Build.VERSION.SDK_INT < 26 || maxInputChannelCount <= 0) && !"audio/mpeg".equals(str2) && !"audio/3gpp".equals(str2) && !"audio/amr-wb".equals(str2) && !"audio/mp4a-latm".equals(str2) && !"audio/vorbis".equals(str2) && !"audio/opus".equals(str2) && !"audio/raw".equals(str2) && !"audio/flac".equals(str2) && !"audio/g711-alaw".equals(str2) && !"audio/g711-mlaw".equals(str2) && !"audio/gsm".equals(str2))) {
                    int i13 = "audio/ac3".equals(str2) ? 6 : "audio/eac3".equals(str2) ? 16 : 30;
                    y1.b.p("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + this.f9925a + ", [" + maxInputChannelCount + " to " + i13 + "]");
                    maxInputChannelCount = i13;
                }
                if (maxInputChannelCount < i12) {
                    h("channelCount.support, " + i12);
                    return false;
                }
            }
        }
        return true;
    }

    public final boolean f(v1.p pVar) {
        if (this.i) {
            return this.f9929e;
        }
        HashMap map = x.f9976a;
        Pair pairB = y1.e.b(pVar);
        return pairB != null && ((Integer) pairB.first).intValue() == 42;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(int r12, int r13, double r14) {
        /*
            Method dump skipped, instruction units count: 281
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p2.o.g(int, int, double):boolean");
    }

    public final void h(String str) {
        y1.b.f("MediaCodecInfo", "NoSupport [" + str + "] [" + this.f9925a + ", " + this.f9926b + "] [" + a0.f14552b + "]");
    }

    public final String toString() {
        return this.f9925a;
    }
}
