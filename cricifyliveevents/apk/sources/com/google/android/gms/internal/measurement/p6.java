package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p6 extends r6 {
    @Override // com.google.android.gms.internal.measurement.r6
    public final void a(Object obj, long j4, byte b8) {
        if (s6.f2619g) {
            s6.c(obj, j4, b8);
        } else {
            s6.d(obj, j4, b8);
        }
    }

    @Override // com.google.android.gms.internal.measurement.r6
    public final boolean b(long j4, Object obj) {
        return s6.f2619g ? s6.n(j4, obj) : s6.o(j4, obj);
    }

    @Override // com.google.android.gms.internal.measurement.r6
    public final void c(Object obj, long j4, boolean z10) {
        if (s6.f2619g) {
            s6.c(obj, j4, z10 ? (byte) 1 : (byte) 0);
        } else {
            s6.d(obj, j4, z10 ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.gms.internal.measurement.r6
    public final float d(long j4, Object obj) {
        return Float.intBitsToFloat(this.f2585a.getInt(obj, j4));
    }

    @Override // com.google.android.gms.internal.measurement.r6
    public final void e(Object obj, long j4, float f) {
        this.f2585a.putInt(obj, j4, Float.floatToIntBits(f));
    }

    @Override // com.google.android.gms.internal.measurement.r6
    public final double f(long j4, Object obj) {
        return Double.longBitsToDouble(this.f2585a.getLong(obj, j4));
    }

    @Override // com.google.android.gms.internal.measurement.r6
    public final void g(Object obj, long j4, double d10) {
        this.f2585a.putLong(obj, j4, Double.doubleToLongBits(d10));
    }
}
