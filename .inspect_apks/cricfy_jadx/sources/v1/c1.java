package v1;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c1 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f12612h;
    public static final String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f12613j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f12614k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f12615l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f12616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f12617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12618c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f12619d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f12620e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f12621g = b.f12580c;

    static {
        int i10 = y1.a0.f14551a;
        f12612h = Integer.toString(0, 36);
        i = Integer.toString(1, 36);
        f12613j = Integer.toString(2, 36);
        f12614k = Integer.toString(3, 36);
        f12615l = Integer.toString(4, 36);
    }

    public final long a(int i10, int i11) {
        a aVarA = this.f12621g.a(i10);
        if (aVarA.f12561a != -1) {
            return aVarA.f[i11];
        }
        return -9223372036854775807L;
    }

    public final int b(long j4) {
        a aVarA;
        int i10;
        b bVar = this.f12621g;
        long j7 = this.f12619d;
        int i11 = bVar.f12583a;
        if (j4 != Long.MIN_VALUE && (j7 == -9223372036854775807L || j4 < j7)) {
            int i12 = 0;
            while (i12 < i11) {
                bVar.a(i12).getClass();
                bVar.a(i12).getClass();
                if (0 > j4 && ((i10 = (aVarA = bVar.a(i12)).f12561a) == -1 || aVarA.a(-1) < i10)) {
                    break;
                }
                i12++;
            }
            if (i12 < i11) {
                if (j7 != -9223372036854775807L) {
                    bVar.a(i12).getClass();
                    if (0 <= j7) {
                    }
                }
                return i12;
            }
        }
        return -1;
    }

    public final int c(long j4) {
        b bVar = this.f12621g;
        int i10 = bVar.f12583a;
        int i11 = i10 - 1;
        if (i11 == i10 - 1) {
            bVar.a(i11).getClass();
        }
        while (i11 >= 0 && j4 != Long.MIN_VALUE) {
            bVar.a(i11).getClass();
            if (j4 >= 0) {
                break;
            }
            i11--;
        }
        if (i11 >= 0) {
            a aVarA = bVar.a(i11);
            int i12 = aVarA.f12561a;
            if (i12 != -1) {
                for (int i13 = 0; i13 < i12; i13++) {
                    int i14 = aVarA.f12565e[i13];
                    if (i14 != 0 && i14 != 1) {
                    }
                }
            }
            return i11;
        }
        return -1;
    }

    public final long d(int i10) {
        this.f12621g.a(i10).getClass();
        return 0L;
    }

    public final int e(int i10) {
        return this.f12621g.a(i10).a(-1);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && c1.class.equals(obj.getClass())) {
            c1 c1Var = (c1) obj;
            if (Objects.equals(this.f12616a, c1Var.f12616a) && Objects.equals(this.f12617b, c1Var.f12617b) && this.f12618c == c1Var.f12618c && this.f12619d == c1Var.f12619d && this.f12620e == c1Var.f12620e && this.f == c1Var.f && Objects.equals(this.f12621g, c1Var.f12621g)) {
                return true;
            }
        }
        return false;
    }

    public final boolean f(int i10) {
        b bVar = this.f12621g;
        int i11 = bVar.f12583a;
        if (i10 != i11 - 1 || i10 != i11 - 1) {
            return false;
        }
        bVar.a(i10).getClass();
        return false;
    }

    public final boolean g(int i10) {
        this.f12621g.a(i10).getClass();
        return false;
    }

    public final void h(Object obj, Object obj2, int i10, long j4, long j7, b bVar, boolean z10) {
        this.f12616a = obj;
        this.f12617b = obj2;
        this.f12618c = i10;
        this.f12619d = j4;
        this.f12620e = j7;
        this.f12621g = bVar;
        this.f = z10;
    }

    public final int hashCode() {
        Object obj = this.f12616a;
        int iHashCode = (217 + (obj == null ? 0 : obj.hashCode())) * 31;
        Object obj2 = this.f12617b;
        int iHashCode2 = (((iHashCode + (obj2 != null ? obj2.hashCode() : 0)) * 31) + this.f12618c) * 31;
        long j4 = this.f12619d;
        int i10 = (iHashCode2 + ((int) (j4 ^ (j4 >>> 32)))) * 31;
        long j7 = this.f12620e;
        return this.f12621g.hashCode() + ((((i10 + ((int) (j7 ^ (j7 >>> 32)))) * 31) + (this.f ? 1 : 0)) * 31);
    }
}
