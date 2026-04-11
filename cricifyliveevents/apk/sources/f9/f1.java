package f9;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Pair;
import android.util.SparseArray;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f1 extends b2 {
    public static final Pair V = new Pair("", 0L);
    public b7.d A;
    public final e1 B;
    public final com.bumptech.glide.l C;
    public String D;
    public boolean E;
    public long F;
    public final e1 G;
    public final d1 H;
    public final com.bumptech.glide.l I;
    public final nc.p J;
    public final d1 K;
    public final e1 L;
    public final e1 M;
    public boolean N;
    public final d1 O;
    public final d1 P;
    public final e1 Q;
    public final com.bumptech.glide.l R;
    public final com.bumptech.glide.l S;
    public final e1 T;
    public final nc.p U;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public SharedPreferences f4168y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public SharedPreferences f4169z;

    public f1(r1 r1Var) {
        super(r1Var);
        this.G = new e1(this, "session_timeout", 1800000L);
        this.H = new d1(this, "start_new_session", true);
        this.L = new e1(this, "last_pause_time", 0L);
        this.M = new e1(this, "session_id", 0L);
        this.I = new com.bumptech.glide.l(this, "non_personalized_ads");
        this.J = new nc.p(this, "last_received_uri_timestamps_by_source");
        this.K = new d1(this, "allow_remote_dynamite", false);
        this.B = new e1(this, "first_open_time", 0L);
        o8.u.d("app_install_time");
        this.C = new com.bumptech.glide.l(this, "app_instance_id");
        this.O = new d1(this, "app_backgrounded", false);
        this.P = new d1(this, "deep_link_retrieval_complete", false);
        this.Q = new e1(this, "deep_link_retrieval_attempts", 0L);
        this.R = new com.bumptech.glide.l(this, "firebase_feature_rollouts");
        this.S = new com.bumptech.glide.l(this, "deferred_attribution_cache");
        this.T = new e1(this, "deferred_attribution_cache_timestamp", 0L);
        this.U = new nc.p(this, "default_event_parameters");
    }

    @Override // f9.b2
    public final boolean n1() {
        return true;
    }

    public final SharedPreferences q1() {
        m1();
        o1();
        o8.u.g(this.f4168y);
        return this.f4168y;
    }

    public final SharedPreferences r1() {
        m1();
        o1();
        if (this.f4169z == null) {
            r1 r1Var = (r1) this.f307w;
            String strValueOf = String.valueOf(r1Var.f4363v.getPackageName());
            w0 w0Var = r1Var.A;
            r1.g(w0Var);
            u0 u0Var = w0Var.J;
            String strConcat = strValueOf.concat("_preferences");
            u0Var.b(strConcat, "Default prefs file");
            this.f4169z = r1Var.f4363v.getSharedPreferences(strConcat, 0);
        }
        return this.f4169z;
    }

    public final SparseArray s1() {
        Bundle bundleC = this.J.C();
        int[] intArray = bundleC.getIntArray("uriSources");
        long[] longArray = bundleC.getLongArray("uriTimestamps");
        if (intArray == null || longArray == null) {
            return new SparseArray();
        }
        if (intArray.length != longArray.length) {
            w0 w0Var = ((r1) this.f307w).A;
            r1.g(w0Var);
            w0Var.B.a("Trigger URI source and timestamp array lengths do not match");
            return new SparseArray();
        }
        SparseArray sparseArray = new SparseArray();
        for (int i = 0; i < intArray.length; i++) {
            sparseArray.put(intArray[i], Long.valueOf(longArray[i]));
        }
        return sparseArray;
    }

    public final g2 t1() {
        m1();
        return g2.c(q1().getInt("consent_source", 100), q1().getString("consent_settings", "G1"));
    }

    public final boolean u1(c4 c4Var) {
        m1();
        String string = q1().getString("stored_tcf_param", "");
        String strA = c4Var.a();
        if (strA.equals(string)) {
            return false;
        }
        SharedPreferences.Editor editorEdit = q1().edit();
        editorEdit.putString("stored_tcf_param", strA);
        editorEdit.apply();
        return true;
    }

    public final void v1(boolean z10) {
        m1();
        w0 w0Var = ((r1) this.f307w).A;
        r1.g(w0Var);
        w0Var.J.b(Boolean.valueOf(z10), "App measurement setting deferred collection");
        SharedPreferences.Editor editorEdit = q1().edit();
        editorEdit.putBoolean("deferred_analytics_collection", z10);
        editorEdit.apply();
    }

    public final boolean w1(long j4) {
        return j4 - this.G.c() > this.L.c();
    }
}
