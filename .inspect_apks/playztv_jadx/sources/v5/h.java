package v5;

import android.graphics.PointF;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h implements d0 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final h f13284u = new h();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final pb.c f13285v = pb.c.k("t", "f", "s", "j", "tr", "lh", "ls", "fc", "sc", "sw", "of", "ps", "sz");

    @Override // v5.d0
    public final Object a(w5.a aVar, float f) {
        PointF pointF;
        PointF pointF2;
        aVar.d();
        String strS = null;
        float fJ = 0.0f;
        float fJ2 = 0.0f;
        float fJ3 = 0.0f;
        float fJ4 = 0.0f;
        int iK = 0;
        int iA = 0;
        int iA2 = 0;
        boolean zH = true;
        int i = 3;
        String strS2 = null;
        PointF pointF3 = null;
        PointF pointF4 = null;
        while (aVar.G()) {
            switch (aVar.i0(f13285v)) {
                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                    strS = aVar.S();
                    break;
                case 1:
                    strS2 = aVar.S();
                    break;
                case 2:
                    pointF = pointF3;
                    fJ = (float) aVar.J();
                    pointF3 = pointF;
                    break;
                case 3:
                    PointF pointF5 = pointF3;
                    pointF2 = pointF4;
                    int iK2 = aVar.K();
                    i = (iK2 > 2 || iK2 < 0) ? 3 : v.e.d(3)[iK2];
                    pointF3 = pointF5;
                    pointF4 = pointF2;
                    break;
                case b1.j.LONG_FIELD_NUMBER /* 4 */:
                    iK = aVar.K();
                    break;
                case b1.j.STRING_FIELD_NUMBER /* 5 */:
                    pointF = pointF3;
                    fJ2 = (float) aVar.J();
                    pointF3 = pointF;
                    break;
                case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                    pointF = pointF3;
                    fJ3 = (float) aVar.J();
                    pointF3 = pointF;
                    break;
                case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                    iA = n.a(aVar);
                    break;
                case 8:
                    iA2 = n.a(aVar);
                    break;
                case 9:
                    pointF = pointF3;
                    fJ4 = (float) aVar.J();
                    pointF3 = pointF;
                    break;
                case 10:
                    zH = aVar.H();
                    break;
                case 11:
                    aVar.a();
                    pointF2 = pointF4;
                    PointF pointF6 = new PointF(((float) aVar.J()) * f, ((float) aVar.J()) * f);
                    aVar.v();
                    pointF3 = pointF6;
                    pointF4 = pointF2;
                    break;
                case 12:
                    aVar.a();
                    pointF = pointF3;
                    pointF4 = new PointF(((float) aVar.J()) * f, ((float) aVar.J()) * f);
                    aVar.v();
                    pointF3 = pointF;
                    break;
                default:
                    aVar.j0();
                    aVar.k0();
                    break;
            }
        }
        aVar.x();
        q5.b bVar = new q5.b();
        bVar.f10990a = strS;
        bVar.f10991b = strS2;
        bVar.f10992c = fJ;
        bVar.f10993d = i;
        bVar.f10994e = iK;
        bVar.f = fJ2;
        bVar.f10995g = fJ3;
        bVar.f10996h = iA;
        bVar.i = iA2;
        bVar.f10997j = fJ4;
        bVar.f10998k = zH;
        bVar.f10999l = pointF3;
        bVar.f11000m = pointF4;
        return bVar;
    }
}
