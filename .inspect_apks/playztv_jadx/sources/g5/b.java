package g5;

import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b extends Property {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5259a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(Class cls, String str, int i) {
        super(cls, str);
        this.f5259a = i;
    }

    @Override // android.util.Property
    public final Object get(Object obj) {
        switch (this.f5259a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return null;
            case 1:
                return null;
            case 2:
                return null;
            case 3:
                return null;
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                return null;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                return Float.valueOf(z.f5317a.q((View) obj));
            default:
                return ((View) obj).getClipBounds();
        }
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        switch (this.f5259a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                e eVar = (e) obj;
                PointF pointF = (PointF) obj2;
                eVar.getClass();
                eVar.f5262a = Math.round(pointF.x);
                int iRound = Math.round(pointF.y);
                eVar.f5263b = iRound;
                int i = eVar.f + 1;
                eVar.f = i;
                if (i == eVar.f5267g) {
                    z.a(eVar.f5266e, eVar.f5262a, iRound, eVar.f5264c, eVar.f5265d);
                    eVar.f = 0;
                    eVar.f5267g = 0;
                }
                break;
            case 1:
                e eVar2 = (e) obj;
                PointF pointF2 = (PointF) obj2;
                eVar2.getClass();
                eVar2.f5264c = Math.round(pointF2.x);
                int iRound2 = Math.round(pointF2.y);
                eVar2.f5265d = iRound2;
                int i10 = eVar2.f5267g + 1;
                eVar2.f5267g = i10;
                if (eVar2.f == i10) {
                    z.a(eVar2.f5266e, eVar2.f5262a, eVar2.f5263b, eVar2.f5264c, iRound2);
                    eVar2.f = 0;
                    eVar2.f5267g = 0;
                }
                break;
            case 2:
                View view = (View) obj;
                PointF pointF3 = (PointF) obj2;
                z.a(view, view.getLeft(), view.getTop(), Math.round(pointF3.x), Math.round(pointF3.y));
                break;
            case 3:
                View view2 = (View) obj;
                PointF pointF4 = (PointF) obj2;
                z.a(view2, Math.round(pointF4.x), Math.round(pointF4.y), view2.getRight(), view2.getBottom());
                break;
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                View view3 = (View) obj;
                PointF pointF5 = (PointF) obj2;
                int iRound3 = Math.round(pointF5.x);
                int iRound4 = Math.round(pointF5.y);
                z.a(view3, iRound3, iRound4, view3.getWidth() + iRound3, view3.getHeight() + iRound4);
                break;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                float fFloatValue = ((Float) obj2).floatValue();
                z.f5317a.x((View) obj, fFloatValue);
                break;
            default:
                ((View) obj).setClipBounds((Rect) obj2);
                break;
        }
    }
}
