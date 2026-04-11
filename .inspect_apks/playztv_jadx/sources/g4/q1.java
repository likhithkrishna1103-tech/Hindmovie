package g4;

import android.os.Bundle;
import android.os.SystemClock;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class q1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f5186e;
    public static final String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f5187g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f5188h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bundle f5190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f5191c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o1 f5192d;

    static {
        int i = s1.b0.f11647a;
        f5186e = Integer.toString(0, 36);
        f = Integer.toString(1, 36);
        f5187g = Integer.toString(2, 36);
        f5188h = Integer.toString(3, 36);
    }

    public q1(int i) {
        this(i, Bundle.EMPTY, SystemClock.elapsedRealtime(), null);
    }

    public static q1 a(Bundle bundle) {
        o1 o1Var;
        int i = bundle.getInt(f5186e, -1);
        Bundle bundle2 = bundle.getBundle(f);
        long j5 = bundle.getLong(f5187g, SystemClock.elapsedRealtime());
        Bundle bundle3 = bundle.getBundle(f5188h);
        if (bundle3 != null) {
            int i10 = bundle3.getInt(o1.f5149d, 1000);
            String string = bundle3.getString(o1.f5150e, "");
            Bundle bundle4 = bundle3.getBundle(o1.f);
            if (bundle4 == null) {
                bundle4 = Bundle.EMPTY;
            }
            o1Var = new o1(i10, string, bundle4);
        } else {
            o1Var = i != 0 ? new o1(i) : null;
        }
        o1 o1Var2 = o1Var;
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        return new q1(i, bundle2, j5, o1Var2);
    }

    public q1(int i, Bundle bundle, long j5, o1 o1Var) {
        s1.d.b(o1Var == null || i < 0);
        this.f5189a = i;
        this.f5190b = new Bundle(bundle);
        this.f5191c = j5;
        if (o1Var == null && i < 0) {
            o1Var = new o1(i);
        }
        this.f5192d = o1Var;
    }
}
