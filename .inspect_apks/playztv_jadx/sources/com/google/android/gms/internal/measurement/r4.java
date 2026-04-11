package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r4 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f3172g = new Object();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile h4 f3173h;
    public static final AtomicInteger i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a2.c f3174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f3176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile int f3177d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile Object f3178e;
    public final /* synthetic */ int f;

    static {
        new AtomicReference();
        i = new AtomicInteger();
    }

    public r4(a2.c cVar, String str, Object obj, int i10) {
        this.f = i10;
        cVar.getClass();
        if (((Uri) cVar.f173v) == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        this.f3174a = cVar;
        this.f3175b = str;
        this.f3176c = obj;
    }

    public final Object a() {
        int i10 = i.get();
        if (this.f3177d < i10) {
            synchronized (this) {
                try {
                    if (this.f3177d < i10) {
                        h4 h4Var = f3173h;
                        z9.g gVar = z9.a.f14905u;
                        String str = null;
                        if (h4Var != null) {
                            gVar = (z9.g) h4Var.f3036b.get();
                            if (gVar.b()) {
                                i4 i4Var = (i4) gVar.a();
                                a2.c cVar = this.f3174a;
                                Uri uri = (Uri) cVar.f173v;
                                String str2 = (String) cVar.f175x;
                                String str3 = this.f3175b;
                                i4Var.getClass();
                                s.i iVar = uri != null ? (s.i) i4Var.f3050a.get(uri.toString()) : null;
                                if (iVar != null) {
                                    if (str2 != null) {
                                        str3 = str2 + str3;
                                    }
                                    str = (String) iVar.get(str3);
                                }
                            }
                        }
                        q1.c.m("Must call PhenotypeFlagInitializer.maybeInit() first", h4Var != null);
                        this.f3174a.getClass();
                        Object objD = d(h4Var);
                        if (objD == null && (objD = b(h4Var)) == null) {
                            objD = this.f3176c;
                        }
                        if (gVar.b()) {
                            objD = str == null ? this.f3176c : c(str);
                        }
                        this.f3178e = objD;
                        this.f3177d = i10;
                    }
                } finally {
                }
            }
        }
        return this.f3178e;
    }

    public final Object b(h4 h4Var) {
        k4 k4Var;
        String strM;
        k4 k4Var2;
        if (!this.f3174a.f172u) {
            Context context = h4Var.f3035a;
            synchronized (k4.class) {
                try {
                    if (k4.f3069w == null) {
                        if (f0.c.b(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
                            k4Var2 = new k4();
                            k4Var2.f3070u = context;
                            l4 l4Var = new l4(null);
                            k4Var2.f3071v = l4Var;
                            context.getContentResolver().registerContentObserver(a4.f2880a, true, l4Var);
                        } else {
                            k4Var2 = new k4(0);
                        }
                        k4.f3069w = k4Var2;
                    }
                    k4Var = k4.f3069w;
                } catch (Throwable th) {
                    throw th;
                }
            }
            a2.c cVar = this.f3174a;
            if (cVar.f172u) {
                strM = null;
            } else {
                String str = (String) cVar.f174w;
                strM = this.f3175b;
                if (str == null || !str.isEmpty()) {
                    strM = e6.j.m(str, strM);
                }
            }
            Object objD = k4Var.d(strM);
            if (objD != null) {
                return c(objD);
            }
        }
        return null;
    }

    public final Object c(Object obj) {
        switch (this.f) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (!(obj instanceof Long)) {
                    if (obj instanceof String) {
                        try {
                            break;
                        } catch (NumberFormatException unused) {
                        }
                    }
                    String str = (String) this.f3174a.f175x;
                    String strM = this.f3175b;
                    if (str == null || !str.isEmpty()) {
                        strM = e6.j.m(str, strM);
                    }
                    Log.e("PhenotypeFlag", "Invalid long value for " + strM + ": " + String.valueOf(obj));
                }
                break;
            case 1:
                if (!(obj instanceof Double)) {
                    if (!(obj instanceof Float)) {
                        if (obj instanceof String) {
                            try {
                                break;
                            } catch (NumberFormatException unused2) {
                            }
                        }
                        String str2 = (String) this.f3174a.f175x;
                        String strM2 = this.f3175b;
                        if (str2 == null || !str2.isEmpty()) {
                            strM2 = e6.j.m(str2, strM2);
                        }
                        Log.e("PhenotypeFlag", "Invalid double value for " + strM2 + ": " + String.valueOf(obj));
                    }
                }
                break;
            case 2:
                if (!(obj instanceof Boolean)) {
                    if (obj instanceof String) {
                        String str3 = (String) obj;
                        if (!a4.f2882c.matcher(str3).matches()) {
                            if (a4.f2883d.matcher(str3).matches()) {
                            }
                        }
                    }
                    String str4 = (String) this.f3174a.f175x;
                    String strM3 = this.f3175b;
                    if (str4 == null || !str4.isEmpty()) {
                        strM3 = e6.j.m(str4, strM3);
                    }
                    Log.e("PhenotypeFlag", "Invalid boolean value for " + strM3 + ": " + String.valueOf(obj));
                    break;
                }
                break;
            default:
                if (obj instanceof String) {
                }
                break;
        }
        return null;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:19|(1:21)(7:22|(1:24)(1:25)|26|(0)|35|36|37)|30|58|31|32|(1:34)|35|36|37) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(com.google.android.gms.internal.measurement.h4 r9) {
        /*
            Method dump skipped, instruction units count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.r4.d(com.google.android.gms.internal.measurement.h4):java.lang.Object");
    }
}
