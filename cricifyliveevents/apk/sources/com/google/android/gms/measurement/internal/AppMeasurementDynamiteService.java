package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.bumptech.glide.manager.p;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.internal.measurement.i0;
import com.google.android.gms.internal.measurement.l0;
import com.google.android.gms.internal.measurement.n0;
import com.google.android.gms.internal.measurement.q0;
import com.google.android.gms.internal.measurement.s0;
import com.google.android.gms.internal.measurement.t0;
import com.google.android.gms.internal.measurement.v0;
import f9.b3;
import f9.d3;
import f9.f3;
import f9.i2;
import f9.i4;
import f9.j3;
import f9.k4;
import f9.n2;
import f9.o2;
import f9.p1;
import f9.q1;
import f9.q2;
import f9.r1;
import f9.r2;
import f9.t2;
import f9.u0;
import f9.u4;
import f9.v;
import f9.v4;
import f9.w0;
import f9.x2;
import f9.y;
import f9.z0;
import f9.z1;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import l4.c0;
import o8.u;
import v.e;
import v8.a;
import v8.b;
import ya.s;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
@DynamiteApi
public class AppMeasurementDynamiteService extends i0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public r1 f2752d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f2753e;

    public AppMeasurementDynamiteService() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        this.f2752d = null;
        this.f2753e = new e(0);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void beginAdUnitExposure(String str, long j4) {
        e();
        y yVar = this.f2752d.I;
        r1.d(yVar);
        yVar.n1(str, j4);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        e();
        x2 x2Var = this.f2752d.H;
        r1.f(x2Var);
        x2Var.A1(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void clearMeasurementEnabled(long j4) {
        e();
        x2 x2Var = this.f2752d.H;
        r1.f(x2Var);
        x2Var.n1();
        p1 p1Var = ((r1) x2Var.f307w).B;
        r1.g(p1Var);
        p1Var.v1(new s(8, x2Var, null, false));
    }

    public final void e() {
        if (this.f2752d == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void endAdUnitExposure(String str, long j4) {
        e();
        y yVar = this.f2752d.I;
        r1.d(yVar);
        yVar.o1(str, j4);
    }

    public final void f(String str, l0 l0Var) {
        e();
        u4 u4Var = this.f2752d.D;
        r1.e(u4Var);
        u4Var.V1(str, l0Var);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void generateEventId(l0 l0Var) {
        e();
        u4 u4Var = this.f2752d.D;
        r1.e(u4Var);
        long jJ2 = u4Var.j2();
        e();
        u4 u4Var2 = this.f2752d.D;
        r1.e(u4Var2);
        u4Var2.W1(l0Var, jJ2);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void getAppInstanceId(l0 l0Var) {
        e();
        p1 p1Var = this.f2752d.B;
        r1.g(p1Var);
        p1Var.v1(new q1(this, l0Var, 0));
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void getCachedAppInstanceId(l0 l0Var) {
        e();
        x2 x2Var = this.f2752d.H;
        r1.f(x2Var);
        f((String) x2Var.C.get(), l0Var);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void getConditionalUserProperties(String str, String str2, l0 l0Var) {
        e();
        p1 p1Var = this.f2752d.B;
        r1.g(p1Var);
        p1Var.v1(new z1(this, l0Var, str, str2, 4, false));
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void getCurrentScreenClass(l0 l0Var) {
        e();
        x2 x2Var = this.f2752d.H;
        r1.f(x2Var);
        j3 j3Var = ((r1) x2Var.f307w).G;
        r1.f(j3Var);
        f3 f3Var = j3Var.f4242y;
        f(f3Var != null ? f3Var.f4176b : null, l0Var);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void getCurrentScreenName(l0 l0Var) {
        e();
        x2 x2Var = this.f2752d.H;
        r1.f(x2Var);
        j3 j3Var = ((r1) x2Var.f307w).G;
        r1.f(j3Var);
        f3 f3Var = j3Var.f4242y;
        f(f3Var != null ? f3Var.f4175a : null, l0Var);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void getGmpAppId(l0 l0Var) {
        e();
        x2 x2Var = this.f2752d.H;
        r1.f(x2Var);
        f(x2Var.B1(), l0Var);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void getMaxUserProperties(String str, l0 l0Var) {
        e();
        x2 x2Var = this.f2752d.H;
        r1.f(x2Var);
        u.d(str);
        ((r1) x2Var.f307w).getClass();
        e();
        u4 u4Var = this.f2752d.D;
        r1.e(u4Var);
        u4Var.X1(l0Var, 25);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void getSessionId(l0 l0Var) {
        e();
        x2 x2Var = this.f2752d.H;
        r1.f(x2Var);
        p1 p1Var = ((r1) x2Var.f307w).B;
        r1.g(p1Var);
        p1Var.v1(new s(x2Var, l0Var));
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void getTestFlag(l0 l0Var, int i) {
        e();
        if (i == 0) {
            u4 u4Var = this.f2752d.D;
            r1.e(u4Var);
            x2 x2Var = this.f2752d.H;
            r1.f(x2Var);
            AtomicReference atomicReference = new AtomicReference();
            p1 p1Var = ((r1) x2Var.f307w).B;
            r1.g(p1Var);
            u4Var.V1((String) p1Var.w1(atomicReference, 15000L, "String test flag value", new q2(x2Var, atomicReference, 1)), l0Var);
            return;
        }
        if (i == 1) {
            u4 u4Var2 = this.f2752d.D;
            r1.e(u4Var2);
            x2 x2Var2 = this.f2752d.H;
            r1.f(x2Var2);
            AtomicReference atomicReference2 = new AtomicReference();
            p1 p1Var2 = ((r1) x2Var2.f307w).B;
            r1.g(p1Var2);
            u4Var2.W1(l0Var, ((Long) p1Var2.w1(atomicReference2, 15000L, "long test flag value", new q2(x2Var2, atomicReference2, 2))).longValue());
            return;
        }
        if (i == 2) {
            u4 u4Var3 = this.f2752d.D;
            r1.e(u4Var3);
            x2 x2Var3 = this.f2752d.H;
            r1.f(x2Var3);
            AtomicReference atomicReference3 = new AtomicReference();
            p1 p1Var3 = ((r1) x2Var3.f307w).B;
            r1.g(p1Var3);
            double dDoubleValue = ((Double) p1Var3.w1(atomicReference3, 15000L, "double test flag value", new q2(x2Var3, atomicReference3, 4))).doubleValue();
            Bundle bundle = new Bundle();
            bundle.putDouble("r", dDoubleValue);
            try {
                l0Var.t(bundle);
                return;
            } catch (RemoteException e9) {
                w0 w0Var = ((r1) u4Var3.f307w).A;
                r1.g(w0Var);
                w0Var.E.b(e9, "Error returning double value to wrapper");
                return;
            }
        }
        if (i == 3) {
            u4 u4Var4 = this.f2752d.D;
            r1.e(u4Var4);
            x2 x2Var4 = this.f2752d.H;
            r1.f(x2Var4);
            AtomicReference atomicReference4 = new AtomicReference();
            p1 p1Var4 = ((r1) x2Var4.f307w).B;
            r1.g(p1Var4);
            u4Var4.X1(l0Var, ((Integer) p1Var4.w1(atomicReference4, 15000L, "int test flag value", new q2(x2Var4, atomicReference4, 3))).intValue());
            return;
        }
        if (i != 4) {
            return;
        }
        u4 u4Var5 = this.f2752d.D;
        r1.e(u4Var5);
        x2 x2Var5 = this.f2752d.H;
        r1.f(x2Var5);
        AtomicReference atomicReference5 = new AtomicReference();
        p1 p1Var5 = ((r1) x2Var5.f307w).B;
        r1.g(p1Var5);
        u4Var5.Z1(l0Var, ((Boolean) p1Var5.w1(atomicReference5, 15000L, "boolean test flag value", new q2(x2Var5, atomicReference5, 0))).booleanValue());
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void getUserProperties(String str, String str2, boolean z10, l0 l0Var) {
        e();
        p1 p1Var = this.f2752d.B;
        r1.g(p1Var);
        p1Var.v1(new n2(this, l0Var, str, str2, z10));
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void initForTests(Map map) {
        e();
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void initialize(a aVar, t0 t0Var, long j4) {
        r1 r1Var = this.f2752d;
        if (r1Var == null) {
            Context context = (Context) b.N(aVar);
            u.g(context);
            this.f2752d = r1.m(context, t0Var, Long.valueOf(j4));
        } else {
            w0 w0Var = r1Var.A;
            r1.g(w0Var);
            w0Var.E.a("Attempting to initialize multiple times");
        }
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void isDataCollectionEnabled(l0 l0Var) {
        e();
        p1 p1Var = this.f2752d.B;
        r1.g(p1Var);
        p1Var.v1(new q1(this, l0Var, 1));
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void logEvent(String str, String str2, Bundle bundle, boolean z10, boolean z11, long j4) {
        e();
        x2 x2Var = this.f2752d.H;
        r1.f(x2Var);
        x2Var.r1(str, str2, bundle, z10, z11, j4);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void logEventAndBundle(String str, String str2, Bundle bundle, l0 l0Var, long j4) {
        e();
        u.d(str2);
        (bundle != null ? new Bundle(bundle) : new Bundle()).putString("_o", "app");
        v vVar = new v(str2, new f9.u(bundle), "app", j4);
        p1 p1Var = this.f2752d.B;
        r1.g(p1Var);
        p1Var.v1(new z1(this, l0Var, vVar, str));
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void logHealthData(int i, String str, a aVar, a aVar2, a aVar3) {
        e();
        Object objN = aVar == null ? null : b.N(aVar);
        Object objN2 = aVar2 == null ? null : b.N(aVar2);
        Object objN3 = aVar3 != null ? b.N(aVar3) : null;
        w0 w0Var = this.f2752d.A;
        r1.g(w0Var);
        w0Var.v1(i, true, false, str, objN, objN2, objN3);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void onActivityCreated(a aVar, Bundle bundle, long j4) {
        e();
        Activity activity = (Activity) b.N(aVar);
        u.g(activity);
        onActivityCreatedByScionActivityInfo(v0.a(activity), bundle, j4);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void onActivityCreatedByScionActivityInfo(v0 v0Var, Bundle bundle, long j4) {
        e();
        x2 x2Var = this.f2752d.H;
        r1.f(x2Var);
        t2 t2Var = x2Var.f4479y;
        if (t2Var != null) {
            x2 x2Var2 = this.f2752d.H;
            r1.f(x2Var2);
            x2Var2.F1();
            t2Var.j(v0Var, bundle);
        }
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void onActivityDestroyed(a aVar, long j4) {
        e();
        Activity activity = (Activity) b.N(aVar);
        u.g(activity);
        onActivityDestroyedByScionActivityInfo(v0.a(activity), j4);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void onActivityDestroyedByScionActivityInfo(v0 v0Var, long j4) {
        e();
        x2 x2Var = this.f2752d.H;
        r1.f(x2Var);
        t2 t2Var = x2Var.f4479y;
        if (t2Var != null) {
            x2 x2Var2 = this.f2752d.H;
            r1.f(x2Var2);
            x2Var2.F1();
            t2Var.k(v0Var);
        }
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void onActivityPaused(a aVar, long j4) {
        e();
        Activity activity = (Activity) b.N(aVar);
        u.g(activity);
        onActivityPausedByScionActivityInfo(v0.a(activity), j4);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void onActivityPausedByScionActivityInfo(v0 v0Var, long j4) {
        e();
        x2 x2Var = this.f2752d.H;
        r1.f(x2Var);
        t2 t2Var = x2Var.f4479y;
        if (t2Var != null) {
            x2 x2Var2 = this.f2752d.H;
            r1.f(x2Var2);
            x2Var2.F1();
            t2Var.l(v0Var);
        }
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void onActivityResumed(a aVar, long j4) {
        e();
        Activity activity = (Activity) b.N(aVar);
        u.g(activity);
        onActivityResumedByScionActivityInfo(v0.a(activity), j4);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void onActivityResumedByScionActivityInfo(v0 v0Var, long j4) {
        e();
        x2 x2Var = this.f2752d.H;
        r1.f(x2Var);
        t2 t2Var = x2Var.f4479y;
        if (t2Var != null) {
            x2 x2Var2 = this.f2752d.H;
            r1.f(x2Var2);
            x2Var2.F1();
            t2Var.m(v0Var);
        }
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void onActivitySaveInstanceState(a aVar, l0 l0Var, long j4) {
        e();
        Activity activity = (Activity) b.N(aVar);
        u.g(activity);
        onActivitySaveInstanceStateByScionActivityInfo(v0.a(activity), l0Var, j4);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void onActivitySaveInstanceStateByScionActivityInfo(v0 v0Var, l0 l0Var, long j4) {
        e();
        x2 x2Var = this.f2752d.H;
        r1.f(x2Var);
        t2 t2Var = x2Var.f4479y;
        Bundle bundle = new Bundle();
        if (t2Var != null) {
            x2 x2Var2 = this.f2752d.H;
            r1.f(x2Var2);
            x2Var2.F1();
            t2Var.n(v0Var, bundle);
        }
        try {
            l0Var.t(bundle);
        } catch (RemoteException e9) {
            w0 w0Var = this.f2752d.A;
            r1.g(w0Var);
            w0Var.E.b(e9, "Error returning bundle value to wrapper");
        }
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void onActivityStarted(a aVar, long j4) {
        e();
        Activity activity = (Activity) b.N(aVar);
        u.g(activity);
        onActivityStartedByScionActivityInfo(v0.a(activity), j4);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void onActivityStartedByScionActivityInfo(v0 v0Var, long j4) {
        e();
        x2 x2Var = this.f2752d.H;
        r1.f(x2Var);
        if (x2Var.f4479y != null) {
            x2 x2Var2 = this.f2752d.H;
            r1.f(x2Var2);
            x2Var2.F1();
        }
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void onActivityStopped(a aVar, long j4) {
        e();
        Activity activity = (Activity) b.N(aVar);
        u.g(activity);
        onActivityStoppedByScionActivityInfo(v0.a(activity), j4);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void onActivityStoppedByScionActivityInfo(v0 v0Var, long j4) {
        e();
        x2 x2Var = this.f2752d.H;
        r1.f(x2Var);
        if (x2Var.f4479y != null) {
            x2 x2Var2 = this.f2752d.H;
            r1.f(x2Var2);
            x2Var2.F1();
        }
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void performAction(Bundle bundle, l0 l0Var, long j4) {
        e();
        l0Var.t(null);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void registerOnMeasurementEventListener(q0 q0Var) {
        Object v4Var;
        e();
        e eVar = this.f2753e;
        synchronized (eVar) {
            try {
                v4Var = (i2) eVar.get(Integer.valueOf(q0Var.g()));
                if (v4Var == null) {
                    v4Var = new v4(this, q0Var);
                    eVar.put(Integer.valueOf(q0Var.g()), v4Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        x2 x2Var = this.f2752d.H;
        r1.f(x2Var);
        x2Var.n1();
        if (x2Var.A.add(v4Var)) {
            return;
        }
        w0 w0Var = ((r1) x2Var.f307w).A;
        r1.g(w0Var);
        w0Var.E.a("OnEventListener already registered");
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void resetAnalyticsData(long j4) {
        e();
        x2 x2Var = this.f2752d.H;
        r1.f(x2Var);
        x2Var.C.set(null);
        p1 p1Var = ((r1) x2Var.f307w).B;
        r1.g(p1Var);
        p1Var.v1(new o2(x2Var, j4, 1));
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void retrieveAndUploadBatches(n0 n0Var) {
        d3 d3Var;
        e();
        x2 x2Var = this.f2752d.H;
        r1.f(x2Var);
        x2Var.n1();
        r1 r1Var = (r1) x2Var.f307w;
        p1 p1Var = r1Var.B;
        r1.g(p1Var);
        if (p1Var.s1()) {
            w0 w0Var = r1Var.A;
            r1.g(w0Var);
            w0Var.B.a("Cannot retrieve and upload batches from analytics worker thread");
            return;
        }
        p1 p1Var2 = r1Var.B;
        r1.g(p1Var2);
        if (Thread.currentThread() == p1Var2.f4322z) {
            w0 w0Var2 = r1Var.A;
            r1.g(w0Var2);
            w0Var2.B.a("Cannot retrieve and upload batches from analytics network thread");
            return;
        }
        if (jb.b.i()) {
            w0 w0Var3 = r1Var.A;
            r1.g(w0Var3);
            w0Var3.B.a("Cannot retrieve and upload batches from main thread");
            return;
        }
        w0 w0Var4 = r1Var.A;
        r1.g(w0Var4);
        w0Var4.J.a("[sgtm] Started client-side batch upload work.");
        boolean z10 = false;
        int size = 0;
        int i = 0;
        while (!z10) {
            w0 w0Var5 = r1Var.A;
            r1.g(w0Var5);
            w0Var5.J.a("[sgtm] Getting upload batches from service (FE)");
            AtomicReference atomicReference = new AtomicReference();
            p1 p1Var3 = r1Var.B;
            r1.g(p1Var3);
            p1Var3.w1(atomicReference, 10000L, "[sgtm] Getting upload batches", new q2(x2Var, atomicReference, 6, false));
            k4 k4Var = (k4) atomicReference.get();
            if (k4Var == null) {
                break;
            }
            List list = k4Var.f4258v;
            if (list.isEmpty()) {
                break;
            }
            w0 w0Var6 = r1Var.A;
            r1.g(w0Var6);
            w0Var6.J.b(Integer.valueOf(list.size()), "[sgtm] Retrieved upload batches. count");
            size += list.size();
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z10 = false;
                    break;
                }
                i4 i4Var = (i4) it.next();
                try {
                    URL url = new URI(i4Var.f4224x).toURL();
                    AtomicReference atomicReference2 = new AtomicReference();
                    f9.n0 n0VarL = ((r1) x2Var.f307w).l();
                    n0VarL.n1();
                    u.g(n0VarL.C);
                    String str = n0VarL.C;
                    r1 r1Var2 = (r1) x2Var.f307w;
                    w0 w0Var7 = r1Var2.A;
                    r1.g(w0Var7);
                    u0 u0Var = w0Var7.J;
                    Long lValueOf = Long.valueOf(i4Var.f4222v);
                    u0Var.d("[sgtm] Uploading data from app. row_id, url, uncompressed size", lValueOf, i4Var.f4224x, Integer.valueOf(i4Var.f4223w.length));
                    if (!TextUtils.isEmpty(i4Var.B)) {
                        w0 w0Var8 = r1Var2.A;
                        r1.g(w0Var8);
                        w0Var8.J.c(lValueOf, i4Var.B, "[sgtm] Uploading data from app. row_id");
                    }
                    HashMap map = new HashMap();
                    Bundle bundle = i4Var.f4225y;
                    for (String str2 : bundle.keySet()) {
                        String string = bundle.getString(str2);
                        if (!TextUtils.isEmpty(string)) {
                            map.put(str2, string);
                        }
                    }
                    b3 b3Var = r1Var2.J;
                    r1.g(b3Var);
                    byte[] bArr = i4Var.f4223w;
                    androidx.emoji2.text.v vVar = new androidx.emoji2.text.v(x2Var, atomicReference2, i4Var, 12);
                    b3Var.o1();
                    u.g(url);
                    u.g(bArr);
                    p1 p1Var4 = ((r1) b3Var.f307w).B;
                    r1.g(p1Var4);
                    p1Var4.y1(new z0(b3Var, str, url, bArr, map, vVar));
                    try {
                        u4 u4Var = r1Var2.D;
                        r1.e(u4Var);
                        r1 r1Var3 = (r1) u4Var.f307w;
                        r1Var3.F.getClass();
                        long jCurrentTimeMillis = System.currentTimeMillis() + 60000;
                        synchronized (atomicReference2) {
                            for (long jCurrentTimeMillis2 = 60000; atomicReference2.get() == null && jCurrentTimeMillis2 > 0; jCurrentTimeMillis2 = jCurrentTimeMillis - System.currentTimeMillis()) {
                                try {
                                    atomicReference2.wait(jCurrentTimeMillis2);
                                    r1Var3.F.getClass();
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        }
                    } catch (InterruptedException unused) {
                        w0 w0Var9 = ((r1) x2Var.f307w).A;
                        r1.g(w0Var9);
                        w0Var9.E.a("[sgtm] Interrupted waiting for uploading batch");
                    }
                    d3Var = atomicReference2.get() == null ? d3.f4075w : (d3) atomicReference2.get();
                } catch (MalformedURLException | URISyntaxException e9) {
                    w0 w0Var10 = ((r1) x2Var.f307w).A;
                    r1.g(w0Var10);
                    w0Var10.B.d("[sgtm] Bad upload url for row_id", i4Var.f4224x, Long.valueOf(i4Var.f4222v), e9);
                    d3Var = d3.f4077y;
                }
                if (d3Var != d3.f4076x) {
                    if (d3Var == d3.f4078z) {
                        z10 = true;
                        break;
                    }
                } else {
                    i++;
                }
            }
        }
        w0 w0Var11 = r1Var.A;
        r1.g(w0Var11);
        w0Var11.J.c(Integer.valueOf(size), Integer.valueOf(i), "[sgtm] Completed client-side batch upload work. total, success");
        try {
            n0Var.a();
        } catch (RemoteException e10) {
            r1 r1Var4 = this.f2752d;
            u.g(r1Var4);
            w0 w0Var12 = r1Var4.A;
            r1.g(w0Var12);
            w0Var12.E.b(e10, "Failed to call IDynamiteUploadBatchesCallback");
        }
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void setConditionalUserProperty(Bundle bundle, long j4) {
        e();
        if (bundle == null) {
            w0 w0Var = this.f2752d.A;
            r1.g(w0Var);
            w0Var.B.a("Conditional user property must not be null");
        } else {
            x2 x2Var = this.f2752d.H;
            r1.f(x2Var);
            x2Var.z1(bundle, j4);
        }
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void setConsentThirdParty(Bundle bundle, long j4) throws Throwable {
        e();
        x2 x2Var = this.f2752d.H;
        r1.f(x2Var);
        x2Var.G1(bundle, -20, j4);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void setCurrentScreen(a aVar, String str, String str2, long j4) {
        e();
        Activity activity = (Activity) b.N(aVar);
        u.g(activity);
        setCurrentScreenByScionActivityInfo(v0.a(activity), str, str2, j4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0088, code lost:
    
        if (r3 <= 500) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b1, code lost:
    
        if (r3 <= 500) goto L39;
     */
    @Override // com.google.android.gms.internal.measurement.j0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setCurrentScreenByScionActivityInfo(com.google.android.gms.internal.measurement.v0 r6, java.lang.String r7, java.lang.String r8, long r9) {
        /*
            Method dump skipped, instruction units count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.AppMeasurementDynamiteService.setCurrentScreenByScionActivityInfo(com.google.android.gms.internal.measurement.v0, java.lang.String, java.lang.String, long):void");
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void setDataCollectionEnabled(boolean z10) {
        e();
        x2 x2Var = this.f2752d.H;
        r1.f(x2Var);
        x2Var.n1();
        p1 p1Var = ((r1) x2Var.f307w).B;
        r1.g(p1Var);
        p1Var.v1(new p(x2Var, z10));
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void setDefaultEventParameters(Bundle bundle) {
        e();
        x2 x2Var = this.f2752d.H;
        r1.f(x2Var);
        Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        p1 p1Var = ((r1) x2Var.f307w).B;
        r1.g(p1Var);
        p1Var.v1(new r2(x2Var, bundle2, 2));
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void setEventInterceptor(q0 q0Var) {
        e();
        c0 c0Var = new c0(19, this, q0Var, false);
        p1 p1Var = this.f2752d.B;
        r1.g(p1Var);
        if (!p1Var.s1()) {
            p1 p1Var2 = this.f2752d.B;
            r1.g(p1Var2);
            p1Var2.v1(new s(10, this, c0Var, false));
            return;
        }
        x2 x2Var = this.f2752d.H;
        r1.f(x2Var);
        x2Var.m1();
        x2Var.n1();
        c0 c0Var2 = x2Var.f4480z;
        if (c0Var != c0Var2) {
            u.i("EventInterceptor already set.", c0Var2 == null);
        }
        x2Var.f4480z = c0Var;
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void setInstanceIdProvider(s0 s0Var) {
        e();
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void setMeasurementEnabled(boolean z10, long j4) {
        e();
        x2 x2Var = this.f2752d.H;
        r1.f(x2Var);
        Boolean boolValueOf = Boolean.valueOf(z10);
        x2Var.n1();
        p1 p1Var = ((r1) x2Var.f307w).B;
        r1.g(p1Var);
        p1Var.v1(new s(8, x2Var, boolValueOf, false));
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void setMinimumSessionDuration(long j4) {
        e();
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void setSessionTimeoutDuration(long j4) {
        e();
        x2 x2Var = this.f2752d.H;
        r1.f(x2Var);
        p1 p1Var = ((r1) x2Var.f307w).B;
        r1.g(p1Var);
        p1Var.v1(new o2(x2Var, j4, 0));
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void setSgtmDebugInfo(Intent intent) {
        e();
        x2 x2Var = this.f2752d.H;
        r1.f(x2Var);
        r1 r1Var = (r1) x2Var.f307w;
        Uri data = intent.getData();
        if (data == null) {
            w0 w0Var = r1Var.A;
            r1.g(w0Var);
            w0Var.H.a("Activity intent has no data. Preview Mode was not enabled.");
            return;
        }
        String queryParameter = data.getQueryParameter("sgtm_debug_enable");
        if (queryParameter == null || !queryParameter.equals("1")) {
            w0 w0Var2 = r1Var.A;
            r1.g(w0Var2);
            w0Var2.H.a("[sgtm] Preview Mode was not enabled.");
            r1Var.f4366y.f4184y = null;
            return;
        }
        String queryParameter2 = data.getQueryParameter("sgtm_preview_key");
        if (TextUtils.isEmpty(queryParameter2)) {
            return;
        }
        w0 w0Var3 = r1Var.A;
        r1.g(w0Var3);
        w0Var3.H.b(queryParameter2, "[sgtm] Preview Mode was enabled. Using the sgtmPreviewKey: ");
        r1Var.f4366y.f4184y = queryParameter2;
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void setUserId(String str, long j4) {
        e();
        x2 x2Var = this.f2752d.H;
        r1.f(x2Var);
        r1 r1Var = (r1) x2Var.f307w;
        if (str != null && TextUtils.isEmpty(str)) {
            w0 w0Var = r1Var.A;
            r1.g(w0Var);
            w0Var.E.a("User ID must be non-empty or null");
        } else {
            p1 p1Var = r1Var.B;
            r1.g(p1Var);
            p1Var.v1(new s(12, x2Var, str));
            x2Var.w1(null, "_id", str, true, j4);
        }
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void setUserProperty(String str, String str2, a aVar, boolean z10, long j4) {
        e();
        Object objN = b.N(aVar);
        x2 x2Var = this.f2752d.H;
        r1.f(x2Var);
        x2Var.w1(str, str2, objN, z10, j4);
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void unregisterOnMeasurementEventListener(q0 q0Var) {
        Object v4Var;
        e();
        e eVar = this.f2753e;
        synchronized (eVar) {
            v4Var = (i2) eVar.remove(Integer.valueOf(q0Var.g()));
        }
        if (v4Var == null) {
            v4Var = new v4(this, q0Var);
        }
        x2 x2Var = this.f2752d.H;
        r1.f(x2Var);
        x2Var.n1();
        if (x2Var.A.remove(v4Var)) {
            return;
        }
        w0 w0Var = ((r1) x2Var.f307w).A;
        r1.g(w0Var);
        w0Var.E.a("OnEventListener had not been registered");
    }

    @Override // com.google.android.gms.internal.measurement.j0
    public void setConsent(Bundle bundle, long j4) {
    }
}
