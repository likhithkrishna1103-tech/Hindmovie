package p1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n1 f9950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f9951c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final aa.j0 f9952a;

    static {
        aa.h0 h0Var = aa.j0.f690v;
        f9950b = new n1(aa.c1.f650y);
        int i = s1.b0.f11647a;
        f9951c = Integer.toString(0, 36);
    }

    public n1(aa.c1 c1Var) {
        this.f9952a = aa.j0.r(c1Var);
    }

    public final boolean a(int i) {
        int i10 = 0;
        while (true) {
            aa.j0 j0Var = this.f9952a;
            if (i10 >= j0Var.size()) {
                return false;
            }
            m1 m1Var = (m1) j0Var.get(i10);
            boolean[] zArr = m1Var.f9947e;
            int length = zArr.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                if (!zArr[i11]) {
                    i11++;
                } else if (m1Var.f9944b.f9764c == i) {
                    return true;
                }
            }
            i10++;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n1.class != obj.getClass()) {
            return false;
        }
        return this.f9952a.equals(((n1) obj).f9952a);
    }

    public final int hashCode() {
        return this.f9952a.hashCode();
    }
}
