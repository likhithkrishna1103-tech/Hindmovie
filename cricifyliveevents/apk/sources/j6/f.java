package j6;

import android.graphics.PointF;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.internal.measurement.z3;
import java.util.List;
import nb.w;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends k {
    public final /* synthetic */ int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(int i, List list) {
        super(list);
        this.i = i;
    }

    @Override // j6.e
    public final Object f(t6.a aVar, float f) {
        int i;
        int iIntValue;
        Integer num;
        Object obj;
        switch (this.i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return Integer.valueOf(l(aVar, f));
            case 1:
                Object obj2 = aVar.f11932b;
                if (obj2 == null) {
                    throw new IllegalStateException("Missing values for keyframe.");
                }
                Object obj3 = aVar.f11933c;
                if (obj3 == null) {
                    if (aVar.f11939k == 784923401) {
                        aVar.f11939k = ((Integer) obj2).intValue();
                    }
                    i = aVar.f11939k;
                } else {
                    if (aVar.f11940l == 784923401) {
                        aVar.f11940l = ((Integer) obj3).intValue();
                    }
                    i = aVar.f11940l;
                }
                int i10 = i;
                w wVar = this.f6634e;
                if (wVar == null || (num = (Integer) wVar.G(aVar.f11936g, aVar.f11937h.floatValue(), (Integer) obj2, Integer.valueOf(i10), f, d(), this.f6633d)) == null) {
                    if (aVar.f11939k == 784923401) {
                        aVar.f11939k = ((Integer) obj2).intValue();
                    }
                    int i11 = aVar.f11939k;
                    PointF pointF = s6.g.f11558a;
                    iIntValue = (int) (((i10 - i11) * f) + i11);
                } else {
                    iIntValue = num.intValue();
                }
                return Integer.valueOf(iIntValue);
            default:
                Object obj4 = aVar.f11932b;
                w wVar2 = this.f6634e;
                if (wVar2 == null) {
                    return (f != 1.0f || (obj = aVar.f11933c) == null) ? (l6.b) obj4 : (l6.b) obj;
                }
                float f10 = aVar.f11936g;
                Float f11 = aVar.f11937h;
                float fFloatValue = f11 == null ? Float.MAX_VALUE : f11.floatValue();
                l6.b bVar = (l6.b) obj4;
                Object obj5 = aVar.f11933c;
                return (l6.b) wVar2.G(f10, fFloatValue, bVar, obj5 == null ? bVar : (l6.b) obj5, f, c(), this.f6633d);
        }
    }

    public int l(t6.a aVar, float f) {
        float f10;
        Float f11;
        Object obj = aVar.f11932b;
        Object obj2 = aVar.f11932b;
        if (obj == null || aVar.f11933c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        w wVar = this.f6634e;
        if (wVar == null || (f11 = aVar.f11937h) == null) {
            f10 = f;
        } else {
            f10 = f;
            Integer num = (Integer) wVar.G(aVar.f11936g, f11.floatValue(), (Integer) obj2, (Integer) aVar.f11933c, f10, d(), this.f6633d);
            if (num != null) {
                return num.intValue();
            }
        }
        return z3.k(s6.g.b(f10, 0.0f, 1.0f), ((Integer) obj2).intValue(), ((Integer) aVar.f11933c).intValue());
    }
}
