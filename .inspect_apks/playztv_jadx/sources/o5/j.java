package o5;

import android.graphics.PointF;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j extends k {
    public final /* synthetic */ int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Object f9389j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(int i, List list) {
        super(list);
        this.i = i;
        switch (i) {
            case 1:
                super(list);
                this.f9389j = new PointF();
                break;
            case 2:
                super(list);
                this.f9389j = new y5.b();
                break;
            default:
                int iMax = 0;
                for (int i10 = 0; i10 < list.size(); i10++) {
                    s5.c cVar = (s5.c) ((y5.a) list.get(i10)).f14522b;
                    if (cVar != null) {
                        iMax = Math.max(iMax, cVar.f11796b.length);
                    }
                }
                this.f9389j = new s5.c(new float[iMax], new int[iMax]);
                break;
        }
    }

    @Override // o5.e
    public final Object f(y5.a aVar, float f) {
        Object obj;
        float f4;
        switch (this.i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                s5.c cVar = (s5.c) this.f9389j;
                s5.c cVar2 = (s5.c) aVar.f14522b;
                s5.c cVar3 = (s5.c) aVar.f14523c;
                int[] iArr = cVar.f11796b;
                float[] fArr = cVar.f11795a;
                boolean zEquals = cVar2.equals(cVar3);
                int[] iArr2 = cVar2.f11796b;
                if (zEquals || f <= 0.0f) {
                    cVar.a(cVar2);
                } else if (f >= 1.0f) {
                    cVar.a(cVar3);
                } else {
                    int length = iArr2.length;
                    int[] iArr3 = cVar3.f11796b;
                    if (length != iArr3.length) {
                        StringBuilder sb2 = new StringBuilder("Cannot interpolate between gradients. Lengths vary (");
                        sb2.append(iArr2.length);
                        sb2.append(" vs ");
                        throw new IllegalArgumentException(x.c.a(sb2, iArr3.length, ")"));
                    }
                    for (int i = 0; i < iArr2.length; i++) {
                        fArr[i] = x5.f.e(cVar2.f11795a[i], cVar3.f11795a[i], f);
                        iArr[i] = com.bumptech.glide.d.k(f, iArr2[i], iArr3[i]);
                    }
                    for (int length2 = iArr2.length; length2 < fArr.length; length2++) {
                        fArr[length2] = fArr[iArr2.length - 1];
                        iArr[length2] = iArr[iArr2.length - 1];
                    }
                }
                return cVar;
            case 1:
                return k(aVar, f, f, f);
            default:
                y5.b bVar = (y5.b) this.f9389j;
                Object obj2 = aVar.f14522b;
                if (obj2 == null || (obj = aVar.f14523c) == null) {
                    throw new IllegalStateException("Missing values for keyframe.");
                }
                y5.b bVar2 = (y5.b) obj2;
                y5.b bVar3 = (y5.b) obj;
                p2.c cVar4 = this.f9379e;
                if (cVar4 != null) {
                    f4 = f;
                    y5.b bVar4 = (y5.b) cVar4.n(aVar.f14526g, aVar.f14527h.floatValue(), bVar2, bVar3, f4, d(), this.f9378d);
                    if (bVar4 != null) {
                        return bVar4;
                    }
                } else {
                    f4 = f;
                }
                float fE = x5.f.e(bVar2.f14535a, bVar3.f14535a, f4);
                float fE2 = x5.f.e(bVar2.f14536b, bVar3.f14536b, f4);
                bVar.f14535a = fE;
                bVar.f14536b = fE2;
                return bVar;
        }
    }

    @Override // o5.e
    public /* bridge */ /* synthetic */ Object g(y5.a aVar, float f, float f4, float f10) {
        switch (this.i) {
            case 1:
                return k(aVar, f, f4, f10);
            default:
                return super.g(aVar, f, f4, f10);
        }
    }

    public PointF k(y5.a aVar, float f, float f4, float f10) {
        Object obj;
        PointF pointF;
        PointF pointF2 = (PointF) this.f9389j;
        Object obj2 = aVar.f14522b;
        if (obj2 == null || (obj = aVar.f14523c) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF3 = (PointF) obj2;
        PointF pointF4 = (PointF) obj;
        p2.c cVar = this.f9379e;
        if (cVar != null && (pointF = (PointF) cVar.n(aVar.f14526g, aVar.f14527h.floatValue(), pointF3, pointF4, f, d(), this.f9378d)) != null) {
            return pointF;
        }
        float f11 = pointF3.x;
        float fG = e6.j.g(pointF4.x, f11, f4, f11);
        float f12 = pointF3.y;
        pointF2.set(fG, e6.j.g(pointF4.y, f12, f10, f12));
        return pointF2;
    }
}
