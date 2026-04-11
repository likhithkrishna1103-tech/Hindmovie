package androidx.datastore.preferences.protobuf;

import androidx.media3.decoder.DecoderInputBuffer;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e1 extends g1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f698b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e1(Unsafe unsafe, int i) {
        super(unsafe);
        this.f698b = i;
    }

    @Override // androidx.datastore.preferences.protobuf.g1
    public final boolean c(long j4, Object obj) {
        switch (this.f698b) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (!h1.f721g) {
                }
                break;
            default:
                if (!h1.f721g) {
                }
                break;
        }
        return h1.c(j4, obj);
    }

    @Override // androidx.datastore.preferences.protobuf.g1
    public final double d(long j4, Object obj) {
        switch (this.f698b) {
        }
        return Double.longBitsToDouble(g(j4, obj));
    }

    @Override // androidx.datastore.preferences.protobuf.g1
    public final float e(long j4, Object obj) {
        switch (this.f698b) {
        }
        return Float.intBitsToFloat(f(j4, obj));
    }

    @Override // androidx.datastore.preferences.protobuf.g1
    public final void j(Object obj, long j4, boolean z10) {
        switch (this.f698b) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (!h1.f721g) {
                    h1.l(obj, j4, z10 ? (byte) 1 : (byte) 0);
                } else {
                    h1.k(obj, j4, z10 ? (byte) 1 : (byte) 0);
                }
                break;
            default:
                if (!h1.f721g) {
                    h1.l(obj, j4, z10 ? (byte) 1 : (byte) 0);
                } else {
                    h1.k(obj, j4, z10 ? (byte) 1 : (byte) 0);
                }
                break;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.g1
    public final void k(Object obj, long j4, byte b8) {
        switch (this.f698b) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (!h1.f721g) {
                    h1.l(obj, j4, b8);
                } else {
                    h1.k(obj, j4, b8);
                }
                break;
            default:
                if (!h1.f721g) {
                    h1.l(obj, j4, b8);
                } else {
                    h1.k(obj, j4, b8);
                }
                break;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.g1
    public final void l(Object obj, long j4, double d10) {
        switch (this.f698b) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                o(obj, j4, Double.doubleToLongBits(d10));
                break;
            default:
                o(obj, j4, Double.doubleToLongBits(d10));
                break;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.g1
    public final void m(Object obj, long j4, float f) {
        switch (this.f698b) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                n(j4, obj, Float.floatToIntBits(f));
                break;
            default:
                n(j4, obj, Float.floatToIntBits(f));
                break;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.g1
    public final boolean r() {
        switch (this.f698b) {
        }
        return false;
    }
}
