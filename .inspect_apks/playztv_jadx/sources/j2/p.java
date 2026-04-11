package j2;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.os.Build;
import android.util.Pair;
import android.util.Range;
import java.util.HashMap;
import java.util.Objects;
import p1.m0;
import s1.b0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f6712c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MediaCodecInfo.CodecCapabilities f6713d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f6714e;
    public final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f6715g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f6716h;
    public final boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f6717j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f6718k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f6719l;

    public p(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z2, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        str.getClass();
        this.f6710a = str;
        this.f6711b = str2;
        this.f6712c = str3;
        this.f6713d = codecCapabilities;
        this.f6715g = z2;
        this.f6714e = z12;
        this.f = z13;
        this.f6716h = z14;
        this.i = m0.o(str2);
        this.f6719l = -3.4028235E38f;
        this.f6717j = -1;
        this.f6718k = -1;
    }

    public static boolean a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i10, double d10) {
        Range<Double> achievableFrameRatesFor;
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        Point point = new Point(b0.f(i, widthAlignment) * widthAlignment, b0.f(i10, heightAlignment) * heightAlignment);
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
    public static j2.p i(java.lang.String r11, java.lang.String r12, java.lang.String r13, android.media.MediaCodecInfo.CodecCapabilities r14, boolean r15, boolean r16, boolean r17, boolean r18) {
        /*
            j2.p r0 = new j2.p
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
        throw new UnsupportedOperationException("Method not decompiled: j2.p.i(java.lang.String, java.lang.String, java.lang.String, android.media.MediaCodecInfo$CodecCapabilities, boolean, boolean, boolean, boolean):j2.p");
    }

    public final a2.i b(p1.q qVar, p1.q qVar2) {
        p1.q qVar3;
        p1.q qVar4;
        int i;
        String str = qVar.f10023n;
        p1.h hVar = qVar.D;
        String str2 = qVar2.f10023n;
        p1.h hVar2 = qVar2.D;
        int i10 = !Objects.equals(str, str2) ? 8 : 0;
        if (this.i) {
            if (qVar.f10035z != qVar2.f10035z) {
                i10 |= 1024;
            }
            boolean z2 = (qVar.f10030u == qVar2.f10030u && qVar.f10031v == qVar2.f10031v) ? false : true;
            if (!this.f6714e && z2) {
                i10 |= 512;
            }
            if ((!p1.h.e(hVar) || !p1.h.e(hVar2)) && !Objects.equals(hVar, hVar2)) {
                i10 |= 2048;
            }
            if (Build.MODEL.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(this.f6710a) && !qVar.b(qVar2)) {
                i10 |= 2;
            }
            int i11 = qVar.f10032w;
            if (i11 != -1 && (i = qVar.f10033x) != -1 && i11 == qVar2.f10032w && i == qVar2.f10033x && z2) {
                i10 |= 2;
            }
            if (i10 == 0) {
                return new a2.i(this.f6710a, qVar, qVar2, qVar.b(qVar2) ? 3 : 2, 0);
            }
            qVar3 = qVar;
            qVar4 = qVar2;
        } else {
            qVar3 = qVar;
            qVar4 = qVar2;
            if (qVar3.F != qVar4.F) {
                i10 |= 4096;
            }
            if (qVar3.G != qVar4.G) {
                i10 |= 8192;
            }
            if (qVar3.H != qVar4.H) {
                i10 |= 16384;
            }
            String str3 = this.f6711b;
            if (i10 == 0 && "audio/mp4a-latm".equals(str3)) {
                HashMap map = y.f6759a;
                Pair pairB = s1.e.b(qVar3);
                Pair pairB2 = s1.e.b(qVar4);
                if (pairB != null && pairB2 != null) {
                    int iIntValue = ((Integer) pairB.first).intValue();
                    int iIntValue2 = ((Integer) pairB2.first).intValue();
                    if (iIntValue == 42 && iIntValue2 == 42) {
                        return new a2.i(this.f6710a, qVar3, qVar4, 3, 0);
                    }
                }
            }
            if (!qVar3.b(qVar4)) {
                i10 |= 32;
            }
            if ("audio/opus".equals(str3)) {
                i10 |= 2;
            }
            if (i10 == 0) {
                return new a2.i(this.f6710a, qVar3, qVar4, 1, 0);
            }
        }
        return new a2.i(this.f6710a, qVar3, qVar4, 0, i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00c6 A[PHI: r2
      0x00c6: PHI (r2v2 android.util.Pair) = (r2v1 android.util.Pair), (r2v1 android.util.Pair), (r2v1 android.util.Pair), (r2v14 android.util.Pair) binds: [B:3:0x0011, B:5:0x0019, B:10:0x002d, B:40:0x00c5] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(p1.q r19, boolean r20) {
        /*
            Method dump skipped, instruction units count: 564
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j2.p.c(p1.q, boolean):boolean");
    }

    public final boolean d(p1.q qVar) {
        return (Objects.equals(qVar.f10023n, "audio/flac") && qVar.H == 22 && Build.VERSION.SDK_INT < 34 && this.f6710a.equals("c2.android.flac.decoder")) ? false : true;
    }

    public final boolean e(p1.q qVar) {
        int i;
        String str = qVar.f10023n;
        String str2 = this.f6711b;
        if ((!str2.equals(str) && !str2.equals(y.b(qVar))) || !c(qVar, true) || !d(qVar)) {
            return false;
        }
        if (this.i) {
            int i10 = qVar.f10030u;
            if (i10 > 0 && (i = qVar.f10031v) > 0) {
                return g(i10, i, qVar.f10034y);
            }
        } else {
            int i11 = qVar.G;
            MediaCodecInfo.CodecCapabilities codecCapabilities = this.f6713d;
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
            int i12 = qVar.F;
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
                    s1.b.p("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + this.f6710a + ", [" + maxInputChannelCount + " to " + i13 + "]");
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

    public final boolean f(p1.q qVar) {
        if (this.i) {
            return this.f6714e;
        }
        HashMap map = y.f6759a;
        Pair pairB = s1.e.b(qVar);
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
        throw new UnsupportedOperationException("Method not decompiled: j2.p.g(int, int, double):boolean");
    }

    public final void h(String str) {
        s1.b.f("MediaCodecInfo", "NoSupport [" + str + "] [" + this.f6710a + ", " + this.f6711b + "] [" + b0.f11648b + "]");
    }

    public final String toString() {
        return this.f6710a;
    }
}
