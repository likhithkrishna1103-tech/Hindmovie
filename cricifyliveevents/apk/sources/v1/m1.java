package v1;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m1 {
    public static final String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f12870g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f12871h;
    public static final String i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g1 f12873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f12874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f12875d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean[] f12876e;

    static {
        int i10 = y1.a0.f14551a;
        f = Integer.toString(0, 36);
        f12870g = Integer.toString(1, 36);
        f12871h = Integer.toString(3, 36);
        i = Integer.toString(4, 36);
    }

    public m1(g1 g1Var, boolean z10, int[] iArr, boolean[] zArr) {
        int i10 = g1Var.f12702a;
        this.f12872a = i10;
        boolean z11 = false;
        y1.d.b(i10 == iArr.length && i10 == zArr.length);
        this.f12873b = g1Var;
        if (z10 && i10 > 1) {
            z11 = true;
        }
        this.f12874c = z11;
        this.f12875d = (int[]) iArr.clone();
        this.f12876e = (boolean[]) zArr.clone();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && m1.class == obj.getClass()) {
            m1 m1Var = (m1) obj;
            if (this.f12874c == m1Var.f12874c && this.f12873b.equals(m1Var.f12873b) && Arrays.equals(this.f12875d, m1Var.f12875d) && Arrays.equals(this.f12876e, m1Var.f12876e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f12876e) + ((Arrays.hashCode(this.f12875d) + (((this.f12873b.hashCode() * 31) + (this.f12874c ? 1 : 0)) * 31)) * 31);
    }
}
