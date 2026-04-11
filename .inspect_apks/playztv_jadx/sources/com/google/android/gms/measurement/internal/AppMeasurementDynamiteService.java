package com.google.android.gms.measurement.internal;

import a8.a;
import a8.b;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.bumptech.glide.manager.o;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.internal.measurement.b1;
import com.google.android.gms.internal.measurement.d1;
import com.google.android.gms.internal.measurement.l9;
import com.google.android.gms.internal.measurement.v0;
import com.google.android.gms.internal.measurement.w0;
import com.google.android.gms.internal.measurement.x0;
import ea.t;
import h4.z;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import k8.c2;
import k8.d2;
import k8.g2;
import k8.h1;
import k8.h2;
import k8.h4;
import k8.i2;
import k8.j2;
import k8.k1;
import k8.l2;
import k8.m1;
import k8.n2;
import k8.p0;
import k8.q2;
import k8.u;
import k8.v1;
import k8.v2;
import k8.w;
import k8.w2;
import s.e;
import t7.v;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
@DynamiteApi
public class AppMeasurementDynamiteService extends v0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k1 f3299d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f3300e;

    public AppMeasurementDynamiteService() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        this.f3299d = null;
        this.f3300e = new e(0);
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public void beginAdUnitExposure(String str, long j5) {
        e();
        this.f3299d.k().v1(str, j5);
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        e();
        g2 g2Var = this.f3299d.J;
        k1.e(g2Var);
        g2Var.B1(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public void clearMeasurementEnabled(long j5) {
        e();
        g2 g2Var = this.f3299d.J;
        k1.e(g2Var);
        g2Var.t1();
        g2Var.x().y1(new t(14, g2Var, null, false));
    }

    public final void e() {
        if (this.f3299d == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public void endAdUnitExposure(String str, long j5) {
        e();
        this.f3299d.k().y1(str, j5);
    }

    public final void f(String str, w0 w0Var) {
        e();
        h4 h4Var = this.f3299d.F;
        k1.d(h4Var);
        h4Var.P1(str, w0Var);
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public void generateEventId(w0 w0Var) {
        e();
        h4 h4Var = this.f3299d.F;
        k1.d(h4Var);
        long jZ2 = h4Var.z2();
        e();
        h4 h4Var2 = this.f3299d.F;
        k1.d(h4Var2);
        h4Var2.K1(w0Var, jZ2);
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public void getAppInstanceId(w0 w0Var) {
        e();
        h1 h1Var = this.f3299d.D;
        k1.f(h1Var);
        h1Var.y1(new m1(this, w0Var, 0));
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public void getCachedAppInstanceId(w0 w0Var) {
        e();
        g2 g2Var = this.f3299d.J;
        k1.e(g2Var);
        f((String) g2Var.B.get(), w0Var);
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public void getConditionalUserProperties(String str, String str2, w0 w0Var) {
        e();
        h1 h1Var = this.f3299d.D;
        k1.f(h1Var);
        h1Var.y1(new l2((Object) this, (Object) w0Var, str, str2, 2));
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public void getCurrentScreenClass(w0 w0Var) {
        e();
        g2 g2Var = this.f3299d.J;
        k1.e(g2Var);
        v2 v2Var = ((k1) g2Var.f2454v).I;
        k1.e(v2Var);
        w2 w2Var = v2Var.f7460x;
        f(w2Var != null ? w2Var.f7527b : null, w0Var);
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public void getCurrentScreenName(w0 w0Var) {
        e();
        g2 g2Var = this.f3299d.J;
        k1.e(g2Var);
        v2 v2Var = ((k1) g2Var.f2454v).I;
        k1.e(v2Var);
        w2 w2Var = v2Var.f7460x;
        f(w2Var != null ? w2Var.f7526a : null, w0Var);
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public void getGmpAppId(w0 w0Var) {
        e();
        g2 g2Var = this.f3299d.J;
        k1.e(g2Var);
        k1 k1Var = (k1) g2Var.f2454v;
        String string = k1Var.f7283v;
        if (string == null) {
            string = null;
            try {
                Context context = k1Var.f7282u;
                String strB = k1Var.M;
                v.h(context);
                Resources resources = context.getResources();
                if (TextUtils.isEmpty(strB)) {
                    strB = c2.b(context);
                }
                int identifier = resources.getIdentifier("google_app_id", "string", strB);
                if (identifier != 0) {
                    try {
                        string = resources.getString(identifier);
                    } catch (Resources.NotFoundException unused) {
                    }
                }
            } catch (IllegalStateException e10) {
                p0 p0Var = k1Var.C;
                k1.f(p0Var);
                p0Var.A.c(e10, "getGoogleAppId failed with exception");
            }
        }
        f(string, w0Var);
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public void getMaxUserProperties(String str, w0 w0Var) {
        e();
        k1.e(this.f3299d.J);
        v.d(str);
        e();
        h4 h4Var = this.f3299d.F;
        k1.d(h4Var);
        h4Var.J1(w0Var, 25);
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public void getSessionId(w0 w0Var) {
        e();
        g2 g2Var = this.f3299d.J;
        k1.e(g2Var);
        g2Var.x().y1(new t(13, g2Var, w0Var, false));
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public void getTestFlag(w0 w0Var, int i) {
        e();
        if (i == 0) {
            h4 h4Var = this.f3299d.F;
            k1.d(h4Var);
            g2 g2Var = this.f3299d.J;
            k1.e(g2Var);
            AtomicReference atomicReference = new AtomicReference();
            h4Var.P1((String) g2Var.x().t1(atomicReference, 15000L, "String test flag value", new h2(g2Var, atomicReference, 2)), w0Var);
            return;
        }
        if (i == 1) {
            h4 h4Var2 = this.f3299d.F;
            k1.d(h4Var2);
            g2 g2Var2 = this.f3299d.J;
            k1.e(g2Var2);
            AtomicReference atomicReference2 = new AtomicReference();
            h4Var2.K1(w0Var, ((Long) g2Var2.x().t1(atomicReference2, 15000L, "long test flag value", new h2(g2Var2, atomicReference2, 4))).longValue());
            return;
        }
        if (i == 2) {
            h4 h4Var3 = this.f3299d.F;
            k1.d(h4Var3);
            g2 g2Var3 = this.f3299d.J;
            k1.e(g2Var3);
            AtomicReference atomicReference3 = new AtomicReference();
            double dDoubleValue = ((Double) g2Var3.x().t1(atomicReference3, 15000L, "double test flag value", new h2(g2Var3, atomicReference3, 5))).doubleValue();
            Bundle bundle = new Bundle();
            bundle.putDouble("r", dDoubleValue);
            try {
                w0Var.h(bundle);
                return;
            } catch (RemoteException e10) {
                p0 p0Var = ((k1) h4Var3.f2454v).C;
                k1.f(p0Var);
                p0Var.D.c(e10, "Error returning double value to wrapper");
                return;
            }
        }
        if (i == 3) {
            h4 h4Var4 = this.f3299d.F;
            k1.d(h4Var4);
            g2 g2Var4 = this.f3299d.J;
            k1.e(g2Var4);
            AtomicReference atomicReference4 = new AtomicReference();
            h4Var4.J1(w0Var, ((Integer) g2Var4.x().t1(atomicReference4, 15000L, "int test flag value", new h2(g2Var4, atomicReference4, 3))).intValue());
            return;
        }
        if (i != 4) {
            return;
        }
        h4 h4Var5 = this.f3299d.F;
        k1.d(h4Var5);
        g2 g2Var5 = this.f3299d.J;
        k1.e(g2Var5);
        AtomicReference atomicReference5 = new AtomicReference();
        h4Var5.N1(w0Var, ((Boolean) g2Var5.x().t1(atomicReference5, 15000L, "boolean test flag value", new h2(g2Var5, atomicReference5, 1))).booleanValue());
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public void getUserProperties(String str, String str2, boolean z2, w0 w0Var) {
        e();
        h1 h1Var = this.f3299d.D;
        k1.f(h1Var);
        h1Var.y1(new v1(this, w0Var, str, str2, z2, 0));
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public void initForTests(Map map) {
        e();
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public void initialize(a aVar, d1 d1Var, long j5) {
        k1 k1Var = this.f3299d;
        if (k1Var == null) {
            Context context = (Context) b.I(aVar);
            v.h(context);
            this.f3299d = k1.c(context, d1Var, Long.valueOf(j5));
        } else {
            p0 p0Var = k1Var.C;
            k1.f(p0Var);
            p0Var.D.d("Attempting to initialize multiple times");
        }
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public void isDataCollectionEnabled(w0 w0Var) {
        e();
        h1 h1Var = this.f3299d.D;
        k1.f(h1Var);
        h1Var.y1(new m1(this, w0Var, 1));
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public void logEvent(String str, String str2, Bundle bundle, boolean z2, boolean z10, long j5) {
        e();
        g2 g2Var = this.f3299d.J;
        k1.e(g2Var);
        g2Var.C1(str, str2, bundle, z2, z10, j5);
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public void logEventAndBundle(String str, String str2, Bundle bundle, w0 w0Var, long j5) {
        e();
        v.d(str2);
        (bundle != null ? new Bundle(bundle) : new Bundle()).putString("_o", "app");
        k8.v vVar = new k8.v(str2, new u(bundle), "app", j5);
        h1 h1Var = this.f3299d.D;
        k1.f(h1Var);
        h1Var.y1(new l2(this, w0Var, vVar, str, 0));
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public void logHealthData(int i, String str, a aVar, a aVar2, a aVar3) {
        e();
        Object objI = aVar == null ? null : b.I(aVar);
        Object objI2 = aVar2 == null ? null : b.I(aVar2);
        Object objI3 = aVar3 != null ? b.I(aVar3) : null;
        p0 p0Var = this.f3299d.C;
        k1.f(p0Var);
        p0Var.w1(i, true, false, str, objI, objI2, objI3);
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public void onActivityCreated(a aVar, Bundle bundle, long j5) {
        e();
        g2 g2Var = this.f3299d.J;
        k1.e(g2Var);
        q2 q2Var = g2Var.f7212x;
        if (q2Var != null) {
            g2 g2Var2 = this.f3299d.J;
            k1.e(g2Var2);
            g2Var2.M1();
            q2Var.onActivityCreated((Activity) b.I(aVar), bundle);
        }
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public void onActivityDestroyed(a aVar, long j5) {
        e();
        g2 g2Var = this.f3299d.J;
        k1.e(g2Var);
        q2 q2Var = g2Var.f7212x;
        if (q2Var != null) {
            g2 g2Var2 = this.f3299d.J;
            k1.e(g2Var2);
            g2Var2.M1();
            q2Var.onActivityDestroyed((Activity) b.I(aVar));
        }
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public void onActivityPaused(a aVar, long j5) {
        e();
        g2 g2Var = this.f3299d.J;
        k1.e(g2Var);
        q2 q2Var = g2Var.f7212x;
        if (q2Var != null) {
            g2 g2Var2 = this.f3299d.J;
            k1.e(g2Var2);
            g2Var2.M1();
            q2Var.onActivityPaused((Activity) b.I(aVar));
        }
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public void onActivityResumed(a aVar, long j5) {
        e();
        g2 g2Var = this.f3299d.J;
        k1.e(g2Var);
        q2 q2Var = g2Var.f7212x;
        if (q2Var != null) {
            g2 g2Var2 = this.f3299d.J;
            k1.e(g2Var2);
            g2Var2.M1();
            q2Var.onActivityResumed((Activity) b.I(aVar));
        }
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public void onActivitySaveInstanceState(a aVar, w0 w0Var, long j5) {
        e();
        g2 g2Var = this.f3299d.J;
        k1.e(g2Var);
        q2 q2Var = g2Var.f7212x;
        Bundle bundle = new Bundle();
        if (q2Var != null) {
            g2 g2Var2 = this.f3299d.J;
            k1.e(g2Var2);
            g2Var2.M1();
            q2Var.onActivitySaveInstanceState((Activity) b.I(aVar), bundle);
        }
        try {
            w0Var.h(bundle);
        } catch (RemoteException e10) {
            p0 p0Var = this.f3299d.C;
            k1.f(p0Var);
            p0Var.D.c(e10, "Error returning bundle value to wrapper");
        }
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public void onActivityStarted(a aVar, long j5) {
        e();
        g2 g2Var = this.f3299d.J;
        k1.e(g2Var);
        if (g2Var.f7212x != null) {
            g2 g2Var2 = this.f3299d.J;
            k1.e(g2Var2);
            g2Var2.M1();
        }
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public void onActivityStopped(a aVar, long j5) {
        e();
        g2 g2Var = this.f3299d.J;
        k1.e(g2Var);
        if (g2Var.f7212x != null) {
            g2 g2Var2 = this.f3299d.J;
            k1.e(g2Var2);
            g2Var2.M1();
        }
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public void performAction(Bundle bundle, w0 w0Var, long j5) {
        e();
        w0Var.h(null);
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public void registerOnMeasurementEventListener(x0 x0Var) {
        Object aVar;
        e();
        synchronized (this.f3300e) {
            try {
                aVar = (d2) this.f3300e.get(Integer.valueOf(x0Var.a()));
                if (aVar == null) {
                    aVar = new k8.a(this, x0Var);
                    this.f3300e.put(Integer.valueOf(x0Var.a()), aVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        g2 g2Var = this.f3299d.J;
        k1.e(g2Var);
        g2Var.t1();
        if (g2Var.f7214z.add(aVar)) {
            return;
        }
        g2Var.g().D.d("OnEventListener already registered");
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public void resetAnalyticsData(long j5) {
        e();
        g2 g2Var = this.f3299d.J;
        k1.e(g2Var);
        g2Var.S1(null);
        g2Var.x().y1(new n2(g2Var, j5, 1));
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public void setConditionalUserProperty(Bundle bundle, long j5) {
        e();
        if (bundle == null) {
            p0 p0Var = this.f3299d.C;
            k1.f(p0Var);
            p0Var.A.d("Conditional user property must not be null");
        } else {
            g2 g2Var = this.f3299d.J;
            k1.e(g2Var);
            g2Var.R1(bundle, j5);
        }
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public void setConsent(Bundle bundle, long j5) {
        e();
        g2 g2Var = this.f3299d.J;
        k1.e(g2Var);
        h1 h1VarX = g2Var.x();
        j2 j2Var = new j2();
        j2Var.f7259w = g2Var;
        j2Var.f7260x = bundle;
        j2Var.f7258v = j5;
        h1VarX.z1(j2Var);
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public void setConsentThirdParty(Bundle bundle, long j5) {
        e();
        g2 g2Var = this.f3299d.J;
        k1.e(g2Var);
        g2Var.y1(bundle, -20, j5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0091, code lost:
    
        if (r0 > 500) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00bc, code lost:
    
        if (r0 > 500) goto L34;
     */
    @Override // com.google.android.gms.internal.measurement.s0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setCurrentScreen(a8.a r3, java.lang.String r4, java.lang.String r5, long r6) {
        /*
            Method dump skipped, instruction units count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.AppMeasurementDynamiteService.setCurrentScreen(a8.a, java.lang.String, java.lang.String, long):void");
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public void setDataCollectionEnabled(boolean z2) {
        e();
        g2 g2Var = this.f3299d.J;
        k1.e(g2Var);
        g2Var.t1();
        g2Var.x().y1(new o(g2Var, z2, 3));
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public void setDefaultEventParameters(Bundle bundle) {
        e();
        g2 g2Var = this.f3299d.J;
        k1.e(g2Var);
        Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        h1 h1VarX = g2Var.x();
        i2 i2Var = new i2();
        i2Var.f7243w = g2Var;
        i2Var.f7242v = bundle2;
        h1VarX.y1(i2Var);
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public void setEventInterceptor(x0 x0Var) {
        e();
        z zVar = new z(22, this, x0Var, false);
        h1 h1Var = this.f3299d.D;
        k1.f(h1Var);
        if (!h1Var.A1()) {
            h1 h1Var2 = this.f3299d.D;
            k1.f(h1Var2);
            h1Var2.y1(new t(16, this, zVar, false));
            return;
        }
        g2 g2Var = this.f3299d.J;
        k1.e(g2Var);
        g2Var.p1();
        g2Var.t1();
        z zVar2 = g2Var.f7213y;
        if (zVar != zVar2) {
            v.j("EventInterceptor already set.", zVar2 == null);
        }
        g2Var.f7213y = zVar;
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public void setInstanceIdProvider(b1 b1Var) {
        e();
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public void setMeasurementEnabled(boolean z2, long j5) {
        e();
        g2 g2Var = this.f3299d.J;
        k1.e(g2Var);
        Boolean boolValueOf = Boolean.valueOf(z2);
        g2Var.t1();
        g2Var.x().y1(new t(14, g2Var, boolValueOf, false));
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public void setMinimumSessionDuration(long j5) {
        e();
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public void setSessionTimeoutDuration(long j5) {
        e();
        g2 g2Var = this.f3299d.J;
        k1.e(g2Var);
        g2Var.x().y1(new n2(g2Var, j5, 0));
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public void setSgtmDebugInfo(Intent intent) {
        e();
        g2 g2Var = this.f3299d.J;
        k1.e(g2Var);
        l9.a();
        k8.e eVar = ((k1) g2Var.f2454v).A;
        if (eVar.A1(null, w.f7520y0)) {
            Uri data = intent.getData();
            if (data == null) {
                g2Var.g().G.d("Activity intent has no data. Preview Mode was not enabled.");
                return;
            }
            String queryParameter = data.getQueryParameter("sgtm_debug_enable");
            if (queryParameter == null || !queryParameter.equals("1")) {
                g2Var.g().G.d("Preview Mode was not enabled.");
                eVar.f7145x = null;
                return;
            }
            String queryParameter2 = data.getQueryParameter("sgtm_preview_key");
            if (TextUtils.isEmpty(queryParameter2)) {
                return;
            }
            g2Var.g().G.c(queryParameter2, "Preview Mode was enabled. Using the sgtmPreviewKey: ");
            eVar.f7145x = queryParameter2;
        }
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public void setUserId(String str, long j5) {
        e();
        g2 g2Var = this.f3299d.J;
        k1.e(g2Var);
        if (str != null && TextUtils.isEmpty(str)) {
            p0 p0Var = ((k1) g2Var.f2454v).C;
            k1.f(p0Var);
            p0Var.D.d("User ID must be non-empty or null");
        } else {
            h1 h1VarX = g2Var.x();
            t tVar = new t(12);
            tVar.f4631v = g2Var;
            tVar.f4632w = str;
            h1VarX.y1(tVar);
            g2Var.D1(null, "_id", str, true, j5);
        }
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public void setUserProperty(String str, String str2, a aVar, boolean z2, long j5) {
        e();
        Object objI = b.I(aVar);
        g2 g2Var = this.f3299d.J;
        k1.e(g2Var);
        g2Var.D1(str, str2, objI, z2, j5);
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public void unregisterOnMeasurementEventListener(x0 x0Var) {
        Object aVar;
        e();
        synchronized (this.f3300e) {
            aVar = (d2) this.f3300e.remove(Integer.valueOf(x0Var.a()));
        }
        if (aVar == null) {
            aVar = new k8.a(this, x0Var);
        }
        g2 g2Var = this.f3299d.J;
        k1.e(g2Var);
        g2Var.t1();
        if (g2Var.f7214z.remove(aVar)) {
            return;
        }
        g2Var.g().D.d("OnEventListener had not been registered");
    }
}
