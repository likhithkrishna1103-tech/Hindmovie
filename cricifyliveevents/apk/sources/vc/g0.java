package vc;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g0 {
    public static final f0 Companion = new f0();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ze.a[] f13621d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k0 f13622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d1 f13623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f13624c;

    static {
        df.q qVar = df.q.f3731a;
        f13621d = new ze.a[]{null, null, new df.h(y.f13714a)};
    }

    public /* synthetic */ g0(int i, k0 k0Var, d1 d1Var, Map map) {
        if (1 != (i & 1)) {
            df.k.a(i, 1, e0.f13609a.d());
            throw null;
        }
        this.f13622a = k0Var;
        if ((i & 2) == 0) {
            this.f13623b = null;
        } else {
            this.f13623b = d1Var;
        }
        if ((i & 4) == 0) {
            this.f13624c = null;
        } else {
            this.f13624c = map;
        }
    }

    public static g0 a(g0 g0Var, k0 k0Var, d1 d1Var, Map map, int i) {
        if ((i & 1) != 0) {
            k0Var = g0Var.f13622a;
        }
        if ((i & 2) != 0) {
            d1Var = g0Var.f13623b;
        }
        if ((i & 4) != 0) {
            map = g0Var.f13624c;
        }
        g0Var.getClass();
        ge.i.e(k0Var, "sessionDetails");
        return new g0(k0Var, d1Var, map);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g0)) {
            return false;
        }
        g0 g0Var = (g0) obj;
        return ge.i.a(this.f13622a, g0Var.f13622a) && ge.i.a(this.f13623b, g0Var.f13623b) && ge.i.a(this.f13624c, g0Var.f13624c);
    }

    public final int hashCode() {
        int iHashCode = this.f13622a.hashCode() * 31;
        d1 d1Var = this.f13623b;
        int iHashCode2 = (iHashCode + (d1Var == null ? 0 : d1Var.hashCode())) * 31;
        Map map = this.f13624c;
        return iHashCode2 + (map != null ? map.hashCode() : 0);
    }

    public final String toString() {
        return "SessionData(sessionDetails=" + this.f13622a + ", backgroundTime=" + this.f13623b + ", processDataMap=" + this.f13624c + ')';
    }

    public g0(k0 k0Var, d1 d1Var, Map map) {
        ge.i.e(k0Var, "sessionDetails");
        this.f13622a = k0Var;
        this.f13623b = d1Var;
        this.f13624c = map;
    }
}
