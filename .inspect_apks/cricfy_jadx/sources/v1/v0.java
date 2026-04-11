package v1;

import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class v0 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f13006j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f13007k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f13008l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f13009m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f13010n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f13011o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f13012p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f13013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g0 f13015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f13016d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f13017e;
    public final long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f13018g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f13019h;
    public final int i;

    static {
        int i = y1.a0.f14551a;
        f13006j = Integer.toString(0, 36);
        f13007k = Integer.toString(1, 36);
        f13008l = Integer.toString(2, 36);
        f13009m = Integer.toString(3, 36);
        f13010n = Integer.toString(4, 36);
        f13011o = Integer.toString(5, 36);
        f13012p = Integer.toString(6, 36);
    }

    public v0(Object obj, int i, g0 g0Var, Object obj2, int i10, long j4, long j7, int i11, int i12) {
        this.f13013a = obj;
        this.f13014b = i;
        this.f13015c = g0Var;
        this.f13016d = obj2;
        this.f13017e = i10;
        this.f = j4;
        this.f13018g = j7;
        this.f13019h = i11;
        this.i = i12;
    }

    public final boolean a(v0 v0Var) {
        return this.f13014b == v0Var.f13014b && this.f13017e == v0Var.f13017e && this.f == v0Var.f && this.f13018g == v0Var.f13018g && this.f13019h == v0Var.f13019h && this.i == v0Var.i && Objects.equals(this.f13015c, v0Var.f13015c);
    }

    public final v0 b(boolean z10, boolean z11) {
        if (z10 && z11) {
            return this;
        }
        return new v0(this.f13013a, z11 ? this.f13014b : 0, z10 ? this.f13015c : null, this.f13016d, z11 ? this.f13017e : 0, z10 ? this.f : 0L, z10 ? this.f13018g : 0L, z10 ? this.f13019h : -1, z10 ? this.i : -1);
    }

    public final Bundle c(int i) {
        Bundle bundle = new Bundle();
        int i10 = this.f13014b;
        if (i < 3 || i10 != 0) {
            bundle.putInt(f13006j, i10);
        }
        g0 g0Var = this.f13015c;
        if (g0Var != null) {
            bundle.putBundle(f13007k, g0Var.c(false));
        }
        int i11 = this.f13017e;
        if (i < 3 || i11 != 0) {
            bundle.putInt(f13008l, i11);
        }
        long j4 = this.f;
        if (i < 3 || j4 != 0) {
            bundle.putLong(f13009m, j4);
        }
        long j7 = this.f13018g;
        if (i < 3 || j7 != 0) {
            bundle.putLong(f13010n, j7);
        }
        int i12 = this.f13019h;
        if (i12 != -1) {
            bundle.putInt(f13011o, i12);
        }
        int i13 = this.i;
        if (i13 != -1) {
            bundle.putInt(f13012p, i13);
        }
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && v0.class == obj.getClass()) {
            v0 v0Var = (v0) obj;
            if (a(v0Var) && Objects.equals(this.f13013a, v0Var.f13013a) && Objects.equals(this.f13016d, v0Var.f13016d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f13013a, Integer.valueOf(this.f13014b), this.f13015c, this.f13016d, Integer.valueOf(this.f13017e), Long.valueOf(this.f), Long.valueOf(this.f13018g), Integer.valueOf(this.f13019h), Integer.valueOf(this.i));
    }

    public final String toString() {
        String str = "mediaItem=" + this.f13014b + ", period=" + this.f13017e + ", pos=" + this.f;
        int i = this.f13019h;
        if (i == -1) {
            return str;
        }
        return str + ", contentPos=" + this.f13018g + ", adGroup=" + i + ", ad=" + this.i;
    }
}
