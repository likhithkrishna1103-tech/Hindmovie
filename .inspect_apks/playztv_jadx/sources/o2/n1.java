package o2;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final n1 f9176d = new n1(new p1.g1[0]);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f9177e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final aa.c1 f9179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9180c;

    static {
        int i = s1.b0.f11647a;
        f9177e = Integer.toString(0, 36);
    }

    public n1(p1.g1... g1VarArr) {
        aa.c1 c1VarS = aa.j0.s(g1VarArr);
        this.f9179b = c1VarS;
        this.f9178a = g1VarArr.length;
        int i = 0;
        while (i < c1VarS.f652x) {
            int i10 = i + 1;
            for (int i11 = i10; i11 < c1VarS.f652x; i11++) {
                if (((p1.g1) c1VarS.get(i)).equals(c1VarS.get(i11))) {
                    s1.b.h("TrackGroupArray", "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                }
            }
            i = i10;
        }
    }

    public final p1.g1 a(int i) {
        return (p1.g1) this.f9179b.get(i);
    }

    public final int b(p1.g1 g1Var) {
        int iIndexOf = this.f9179b.indexOf(g1Var);
        if (iIndexOf >= 0) {
            return iIndexOf;
        }
        return -1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n1.class != obj.getClass()) {
            return false;
        }
        n1 n1Var = (n1) obj;
        return this.f9178a == n1Var.f9178a && this.f9179b.equals(n1Var.f9179b);
    }

    public final int hashCode() {
        if (this.f9180c == 0) {
            this.f9180c = this.f9179b.hashCode();
        }
        return this.f9180c;
    }

    public final String toString() {
        return this.f9179b.toString();
    }
}
