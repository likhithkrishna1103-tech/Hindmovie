package q6;

import android.graphics.Color;
import android.graphics.PointF;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements e0 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f10405v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final f f10401w = new f(0);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final f f10402x = new f(1);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final f f10403y = new f(2);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final f f10404z = new f(3);
    public static final f A = new f(4);
    public static final f B = new f(5);

    public /* synthetic */ f(int i) {
        this.f10405v = i;
    }

    @Override // q6.e0
    public final Object a(r6.a aVar, float f) {
        switch (this.f10405v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                boolean z10 = aVar.R() == 1;
                if (z10) {
                    aVar.a();
                }
                double dJ = aVar.J();
                double dJ2 = aVar.J();
                double dJ3 = aVar.J();
                double dJ4 = aVar.R() == 7 ? aVar.J() : 1.0d;
                if (z10) {
                    aVar.q();
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
                return Float.valueOf(o.d(aVar) * f);
            case 2:
                return Integer.valueOf(Math.round(o.d(aVar) * f));
            case 3:
                return o.b(aVar, f);
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                int iR = aVar.R();
                if (iR == 1) {
                    return o.b(aVar, f);
                }
                if (iR == 3) {
                    return o.b(aVar, f);
                }
                if (iR != 7) {
                    throw new IllegalArgumentException("Cannot convert json to point. Next token is ".concat(l0.e.u(iR)));
                }
                PointF pointF = new PointF(((float) aVar.J()) * f, ((float) aVar.J()) * f);
                while (aVar.A()) {
                    aVar.i0();
                }
                return pointF;
            default:
                boolean z11 = aVar.R() == 1;
                if (z11) {
                    aVar.a();
                }
                float fJ = (float) aVar.J();
                float fJ2 = (float) aVar.J();
                while (aVar.A()) {
                    aVar.i0();
                }
                if (z11) {
                    aVar.q();
                }
                return new t6.b((fJ / 100.0f) * f, (fJ2 / 100.0f) * f);
        }
    }
}
