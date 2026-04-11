package w2;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f implements h, y6.a {
    public static yc.b a(int i) {
        yc.b bVar = yc.b.f14649w;
        switch (i) {
            case -1:
                return bVar;
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return yc.b.f14650x;
            case 1:
                return yc.b.f14651y;
            case 2:
                return yc.b.f14652z;
            case 3:
                return yc.b.A;
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                return yc.b.B;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                return yc.b.C;
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                return yc.b.D;
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                return yc.b.E;
            case 8:
                return yc.b.F;
            case 9:
                return yc.b.G;
            case 10:
                return yc.b.H;
            case 11:
                return yc.b.I;
            case 12:
            case 14:
            case 18:
            default:
                return bVar;
            case 13:
                return yc.b.J;
            case 15:
                return yc.b.L;
            case 16:
                return yc.b.M;
            case 17:
                return yc.b.N;
            case 19:
                return yc.b.O;
            case 20:
                return yc.b.P;
            case 21:
                return yc.b.Q;
            case 22:
                return yc.b.R;
            case 23:
                return yc.b.S;
            case 24:
                return yc.b.T;
            case 25:
                return yc.b.U;
            case 26:
                return yc.b.V;
            case 27:
                return yc.b.W;
            case 28:
                return yc.b.X;
            case 29:
                return yc.b.Y;
            case 30:
                return yc.b.Z;
            case 31:
                return yc.b.f14646a0;
        }
    }

    public static yc.k b(int i) {
        yc.k kVar = yc.k.f14688w;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return kVar;
            case 1:
                return yc.k.f14689x;
            case 2:
                return yc.k.f14690y;
            case 3:
                return yc.k.f14691z;
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                return yc.k.A;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                return yc.k.B;
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                return yc.k.C;
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                return yc.k.D;
            case 8:
                return yc.k.E;
            case 9:
                return yc.k.F;
            default:
                return kVar;
        }
    }

    @Override // y6.a
    public Object r() {
        return new ArrayList();
    }

    @Override // w2.h
    public long e(long j5) {
        return j5;
    }
}
