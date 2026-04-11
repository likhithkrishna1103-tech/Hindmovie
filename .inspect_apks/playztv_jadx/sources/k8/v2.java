package k8;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class v2 extends y0 {
    public final ConcurrentHashMap A;
    public Activity B;
    public volatile boolean C;
    public volatile w2 D;
    public w2 E;
    public boolean F;
    public final Object G;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public volatile w2 f7460x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public volatile w2 f7461y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public w2 f7462z;

    public v2(k1 k1Var) {
        super(k1Var);
        this.G = new Object();
        this.A = new ConcurrentHashMap();
    }

    public final void A1(w2 w2Var, w2 w2Var2, long j5, boolean z2, Bundle bundle) {
        boolean z10 = w2Var.f7530e;
        k1 k1Var = (k1) this.f2454v;
        p1();
        boolean z11 = false;
        boolean z12 = (w2Var2 != null && w2Var2.f7528c == w2Var.f7528c && Objects.equals(w2Var2.f7527b, w2Var.f7527b) && Objects.equals(w2Var2.f7526a, w2Var.f7526a)) ? false : true;
        if (z2 && this.f7462z != null) {
            z11 = true;
        }
        if (z12) {
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            h4.S1(w2Var, bundle2, true);
            if (w2Var2 != null) {
                String str = w2Var2.f7526a;
                if (str != null) {
                    bundle2.putString("_pn", str);
                }
                String str2 = w2Var2.f7527b;
                if (str2 != null) {
                    bundle2.putString("_pc", str2);
                }
                bundle2.putLong("_pi", w2Var2.f7528c);
            }
            if (z11) {
                o3 o3Var = s1().A;
                long j8 = j5 - o3Var.f7357v;
                o3Var.f7357v = j5;
                if (j8 > 0) {
                    o1().G1(bundle2, j8);
                }
            }
            if (!k1Var.A.C1()) {
                bundle2.putLong("_mst", 1L);
            }
            String str3 = z10 ? "app" : "auto";
            k1Var.H.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (z10) {
                long j10 = w2Var.f;
                if (j10 != 0) {
                    jCurrentTimeMillis = j10;
                }
            }
            q1().w1(jCurrentTimeMillis, bundle2, str3, "_vs");
        }
        if (z11) {
            B1(this.f7462z, true, j5);
        }
        this.f7462z = w2Var;
        if (z10) {
            this.E = w2Var;
        }
        z2 z2VarP = k1Var.p();
        z2VarP.p1();
        z2VarP.t1();
        z2VarP.w1(new ea.t(17, z2VarP, w2Var, false));
    }

    public final void B1(w2 w2Var, boolean z2, long j5) {
        k1 k1Var = (k1) this.f2454v;
        q qVarK = k1Var.k();
        k1Var.H.getClass();
        qVarK.t1(SystemClock.elapsedRealtime());
        if (!s1().A.a(j5, w2Var != null && w2Var.f7529d, z2) || w2Var == null) {
            return;
        }
        w2Var.f7529d = false;
    }

    public final w2 C1(Activity activity) {
        t7.v.h(activity);
        w2 w2Var = (w2) this.A.get(Integer.valueOf(activity.hashCode()));
        if (w2Var == null) {
            w2 w2Var2 = new w2(o1().z2(), null, w1(activity.getClass()));
            this.A.put(Integer.valueOf(activity.hashCode()), w2Var2);
            w2Var = w2Var2;
        }
        return this.D != null ? this.D : w2Var;
    }

    @Override // k8.y0
    public final boolean v1() {
        return false;
    }

    public final String w1(Class cls) {
        k1 k1Var = (k1) this.f2454v;
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            return "Activity";
        }
        String[] strArrSplit = canonicalName.split("\\.");
        String str = strArrSplit.length > 0 ? strArrSplit[strArrSplit.length - 1] : "";
        int length = str.length();
        k1Var.A.getClass();
        if (length <= 500) {
            return str;
        }
        k1Var.A.getClass();
        return str.substring(0, 500);
    }

    public final w2 x1(boolean z2) {
        t1();
        p1();
        if (!z2) {
            return this.f7462z;
        }
        w2 w2Var = this.f7462z;
        return w2Var != null ? w2Var : this.E;
    }

    public final void y1(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (!((k1) this.f2454v).A.C1() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.A.put(Integer.valueOf(activity.hashCode()), new w2(bundle2.getLong("id"), bundle2.getString("name"), bundle2.getString("referrer_name")));
    }

    public final void z1(Activity activity, w2 w2Var, boolean z2) {
        w2 w2Var2 = this.f7460x == null ? this.f7461y : this.f7460x;
        w2 w2Var3 = w2Var.f7527b == null ? new w2(w2Var.f7526a, w1(activity.getClass()), w2Var.f7528c, w2Var.f7530e, w2Var.f) : w2Var;
        this.f7461y = this.f7460x;
        this.f7460x = w2Var3;
        ((k1) this.f2454v).H.getClass();
        x().y1(new r2(this, w2Var3, w2Var2, SystemClock.elapsedRealtime(), z2));
    }
}
