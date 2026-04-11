package k8;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Pair;
import android.util.SparseArray;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class z0 extends x1 {
    public static final Pair V = new Pair("", 0L);
    public g4.k0 A;
    public final a2.e2 B;
    public final a2.c C;
    public String D;
    public boolean E;
    public long F;
    public final a2.e2 G;
    public final x0 H;
    public final a2.c I;
    public final ub.o J;
    public final x0 K;
    public final a2.e2 L;
    public final a2.e2 M;
    public boolean N;
    public final x0 O;
    public final x0 P;
    public final a2.e2 Q;
    public final a2.c R;
    public final a2.c S;
    public final a2.e2 T;
    public final ub.o U;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public SharedPreferences f7566x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Object f7567y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public SharedPreferences f7568z;

    public z0(k1 k1Var) {
        super(k1Var);
        this.f7567y = new Object();
        this.G = new a2.e2(this, "session_timeout", 1800000L);
        this.H = new x0(this, "start_new_session", true);
        this.L = new a2.e2(this, "last_pause_time", 0L);
        this.M = new a2.e2(this, "session_id", 0L);
        this.I = new a2.c(this, "non_personalized_ads");
        this.J = new ub.o(this, "last_received_uri_timestamps_by_source");
        this.K = new x0(this, "allow_remote_dynamite", false);
        this.B = new a2.e2(this, "first_open_time", 0L);
        t7.v.d("app_install_time");
        this.C = new a2.c(this, "app_instance_id");
        this.O = new x0(this, "app_backgrounded", false);
        this.P = new x0(this, "deep_link_retrieval_complete", false);
        this.Q = new a2.e2(this, "deep_link_retrieval_attempts", 0L);
        this.R = new a2.c(this, "firebase_feature_rollouts");
        this.S = new a2.c(this, "deferred_attribution_cache");
        this.T = new a2.e2(this, "deferred_attribution_cache_timestamp", 0L);
        this.U = new ub.o(this, "default_event_parameters");
    }

    @Override // k8.x1
    public final boolean s1() {
        return true;
    }

    public final void t1(SparseArray sparseArray) {
        int[] iArr = new int[sparseArray.size()];
        long[] jArr = new long[sparseArray.size()];
        for (int i = 0; i < sparseArray.size(); i++) {
            iArr[i] = sparseArray.keyAt(i);
            jArr[i] = ((Long) sparseArray.valueAt(i)).longValue();
        }
        Bundle bundle = new Bundle();
        bundle.putIntArray("uriSources", iArr);
        bundle.putLongArray("uriTimestamps", jArr);
        this.J.c0(bundle);
    }

    public final boolean u1(long j5) {
        return j5 - this.G.c() > this.L.c();
    }

    public final void v1(boolean z2) {
        p1();
        g().I.c(Boolean.valueOf(z2), "App measurement setting deferred collection");
        SharedPreferences.Editor editorEdit = x1().edit();
        editorEdit.putBoolean("deferred_analytics_collection", z2);
        editorEdit.apply();
    }

    public final SharedPreferences w1() {
        p1();
        q1();
        if (this.f7568z == null) {
            synchronized (this.f7567y) {
                try {
                    if (this.f7568z == null) {
                        String str = ((k1) this.f2454v).f7282u.getPackageName() + "_preferences";
                        g().I.c(str, "Default prefs file");
                        this.f7568z = ((k1) this.f2454v).f7282u.getSharedPreferences(str, 0);
                    }
                } finally {
                }
            }
        }
        return this.f7568z;
    }

    public final SharedPreferences x1() {
        p1();
        q1();
        t7.v.h(this.f7566x);
        return this.f7566x;
    }

    public final SparseArray y1() {
        Bundle bundleW = this.J.W();
        int[] intArray = bundleW.getIntArray("uriSources");
        long[] longArray = bundleW.getLongArray("uriTimestamps");
        if (intArray == null || longArray == null) {
            return new SparseArray();
        }
        if (intArray.length != longArray.length) {
            g().A.d("Trigger URI source and timestamp array lengths do not match");
            return new SparseArray();
        }
        SparseArray sparseArray = new SparseArray();
        for (int i = 0; i < intArray.length; i++) {
            sparseArray.put(intArray[i], Long.valueOf(longArray[i]));
        }
        return sparseArray;
    }

    public final z1 z1() {
        p1();
        return z1.d(x1().getString("consent_settings", "G1"), x1().getInt("consent_source", 100));
    }
}
