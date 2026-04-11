package f9;

import android.app.Application;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.q8;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class x2 extends h0 {
    public final CopyOnWriteArraySet A;
    public boolean B;
    public final AtomicReference C;
    public final Object D;
    public boolean E;
    public int F;
    public l2 G;
    public l2 H;
    public PriorityQueue I;
    public boolean J;
    public g2 K;
    public final AtomicLong L;
    public long M;
    public final p6.d N;
    public boolean O;
    public l2 P;
    public w2 Q;
    public l2 R;
    public final p6.d S;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public t2 f4479y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public l4.c0 f4480z;

    public x2(r1 r1Var) {
        super(r1Var);
        this.A = new CopyOnWriteArraySet();
        this.D = new Object();
        this.E = false;
        this.F = 1;
        this.O = true;
        this.S = new p6.d(15, this);
        this.C = new AtomicReference();
        this.K = g2.f4188c;
        this.M = -1L;
        this.L = new AtomicLong(0L);
        this.N = new p6.d(17, r1Var);
    }

    public final void A1(String str, String str2, Bundle bundle) {
        r1 r1Var = (r1) this.f307w;
        r1Var.F.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        o8.u.d(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong("creation_timestamp", jCurrentTimeMillis);
        if (str2 != null) {
            bundle2.putString("expired_event_name", str2);
            bundle2.putBundle("expired_event_params", bundle);
        }
        p1 p1Var = r1Var.B;
        r1.g(p1Var);
        p1Var.v1(new r2(this, bundle2, 1));
    }

    public final String B1() {
        r1 r1Var = (r1) this.f307w;
        try {
            return h2.b(r1Var.f4363v, r1Var.K);
        } catch (IllegalStateException e9) {
            w0 w0Var = r1Var.A;
            r1.g(w0Var);
            w0Var.B.b(e9, "getGoogleAppId failed with exception");
            return null;
        }
    }

    public final void C1(g2 g2Var, long j4, boolean z10) {
        int i = g2Var.f4190b;
        m1();
        n1();
        r1 r1Var = (r1) this.f307w;
        f1 f1Var = r1Var.f4367z;
        w0 w0Var = r1Var.A;
        r1.e(f1Var);
        g2 g2VarT1 = f1Var.t1();
        if (j4 <= this.M && g2.l(g2VarT1.f4190b, i)) {
            r1.g(w0Var);
            w0Var.H.b(g2Var, "Dropped out-of-date consent setting, proposed settings");
            return;
        }
        f1 f1Var2 = r1Var.f4367z;
        r1.e(f1Var2);
        f1Var2.m1();
        if (!g2.l(i, f1Var2.q1().getInt("consent_source", 100))) {
            r1.g(w0Var);
            w0Var.H.b(Integer.valueOf(i), "Lower precedence consent source ignored, proposed source");
            return;
        }
        SharedPreferences.Editor editorEdit = f1Var2.q1().edit();
        editorEdit.putString("consent_settings", g2Var.g());
        editorEdit.putInt("consent_source", i);
        editorEdit.apply();
        r1.g(w0Var);
        w0Var.J.b(g2Var, "Setting storage consent(FE)");
        this.M = j4;
        if (r1Var.j().w1()) {
            t3 t3VarJ = r1Var.j();
            t3VarJ.m1();
            t3VarJ.n1();
            t3VarJ.A1(new r3(t3VarJ, 2));
        } else {
            t3 t3VarJ2 = r1Var.j();
            t3VarJ2.m1();
            t3VarJ2.n1();
            if (t3VarJ2.v1()) {
                t3VarJ2.A1(new o3(t3VarJ2, t3VarJ2.C1(false)));
            }
        }
        if (z10) {
            r1Var.j().q1(new AtomicReference());
        }
    }

    public final void D1(Boolean bool, boolean z10) {
        m1();
        n1();
        r1 r1Var = (r1) this.f307w;
        w0 w0Var = r1Var.A;
        r1.g(w0Var);
        w0Var.I.b(bool, "Setting app measurement enabled (FE)");
        f1 f1Var = r1Var.f4367z;
        r1.e(f1Var);
        f1Var.m1();
        SharedPreferences.Editor editorEdit = f1Var.q1().edit();
        if (bool != null) {
            editorEdit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            editorEdit.remove("measurement_enabled");
        }
        editorEdit.apply();
        if (z10) {
            f1Var.m1();
            SharedPreferences.Editor editorEdit2 = f1Var.q1().edit();
            if (bool != null) {
                editorEdit2.putBoolean("measurement_enabled_from_api", bool.booleanValue());
            } else {
                editorEdit2.remove("measurement_enabled_from_api");
            }
            editorEdit2.apply();
        }
        p1 p1Var = r1Var.B;
        r1.g(p1Var);
        p1Var.m1();
        if (r1Var.U || !(bool == null || bool.booleanValue())) {
            E1();
        }
    }

    public final void E1() {
        m1();
        r1 r1Var = (r1) this.f307w;
        f1 f1Var = r1Var.f4367z;
        w0 w0Var = r1Var.A;
        s8.a aVar = r1Var.F;
        r1.e(f1Var);
        String strR = f1Var.I.r();
        if (strR != null) {
            if ("unset".equals(strR)) {
                aVar.getClass();
                x1(System.currentTimeMillis(), null, "app", "_npa");
            } else {
                Long lValueOf = Long.valueOf(true != "true".equals(strR) ? 0L : 1L);
                aVar.getClass();
                x1(System.currentTimeMillis(), lValueOf, "app", "_npa");
            }
        }
        if (!r1Var.a() || !this.O) {
            r1.g(w0Var);
            w0Var.I.a("Updating Scion state (FE)");
            t3 t3VarJ = r1Var.j();
            t3VarJ.m1();
            t3VarJ.n1();
            t3VarJ.A1(new o3(t3VarJ, t3VarJ.C1(true), 3));
            return;
        }
        r1.g(w0Var);
        w0Var.I.a("Recording app launch after enabling measurement for the first time (FE)");
        y1();
        b4 b4Var = r1Var.C;
        r1.f(b4Var);
        b4Var.A.t();
        p1 p1Var = r1Var.B;
        r1.g(p1Var);
        p1Var.v1(new k2(this, 1));
    }

    public final void F1() {
        r1 r1Var = (r1) this.f307w;
        if (!(r1Var.f4363v.getApplicationContext() instanceof Application) || this.f4479y == null) {
            return;
        }
        ((Application) r1Var.f4363v.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.f4479y);
    }

    public final void G1(Bundle bundle, int i, long j4) throws Throwable {
        Boolean bool;
        String string;
        d2 d2Var;
        r1 r1Var = (r1) this.f307w;
        n1();
        g2 g2Var = g2.f4188c;
        f2[] f2VarArr = e2.STORAGE.f4101v;
        int length = f2VarArr.length;
        int i10 = 0;
        while (true) {
            bool = null;
            if (i10 >= length) {
                string = null;
                break;
            }
            String str = f2VarArr[i10].f4174v;
            if (bundle.containsKey(str) && (string = bundle.getString(str)) != null) {
                if ((string.equals("granted") ? Boolean.TRUE : string.equals("denied") ? Boolean.FALSE : null) == null) {
                    break;
                }
            }
            i10++;
        }
        if (string != null) {
            w0 w0Var = r1Var.A;
            r1.g(w0Var);
            w0Var.G.b(string, "Ignoring invalid consent setting");
            w0 w0Var2 = r1Var.A;
            r1.g(w0Var2);
            w0Var2.G.a("Valid consent values are 'granted', 'denied'");
        }
        p1 p1Var = r1Var.B;
        r1.g(p1Var);
        boolean zS1 = p1Var.s1();
        g2 g2VarB = g2.b(i, bundle);
        Iterator it = g2VarB.f4189a.values().iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            d2Var = d2.f4070w;
            if (!zHasNext) {
                break;
            } else if (((d2) it.next()) != d2Var) {
                I1(g2VarB, zS1);
                break;
            }
        }
        p pVarC = p.c(i, bundle);
        Iterator it2 = pVarC.f4318e.values().iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            } else if (((d2) it2.next()) != d2Var) {
                H1(pVarC, zS1);
                break;
            }
        }
        if (bundle != null) {
            int iOrdinal = g2.d(bundle.getString("ad_personalization")).ordinal();
            if (iOrdinal == 2) {
                bool = Boolean.FALSE;
            } else if (iOrdinal == 3) {
                bool = Boolean.TRUE;
            }
        }
        if (bool != null) {
            String str2 = i == -30 ? "tcf" : "app";
            if (zS1) {
                x1(j4, bool.toString(), str2, "allow_personalized_ads");
            } else {
                w1(str2, "allow_personalized_ads", bool.toString(), false, j4);
            }
        }
    }

    public final void H1(p pVar, boolean z10) {
        ya.s sVar = new ya.s(9, this, pVar, false);
        if (z10) {
            m1();
            sVar.run();
        } else {
            p1 p1Var = ((r1) this.f307w).B;
            r1.g(p1Var);
            p1Var.v1(sVar);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:70:0x0116
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public final void I1(f9.g2 r14, boolean r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.x2.I1(f9.g2, boolean):void");
    }

    public final void J1() {
        q8.a();
        r1 r1Var = (r1) this.f307w;
        g gVar = r1Var.f4366y;
        p1 p1Var = r1Var.B;
        w0 w0Var = r1Var.A;
        if (gVar.w1(null, f0.R0)) {
            r1.g(p1Var);
            if (p1Var.s1()) {
                r1.g(w0Var);
                w0Var.B.a("Cannot get trigger URIs from analytics worker thread");
                return;
            }
            if (jb.b.i()) {
                r1.g(w0Var);
                w0Var.B.a("Cannot get trigger URIs from main thread");
                return;
            }
            n1();
            r1.g(w0Var);
            w0Var.J.a("Getting trigger URIs (FE)");
            AtomicReference atomicReference = new AtomicReference();
            r1.g(p1Var);
            p1Var.w1(atomicReference, 10000L, "get trigger URIs", new q2(this, atomicReference, 5, false));
            List list = (List) atomicReference.get();
            if (list == null) {
                r1.g(w0Var);
                w0Var.D.a("Timed out waiting for get trigger URIs");
            } else {
                r1.g(p1Var);
                p1Var.v1(new ya.s(11, this, list));
            }
        }
    }

    public final PriorityQueue K1() {
        if (this.I == null) {
            v2 v2Var = v2.f4450a;
            this.I = a9.b.m(Comparator.comparing(v2.f4450a, a5.f.f276w));
        }
        return this.I;
    }

    public final void L1() {
        f4 f4Var;
        m1();
        this.J = false;
        if (K1().isEmpty() || this.E || (f4Var = (f4) K1().poll()) == null) {
            return;
        }
        r1 r1Var = (r1) this.f307w;
        u4 u4Var = r1Var.D;
        r1.e(u4Var);
        r4.b bVarH1 = u4Var.H1();
        if (bVarH1 != null) {
            this.E = true;
            w0 w0Var = r1Var.A;
            r1.g(w0Var);
            u0 u0Var = w0Var.J;
            String str = f4Var.f4180v;
            u0Var.b(str, "Registering trigger URI");
            ya.w wVarE = bVarH1.e(Uri.parse(str));
            if (wVarE != null) {
                wVarE.h(new ya.s(0, wVarE, new l4.c0(17, this, f4Var, false)), new m2(0, this));
            } else {
                this.E = false;
                K1().add(f4Var);
            }
        }
    }

    @Override // f9.h0
    public final boolean p1() {
        return false;
    }

    public final void q1(g2 g2Var) {
        m1();
        boolean z10 = (g2Var.i(f2.f4171x) && g2Var.i(f2.f4170w)) || ((r1) this.f307w).j().v1();
        r1 r1Var = (r1) this.f307w;
        p1 p1Var = r1Var.B;
        r1.g(p1Var);
        p1Var.m1();
        if (z10 != r1Var.U) {
            p1 p1Var2 = r1Var.B;
            r1.g(p1Var2);
            p1Var2.m1();
            r1Var.U = z10;
            f1 f1Var = ((r1) this.f307w).f4367z;
            r1.e(f1Var);
            f1Var.m1();
            Boolean boolValueOf = f1Var.q1().contains("measurement_enabled_from_api") ? Boolean.valueOf(f1Var.q1().getBoolean("measurement_enabled_from_api", true)) : null;
            if (!z10 || boolValueOf == null || boolValueOf.booleanValue()) {
                D1(Boolean.valueOf(z10), false);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0055, code lost:
    
        if (r4 > 500) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008c, code lost:
    
        if (r6 > 500) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r1(java.lang.String r13, java.lang.String r14, android.os.Bundle r15, boolean r16, boolean r17, long r18) {
        /*
            Method dump skipped, instruction units count: 477
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.x2.r1(java.lang.String, java.lang.String, android.os.Bundle, boolean, boolean, long):void");
    }

    public final void s1() throws Throwable {
        w0 w0Var;
        String str;
        int i;
        int i10;
        int i11;
        int i12;
        c4 c4Var;
        c4 c4Var2;
        x2 x2Var;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        ua.e1 e1Var;
        com.google.android.gms.internal.measurement.t4 t4Var;
        ua.k0 k0VarC;
        com.google.android.gms.internal.measurement.t4 t4Var2;
        m1();
        r1 r1Var = (r1) this.f307w;
        w0 w0Var2 = r1Var.A;
        s8.a aVar = r1Var.F;
        r1.g(w0Var2);
        w0Var2.I.a("Handle tcf update.");
        f1 f1Var = r1Var.f4367z;
        r1.e(f1Var);
        SharedPreferences sharedPreferencesR1 = f1Var.r1();
        HashMap map = new HashMap();
        e0 e0Var = f0.f4110a1;
        int i18 = 2;
        int i19 = 1;
        if (((Boolean) e0Var.a(null)).booleanValue()) {
            ua.z0 z0Var = e4.f4107a;
            com.google.android.gms.internal.measurement.s4 s4Var = com.google.android.gms.internal.measurement.s4.f2604w;
            w0Var = w0Var2;
            d4 d4Var = d4.f4080v;
            AbstractMap.SimpleImmutableEntry simpleImmutableEntry = new AbstractMap.SimpleImmutableEntry(s4Var, d4Var);
            com.google.android.gms.internal.measurement.s4 s4Var2 = com.google.android.gms.internal.measurement.s4.f2605x;
            d4 d4Var2 = d4.f4081w;
            AbstractMap.SimpleImmutableEntry simpleImmutableEntry2 = new AbstractMap.SimpleImmutableEntry(s4Var2, d4Var2);
            com.google.android.gms.internal.measurement.s4 s4Var3 = com.google.android.gms.internal.measurement.s4.f2606y;
            AbstractMap.SimpleImmutableEntry simpleImmutableEntry3 = new AbstractMap.SimpleImmutableEntry(s4Var3, d4Var);
            com.google.android.gms.internal.measurement.s4 s4Var4 = com.google.android.gms.internal.measurement.s4.f2607z;
            AbstractMap.SimpleImmutableEntry simpleImmutableEntry4 = new AbstractMap.SimpleImmutableEntry(s4Var4, d4Var);
            com.google.android.gms.internal.measurement.s4 s4Var5 = com.google.android.gms.internal.measurement.s4.A;
            List listAsList = Arrays.asList(simpleImmutableEntry, simpleImmutableEntry2, simpleImmutableEntry3, simpleImmutableEntry4, new AbstractMap.SimpleImmutableEntry(s4Var5, d4Var2), new AbstractMap.SimpleImmutableEntry(com.google.android.gms.internal.measurement.s4.B, d4Var2), new AbstractMap.SimpleImmutableEntry(com.google.android.gms.internal.measurement.s4.C, d4Var2));
            f3.a aVar2 = new f3.a(q4.a.v(listAsList) ? listAsList.size() : 4);
            aVar2.v(listAsList);
            ua.e1 e1Var2 = (ua.e1) aVar2.c();
            int i20 = ua.m0.f12358x;
            ua.l1 l1Var = new ua.l1("CH");
            char[] cArr = new char[5];
            boolean zContains = sharedPreferencesR1.contains("IABTCF_TCString");
            try {
                i13 = sharedPreferencesR1.getInt("IABTCF_CmpSdkID", -1);
            } catch (ClassCastException unused) {
                i13 = -1;
            }
            try {
                i14 = sharedPreferencesR1.getInt("IABTCF_PolicyVersion", -1);
            } catch (ClassCastException unused2) {
                i14 = -1;
            }
            try {
                i15 = sharedPreferencesR1.getInt("IABTCF_gdprApplies", -1);
            } catch (ClassCastException unused3) {
                i15 = -1;
            }
            int i21 = i14;
            try {
                i16 = sharedPreferencesR1.getInt("IABTCF_PurposeOneTreatment", -1);
            } catch (ClassCastException unused4) {
                i16 = -1;
            }
            try {
                i17 = sharedPreferencesR1.getInt("IABTCF_EnableAdvertiserConsentMode", -1);
            } catch (ClassCastException unused5) {
                i17 = -1;
            }
            String strA = e4.a(sharedPreferencesR1, "IABTCF_PublisherCC");
            int i22 = i13;
            f3.a aVar3 = new f3.a(4);
            ua.m0 m0VarC = e1Var2.f12350w;
            if (m0VarC == null) {
                m0VarC = e1Var2.c();
                e1Var2.f12350w = m0VarC;
            }
            ua.n1 it = m0VarC.iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                e1Var = e1Var2;
                t4Var = com.google.android.gms.internal.measurement.t4.f2639z;
                if (!zHasNext) {
                    break;
                }
                com.google.android.gms.internal.measurement.s4 s4Var6 = (com.google.android.gms.internal.measurement.s4) it.next();
                ua.n1 n1Var = it;
                int iA = s4Var6.a();
                String str2 = strA;
                int i23 = i16;
                StringBuilder sb = new StringBuilder(String.valueOf(iA).length() + 28);
                sb.append("IABTCF_PublisherRestrictions");
                sb.append(iA);
                String strA2 = e4.a(sharedPreferencesR1, sb.toString());
                if (TextUtils.isEmpty(strA2) || strA2.length() < 755) {
                    t4Var2 = t4Var;
                } else {
                    int iDigit = Character.digit(strA2.charAt(754), 10);
                    t4Var2 = com.google.android.gms.internal.measurement.t4.f2636w;
                    if (iDigit >= 0 && iDigit <= com.google.android.gms.internal.measurement.t4.values().length && iDigit != 0) {
                        if (iDigit == i19) {
                            t4Var = com.google.android.gms.internal.measurement.t4.f2637x;
                        } else if (iDigit == i18) {
                            t4Var = com.google.android.gms.internal.measurement.t4.f2638y;
                        }
                        t4Var2 = t4Var;
                    }
                }
                aVar3.u(s4Var6, t4Var2);
                it = n1Var;
                e1Var2 = e1Var;
                i16 = i23;
                strA = str2;
                i18 = 2;
                i19 = 1;
            }
            int i24 = i16;
            String str3 = strA;
            ua.k0 k0VarC2 = aVar3.c();
            String strA3 = e4.a(sharedPreferencesR1, "IABTCF_PurposeConsents");
            String strA4 = e4.a(sharedPreferencesR1, "IABTCF_VendorConsents");
            boolean z10 = !TextUtils.isEmpty(strA4) && strA4.length() >= 755 && strA4.charAt(754) == '1';
            String strA5 = e4.a(sharedPreferencesR1, "IABTCF_PurposeLegitimateInterests");
            String strA6 = e4.a(sharedPreferencesR1, "IABTCF_VendorLegitimateInterests");
            boolean z11 = !TextUtils.isEmpty(strA6) && strA6.length() >= 755 && strA6.charAt(754) == '1';
            cArr[0] = '2';
            if (zContains) {
                com.google.android.gms.internal.measurement.t4 t4Var3 = (com.google.android.gms.internal.measurement.t4) k0VarC2.get(s4Var);
                com.google.android.gms.internal.measurement.t4 t4Var4 = (com.google.android.gms.internal.measurement.t4) k0VarC2.get(s4Var3);
                com.google.android.gms.internal.measurement.t4 t4Var5 = (com.google.android.gms.internal.measurement.t4) k0VarC2.get(s4Var4);
                com.google.android.gms.internal.measurement.t4 t4Var6 = (com.google.android.gms.internal.measurement.t4) k0VarC2.get(s4Var5);
                f3.a aVar4 = new f3.a(4);
                aVar4.u("Version", "2");
                boolean z12 = z10;
                aVar4.u("VendorConsent", true != z10 ? "0" : "1");
                boolean z13 = z11;
                aVar4.u("VendorLegitimateInterest", true != z11 ? "0" : "1");
                aVar4.u("gdprApplies", i15 != 1 ? "0" : "1");
                aVar4.u("EnableAdvertiserConsentMode", i17 != 1 ? "0" : "1");
                aVar4.u("PolicyVersion", String.valueOf(i21));
                aVar4.u("CmpSdkID", String.valueOf(i22));
                aVar4.u("PurposeOneTreatment", i24 != 1 ? "0" : "1");
                aVar4.u("PublisherCC", str3);
                aVar4.u("PublisherRestrictions1", String.valueOf(t4Var3 != null ? t4Var3.a() : t4Var.a()));
                aVar4.u("PublisherRestrictions3", String.valueOf(t4Var4 != null ? t4Var4.a() : t4Var.a()));
                aVar4.u("PublisherRestrictions4", String.valueOf(t4Var5 != null ? t4Var5.a() : t4Var.a()));
                aVar4.u("PublisherRestrictions7", String.valueOf(t4Var6 != null ? t4Var6.a() : t4Var.a()));
                String strD = e4.d(s4Var, strA3, strA5);
                String strD2 = e4.d(s4Var3, strA3, strA5);
                String strD3 = e4.d(s4Var4, strA3, strA5);
                String strD4 = e4.d(s4Var5, strA3, strA5);
                ua.q.c("Purpose1", strD);
                ua.q.c("Purpose3", strD2);
                ua.q.c("Purpose4", strD3);
                ua.q.c("Purpose7", strD4);
                int i25 = i17;
                int i26 = i15;
                k0VarC = aVar4.w(ua.e1.f(4, new Object[]{"Purpose1", strD, "Purpose3", strD2, "Purpose4", strD3, "Purpose7", strD4}, null)).w(ua.e1.f(5, new Object[]{"AuthorizePurpose1", true != e4.b(s4Var, e1Var, k0VarC2, l1Var, cArr, i25, i26, i24, str3, strA3, strA5, z12, z13) ? "0" : "1", "AuthorizePurpose3", true != e4.b(s4Var3, e1Var, k0VarC2, l1Var, cArr, i25, i26, i24, str3, strA3, strA5, z12, z13) ? "0" : "1", "AuthorizePurpose4", true != e4.b(s4Var4, e1Var, k0VarC2, l1Var, cArr, i25, i26, i24, str3, strA3, strA5, z12, z13) ? "0" : "1", "AuthorizePurpose7", true != e4.b(s4Var5, e1Var, k0VarC2, l1Var, cArr, i25, i26, i24, str3, strA3, strA5, z12, z13) ? "0" : "1", "PurposeDiagnostics", new String(cArr)}, null)).c();
            } else {
                k0VarC = ua.e1.B;
            }
            c4Var = new c4(k0VarC);
            str = "";
        } else {
            w0Var = w0Var2;
            String strA7 = e4.a(sharedPreferencesR1, "IABTCF_VendorConsents");
            str = "";
            if (!str.equals(strA7) && strA7.length() > 754) {
                map.put("GoogleConsent", String.valueOf(strA7.charAt(754)));
            }
            try {
                i = sharedPreferencesR1.getInt("IABTCF_gdprApplies", -1);
            } catch (ClassCastException unused6) {
                i = -1;
            }
            if (i != -1) {
                map.put("gdprApplies", String.valueOf(i));
            }
            try {
                i10 = sharedPreferencesR1.getInt("IABTCF_EnableAdvertiserConsentMode", -1);
            } catch (ClassCastException unused7) {
                i10 = -1;
            }
            if (i10 != -1) {
                map.put("EnableAdvertiserConsentMode", String.valueOf(i10));
            }
            try {
                i11 = sharedPreferencesR1.getInt("IABTCF_PolicyVersion", -1);
            } catch (ClassCastException unused8) {
                i11 = -1;
            }
            if (i11 != -1) {
                map.put("PolicyVersion", String.valueOf(i11));
            }
            String strA8 = e4.a(sharedPreferencesR1, "IABTCF_PurposeConsents");
            if (!str.equals(strA8)) {
                map.put("PurposeConsents", strA8);
            }
            try {
                i12 = sharedPreferencesR1.getInt("IABTCF_CmpSdkID", -1);
            } catch (ClassCastException unused9) {
                i12 = -1;
            }
            if (i12 != -1) {
                map.put("CmpSdkID", String.valueOf(i12));
            }
            c4Var = new c4(map);
        }
        r1.g(w0Var);
        w0 w0Var3 = w0Var;
        u0 u0Var = w0Var3.J;
        u0Var.b(c4Var, "Tcf preferences read");
        if (!r1Var.f4366y.w1(null, e0Var)) {
            if (f1Var.u1(c4Var)) {
                Bundle bundleB = c4Var.b();
                r1.g(w0Var3);
                u0Var.b(bundleB, "Consent generated from Tcf");
                if (bundleB != Bundle.EMPTY) {
                    aVar.getClass();
                    G1(bundleB, -30, System.currentTimeMillis());
                }
                Bundle bundle = new Bundle();
                bundle.putString("_tcfd", c4Var.c());
                t1("auto", "_tcf", bundle);
                return;
            }
            return;
        }
        f1Var.m1();
        String string = f1Var.q1().getString("stored_tcf_param", str);
        HashMap map2 = new HashMap();
        if (TextUtils.isEmpty(string)) {
            c4Var2 = new c4(map2);
        } else {
            for (String str4 : string.split(";")) {
                String[] strArrSplit = str4.split("=");
                if (strArrSplit.length >= 2 && e4.f4107a.contains(strArrSplit[0])) {
                    map2.put(strArrSplit[0], strArrSplit[1]);
                }
            }
            c4Var2 = new c4(map2);
        }
        if (f1Var.u1(c4Var)) {
            Bundle bundleB2 = c4Var.b();
            r1.g(w0Var3);
            u0Var.b(bundleB2, "Consent generated from Tcf");
            if (bundleB2 != Bundle.EMPTY) {
                aVar.getClass();
                x2Var = this;
                x2Var.G1(bundleB2, -30, System.currentTimeMillis());
            } else {
                x2Var = this;
            }
            Bundle bundle2 = new Bundle();
            HashMap map3 = c4Var2.f4061a;
            String str5 = (map3.isEmpty() || ((String) map3.get("Version")) != null) ? "0" : "1";
            Bundle bundleB3 = c4Var.b();
            Bundle bundleB4 = c4Var2.b();
            bundle2.putString("_tcfm", str5.concat((bundleB3.size() == bundleB4.size() && Objects.equals(bundleB3.getString("ad_storage"), bundleB4.getString("ad_storage")) && Objects.equals(bundleB3.getString("ad_personalization"), bundleB4.getString("ad_personalization")) && Objects.equals(bundleB3.getString("ad_user_data"), bundleB4.getString("ad_user_data"))) ? "0" : "1"));
            String str6 = (String) c4Var.f4061a.get("PurposeDiagnostics");
            if (TextUtils.isEmpty(str6)) {
                str6 = "200000";
            }
            bundle2.putString("_tcfd2", str6);
            bundle2.putString("_tcfd", c4Var.c());
            x2Var.t1("auto", "_tcf", bundle2);
        }
    }

    public final void t1(String str, String str2, Bundle bundle) {
        m1();
        ((r1) this.f307w).F.getClass();
        u1(System.currentTimeMillis(), bundle, str, str2);
    }

    public final void u1(long j4, Bundle bundle, String str, String str2) {
        m1();
        boolean z10 = true;
        if (this.f4480z != null && !u4.L1(str2)) {
            z10 = false;
        }
        v1(str, str2, j4, bundle, true, z10, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:217:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0200  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void v1(java.lang.String r30, java.lang.String r31, long r32, android.os.Bundle r34, boolean r35, boolean r36, boolean r37) {
        /*
            Method dump skipped, instruction units count: 1285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.x2.v1(java.lang.String, java.lang.String, long, android.os.Bundle, boolean, boolean, boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w1(java.lang.String r12, java.lang.String r13, java.lang.Object r14, boolean r15, long r16) {
        /*
            Method dump skipped, instruction units count: 215
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.x2.w1(java.lang.String, java.lang.String, java.lang.Object, boolean, long):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void x1(long r20, java.lang.Object r22, java.lang.String r23, java.lang.String r24) {
        /*
            Method dump skipped, instruction units count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.x2.x1(long, java.lang.Object, java.lang.String, java.lang.String):void");
    }

    public final void y1() {
        m1();
        n1();
        r1 r1Var = (r1) this.f307w;
        if (r1Var.c()) {
            g gVar = r1Var.f4366y;
            ((r1) gVar.f307w).getClass();
            Boolean boolY1 = gVar.y1("google_analytics_deferred_deep_link_enabled");
            if (boolY1 != null && boolY1.booleanValue()) {
                w0 w0Var = r1Var.A;
                r1.g(w0Var);
                w0Var.I.a("Deferred Deep Link feature enabled.");
                p1 p1Var = r1Var.B;
                r1.g(p1Var);
                p1Var.v1(new k2(this, 2));
            }
            t3 t3VarJ = r1Var.j();
            t3VarJ.m1();
            t3VarJ.n1();
            w4 w4VarC1 = t3VarJ.C1(true);
            t3VarJ.y1();
            r1 r1Var2 = (r1) t3VarJ.f307w;
            r1Var2.f4366y.w1(null, f0.c1);
            r1Var2.i().t1(3, new byte[0]);
            t3VarJ.A1(new o3(t3VarJ, w4VarC1, 1));
            this.O = false;
            f1 f1Var = r1Var.f4367z;
            r1.e(f1Var);
            f1Var.m1();
            String string = f1Var.q1().getString("previous_os_version", null);
            ((r1) f1Var.f307w).k().o1();
            String str = Build.VERSION.RELEASE;
            if (!TextUtils.isEmpty(str) && !str.equals(string)) {
                SharedPreferences.Editor editorEdit = f1Var.q1().edit();
                editorEdit.putString("previous_os_version", str);
                editorEdit.apply();
            }
            if (TextUtils.isEmpty(string)) {
                return;
            }
            r1Var.k().o1();
            if (string.equals(str)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", string);
            t1("auto", "_ou", bundle);
        }
    }

    public final void z1(Bundle bundle, long j4) {
        r1 r1Var = (r1) this.f307w;
        o8.u.g(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            w0 w0Var = r1Var.A;
            r1.g(w0Var);
            w0Var.E.a("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        h2.e(bundle2, "app_id", String.class, null);
        h2.e(bundle2, "origin", String.class, null);
        h2.e(bundle2, "name", String.class, null);
        h2.e(bundle2, "value", Object.class, null);
        h2.e(bundle2, "trigger_event_name", String.class, null);
        h2.e(bundle2, "trigger_timeout", Long.class, 0L);
        h2.e(bundle2, "timed_out_event_name", String.class, null);
        h2.e(bundle2, "timed_out_event_params", Bundle.class, null);
        h2.e(bundle2, "triggered_event_name", String.class, null);
        h2.e(bundle2, "triggered_event_params", Bundle.class, null);
        h2.e(bundle2, "time_to_live", Long.class, 0L);
        h2.e(bundle2, "expired_event_name", String.class, null);
        h2.e(bundle2, "expired_event_params", Bundle.class, null);
        o8.u.d(bundle2.getString("name"));
        o8.u.d(bundle2.getString("origin"));
        o8.u.g(bundle2.get("value"));
        bundle2.putLong("creation_timestamp", j4);
        String string = bundle2.getString("name");
        Object obj = bundle2.get("value");
        u4 u4Var = r1Var.D;
        q0 q0Var = r1Var.E;
        w0 w0Var2 = r1Var.A;
        r1.e(u4Var);
        if (u4Var.s2(string) != 0) {
            r1.g(w0Var2);
            w0Var2.B.b(q0Var.c(string), "Invalid conditional user property name");
            return;
        }
        r1.e(u4Var);
        if (u4Var.z1(obj, string) != 0) {
            r1.g(w0Var2);
            w0Var2.B.c(q0Var.c(string), obj, "Invalid conditional user property value");
            return;
        }
        Object objA1 = u4Var.A1(obj, string);
        if (objA1 == null) {
            r1.g(w0Var2);
            w0Var2.B.c(q0Var.c(string), obj, "Unable to normalize conditional user property value");
            return;
        }
        h2.c(bundle2, objA1);
        long j7 = bundle2.getLong("trigger_timeout");
        if (!TextUtils.isEmpty(bundle2.getString("trigger_event_name")) && (j7 > 15552000000L || j7 < 1)) {
            r1.g(w0Var2);
            w0Var2.B.c(q0Var.c(string), Long.valueOf(j7), "Invalid conditional user property timeout");
            return;
        }
        long j10 = bundle2.getLong("time_to_live");
        if (j10 > 15552000000L || j10 < 1) {
            r1.g(w0Var2);
            w0Var2.B.c(q0Var.c(string), Long.valueOf(j10), "Invalid conditional user property time to live");
        } else {
            p1 p1Var = r1Var.B;
            r1.g(p1Var);
            p1Var.v1(new r2(this, bundle2, 0));
        }
    }
}
