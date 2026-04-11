package lb;

import android.media.MediaCodec;
import android.net.Uri;
import android.os.Trace;
import com.bumptech.glide.manager.l;
import com.google.android.gms.internal.measurement.e9;
import com.google.android.gms.internal.measurement.g9;
import com.google.android.gms.internal.measurement.i7;
import com.google.android.gms.internal.measurement.k7;
import com.google.android.gms.internal.measurement.k9;
import com.google.android.gms.internal.measurement.m9;
import com.google.android.gms.internal.measurement.o7;
import com.google.android.gms.internal.measurement.q7;
import com.google.android.gms.internal.measurement.s6;
import com.google.android.gms.internal.measurement.t6;
import com.google.android.gms.internal.measurement.u7;
import com.google.android.gms.internal.measurement.w7;
import com.google.android.gms.internal.measurement.w9;
import com.google.android.gms.internal.measurement.x6;
import com.google.android.gms.internal.measurement.x9;
import com.google.android.gms.internal.measurement.z6;
import e6.a0;
import hf.i;
import j2.p;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import k8.e0;
import s1.b0;
import s2.o;
import v1.k;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e implements b8.e, cb.a, l, o, y6.a, g6.a, j2.l, e0 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f8081u;

    public /* synthetic */ e(int i) {
        this.f8081u = i;
    }

    public static MediaCodec d(b2.g gVar) throws IOException {
        String str = ((p) gVar.f1737b).f6710a;
        Trace.beginSection("createCodec:" + str);
        MediaCodec mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
        Trace.endSection();
        return mediaCodecCreateByCodecName;
    }

    public static i g(String str) {
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: ".concat(str).toString());
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i10 = i * 2;
            bArr[i] = (byte) (jf.b.a(str.charAt(i10 + 1)) + (jf.b.a(str.charAt(i10)) << 4));
        }
        return new i(bArr);
    }

    public static i h(String str) {
        be.h.e(str, "<this>");
        byte[] bytes = str.getBytes(ie.a.f6599a);
        be.h.d(bytes, "this as java.lang.String).getBytes(charset)");
        i iVar = new i(bytes);
        iVar.f6117w = str;
        return iVar;
    }

    @Override // k8.e0
    public Object a() {
        switch (this.f8081u) {
            case 16:
                x6.f3236v.get();
                Long l10 = (Long) z6.f3261a.a();
                l10.getClass();
                return l10;
            case 17:
                e9.f2961v.get();
                Boolean bool = (Boolean) g9.f3025d.a();
                bool.getClass();
                return bool;
            case 18:
                e9.f2961v.get();
                Boolean bool2 = (Boolean) g9.f3027g.a();
                bool2.getClass();
                return bool2;
            case 19:
                k9.f3082v.get();
                Boolean bool3 = (Boolean) m9.f3104a.a();
                bool3.getClass();
                return bool3;
            case 20:
                o7.f3141v.get();
                Boolean bool4 = (Boolean) q7.f3162a.a();
                bool4.getClass();
                return bool4;
            case 21:
                u7.f3210v.get();
                Boolean bool5 = (Boolean) w7.f3230b.a();
                bool5.getClass();
                return bool5;
            case 22:
                i7.f3057v.get();
                Boolean bool6 = (Boolean) k7.f3079a.a();
                bool6.getClass();
                return bool6;
            case 23:
                s6.f3189v.get();
                Boolean bool7 = (Boolean) t6.f3204a.a();
                bool7.getClass();
                return bool7;
            case 24:
                w9.f3231v.get();
                Boolean bool8 = (Boolean) x9.f3241a.a();
                bool8.getClass();
                return bool8;
            case 25:
                x6.f3236v.get();
                return Integer.valueOf((int) ((Long) z6.Y.a()).longValue());
            case 26:
                x6.f3236v.get();
                Long l11 = (Long) z6.N.a();
                l11.getClass();
                return l11;
            case 27:
                x6.f3236v.get();
                Long l12 = (Long) z6.P.a();
                l12.getClass();
                return l12;
            case 28:
                x6.f3236v.get();
                Long l13 = (Long) z6.f3286w.a();
                l13.getClass();
                return l13;
            default:
                x6.f3236v.get();
                Long l14 = (Long) z6.f3264b0.a();
                l14.getClass();
                return l14;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001b A[PHI: r4
      0x001b: PHI (r4v2 int) = (r4v1 int), (r4v3 int) binds: [B:3:0x0014, B:5:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // b8.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public b8.d c(android.content.Context r3, java.lang.String r4, b8.c r5) {
        /*
            r2 = this;
            b8.d r0 = new b8.d
            r0.<init>()
            int r1 = r5.i(r3, r4)
            r0.f1922a = r1
            r1 = 1
            int r3 = r5.n(r3, r4, r1)
            r0.f1923b = r3
            int r4 = r0.f1922a
            if (r4 != 0) goto L1b
            r4 = 0
            if (r3 != 0) goto L1b
            r1 = r4
            goto L1e
        L1b:
            if (r4 < r3) goto L1e
            r1 = -1
        L1e:
            r0.f1924c = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: lb.e.c(android.content.Context, java.lang.String, b8.c):b8.d");
    }

    @Override // s2.o
    public Object e(Uri uri, k kVar) {
        return Long.valueOf(b0.R(new BufferedReader(new InputStreamReader(kVar)).readLine()));
    }

    @Override // g6.a
    public File f(c6.f fVar) {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004b  */
    @Override // j2.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public j2.m j(b2.g r6) throws java.lang.Throwable {
        /*
            r5 = this;
            r0 = 0
            android.media.MediaCodec r0 = d(r6)     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            java.lang.String r1 = "configureCodec"
            android.os.Trace.beginSection(r1)     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            java.lang.Object r1 = r6.f1740e     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            android.view.Surface r1 = (android.view.Surface) r1     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            if (r1 != 0) goto L25
            java.lang.Object r2 = r6.f1737b     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            j2.p r2 = (j2.p) r2     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            boolean r2 = r2.f6716h     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            if (r2 == 0) goto L25
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            r3 = 35
            if (r2 < r3) goto L25
            r2 = 8
            goto L26
        L21:
            r6 = move-exception
            goto L49
        L23:
            r6 = move-exception
            goto L49
        L25:
            r2 = 0
        L26:
            java.lang.Object r3 = r6.f1738c     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            android.media.MediaFormat r3 = (android.media.MediaFormat) r3     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            java.lang.Object r4 = r6.f     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            android.media.MediaCrypto r4 = (android.media.MediaCrypto) r4     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            r0.configure(r3, r1, r4, r2)     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            android.os.Trace.endSection()     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            java.lang.String r1 = "startCodec"
            android.os.Trace.beginSection(r1)     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            r0.start()     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            android.os.Trace.endSection()     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            h4.z r1 = new h4.z     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            java.lang.Object r6 = r6.f1741g     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            a7.b r6 = (a7.b) r6     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            r1.<init>(r0, r6)     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            return r1
        L49:
            if (r0 == 0) goto L4e
            r0.release()
        L4e:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: lb.e.j(b2.g):j2.m");
    }

    @Override // y6.a
    public Object r() {
        return new a0();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
    @Override // cb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.StackTraceElement[] y(java.lang.StackTraceElement[] r15) {
        /*
            r14 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            int r1 = r15.length
            java.lang.StackTraceElement[] r1 = new java.lang.StackTraceElement[r1]
            r2 = 0
            r3 = 1
            r4 = r2
            r5 = r4
            r6 = r3
        Ld:
            int r7 = r15.length
            if (r4 >= r7) goto L61
            r7 = r15[r4]
            java.lang.Object r8 = r0.get(r7)
            java.lang.Integer r8 = (java.lang.Integer) r8
            if (r8 == 0) goto L4f
            int r9 = r8.intValue()
            int r10 = r4 - r9
            int r11 = r4 + r10
            int r12 = r15.length
            if (r11 <= r12) goto L26
            goto L4f
        L26:
            r11 = r2
        L27:
            if (r11 >= r10) goto L3b
            int r12 = r9 + r11
            r12 = r15[r12]
            int r13 = r4 + r11
            r13 = r15[r13]
            boolean r12 = r12.equals(r13)
            if (r12 != 0) goto L38
            goto L4f
        L38:
            int r11 = r11 + 1
            goto L27
        L3b:
            int r8 = r8.intValue()
            int r8 = r4 - r8
            r9 = 10
            if (r6 >= r9) goto L4b
            java.lang.System.arraycopy(r15, r4, r1, r5, r8)
            int r5 = r5 + r8
            int r6 = r6 + 1
        L4b:
            int r8 = r8 + (-1)
            int r8 = r8 + r4
            goto L57
        L4f:
            r6 = r15[r4]
            r1[r5] = r6
            int r5 = r5 + 1
            r6 = r3
            r8 = r4
        L57:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r0.put(r7, r4)
            int r4 = r8 + 1
            goto Ld
        L61:
            java.lang.StackTraceElement[] r0 = new java.lang.StackTraceElement[r5]
            java.lang.System.arraycopy(r1, r2, r0, r2, r5)
            int r1 = r15.length
            if (r5 >= r1) goto L6a
            return r0
        L6a:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: lb.e.y(java.lang.StackTraceElement[]):java.lang.StackTraceElement[]");
    }

    @Override // g6.a
    public void b(c6.f fVar, a7.b bVar) {
    }
}
