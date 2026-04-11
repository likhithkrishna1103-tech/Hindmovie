package k4;

import android.os.Bundle;
import android.os.SystemClock;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f7120e;
    public static final String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f7121g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f7122h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bundle f7124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f7125c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m1 f7126d;

    static {
        int i = y1.a0.f14551a;
        f7120e = Integer.toString(0, 36);
        f = Integer.toString(1, 36);
        f7121g = Integer.toString(2, 36);
        f7122h = Integer.toString(3, 36);
    }

    public o1(int i) {
        this(i, Bundle.EMPTY, SystemClock.elapsedRealtime(), null);
    }

    public static o1 a(Bundle bundle) {
        m1 m1Var;
        int i = bundle.getInt(f7120e, -1);
        Bundle bundle2 = bundle.getBundle(f);
        long j4 = bundle.getLong(f7121g, SystemClock.elapsedRealtime());
        Bundle bundle3 = bundle.getBundle(f7122h);
        if (bundle3 != null) {
            int i10 = bundle3.getInt(m1.f7086d, 1000);
            String string = bundle3.getString(m1.f7087e, "");
            Bundle bundle4 = bundle3.getBundle(m1.f);
            if (bundle4 == null) {
                bundle4 = Bundle.EMPTY;
            }
            m1Var = new m1(i10, string, bundle4);
        } else {
            m1Var = i != 0 ? new m1(i) : null;
        }
        m1 m1Var2 = m1Var;
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        return new o1(i, bundle2, j4, m1Var2);
    }

    public o1(int i, Bundle bundle, long j4, m1 m1Var) {
        y1.d.b(m1Var == null || i < 0);
        this.f7123a = i;
        this.f7124b = new Bundle(bundle);
        this.f7125c = j4;
        if (m1Var == null && i < 0) {
            m1Var = new m1(i);
        }
        this.f7126d = m1Var;
    }
}
