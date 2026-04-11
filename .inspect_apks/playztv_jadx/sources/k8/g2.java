package k8;

import android.app.Application;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.google.android.gms.internal.measurement.d7;
import com.google.android.gms.internal.measurement.e9;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g2 extends y0 {
    public boolean A;
    public final AtomicReference B;
    public final Object C;
    public boolean D;
    public int E;
    public m2 F;
    public PriorityQueue G;
    public boolean H;
    public z1 I;
    public final AtomicLong J;
    public long K;
    public final a1 L;
    public boolean M;
    public m2 N;
    public k2 O;
    public m2 P;
    public final wb.c Q;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public q2 f7212x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public h4.z f7213y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final CopyOnWriteArraySet f7214z;

    public g2(k1 k1Var) {
        super(k1Var);
        this.f7214z = new CopyOnWriteArraySet();
        this.C = new Object();
        this.D = false;
        this.E = 1;
        this.M = true;
        this.Q = new wb.c(22, this);
        this.B = new AtomicReference();
        this.I = z1.f7569c;
        this.K = -1L;
        this.J = new AtomicLong(0L);
        this.L = new a1(k1Var, 2);
    }

    public static void H1(g2 g2Var, z1 z1Var, long j5, boolean z2, boolean z10) {
        int i = z1Var.f7571b;
        g2Var.p1();
        k1 k1Var = (k1) g2Var.f2454v;
        g2Var.t1();
        z1 z1VarZ1 = g2Var.n1().z1();
        if (j5 <= g2Var.K && z1.h(z1VarZ1.f7571b, i)) {
            g2Var.g().G.c(z1Var, "Dropped out-of-date consent setting, proposed settings");
            return;
        }
        z0 z0VarN1 = g2Var.n1();
        z0VarN1.p1();
        if (!z1.h(i, z0VarN1.x1().getInt("consent_source", 100))) {
            g2Var.g().G.c(Integer.valueOf(i), "Lower precedence consent source ignored, proposed source");
            return;
        }
        SharedPreferences.Editor editorEdit = z0VarN1.x1().edit();
        editorEdit.putString("consent_settings", z1Var.m());
        editorEdit.putInt("consent_source", i);
        editorEdit.apply();
        g2Var.g().I.c(z1Var, "Setting storage consent(FE)");
        g2Var.K = j5;
        z2 z2VarP = k1Var.p();
        z2VarP.p1();
        z2VarP.t1();
        if (z2VarP.F1() && z2VarP.o1().t2() < 241200) {
            k1Var.p().A1(z2);
        } else {
            z2 z2VarP2 = k1Var.p();
            z2VarP2.p1();
            z2VarP2.t1();
            d7.a();
            k1 k1Var2 = (k1) z2VarP2.f2454v;
            if (!k1Var2.A.A1(null, w.X0) && z2) {
                k1Var2.n().y1();
            }
            y2 y2Var = new y2(0);
            y2Var.f7561v = z2VarP2;
            z2VarP2.w1(y2Var);
        }
        if (z10) {
            k1Var.p().x1(new AtomicReference());
        }
    }

    public static void I1(g2 g2Var, z1 z1Var, z1 z1Var2) {
        boolean z2;
        d7.a();
        k1 k1Var = (k1) g2Var.f2454v;
        if (k1Var.A.A1(null, w.X0)) {
            return;
        }
        y1 y1Var = y1.f7555w;
        y1 y1Var2 = y1.f7554v;
        y1[] y1VarArr = {y1Var, y1Var2};
        int i = 0;
        while (true) {
            if (i >= 2) {
                z2 = false;
                break;
            }
            y1 y1Var3 = y1VarArr[i];
            if (!z1Var2.i(y1Var3) && z1Var.i(y1Var3)) {
                z2 = true;
                break;
            }
            i++;
        }
        boolean zK = z1Var.k(z1Var2, y1Var, y1Var2);
        if (z2 || zK) {
            k1Var.m().y1();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A1(java.lang.String r26, java.lang.String r27, long r28, android.os.Bundle r30, boolean r31, boolean r32, boolean r33) {
        /*
            Method dump skipped, instruction units count: 1229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.g2.A1(java.lang.String, java.lang.String, long, android.os.Bundle, boolean, boolean, boolean):void");
    }

    public final void B1(String str, String str2, Bundle bundle) {
        ((k1) this.f2454v).H.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        t7.v.d(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong("creation_timestamp", jCurrentTimeMillis);
        if (str2 != null) {
            bundle2.putString("expired_event_name", str2);
            bundle2.putBundle("expired_event_params", bundle);
        }
        x().y1(new i2(this, bundle2, 1));
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0056, code lost:
    
        if (r3 > 500) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0088, code lost:
    
        if (r4 > 500) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void C1(java.lang.String r16, java.lang.String r17, android.os.Bundle r18, boolean r19, boolean r20, long r21) {
        /*
            Method dump skipped, instruction units count: 448
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.g2.C1(java.lang.String, java.lang.String, android.os.Bundle, boolean, boolean, long):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void D1(java.lang.String r13, java.lang.String r14, java.lang.Object r15, boolean r16, long r17) {
        /*
            Method dump skipped, instruction units count: 201
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.g2.D1(java.lang.String, java.lang.String, java.lang.Object, boolean, long):void");
    }

    public final void E1(o oVar, boolean z2) {
        ea.t tVar = new ea.t(15, this, oVar, false);
        if (!z2) {
            x().y1(tVar);
        } else {
            p1();
            tVar.run();
        }
    }

    public final void F1(z1 z1Var) {
        p1();
        boolean z2 = (z1Var.i(y1.f7555w) && z1Var.i(y1.f7554v)) || ((k1) this.f2454v).p().E1();
        k1 k1Var = (k1) this.f2454v;
        h1 h1Var = k1Var.D;
        k1.f(h1Var);
        h1Var.p1();
        if (z2 != k1Var.X) {
            k1 k1Var2 = (k1) this.f2454v;
            h1 h1Var2 = k1Var2.D;
            k1.f(h1Var2);
            h1Var2.p1();
            k1Var2.X = z2;
            z0 z0VarN1 = n1();
            z0VarN1.p1();
            Boolean boolValueOf = z0VarN1.x1().contains("measurement_enabled_from_api") ? Boolean.valueOf(z0VarN1.x1().getBoolean("measurement_enabled_from_api", true)) : null;
            if (!z2 || boolValueOf == null || boolValueOf.booleanValue()) {
                z1(Boolean.valueOf(z2), false);
            }
        }
    }

    public final void G1(z1 z1Var, long j5, boolean z2) {
        z1 z1Var2;
        boolean z10;
        z1 z1VarJ;
        boolean zK;
        boolean z11;
        t1();
        int i = z1Var.f7571b;
        if (i != -10) {
            b2 b2Var = (b2) z1Var.f7570a.get(y1.f7554v);
            if (b2Var == null) {
                b2Var = b2.f7089v;
            }
            b2 b2Var2 = b2.f7089v;
            if (b2Var == b2Var2) {
                b2 b2Var3 = (b2) z1Var.f7570a.get(y1.f7555w);
                if (b2Var3 == null) {
                    b2Var3 = b2Var2;
                }
                if (b2Var3 == b2Var2) {
                    g().F.d("Ignoring empty consent settings");
                    return;
                }
            }
        }
        synchronized (this.C) {
            try {
                z1Var2 = this.I;
                z10 = false;
                if (z1.h(i, z1Var2.f7571b)) {
                    zK = z1Var.k(this.I, (y1[]) z1Var.f7570a.keySet().toArray(new y1[0]));
                    y1 y1Var = y1.f7555w;
                    if (z1Var.i(y1Var) && !this.I.i(y1Var)) {
                        z10 = true;
                    }
                    z1VarJ = z1Var.j(this.I);
                    this.I = z1VarJ;
                    z11 = z10;
                    z10 = true;
                } else {
                    z1VarJ = z1Var;
                    zK = false;
                    z11 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!z10) {
            g().G.c(z1VarJ, "Ignoring lower-priority consent settings, proposed settings");
            return;
        }
        long andIncrement = this.J.getAndIncrement();
        if (zK) {
            S1(null);
            p2 p2Var = new p2(this, z1VarJ, j5, andIncrement, z11, z1Var2);
            if (!z2) {
                x().z1(p2Var);
                return;
            } else {
                p1();
                p2Var.run();
                return;
            }
        }
        r2 r2Var = new r2(this, z1VarJ, andIncrement, z11, z1Var2);
        if (z2) {
            p1();
            r2Var.run();
        } else if (i == 30 || i == -10) {
            x().z1(r2Var);
        } else {
            x().y1(r2Var);
        }
    }

    public final void J1(boolean z2, long j5) {
        k1 k1Var = (k1) this.f2454v;
        p1();
        t1();
        g().H.d("Resetting analytics data (FE)");
        k3 k3VarS1 = s1();
        k3VarS1.p1();
        o3 o3Var = k3VarS1.A;
        ((p3) o3Var.f7358w).a();
        k1 k1Var2 = (k1) ((k3) o3Var.f7359x).f2454v;
        if (k1Var2.A.A1(null, w.f7467b1)) {
            k1Var2.H.getClass();
            o3Var.f7356u = SystemClock.elapsedRealtime();
        } else {
            o3Var.f7356u = 0L;
        }
        o3Var.f7357v = o3Var.f7356u;
        k1Var.m().y1();
        boolean zH = k1Var.h();
        z0 z0VarN1 = n1();
        z0VarN1.B.d(j5);
        if (!TextUtils.isEmpty(z0VarN1.n1().R.o())) {
            z0VarN1.R.r(null);
        }
        z0VarN1.L.d(0L);
        z0VarN1.M.d(0L);
        Boolean boolY1 = ((k1) z0VarN1.f2454v).A.y1("firebase_analytics_collection_deactivated");
        if (boolY1 == null || !boolY1.booleanValue()) {
            z0VarN1.v1(!zH);
        }
        z0VarN1.S.r(null);
        z0VarN1.T.d(0L);
        z0VarN1.U.c0(null);
        if (z2) {
            z2 z2VarP = k1Var.p();
            z2VarP.p1();
            z2VarP.t1();
            a4 a4VarI1 = z2VarP.I1(false);
            ((k1) z2VarP.f2454v).n().y1();
            z2VarP.w1(new d3(z2VarP, a4VarI1, 0));
        }
        s1().f7291z.r();
        this.M = !zH;
    }

    public final PriorityQueue K1() {
        if (this.G == null) {
            this.G = j2.e.o(Comparator.comparing(new f2(), new c0.i(3)));
        }
        return this.G;
    }

    public final void L1() {
        p1();
        t1();
        k1 k1Var = (k1) this.f2454v;
        if (k1Var.i()) {
            Boolean boolY1 = k1Var.A.y1("google_analytics_deferred_deep_link_enabled");
            if (boolY1 != null && boolY1.booleanValue()) {
                g().H.d("Deferred Deep Link feature enabled.");
                h1 h1VarX = x();
                n1 n1Var = new n1(1);
                n1Var.f7330v = this;
                h1VarX.y1(n1Var);
            }
            z2 z2VarP = k1Var.p();
            z2VarP.p1();
            z2VarP.t1();
            a4 a4VarI1 = z2VarP.I1(true);
            ((k1) z2VarP.f2454v).n().x1(3, new byte[0]);
            z2VarP.w1(new d3(z2VarP, a4VarI1, 1));
            this.M = false;
            z0 z0VarN1 = n1();
            z0VarN1.p1();
            String string = z0VarN1.x1().getString("previous_os_version", null);
            ((k1) z0VarN1.f2454v).l().q1();
            String str = Build.VERSION.RELEASE;
            if (!TextUtils.isEmpty(str) && !str.equals(string)) {
                SharedPreferences.Editor editorEdit = z0VarN1.x1().edit();
                editorEdit.putString("previous_os_version", str);
                editorEdit.apply();
            }
            if (TextUtils.isEmpty(string)) {
                return;
            }
            k1Var.l().q1();
            if (string.equals(str)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", string);
            T1("auto", "_ou", bundle);
        }
    }

    public final void M1() {
        k1 k1Var = (k1) this.f2454v;
        if (!(k1Var.f7282u.getApplicationContext() instanceof Application) || this.f7212x == null) {
            return;
        }
        ((Application) k1Var.f7282u.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.f7212x);
    }

    public final void N1() {
        e9.a();
        if (((k1) this.f2454v).A.A1(null, w.I0)) {
            if (x().A1()) {
                g().A.d("Cannot get trigger URIs from analytics worker thread");
                return;
            }
            if (q9.e.n()) {
                g().A.d("Cannot get trigger URIs from main thread");
                return;
            }
            t1();
            g().I.d("Getting trigger URIs (FE)");
            AtomicReference atomicReference = new AtomicReference();
            h1 h1VarX = x();
            h2 h2Var = new h2();
            h2Var.f7229w = this;
            h2Var.f7228v = atomicReference;
            h1VarX.t1(atomicReference, 5000L, "get trigger URIs", h2Var);
            List list = (List) atomicReference.get();
            if (list == null) {
                g().A.d("Timed out waiting for get trigger URIs");
                return;
            }
            h1 h1VarX2 = x();
            ea.t tVar = new ea.t(11);
            tVar.f4631v = this;
            tVar.f4632w = list;
            h1VarX2.y1(tVar);
        }
    }

    public final void O1() {
        String string;
        int i;
        int i10;
        int i11;
        String string2;
        int i12;
        int i13;
        Bundle bundle;
        String str;
        Bundle bundle2;
        p1();
        g().H.d("Handle tcf update.");
        SharedPreferences sharedPreferencesW1 = n1().w1();
        HashMap map = new HashMap();
        try {
            string = sharedPreferencesW1.getString("IABTCF_VendorConsents", "\u0000");
        } catch (ClassCastException unused) {
            string = "\u0000";
        }
        if (!"\u0000".equals(string) && string.length() > 754) {
            map.put("GoogleConsent", String.valueOf(string.charAt(754)));
        }
        try {
            i = sharedPreferencesW1.getInt("IABTCF_gdprApplies", -1);
        } catch (ClassCastException unused2) {
            i = -1;
        }
        if (i != -1) {
            map.put("gdprApplies", String.valueOf(i));
        }
        try {
            i10 = sharedPreferencesW1.getInt("IABTCF_EnableAdvertiserConsentMode", -1);
        } catch (ClassCastException unused3) {
            i10 = -1;
        }
        if (i10 != -1) {
            map.put("EnableAdvertiserConsentMode", String.valueOf(i10));
        }
        try {
            i11 = sharedPreferencesW1.getInt("IABTCF_PolicyVersion", -1);
        } catch (ClassCastException unused4) {
            i11 = -1;
        }
        if (i11 != -1) {
            map.put("PolicyVersion", String.valueOf(i11));
        }
        try {
            string2 = sharedPreferencesW1.getString("IABTCF_PurposeConsents", "\u0000");
        } catch (ClassCastException unused5) {
            string2 = "\u0000";
        }
        if (!"\u0000".equals(string2)) {
            map.put("PurposeConsents", string2);
        }
        try {
            i12 = sharedPreferencesW1.getInt("IABTCF_CmpSdkID", -1);
        } catch (ClassCastException unused6) {
            i12 = -1;
        }
        if (i12 != -1) {
            map.put("CmpSdkID", String.valueOf(i12));
        }
        q3 q3Var = new q3(map);
        g().I.c(q3Var, "Tcf preferences read");
        z0 z0VarN1 = n1();
        z0VarN1.p1();
        String string3 = z0VarN1.x1().getString("stored_tcf_param", "");
        String strA = q3Var.a();
        if (strA.equals(string3)) {
            return;
        }
        SharedPreferences.Editor editorEdit = z0VarN1.x1().edit();
        editorEdit.putString("stored_tcf_param", strA);
        editorEdit.apply();
        HashMap map2 = q3Var.f7386a;
        if ("1".equals(map2.get("GoogleConsent")) && "1".equals(map2.get("gdprApplies")) && "1".equals(map2.get("EnableAdvertiserConsentMode"))) {
            int iB = q3Var.b();
            if (iB < 0) {
                bundle2 = Bundle.EMPTY;
            } else {
                String str2 = (String) map2.get("PurposeConsents");
                if (TextUtils.isEmpty(str2)) {
                    bundle2 = Bundle.EMPTY;
                } else {
                    bundle = new Bundle();
                    String str3 = "denied";
                    if (str2.length() > 0) {
                        bundle.putString("ad_storage", str2.charAt(0) == '1' ? "granted" : "denied");
                    }
                    if (str2.length() > 3) {
                        bundle.putString("ad_personalization", (str2.charAt(2) == '1' && str2.charAt(3) == '1') ? "granted" : "denied");
                    }
                    if (str2.length() <= 6 || iB < 4) {
                        i13 = 0;
                    } else {
                        i13 = 0;
                        if (str2.charAt(0) == '1' && str2.charAt(6) == '1') {
                            str3 = "granted";
                        }
                        bundle.putString("ad_user_data", str3);
                    }
                }
            }
            bundle = bundle2;
            i13 = 0;
        } else {
            i13 = 0;
            bundle = Bundle.EMPTY;
        }
        g().I.c(bundle, "Consent generated from Tcf");
        if (bundle != Bundle.EMPTY) {
            ((k1) this.f2454v).H.getClass();
            y1(bundle, -30, System.currentTimeMillis());
        }
        Bundle bundle3 = new Bundle();
        StringBuilder sb2 = new StringBuilder("1");
        try {
            str = (String) map2.get("CmpSdkID");
        } catch (NumberFormatException unused7) {
        }
        int i14 = !TextUtils.isEmpty(str) ? Integer.parseInt(str) : -1;
        if (i14 < 0 || i14 > 4095) {
            sb2.append("00");
        } else {
            sb2.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt((i14 >> 6) & 63));
            sb2.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i14 & 63));
        }
        int iB2 = q3Var.b();
        if (iB2 < 0 || iB2 > 63) {
            sb2.append("0");
        } else {
            sb2.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(iB2));
        }
        int i15 = "1".equals(map2.get("gdprApplies")) ? 2 : i13;
        int i16 = i15 | 4;
        if ("1".equals(map2.get("EnableAdvertiserConsentMode"))) {
            i16 = i15 | 12;
        }
        sb2.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i16));
        bundle3.putString("_tcfd", sb2.toString());
        T1("auto", "_tcf", bundle3);
    }

    public final void P1() {
        r3 r3Var;
        p1();
        this.H = false;
        if (K1().isEmpty() || this.D || (r3Var = (r3) K1().poll()) == null) {
            return;
        }
        String str = r3Var.f7404u;
        m4.a aVarA2 = o1().A2();
        if (aVarA2 == null) {
            return;
        }
        this.D = true;
        g().I.c(str, "Registering trigger URI");
        ea.y yVarD = aVarA2.d(Uri.parse(str));
        if (yVarD == null) {
            this.D = false;
            K1().add(r3Var);
            return;
        }
        if (!((k1) this.f2454v).A.A1(null, w.N0)) {
            SparseArray sparseArrayY1 = n1().y1();
            sparseArrayY1.put(r3Var.f7406w, Long.valueOf(r3Var.f7405v));
            n1().t1(sparseArrayY1);
        }
        yVarD.f(new ea.t(yVarD, 0, new h4.z(23, this, r3Var, false)), new c7.r(1, this));
    }

    public final void Q1() {
        g2 g2Var;
        k1 k1Var = (k1) this.f2454v;
        p1();
        String strO = n1().I.o();
        if (strO == null) {
            g2Var = this;
        } else if ("unset".equals(strO)) {
            k1Var.H.getClass();
            g2Var = this;
            g2Var.x1(System.currentTimeMillis(), null, "app", "_npa");
        } else {
            Long lValueOf = Long.valueOf("true".equals(strO) ? 1L : 0L);
            k1Var.H.getClass();
            x1(System.currentTimeMillis(), lValueOf, "app", "_npa");
            g2Var = this;
        }
        if (k1Var.h() && g2Var.M) {
            g().H.d("Recording app launch after enabling measurement for the first time (FE)");
            L1();
            s1().f7291z.r();
            x().y1(new n1(this));
            return;
        }
        g().H.d("Updating Scion state (FE)");
        z2 z2VarP = k1Var.p();
        z2VarP.p1();
        z2VarP.t1();
        z2VarP.w1(new d3(z2VarP, z2VarP.I1(true), 3));
    }

    public final void R1(Bundle bundle, long j5) {
        k1 k1Var = (k1) this.f2454v;
        t7.v.h(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            g().D.d("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        c2.a(bundle2, "app_id", String.class, null);
        c2.a(bundle2, "origin", String.class, null);
        c2.a(bundle2, "name", String.class, null);
        c2.a(bundle2, "value", Object.class, null);
        c2.a(bundle2, "trigger_event_name", String.class, null);
        c2.a(bundle2, "trigger_timeout", Long.class, 0L);
        c2.a(bundle2, "timed_out_event_name", String.class, null);
        c2.a(bundle2, "timed_out_event_params", Bundle.class, null);
        c2.a(bundle2, "triggered_event_name", String.class, null);
        c2.a(bundle2, "triggered_event_params", Bundle.class, null);
        c2.a(bundle2, "time_to_live", Long.class, 0L);
        c2.a(bundle2, "expired_event_name", String.class, null);
        c2.a(bundle2, "expired_event_params", Bundle.class, null);
        t7.v.d(bundle2.getString("name"));
        t7.v.d(bundle2.getString("origin"));
        t7.v.h(bundle2.get("value"));
        bundle2.putLong("creation_timestamp", j5);
        String string = bundle2.getString("name");
        Object obj = bundle2.get("value");
        if (o1().i2(string) != 0) {
            g().A.c(k1Var.G.g(string), "Invalid conditional user property name");
            return;
        }
        if (o1().t1(obj, string) != 0) {
            g().A.b(k1Var.G.g(string), obj, "Invalid conditional user property value");
            return;
        }
        Object objO2 = o1().o2(obj, string);
        if (objO2 == null) {
            g().A.b(k1Var.G.g(string), obj, "Unable to normalize conditional user property value");
            return;
        }
        c2.e(bundle2, objO2);
        long j8 = bundle2.getLong("trigger_timeout");
        if (!TextUtils.isEmpty(bundle2.getString("trigger_event_name")) && (j8 > 15552000000L || j8 < 1)) {
            g().A.b(k1Var.G.g(string), Long.valueOf(j8), "Invalid conditional user property timeout");
            return;
        }
        long j10 = bundle2.getLong("time_to_live");
        if (j10 > 15552000000L || j10 < 1) {
            g().A.b(k1Var.G.g(string), Long.valueOf(j10), "Invalid conditional user property time to live");
        } else {
            x().y1(new i2(this, bundle2, 2));
        }
    }

    public final void S1(String str) {
        this.B.set(str);
    }

    public final void T1(String str, String str2, Bundle bundle) {
        p1();
        ((k1) this.f2454v).H.getClass();
        w1(System.currentTimeMillis(), bundle, str, str2);
    }

    @Override // k8.y0
    public final boolean v1() {
        return false;
    }

    public final void w1(long j5, Bundle bundle, String str, String str2) {
        p1();
        A1(str, str2, j5, bundle, true, this.f7213y == null || h4.u2(str2), true);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void x1(long r11, java.lang.Object r13, java.lang.String r14, java.lang.String r15) {
        /*
            Method dump skipped, instruction units count: 215
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.g2.x1(long, java.lang.Object, java.lang.String, java.lang.String):void");
    }

    public final void y1(Bundle bundle, int i, long j5) {
        String string;
        b2 b2Var;
        t1();
        z1 z1Var = z1.f7569c;
        y1[] y1VarArr = a2.STORAGE.f7074u;
        int length = y1VarArr.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                string = null;
                break;
            }
            y1 y1Var = y1VarArr[i10];
            if (bundle.containsKey(y1Var.f7559u) && (string = bundle.getString(y1Var.f7559u)) != null) {
                if ((string.equals("granted") ? Boolean.TRUE : string.equals("denied") ? Boolean.FALSE : null) == null) {
                    break;
                }
            }
            i10++;
        }
        if (string != null) {
            g().F.c(string, "Ignoring invalid consent setting");
            g().F.d("Valid consent values are 'granted', 'denied'");
        }
        boolean zA1 = x().A1();
        z1 z1VarC = z1.c(i, bundle);
        Iterator it = z1VarC.f7570a.values().iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            b2Var = b2.f7089v;
            if (!zHasNext) {
                break;
            } else if (((b2) it.next()) != b2Var) {
                G1(z1VarC, j5, zA1);
                break;
            }
        }
        o oVarB = o.b(i, bundle);
        Iterator it2 = oVarB.f7341e.values().iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            } else if (((b2) it2.next()) != b2Var) {
                E1(oVarB, zA1);
                break;
            }
        }
        Boolean boolA = o.a(bundle);
        if (boolA != null) {
            String str = i == -30 ? "tcf" : "app";
            if (((k1) this.f2454v).A.A1(null, w.S0) && zA1) {
                x1(j5, boolA.toString(), str, "allow_personalized_ads");
            } else {
                D1(str, "allow_personalized_ads", boolA.toString(), false, j5);
            }
        }
    }

    public final void z1(Boolean bool, boolean z2) {
        p1();
        t1();
        g().H.c(bool, "Setting app measurement enabled (FE)");
        z0 z0VarN1 = n1();
        z0VarN1.p1();
        SharedPreferences.Editor editorEdit = z0VarN1.x1().edit();
        if (bool != null) {
            editorEdit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            editorEdit.remove("measurement_enabled");
        }
        editorEdit.apply();
        if (z2) {
            z0 z0VarN12 = n1();
            z0VarN12.p1();
            SharedPreferences.Editor editorEdit2 = z0VarN12.x1().edit();
            if (bool != null) {
                editorEdit2.putBoolean("measurement_enabled_from_api", bool.booleanValue());
            } else {
                editorEdit2.remove("measurement_enabled_from_api");
            }
            editorEdit2.apply();
        }
        k1 k1Var = (k1) this.f2454v;
        h1 h1Var = k1Var.D;
        k1.f(h1Var);
        h1Var.p1();
        if (k1Var.X || !(bool == null || bool.booleanValue())) {
            Q1();
        }
    }
}
