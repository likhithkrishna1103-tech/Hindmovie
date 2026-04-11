package androidx.datastore.preferences.protobuf;

import androidx.media3.decoder.DecoderInputBuffer;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p1 extends r1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1099b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p1(Unsafe unsafe, int i) {
        super(unsafe);
        this.f1099b = i;
    }

    @Override // androidx.datastore.preferences.protobuf.r1
    public final boolean c(long j5, Object obj) {
        switch (this.f1099b) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (s1.f1131h) {
                    if (s1.g(j5, obj) == 0) {
                    }
                } else if (s1.h(j5, obj) == 0) {
                }
                break;
            default:
                if (s1.f1131h) {
                    if (s1.g(j5, obj) == 0) {
                    }
                } else if (s1.h(j5, obj) == 0) {
                }
                break;
        }
        return false;
    }

    @Override // androidx.datastore.preferences.protobuf.r1
    public final byte d(long j5, Object obj) {
        switch (this.f1099b) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (!s1.f1131h) {
                }
                break;
            default:
                if (!s1.f1131h) {
                }
                break;
        }
        return s1.h(j5, obj);
    }

    @Override // androidx.datastore.preferences.protobuf.r1
    public final double e(long j5, Object obj) {
        switch (this.f1099b) {
        }
        return Double.longBitsToDouble(h(j5, obj));
    }

    @Override // androidx.datastore.preferences.protobuf.r1
    public final float f(long j5, Object obj) {
        switch (this.f1099b) {
        }
        return Float.intBitsToFloat(g(j5, obj));
    }

    @Override // androidx.datastore.preferences.protobuf.r1
    public final void k(Object obj, long j5, boolean z2) {
        switch (this.f1099b) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (!s1.f1131h) {
                    s1.l(obj, j5, z2 ? (byte) 1 : (byte) 0);
                } else {
                    s1.k(obj, j5, z2 ? (byte) 1 : (byte) 0);
                }
                break;
            default:
                if (!s1.f1131h) {
                    s1.l(obj, j5, z2 ? (byte) 1 : (byte) 0);
                } else {
                    s1.k(obj, j5, z2 ? (byte) 1 : (byte) 0);
                }
                break;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.r1
    public final void l(Object obj, long j5, byte b10) {
        switch (this.f1099b) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (!s1.f1131h) {
                    s1.l(obj, j5, b10);
                } else {
                    s1.k(obj, j5, b10);
                }
                break;
            default:
                if (!s1.f1131h) {
                    s1.l(obj, j5, b10);
                } else {
                    s1.k(obj, j5, b10);
                }
                break;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.r1
    public final void m(Object obj, long j5, double d10) {
        switch (this.f1099b) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                p(obj, j5, Double.doubleToLongBits(d10));
                break;
            default:
                p(obj, j5, Double.doubleToLongBits(d10));
                break;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.r1
    public final void n(Object obj, long j5, float f) {
        switch (this.f1099b) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                o(Float.floatToIntBits(f), j5, obj);
                break;
            default:
                o(Float.floatToIntBits(f), j5, obj);
                break;
        }
    }
}
