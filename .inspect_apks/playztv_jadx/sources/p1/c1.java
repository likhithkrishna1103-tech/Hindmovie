package p1;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c1 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f9672h;
    public static final String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f9673j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f9674k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f9675l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f9676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f9677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f9679d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f9680e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f9681g = b.f9644c;

    static {
        int i10 = s1.b0.f11647a;
        f9672h = Integer.toString(0, 36);
        i = Integer.toString(1, 36);
        f9673j = Integer.toString(2, 36);
        f9674k = Integer.toString(3, 36);
        f9675l = Integer.toString(4, 36);
    }

    public final long a(int i10, int i11) {
        a aVarA = this.f9681g.a(i10);
        if (aVarA.f9620a != -1) {
            return aVarA.f[i11];
        }
        return -9223372036854775807L;
    }

    public final int b(long j5) {
        a aVarA;
        int i10;
        b bVar = this.f9681g;
        long j8 = this.f9679d;
        int i11 = bVar.f9647a;
        if (j5 != Long.MIN_VALUE && (j8 == -9223372036854775807L || j5 < j8)) {
            int i12 = 0;
            while (i12 < i11) {
                bVar.a(i12).getClass();
                bVar.a(i12).getClass();
                if (0 > j5 && ((i10 = (aVarA = bVar.a(i12)).f9620a) == -1 || aVarA.a(-1) < i10)) {
                    break;
                }
                i12++;
            }
            if (i12 < i11) {
                if (j8 != -9223372036854775807L) {
                    bVar.a(i12).getClass();
                    if (0 <= j8) {
                    }
                }
                return i12;
            }
        }
        return -1;
    }

    public final int c(long j5) {
        b bVar = this.f9681g;
        int i10 = bVar.f9647a;
        int i11 = i10 - 1;
        if (i11 == i10 - 1) {
            bVar.a(i11).getClass();
        }
        while (i11 >= 0 && j5 != Long.MIN_VALUE) {
            bVar.a(i11).getClass();
            if (j5 >= 0) {
                break;
            }
            i11--;
        }
        if (i11 >= 0) {
            a aVarA = bVar.a(i11);
            int i12 = aVarA.f9620a;
            if (i12 != -1) {
                for (int i13 = 0; i13 < i12; i13++) {
                    int i14 = aVarA.f9624e[i13];
                    if (i14 != 0 && i14 != 1) {
                    }
                }
            }
            return i11;
        }
        return -1;
    }

    public final long d(int i10) {
        this.f9681g.a(i10).getClass();
        return 0L;
    }

    public final int e(int i10) {
        return this.f9681g.a(i10).a(-1);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && c1.class.equals(obj.getClass())) {
            c1 c1Var = (c1) obj;
            if (Objects.equals(this.f9676a, c1Var.f9676a) && Objects.equals(this.f9677b, c1Var.f9677b) && this.f9678c == c1Var.f9678c && this.f9679d == c1Var.f9679d && this.f9680e == c1Var.f9680e && this.f == c1Var.f && Objects.equals(this.f9681g, c1Var.f9681g)) {
                return true;
            }
        }
        return false;
    }

    public final boolean f(int i10) {
        b bVar = this.f9681g;
        int i11 = bVar.f9647a;
        if (i10 != i11 - 1 || i10 != i11 - 1) {
            return false;
        }
        bVar.a(i10).getClass();
        return false;
    }

    public final boolean g(int i10) {
        this.f9681g.a(i10).getClass();
        return false;
    }

    public final void h(Object obj, Object obj2, int i10, long j5, long j8, b bVar, boolean z2) {
        this.f9676a = obj;
        this.f9677b = obj2;
        this.f9678c = i10;
        this.f9679d = j5;
        this.f9680e = j8;
        this.f9681g = bVar;
        this.f = z2;
    }

    public final int hashCode() {
        Object obj = this.f9676a;
        int iHashCode = (217 + (obj == null ? 0 : obj.hashCode())) * 31;
        Object obj2 = this.f9677b;
        int iHashCode2 = (((iHashCode + (obj2 != null ? obj2.hashCode() : 0)) * 31) + this.f9678c) * 31;
        long j5 = this.f9679d;
        int i10 = (iHashCode2 + ((int) (j5 ^ (j5 >>> 32)))) * 31;
        long j8 = this.f9680e;
        return this.f9681g.hashCode() + ((((i10 + ((int) (j8 ^ (j8 >>> 32)))) * 31) + (this.f ? 1 : 0)) * 31);
    }
}
