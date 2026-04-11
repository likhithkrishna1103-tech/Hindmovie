package o5;

import android.graphics.PointF;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f extends k {
    public final /* synthetic */ int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(int i, List list) {
        super(list);
        this.i = i;
    }

    @Override // o5.e
    public final Object f(y5.a aVar, float f) {
        Object obj;
        switch (this.i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return Integer.valueOf(k(aVar, f));
            case 1:
                return Integer.valueOf(k(aVar, f));
            default:
                Object obj2 = aVar.f14522b;
                p2.c cVar = this.f9379e;
                if (cVar == null) {
                    return (f != 1.0f || (obj = aVar.f14523c) == null) ? (q5.b) obj2 : (q5.b) obj;
                }
                float f4 = aVar.f14526g;
                Float f10 = aVar.f14527h;
                float fFloatValue = f10 == null ? Float.MAX_VALUE : f10.floatValue();
                q5.b bVar = (q5.b) obj2;
                Object obj3 = aVar.f14523c;
                return (q5.b) cVar.n(f4, fFloatValue, bVar, obj3 == null ? bVar : (q5.b) obj3, f, c(), this.f9378d);
        }
    }

    public int k(y5.a aVar, float f) {
        Float f4;
        Integer num;
        float f10;
        switch (this.i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Object obj = aVar.f14522b;
                Object obj2 = aVar.f14522b;
                if (obj == null || aVar.f14523c == null) {
                    throw new IllegalStateException("Missing values for keyframe.");
                }
                p2.c cVar = this.f9379e;
                return (cVar == null || (f4 = aVar.f14527h) == null || (num = (Integer) cVar.n(aVar.f14526g, f4.floatValue(), (Integer) obj2, (Integer) aVar.f14523c, f, d(), this.f9378d)) == null) ? com.bumptech.glide.d.k(x5.f.b(f, 0.0f, 1.0f), ((Integer) obj2).intValue(), ((Integer) aVar.f14523c).intValue()) : num.intValue();
            default:
                Object obj3 = aVar.f14522b;
                Object obj4 = aVar.f14522b;
                if (obj3 == null || aVar.f14523c == null) {
                    throw new IllegalStateException("Missing values for keyframe.");
                }
                p2.c cVar2 = this.f9379e;
                if (cVar2 != null) {
                    f10 = f;
                    Integer num2 = (Integer) cVar2.n(aVar.f14526g, aVar.f14527h.floatValue(), (Integer) obj4, (Integer) aVar.f14523c, f10, d(), this.f9378d);
                    if (num2 != null) {
                        return num2.intValue();
                    }
                } else {
                    f10 = f;
                }
                if (aVar.f14529k == 784923401) {
                    aVar.f14529k = ((Integer) obj4).intValue();
                }
                int i = aVar.f14529k;
                if (aVar.f14530l == 784923401) {
                    aVar.f14530l = ((Integer) aVar.f14523c).intValue();
                }
                int i10 = aVar.f14530l;
                PointF pointF = x5.f.f14266a;
                return (int) ((f10 * (i10 - i)) + i);
        }
    }
}
