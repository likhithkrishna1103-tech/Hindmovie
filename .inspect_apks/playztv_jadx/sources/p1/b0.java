package p1;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b0 {
    public static final b0 f = new b0(new e2.t());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f9649g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f9650h;
    public static final String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f9651j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f9652k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f9653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f9654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f9655c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f9656d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f9657e;

    static {
        int i10 = s1.b0.f11647a;
        f9649g = Integer.toString(0, 36);
        f9650h = Integer.toString(1, 36);
        i = Integer.toString(2, 36);
        f9651j = Integer.toString(3, 36);
        f9652k = Integer.toString(4, 36);
    }

    public b0(e2.t tVar) {
        long j5 = tVar.f4363a;
        long j8 = tVar.f4364b;
        long j10 = tVar.f4365c;
        float f4 = tVar.f4366d;
        float f10 = tVar.f4367e;
        this.f9653a = j5;
        this.f9654b = j8;
        this.f9655c = j10;
        this.f9656d = f4;
        this.f9657e = f10;
    }

    public final e2.t a() {
        e2.t tVar = new e2.t();
        tVar.f4363a = this.f9653a;
        tVar.f4364b = this.f9654b;
        tVar.f4365c = this.f9655c;
        tVar.f4366d = this.f9656d;
        tVar.f4367e = this.f9657e;
        return tVar;
    }

    public final Bundle b() {
        Bundle bundle = new Bundle();
        b0 b0Var = f;
        long j5 = b0Var.f9653a;
        long j8 = this.f9653a;
        if (j8 != j5) {
            bundle.putLong(f9649g, j8);
        }
        long j10 = b0Var.f9654b;
        long j11 = this.f9654b;
        if (j11 != j10) {
            bundle.putLong(f9650h, j11);
        }
        long j12 = b0Var.f9655c;
        long j13 = this.f9655c;
        if (j13 != j12) {
            bundle.putLong(i, j13);
        }
        float f4 = b0Var.f9656d;
        float f10 = this.f9656d;
        if (f10 != f4) {
            bundle.putFloat(f9651j, f10);
        }
        float f11 = b0Var.f9657e;
        float f12 = this.f9657e;
        if (f12 != f11) {
            bundle.putFloat(f9652k, f12);
        }
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return this.f9653a == b0Var.f9653a && this.f9654b == b0Var.f9654b && this.f9655c == b0Var.f9655c && this.f9656d == b0Var.f9656d && this.f9657e == b0Var.f9657e;
    }

    public final int hashCode() {
        long j5 = this.f9653a;
        long j8 = this.f9654b;
        int i10 = ((((int) (j5 ^ (j5 >>> 32))) * 31) + ((int) (j8 ^ (j8 >>> 32)))) * 31;
        long j10 = this.f9655c;
        int i11 = (i10 + ((int) ((j10 >>> 32) ^ j10))) * 31;
        float f4 = this.f9656d;
        int iFloatToIntBits = (i11 + (f4 != 0.0f ? Float.floatToIntBits(f4) : 0)) * 31;
        float f10 = this.f9657e;
        return iFloatToIntBits + (f10 != 0.0f ? Float.floatToIntBits(f10) : 0);
    }
}
