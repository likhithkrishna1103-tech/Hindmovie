package j6;

import android.graphics.PointF;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.internal.measurement.z3;
import java.util.List;
import nb.w;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends k {
    public final /* synthetic */ int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Object f6645j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(int i, List list) {
        super(list);
        this.i = i;
        switch (i) {
            case 1:
                super(list);
                this.f6645j = new PointF();
                break;
            case 2:
                super(list);
                this.f6645j = new t6.b();
                break;
            default:
                int iMax = 0;
                for (int i10 = 0; i10 < list.size(); i10++) {
                    n6.c cVar = (n6.c) ((t6.a) list.get(i10)).f11932b;
                    if (cVar != null) {
                        iMax = Math.max(iMax, cVar.f8780b.length);
                    }
                }
                this.f6645j = new n6.c(new float[iMax], new int[iMax]);
                break;
        }
    }

    @Override // j6.e
    public final Object f(t6.a aVar, float f) {
        Object obj;
        float f10;
        switch (this.i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                n6.c cVar = (n6.c) this.f6645j;
                n6.c cVar2 = (n6.c) aVar.f11932b;
                n6.c cVar3 = (n6.c) aVar.f11933c;
                int[] iArr = cVar.f8780b;
                float[] fArr = cVar.f8779a;
                boolean zEquals = cVar2.equals(cVar3);
                int[] iArr2 = cVar2.f8780b;
                if (zEquals || f <= 0.0f) {
                    cVar.a(cVar2);
                } else if (f >= 1.0f) {
                    cVar.a(cVar3);
                } else {
                    int length = iArr2.length;
                    int[] iArr3 = cVar3.f8780b;
                    if (length != iArr3.length) {
                        StringBuilder sb = new StringBuilder("Cannot interpolate between gradients. Lengths vary (");
                        sb.append(iArr2.length);
                        sb.append(" vs ");
                        throw new IllegalArgumentException(q4.a.o(sb, iArr3.length, ")"));
                    }
                    for (int i = 0; i < iArr2.length; i++) {
                        fArr[i] = s6.g.f(cVar2.f8779a[i], cVar3.f8779a[i], f);
                        iArr[i] = z3.k(f, iArr2[i], iArr3[i]);
                    }
                    for (int length2 = iArr2.length; length2 < fArr.length; length2++) {
                        fArr[length2] = fArr[iArr2.length - 1];
                        iArr[length2] = iArr[iArr2.length - 1];
                    }
                }
                return cVar;
            case 1:
                return l(aVar, f, f, f);
            default:
                t6.b bVar = (t6.b) this.f6645j;
                Object obj2 = aVar.f11932b;
                if (obj2 == null || (obj = aVar.f11933c) == null) {
                    throw new IllegalStateException("Missing values for keyframe.");
                }
                t6.b bVar2 = (t6.b) obj2;
                t6.b bVar3 = (t6.b) obj;
                w wVar = this.f6634e;
                if (wVar != null) {
                    f10 = f;
                    t6.b bVar4 = (t6.b) wVar.G(aVar.f11936g, aVar.f11937h.floatValue(), bVar2, bVar3, f10, d(), this.f6633d);
                    if (bVar4 != null) {
                        return bVar4;
                    }
                } else {
                    f10 = f;
                }
                float f11 = s6.g.f(bVar2.f11945a, bVar3.f11945a, f10);
                float f12 = s6.g.f(bVar2.f11946b, bVar3.f11946b, f10);
                bVar.f11945a = f11;
                bVar.f11946b = f12;
                return bVar;
        }
    }

    @Override // j6.e
    public /* bridge */ /* synthetic */ Object g(t6.a aVar, float f, float f10, float f11) {
        switch (this.i) {
            case 1:
                return l(aVar, f, f10, f11);
            default:
                return super.g(aVar, f, f10, f11);
        }
    }

    public PointF l(t6.a aVar, float f, float f10, float f11) {
        Object obj;
        PointF pointF;
        PointF pointF2 = (PointF) this.f6645j;
        Object obj2 = aVar.f11932b;
        if (obj2 == null || (obj = aVar.f11933c) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF3 = (PointF) obj2;
        PointF pointF4 = (PointF) obj;
        w wVar = this.f6634e;
        if (wVar != null && (pointF = (PointF) wVar.G(aVar.f11936g, aVar.f11937h.floatValue(), pointF3, pointF4, f, d(), this.f6633d)) != null) {
            return pointF;
        }
        float f12 = pointF3.x;
        float fH = q4.a.h(pointF4.x, f12, f10, f12);
        float f13 = pointF3.y;
        pointF2.set(fH, q4.a.h(pointF4.y, f13, f11, f13));
        return pointF2;
    }
}
