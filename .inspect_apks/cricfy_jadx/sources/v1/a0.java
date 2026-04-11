package v1;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a0 {
    public static final a0 f = new a0(new k2.t());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f12567g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f12568h;
    public static final String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f12569j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f12570k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f12571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f12572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f12573c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f12574d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f12575e;

    static {
        int i10 = y1.a0.f14551a;
        f12567g = Integer.toString(0, 36);
        f12568h = Integer.toString(1, 36);
        i = Integer.toString(2, 36);
        f12569j = Integer.toString(3, 36);
        f12570k = Integer.toString(4, 36);
    }

    public a0(k2.t tVar) {
        long j4 = tVar.f6892a;
        long j7 = tVar.f6893b;
        long j10 = tVar.f6894c;
        float f10 = tVar.f6895d;
        float f11 = tVar.f6896e;
        this.f12571a = j4;
        this.f12572b = j7;
        this.f12573c = j10;
        this.f12574d = f10;
        this.f12575e = f11;
    }

    public final k2.t a() {
        k2.t tVar = new k2.t();
        tVar.f6892a = this.f12571a;
        tVar.f6893b = this.f12572b;
        tVar.f6894c = this.f12573c;
        tVar.f6895d = this.f12574d;
        tVar.f6896e = this.f12575e;
        return tVar;
    }

    public final Bundle b() {
        Bundle bundle = new Bundle();
        a0 a0Var = f;
        long j4 = a0Var.f12571a;
        long j7 = this.f12571a;
        if (j7 != j4) {
            bundle.putLong(f12567g, j7);
        }
        long j10 = a0Var.f12572b;
        long j11 = this.f12572b;
        if (j11 != j10) {
            bundle.putLong(f12568h, j11);
        }
        long j12 = a0Var.f12573c;
        long j13 = this.f12573c;
        if (j13 != j12) {
            bundle.putLong(i, j13);
        }
        float f10 = a0Var.f12574d;
        float f11 = this.f12574d;
        if (f11 != f10) {
            bundle.putFloat(f12569j, f11);
        }
        float f12 = a0Var.f12575e;
        float f13 = this.f12575e;
        if (f13 != f12) {
            bundle.putFloat(f12570k, f13);
        }
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return this.f12571a == a0Var.f12571a && this.f12572b == a0Var.f12572b && this.f12573c == a0Var.f12573c && this.f12574d == a0Var.f12574d && this.f12575e == a0Var.f12575e;
    }

    public final int hashCode() {
        long j4 = this.f12571a;
        long j7 = this.f12572b;
        int i10 = ((((int) (j4 ^ (j4 >>> 32))) * 31) + ((int) (j7 ^ (j7 >>> 32)))) * 31;
        long j10 = this.f12573c;
        int i11 = (i10 + ((int) ((j10 >>> 32) ^ j10))) * 31;
        float f10 = this.f12574d;
        int iFloatToIntBits = (i11 + (f10 != 0.0f ? Float.floatToIntBits(f10) : 0)) * 31;
        float f11 = this.f12575e;
        return iFloatToIntBits + (f11 != 0.0f ? Float.floatToIntBits(f11) : 0);
    }
}
