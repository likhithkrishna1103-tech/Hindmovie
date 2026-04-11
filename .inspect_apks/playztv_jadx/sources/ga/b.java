package ga;

import aa.c1;
import aa.g0;
import aa.j0;
import android.content.Context;
import android.graphics.Path;
import android.media.MediaCodecInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import dd.n;
import j2.y;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p1.m0;
import p1.q;
import pc.l;
import q9.t;
import s1.u;
import ue.m;
import ue.s;
import ue.v;
import v5.p;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class b implements u0.f {
    public static r5.a A(w5.b bVar, l5.j jVar) {
        return new r5.a(2, p.a(bVar, jVar, 1.0f, v5.f.f13279x, false));
    }

    public static r5.a B(w5.b bVar, l5.j jVar) {
        return new r5.a(3, p.a(bVar, jVar, x5.g.c(), v5.f.f13281z, true));
    }

    public static long C(u uVar, int i, int i10) {
        uVar.J(i);
        if (uVar.a() < 5) {
            return -9223372036854775807L;
        }
        int iJ = uVar.j();
        if ((8388608 & iJ) != 0 || ((2096896 & iJ) >> 8) != i10 || (iJ & 32) == 0 || uVar.x() < 7 || uVar.a() < 7 || (uVar.x() & 16) != 16) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[6];
        uVar.h(bArr, 0, 6);
        return ((((long) bArr[0]) & 255) << 25) | ((((long) bArr[1]) & 255) << 17) | ((((long) bArr[2]) & 255) << 9) | ((((long) bArr[3]) & 255) << 1) | ((255 & ((long) bArr[4])) >> 7);
    }

    public static void D(Context context, String str, boolean z2, v vVar, m mVar, l lVar) {
        try {
            zc.c cVar = new zc.c();
            if (mVar != null) {
                cVar.f14947w = mVar.e();
            }
            if (z2) {
                if (vVar == null) {
                    long j5 = 0;
                    ve.b.b(j5, j5, j5);
                    vVar = new ue.u(null, 0, new byte[0]);
                }
                cVar.q("POST", vVar);
            } else {
                cVar.q("GET", null);
            }
            cVar.v(str);
            s sVarB = pc.b.b();
            b2.g gVarM = cVar.m();
            sVarB.getClass();
            new ye.h(sVarB, gVarM).e(new p2.c(lVar, 3, context));
        } catch (IllegalArgumentException e10) {
            E(lVar, false, e10.getMessage());
        }
    }

    public static void E(l lVar, boolean z2, String str) {
        new Handler(Looper.getMainLooper()).post(new n(1, lVar, str, z2));
    }

    public static fe.a F(fe.c cVar, int i) {
        be.h.e(cVar, "<this>");
        boolean z2 = i > 0;
        Integer numValueOf = Integer.valueOf(i);
        if (!z2) {
            throw new IllegalArgumentException("Step must be positive, was: " + numValueOf + '.');
        }
        int i10 = cVar.f4817u;
        int i11 = cVar.f4818v;
        if (cVar.f4819w <= 0) {
            i = -i;
        }
        return new fe.a(i10, i11, i);
    }

    public static fe.c G(int i, int i10) {
        if (i10 > Integer.MIN_VALUE) {
            return new fe.c(i, i10 - 1, 1);
        }
        fe.c cVar = fe.c.f4824x;
        return fe.c.f4824x;
    }

    public static void I(String str) {
        Log.v("RootBeer", t() + String.valueOf(str));
    }

    public static boolean c(i0.f[] fVarArr, i0.f[] fVarArr2) {
        if (fVarArr == null || fVarArr2 == null || fVarArr.length != fVarArr2.length) {
            return false;
        }
        for (int i = 0; i < fVarArr.length; i++) {
            i0.f fVar = fVarArr[i];
            char c9 = fVar.f6166a;
            i0.f fVar2 = fVarArr2[i];
            if (c9 != fVar2.f6166a || fVar.f6167b.length != fVar2.f6167b.length) {
                return false;
            }
        }
        return true;
    }

    public static long d(long j5) {
        if (j5 < -4611686018427387903L) {
            return -4611686018427387903L;
        }
        if (j5 > 4611686018427387903L) {
            return 4611686018427387903L;
        }
        return j5;
    }

    public static float[] g(float[] fArr, int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int iMin = Math.min(i, length);
        float[] fArr2 = new float[i];
        System.arraycopy(fArr, 0, fArr2, 0, iMin);
        return fArr2;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0096 A[Catch: NumberFormatException -> 0x00aa, LOOP:3: B:25:0x0068->B:44:0x0096, LOOP_END, TryCatch #0 {NumberFormatException -> 0x00aa, blocks: (B:22:0x0054, B:25:0x0068, B:27:0x006e, B:31:0x007a, B:44:0x0096, B:46:0x009c, B:52:0x00b1, B:53:0x00b4), top: B:68:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009c A[Catch: NumberFormatException -> 0x00aa, TryCatch #0 {NumberFormatException -> 0x00aa, blocks: (B:22:0x0054, B:25:0x0068, B:27:0x006e, B:31:0x007a, B:44:0x0096, B:46:0x009c, B:52:0x00b1, B:53:0x00b4), top: B:68:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b1 A[Catch: NumberFormatException -> 0x00aa, TryCatch #0 {NumberFormatException -> 0x00aa, blocks: (B:22:0x0054, B:25:0x0068, B:27:0x006e, B:31:0x007a, B:44:0x0096, B:46:0x009c, B:52:0x00b1, B:53:0x00b4), top: B:68:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0095 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static i0.f[] h(java.lang.String r17) {
        /*
            Method dump skipped, instruction units count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ga.b.h(java.lang.String):i0.f[]");
    }

    public static Path i(String str) {
        Path path = new Path();
        try {
            i0.f.b(h(str), path);
            return path;
        } catch (RuntimeException e10) {
            throw new RuntimeException("Error in parsing ".concat(str), e10);
        }
    }

    public static i0.f[] j(i0.f[] fVarArr) {
        i0.f[] fVarArr2 = new i0.f[fVarArr.length];
        for (int i = 0; i < fVarArr.length; i++) {
            fVarArr2[i] = new i0.f(fVarArr[i]);
        }
        return fVarArr2;
    }

    public static void k(Serializable serializable) {
        Log.e("RootBeer", t() + String.valueOf(serializable));
        Log.e("QLog", t() + String.valueOf(serializable));
    }

    public static int l(boolean z2) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        List supportedPerformancePoints;
        try {
            p1.p pVar = new p1.p();
            pVar.f9967m = m0.p("video/avc");
            q qVar = new q(pVar);
            String str = qVar.f10023n;
            if (str != null) {
                List listD = y.d(str, z2, false);
                String strB = y.b(qVar);
                Iterable iterableD = strB == null ? c1.f650y : y.d(strB, z2, false);
                g0 g0VarN = j0.n();
                g0VarN.d(listD);
                g0VarN.d(iterableD);
                c1 c1VarG = g0VarN.g();
                for (int i = 0; i < c1VarG.f652x; i++) {
                    if (((j2.p) c1VarG.get(i)).f6713d != null && (videoCapabilities = ((j2.p) c1VarG.get(i)).f6713d.getVideoCapabilities()) != null && (supportedPerformancePoints = videoCapabilities.getSupportedPerformancePoints()) != null && !supportedPerformancePoints.isEmpty()) {
                        i0.c.m();
                        MediaCodecInfo.VideoCapabilities.PerformancePoint performancePointC = i0.c.c();
                        for (int i10 = 0; i10 < supportedPerformancePoints.size(); i10++) {
                            if (i0.c.e(supportedPerformancePoints.get(i10)).covers(performancePointC)) {
                                return 2;
                            }
                        }
                        return 1;
                    }
                }
            }
        } catch (j2.v unused) {
        }
        return 0;
    }

    public static Object m(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        if (obj2 != null) {
            return obj2;
        }
        throw new NullPointerException("Both parameters are null");
    }

    public static String n(Context context, String str) {
        return uc.b.f(context).getString("api_host", "https://error_pro.com") + str;
    }

    public static void p(Context context, String str, l lVar) {
        q(context, str, null, lVar, false);
    }

    public static void q(Context context, String str, m mVar, l lVar, boolean z2) {
        if (z2) {
            try {
                if (!uc.b.f(context).getBoolean("is_tv", false)) {
                    if (new wc.b(context).f()) {
                        q1.c.Q(context);
                        return;
                    } else {
                        if (q1.c.P(context)) {
                            throw new Exception("p");
                        }
                        q(context, str, mVar, lVar, false);
                        return;
                    }
                }
            } catch (Exception unused) {
                return;
            }
        }
        if (q1.c.P(context)) {
            throw new Exception("p");
        }
        D(context, str, false, null, mVar, lVar);
    }

    public static void r(String str, l lVar) {
        try {
            JSONObject jSONObject = new JSONArray(str).getJSONObject(0);
            D(null, jSONObject.getString("playlist"), false, null, null, new b2.b(jSONObject.getString("channel"), 19, lVar));
        } catch (ArrayIndexOutOfBoundsException | JSONException unused) {
            lVar.f("https://error.m3u8", false);
        }
    }

    public static Object s(String str, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 34) {
            return m0.a.a(str, bundle);
        }
        Parcelable parcelable = bundle.getParcelable(str);
        if (e.a.class.isInstance(parcelable)) {
            return parcelable;
        }
        return null;
    }

    public static String t() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        String methodName = stackTrace[2].getMethodName();
        String className = stackTrace[2].getClassName();
        int lineNumber = stackTrace[2].getLineNumber();
        return className.substring(className.lastIndexOf(46) + 1) + ": " + methodName + "() [" + lineNumber + "] - ";
    }

    public static nd.c u(ae.a aVar) {
        nd.l lVar = new nd.l();
        lVar.f8991u = aVar;
        lVar.f8992v = nd.j.f8989a;
        return lVar;
    }

    public static r5.a x(w5.b bVar, l5.j jVar) {
        return new r5.a(0, p.a(bVar, jVar, 1.0f, v5.f.f13277v, false));
    }

    public static r5.b y(w5.a aVar, l5.j jVar, boolean z2) {
        return new r5.b(7, p.a(aVar, jVar, z2 ? x5.g.c() : 1.0f, v5.f.f13278w, false));
    }

    public static r5.a z(w5.b bVar, l5.j jVar, int i) {
        b8.l lVar = new b8.l();
        lVar.f1942u = i;
        ArrayList arrayListA = p.a(bVar, jVar, 1.0f, lVar, false);
        for (int i10 = 0; i10 < arrayListA.size(); i10++) {
            y5.a aVar = (y5.a) arrayListA.get(i10);
            s5.c cVar = (s5.c) aVar.f14522b;
            s5.c cVar2 = (s5.c) aVar.f14523c;
            if (cVar != null && cVar2 != null) {
                float[] fArr = cVar.f11795a;
                int length = fArr.length;
                float[] fArr2 = cVar2.f11795a;
                if (length != fArr2.length) {
                    int length2 = fArr.length + fArr2.length;
                    float[] fArr3 = new float[length2];
                    System.arraycopy(fArr, 0, fArr3, 0, fArr.length);
                    System.arraycopy(fArr2, 0, fArr3, fArr.length, fArr2.length);
                    Arrays.sort(fArr3);
                    float f = Float.NaN;
                    int i11 = 0;
                    for (int i12 = 0; i12 < length2; i12++) {
                        float f4 = fArr3[i12];
                        if (f4 != f) {
                            fArr3[i11] = f4;
                            i11++;
                            f = fArr3[i12];
                        }
                    }
                    float[] fArrCopyOfRange = Arrays.copyOfRange(fArr3, 0, i11);
                    aVar = new y5.a(cVar.b(fArrCopyOfRange), cVar2.b(fArrCopyOfRange));
                }
            }
            arrayListA.set(i10, aVar);
        }
        return new r5.a(1, arrayListA);
    }

    public abstract void H(ArrayList arrayList);

    public abstract void o(t tVar, float f, float f4);

    public abstract View v(int i);

    public abstract boolean w();
}
