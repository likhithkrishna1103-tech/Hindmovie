package p1;

import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class v0 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f10073j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f10074k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f10075l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f10076m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f10077n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f10078o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f10079p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f10080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g0 f10082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f10083d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f10084e;
    public final long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f10085g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f10086h;
    public final int i;

    static {
        int i = s1.b0.f11647a;
        f10073j = Integer.toString(0, 36);
        f10074k = Integer.toString(1, 36);
        f10075l = Integer.toString(2, 36);
        f10076m = Integer.toString(3, 36);
        f10077n = Integer.toString(4, 36);
        f10078o = Integer.toString(5, 36);
        f10079p = Integer.toString(6, 36);
    }

    public v0(Object obj, int i, g0 g0Var, Object obj2, int i10, long j5, long j8, int i11, int i12) {
        this.f10080a = obj;
        this.f10081b = i;
        this.f10082c = g0Var;
        this.f10083d = obj2;
        this.f10084e = i10;
        this.f = j5;
        this.f10085g = j8;
        this.f10086h = i11;
        this.i = i12;
    }

    public final boolean a(v0 v0Var) {
        return this.f10081b == v0Var.f10081b && this.f10084e == v0Var.f10084e && this.f == v0Var.f && this.f10085g == v0Var.f10085g && this.f10086h == v0Var.f10086h && this.i == v0Var.i && Objects.equals(this.f10082c, v0Var.f10082c);
    }

    public final v0 b(boolean z2, boolean z10) {
        if (z2 && z10) {
            return this;
        }
        return new v0(this.f10080a, z10 ? this.f10081b : 0, z2 ? this.f10082c : null, this.f10083d, z10 ? this.f10084e : 0, z2 ? this.f : 0L, z2 ? this.f10085g : 0L, z2 ? this.f10086h : -1, z2 ? this.i : -1);
    }

    public final Bundle c(int i) {
        Bundle bundle = new Bundle();
        int i10 = this.f10081b;
        if (i < 3 || i10 != 0) {
            bundle.putInt(f10073j, i10);
        }
        g0 g0Var = this.f10082c;
        if (g0Var != null) {
            bundle.putBundle(f10074k, g0Var.c(false));
        }
        int i11 = this.f10084e;
        if (i < 3 || i11 != 0) {
            bundle.putInt(f10075l, i11);
        }
        long j5 = this.f;
        if (i < 3 || j5 != 0) {
            bundle.putLong(f10076m, j5);
        }
        long j8 = this.f10085g;
        if (i < 3 || j8 != 0) {
            bundle.putLong(f10077n, j8);
        }
        int i12 = this.f10086h;
        if (i12 != -1) {
            bundle.putInt(f10078o, i12);
        }
        int i13 = this.i;
        if (i13 != -1) {
            bundle.putInt(f10079p, i13);
        }
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && v0.class == obj.getClass()) {
            v0 v0Var = (v0) obj;
            if (a(v0Var) && Objects.equals(this.f10080a, v0Var.f10080a) && Objects.equals(this.f10083d, v0Var.f10083d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f10080a, Integer.valueOf(this.f10081b), this.f10082c, this.f10083d, Integer.valueOf(this.f10084e), Long.valueOf(this.f), Long.valueOf(this.f10085g), Integer.valueOf(this.f10086h), Integer.valueOf(this.i));
    }

    public final String toString() {
        String str = "mediaItem=" + this.f10081b + ", period=" + this.f10084e + ", pos=" + this.f;
        int i = this.f10086h;
        if (i == -1) {
            return str;
        }
        return str + ", contentPos=" + this.f10085g + ", adGroup=" + i + ", ad=" + this.i;
    }
}
