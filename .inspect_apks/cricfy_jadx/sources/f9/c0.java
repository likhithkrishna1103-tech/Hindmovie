package f9;

import android.content.Context;
import android.media.MediaCodec;
import android.os.Looper;
import android.os.Trace;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.internal.measurement.d7;
import com.google.android.gms.internal.measurement.e9;
import com.google.android.gms.internal.measurement.f7;
import com.google.android.gms.internal.measurement.g8;
import com.google.android.gms.internal.measurement.q8;
import com.google.android.gms.internal.measurement.s8;
import com.google.android.gms.internal.measurement.t9;
import com.google.firebase.analytics.connector.internal.AnalyticsConnectorRegistrar;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c0 implements w, hb.e, l2.n, p2.k, t2.l, vf.l, w8.c, wb.a {
    public static c0 H;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4056v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ c0 f4052w = new c0(0);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ c0 f4053x = new c0(1);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ c0 f4054y = new c0(2);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ c0 f4055z = new c0(3);
    public static final /* synthetic */ c0 A = new c0(4);
    public static final /* synthetic */ c0 B = new c0(5);
    public static final /* synthetic */ c0 C = new c0(6);
    public static final /* synthetic */ c0 D = new c0(7);
    public static final /* synthetic */ c0 E = new c0(8);
    public static final /* synthetic */ c0 F = new c0(9);
    public static final /* synthetic */ c0 G = new c0(10);

    public /* synthetic */ c0(int i) {
        this.f4056v = i;
    }

    public static MediaCodec l(c2.o oVar) throws IOException {
        String str = ((p2.o) oVar.f2035b).f9925a;
        Trace.beginSection("createCodec:" + str);
        MediaCodec mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
        Trace.endSection();
        return mediaCodecCreateByCodecName;
    }

    @Override // f9.w
    public Object a() {
        switch (this.f4056v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                List list = f0.f4108a;
                d7.f2368w.get();
                return (String) f7.f2405b0.b();
            case 1:
                List list2 = f0.f4108a;
                d7.f2368w.get();
                return Integer.valueOf((int) ((Long) f7.X.b()).longValue());
            case 2:
                List list3 = f0.f4108a;
                d7.f2368w.get();
                Boolean bool = (Boolean) f7.C.b();
                bool.getClass();
                return bool;
            case 3:
                List list4 = f0.f4108a;
                d7.f2368w.get();
                return Integer.valueOf((int) ((Long) f7.f2417i0.b()).longValue());
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                List list5 = f0.f4108a;
                Boolean bool2 = (Boolean) t9.f2644a.b();
                bool2.getClass();
                return bool2;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                List list6 = f0.f4108a;
                Boolean bool3 = (Boolean) e9.f2383a.b();
                bool3.getClass();
                return bool3;
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                List list7 = f0.f4108a;
                q8.f2581w.get();
                Boolean bool4 = (Boolean) s8.f2622a.b();
                bool4.getClass();
                return bool4;
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                List list8 = f0.f4108a;
                q8.f2581w.get();
                Boolean bool5 = (Boolean) s8.f2626e.b();
                bool5.getClass();
                return bool5;
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                List list9 = f0.f4108a;
                q8.f2581w.get();
                Boolean bool6 = (Boolean) s8.f2625d.b();
                bool6.getClass();
                return bool6;
            default:
                return new Boolean(((Boolean) g8.f2465a.b()).booleanValue());
        }
    }

    @Override // vf.l
    public boolean c(SSLSocket sSLSocket) {
        return ne.o.Z(sSLSocket.getClass().getName(), "com.google.android.gms.org.conscrypt.", false);
    }

    @Override // t2.l
    public long d() {
        throw new NoSuchElementException();
    }

    @Override // hb.e
    public /* synthetic */ Object e(dd.c cVar) {
        return AnalyticsConnectorRegistrar.lambda$getComponents$0(cVar);
    }

    @Override // l2.n
    public /* synthetic */ l2.m f(l2.k kVar, v1.p pVar) {
        return l2.m.f7674j;
    }

    @Override // vf.l
    public vf.n g(SSLSocket sSLSocket) {
        Class<?> cls = sSLSocket.getClass();
        Class<?> superclass = cls;
        while (!superclass.getSimpleName().equals("OpenSSLSocketImpl")) {
            superclass = superclass.getSuperclass();
            if (superclass == null) {
                throw new AssertionError("No OpenSSLSocketImpl superclass of socket of type " + cls);
            }
        }
        return new vf.e(superclass);
    }

    @Override // l2.n
    public int h(v1.p pVar) {
        return pVar.f12950r != null ? 1 : 0;
    }

    @Override // l2.n
    public l2.h i(l2.k kVar, v1.p pVar) {
        if (pVar.f12950r == null) {
            return null;
        }
        return new l2.q(new l2.g(new l2.b0(), 6001));
    }

    @Override // t2.l
    public long j() {
        throw new NoSuchElementException();
    }

    @Override // w8.c
    public a3.d n(Context context, String str, w8.b bVar) {
        a3.d dVar = new a3.d();
        int iG = bVar.g(context, str);
        dVar.f154a = iG;
        if (iG != 0) {
            dVar.f156c = -1;
            return dVar;
        }
        int iE = bVar.e(context, str, true);
        dVar.f155b = iE;
        if (iE != 0) {
            dVar.f156c = 1;
        }
        return dVar;
    }

    @Override // t2.l
    public boolean next() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
    @Override // wb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.StackTraceElement[] o(java.lang.StackTraceElement[] r15) {
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
        throw new UnsupportedOperationException("Method not decompiled: f9.c0.o(java.lang.StackTraceElement[]):java.lang.StackTraceElement[]");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004b  */
    @Override // p2.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public p2.l u(c2.o r6) throws java.lang.Throwable {
        /*
            r5 = this;
            r0 = 0
            android.media.MediaCodec r0 = l(r6)     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            java.lang.String r1 = "configureCodec"
            android.os.Trace.beginSection(r1)     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            java.lang.Object r1 = r6.f2038e     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            android.view.Surface r1 = (android.view.Surface) r1     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            if (r1 != 0) goto L25
            java.lang.Object r2 = r6.f2035b     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            p2.o r2 = (p2.o) r2     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            boolean r2 = r2.f9931h     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
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
            java.lang.Object r3 = r6.f2036c     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            android.media.MediaFormat r3 = (android.media.MediaFormat) r3     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            java.lang.Object r4 = r6.f     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            android.media.MediaCrypto r4 = (android.media.MediaCrypto) r4     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            r0.configure(r3, r1, r4, r2)     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            android.os.Trace.endSection()     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            java.lang.String r1 = "startCodec"
            android.os.Trace.beginSection(r1)     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            r0.start()     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            android.os.Trace.endSection()     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            nb.w r1 = new nb.w     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            java.lang.Object r6 = r6.f2039g     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            l7.a r6 = (l7.a) r6     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            r1.<init>(r0, r6)     // Catch: java.lang.RuntimeException -> L21 java.io.IOException -> L23
            return r1
        L49:
            if (r0 == 0) goto L4e
            r0.release()
        L4e:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.c0.u(c2.o):p2.l");
    }

    public c0(Context context) {
        this.f4056v = 11;
    }

    @Override // l2.n
    public /* synthetic */ void b() {
    }

    @Override // l2.n
    public /* synthetic */ void release() {
    }

    @Override // l2.n
    public void k(Looper looper, h2.l lVar) {
    }
}
