package s2;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final l1 f11260d = new l1(new v1.g1[0]);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f11261e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ua.z0 f11263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11264c;

    static {
        int i = y1.a0.f14551a;
        f11261e = Integer.toString(0, 36);
    }

    public l1(v1.g1... g1VarArr) {
        ua.z0 z0VarL = ua.i0.l(g1VarArr);
        this.f11263b = z0VarL;
        this.f11262a = g1VarArr.length;
        int i = 0;
        while (i < z0VarL.f12415y) {
            int i10 = i + 1;
            for (int i11 = i10; i11 < z0VarL.f12415y; i11++) {
                if (((v1.g1) z0VarL.get(i)).equals(z0VarL.get(i11))) {
                    y1.b.h("TrackGroupArray", "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                }
            }
            i = i10;
        }
    }

    public final v1.g1 a(int i) {
        return (v1.g1) this.f11263b.get(i);
    }

    public final int b(v1.g1 g1Var) {
        int iIndexOf = this.f11263b.indexOf(g1Var);
        if (iIndexOf >= 0) {
            return iIndexOf;
        }
        return -1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l1.class != obj.getClass()) {
            return false;
        }
        l1 l1Var = (l1) obj;
        return this.f11262a == l1Var.f11262a && this.f11263b.equals(l1Var.f11263b);
    }

    public final int hashCode() {
        if (this.f11264c == 0) {
            this.f11264c = this.f11263b.hashCode();
        }
        return this.f11264c;
    }

    public final String toString() {
        return this.f11263b.toString();
    }
}
