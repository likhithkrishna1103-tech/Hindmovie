package q6;

import android.graphics.PointF;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements e0 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final h f10407v = new h();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final nb.w f10408w = nb.w.I("t", "f", "s", "j", "tr", "lh", "ls", "fc", "sc", "sw", "of", "ps", "sz");

    @Override // q6.e0
    public final Object a(r6.a aVar, float f) {
        PointF pointF;
        PointF pointF2;
        aVar.g();
        String strQ = null;
        float fJ = 0.0f;
        float fJ2 = 0.0f;
        float fJ3 = 0.0f;
        float fJ4 = 0.0f;
        int iO = 0;
        int iA = 0;
        int iA2 = 0;
        boolean zC = true;
        int i = 3;
        String strQ2 = null;
        PointF pointF3 = null;
        PointF pointF4 = null;
        while (aVar.A()) {
            switch (aVar.g0(f10408w)) {
                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                    strQ = aVar.Q();
                    break;
                case 1:
                    strQ2 = aVar.Q();
                    break;
                case 2:
                    pointF = pointF3;
                    fJ = (float) aVar.J();
                    pointF3 = pointF;
                    break;
                case 3:
                    PointF pointF5 = pointF3;
                    pointF2 = pointF4;
                    int iO2 = aVar.O();
                    i = (iO2 > 2 || iO2 < 0) ? 3 : y.e.d(3)[iO2];
                    pointF3 = pointF5;
                    pointF4 = pointF2;
                    break;
                case g1.h.LONG_FIELD_NUMBER /* 4 */:
                    iO = aVar.O();
                    break;
                case g1.h.STRING_FIELD_NUMBER /* 5 */:
                    pointF = pointF3;
                    fJ2 = (float) aVar.J();
                    pointF3 = pointF;
                    break;
                case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                    pointF = pointF3;
                    fJ3 = (float) aVar.J();
                    pointF3 = pointF;
                    break;
                case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                    iA = o.a(aVar);
                    break;
                case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                    iA2 = o.a(aVar);
                    break;
                case 9:
                    pointF = pointF3;
                    fJ4 = (float) aVar.J();
                    pointF3 = pointF;
                    break;
                case 10:
                    zC = aVar.C();
                    break;
                case 11:
                    aVar.a();
                    pointF2 = pointF4;
                    PointF pointF6 = new PointF(((float) aVar.J()) * f, ((float) aVar.J()) * f);
                    aVar.q();
                    pointF3 = pointF6;
                    pointF4 = pointF2;
                    break;
                case 12:
                    aVar.a();
                    pointF = pointF3;
                    pointF4 = new PointF(((float) aVar.J()) * f, ((float) aVar.J()) * f);
                    aVar.q();
                    pointF3 = pointF;
                    break;
                default:
                    aVar.h0();
                    aVar.i0();
                    break;
            }
        }
        aVar.s();
        l6.b bVar = new l6.b();
        bVar.f7837a = strQ;
        bVar.f7838b = strQ2;
        bVar.f7839c = fJ;
        bVar.f7840d = i;
        bVar.f7841e = iO;
        bVar.f = fJ2;
        bVar.f7842g = fJ3;
        bVar.f7843h = iA;
        bVar.i = iA2;
        bVar.f7844j = fJ4;
        bVar.f7845k = zC;
        bVar.f7846l = pointF3;
        bVar.f7847m = pointF4;
        return bVar;
    }
}
