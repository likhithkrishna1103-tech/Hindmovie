package v5;

import android.graphics.Color;
import android.graphics.PointF;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f implements d0 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f13282u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final f f13277v = new f(0);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final f f13278w = new f(1);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final f f13279x = new f(2);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final f f13280y = new f(3);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final f f13281z = new f(4);
    public static final f A = new f(5);

    public /* synthetic */ f(int i) {
        this.f13282u = i;
    }

    @Override // v5.d0
    public final Object a(w5.a aVar, float f) {
        switch (this.f13282u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                boolean z2 = aVar.g0() == 1;
                if (z2) {
                    aVar.a();
                }
                double dJ = aVar.J();
                double dJ2 = aVar.J();
                double dJ3 = aVar.J();
                double dJ4 = aVar.g0() == 7 ? aVar.J() : 1.0d;
                if (z2) {
                    aVar.v();
                }
                if (dJ <= 1.0d && dJ2 <= 1.0d && dJ3 <= 1.0d) {
                    dJ *= 255.0d;
                    dJ2 *= 255.0d;
                    dJ3 *= 255.0d;
                    if (dJ4 <= 1.0d) {
                        dJ4 *= 255.0d;
                    }
                }
                return Integer.valueOf(Color.argb((int) dJ4, (int) dJ, (int) dJ2, (int) dJ3));
            case 1:
                return Float.valueOf(n.d(aVar) * f);
            case 2:
                return Integer.valueOf(Math.round(n.d(aVar) * f));
            case 3:
                return n.b(aVar, f);
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                int iG0 = aVar.g0();
                if (iG0 == 1) {
                    return n.b(aVar, f);
                }
                if (iG0 == 3) {
                    return n.b(aVar, f);
                }
                if (iG0 != 7) {
                    throw new IllegalArgumentException("Cannot convert json to point. Next token is ".concat(e6.j.v(iG0)));
                }
                PointF pointF = new PointF(((float) aVar.J()) * f, ((float) aVar.J()) * f);
                while (aVar.G()) {
                    aVar.k0();
                }
                return pointF;
            default:
                boolean z10 = aVar.g0() == 1;
                if (z10) {
                    aVar.a();
                }
                float fJ = (float) aVar.J();
                float fJ2 = (float) aVar.J();
                while (aVar.G()) {
                    aVar.k0();
                }
                if (z10) {
                    aVar.v();
                }
                return new y5.b((fJ / 100.0f) * f, (fJ2 / 100.0f) * f);
        }
    }
}
