package p1;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m1 {
    public static final String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f9941g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f9942h;
    public static final String i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g1 f9944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f9945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f9946d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean[] f9947e;

    static {
        int i10 = s1.b0.f11647a;
        f = Integer.toString(0, 36);
        f9941g = Integer.toString(1, 36);
        f9942h = Integer.toString(3, 36);
        i = Integer.toString(4, 36);
    }

    public m1(g1 g1Var, boolean z2, int[] iArr, boolean[] zArr) {
        int i10 = g1Var.f9762a;
        this.f9943a = i10;
        boolean z10 = false;
        s1.d.b(i10 == iArr.length && i10 == zArr.length);
        this.f9944b = g1Var;
        if (z2 && i10 > 1) {
            z10 = true;
        }
        this.f9945c = z10;
        this.f9946d = (int[]) iArr.clone();
        this.f9947e = (boolean[]) zArr.clone();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && m1.class == obj.getClass()) {
            m1 m1Var = (m1) obj;
            if (this.f9945c == m1Var.f9945c && this.f9944b.equals(m1Var.f9944b) && Arrays.equals(this.f9946d, m1Var.f9946d) && Arrays.equals(this.f9947e, m1Var.f9947e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f9947e) + ((Arrays.hashCode(this.f9946d) + (((this.f9944b.hashCode() * 31) + (this.f9945c ? 1 : 0)) * 31)) * 31);
    }
}
