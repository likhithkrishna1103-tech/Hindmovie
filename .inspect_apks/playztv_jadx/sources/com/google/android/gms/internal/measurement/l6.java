package com.google.android.gms.internal.measurement;

import androidx.media3.decoder.DecoderInputBuffer;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l6 extends m6 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3088b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l6(Unsafe unsafe, int i) {
        super(unsafe);
        this.f3088b = i;
    }

    @Override // com.google.android.gms.internal.measurement.m6
    public final double a(long j5, Object obj) {
        switch (this.f3088b) {
        }
        return Double.longBitsToDouble(k(j5, obj));
    }

    @Override // com.google.android.gms.internal.measurement.m6
    public final void c(Object obj, long j5, byte b10) {
        switch (this.f3088b) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (!n6.f3124g) {
                    n6.h(obj, j5, b10);
                } else {
                    n6.g(obj, j5, b10);
                }
                break;
            default:
                if (!n6.f3124g) {
                    n6.h(obj, j5, b10);
                } else {
                    n6.g(obj, j5, b10);
                }
                break;
        }
    }

    @Override // com.google.android.gms.internal.measurement.m6
    public final void d(Object obj, long j5, double d10) {
        switch (this.f3088b) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                f(obj, j5, Double.doubleToLongBits(d10));
                break;
            default:
                f(obj, j5, Double.doubleToLongBits(d10));
                break;
        }
    }

    @Override // com.google.android.gms.internal.measurement.m6
    public final void e(Object obj, long j5, float f) {
        switch (this.f3088b) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                b(Float.floatToIntBits(f), j5, obj);
                break;
            default:
                b(Float.floatToIntBits(f), j5, obj);
                break;
        }
    }

    @Override // com.google.android.gms.internal.measurement.m6
    public final void g(Object obj, long j5, boolean z2) {
        switch (this.f3088b) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (!n6.f3124g) {
                    n6.h(obj, j5, z2 ? (byte) 1 : (byte) 0);
                } else {
                    n6.g(obj, j5, z2 ? (byte) 1 : (byte) 0);
                }
                break;
            default:
                if (!n6.f3124g) {
                    n6.h(obj, j5, z2 ? (byte) 1 : (byte) 0);
                } else {
                    n6.g(obj, j5, z2 ? (byte) 1 : (byte) 0);
                }
                break;
        }
    }

    @Override // com.google.android.gms.internal.measurement.m6
    public final float h(long j5, Object obj) {
        switch (this.f3088b) {
        }
        return Float.intBitsToFloat(j(j5, obj));
    }

    @Override // com.google.android.gms.internal.measurement.m6
    public final boolean i(long j5, Object obj) {
        switch (this.f3088b) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (n6.f3124g) {
                    if (((byte) (n6.f3121c.j((-4) & j5, obj) >>> ((int) (((~j5) & 3) << 3)))) == 0) {
                    }
                } else {
                    if (((byte) (n6.f3121c.j((-4) & j5, obj) >>> ((int) ((j5 & 3) << 3)))) == 0) {
                    }
                }
                break;
            default:
                if (n6.f3124g) {
                    if (((byte) (n6.f3121c.j((-4) & j5, obj) >>> ((int) (((~j5) & 3) << 3)))) == 0) {
                    }
                } else {
                    if (((byte) (n6.f3121c.j((-4) & j5, obj) >>> ((int) ((j5 & 3) << 3)))) == 0) {
                    }
                }
                break;
        }
        return false;
    }
}
