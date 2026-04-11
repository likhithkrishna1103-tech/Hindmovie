package l5;

import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import androidx.appcompat.widget.SwitchCompat;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends Property {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7779a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(Class cls, String str, int i) {
        super(cls, str);
        this.f7779a = i;
    }

    @Override // android.util.Property
    public final Object get(Object obj) {
        switch (this.f7779a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return null;
            case 1:
                return null;
            case 2:
                return null;
            case 3:
                return null;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                return null;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                return Float.valueOf(x.f7832a.z((View) obj));
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                return ((View) obj).getClipBounds();
            default:
                return Float.valueOf(((SwitchCompat) obj).U);
        }
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        switch (this.f7779a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                e eVar = (e) obj;
                PointF pointF = (PointF) obj2;
                eVar.getClass();
                eVar.f7785a = Math.round(pointF.x);
                int iRound = Math.round(pointF.y);
                eVar.f7786b = iRound;
                int i = eVar.f + 1;
                eVar.f = i;
                if (i == eVar.f7790g) {
                    x.a(eVar.f7789e, eVar.f7785a, iRound, eVar.f7787c, eVar.f7788d);
                    eVar.f = 0;
                    eVar.f7790g = 0;
                }
                break;
            case 1:
                e eVar2 = (e) obj;
                PointF pointF2 = (PointF) obj2;
                eVar2.getClass();
                eVar2.f7787c = Math.round(pointF2.x);
                int iRound2 = Math.round(pointF2.y);
                eVar2.f7788d = iRound2;
                int i10 = eVar2.f7790g + 1;
                eVar2.f7790g = i10;
                if (eVar2.f == i10) {
                    x.a(eVar2.f7789e, eVar2.f7785a, eVar2.f7786b, eVar2.f7787c, iRound2);
                    eVar2.f = 0;
                    eVar2.f7790g = 0;
                }
                break;
            case 2:
                View view = (View) obj;
                PointF pointF3 = (PointF) obj2;
                x.a(view, view.getLeft(), view.getTop(), Math.round(pointF3.x), Math.round(pointF3.y));
                break;
            case 3:
                View view2 = (View) obj;
                PointF pointF4 = (PointF) obj2;
                x.a(view2, Math.round(pointF4.x), Math.round(pointF4.y), view2.getRight(), view2.getBottom());
                break;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                View view3 = (View) obj;
                PointF pointF5 = (PointF) obj2;
                int iRound3 = Math.round(pointF5.x);
                int iRound4 = Math.round(pointF5.y);
                x.a(view3, iRound3, iRound4, view3.getWidth() + iRound3, view3.getHeight() + iRound4);
                break;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                float fFloatValue = ((Float) obj2).floatValue();
                x.f7832a.L((View) obj, fFloatValue);
                break;
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                ((View) obj).setClipBounds((Rect) obj2);
                break;
            default:
                ((SwitchCompat) obj).setThumbPosition(((Float) obj2).floatValue());
                break;
        }
    }
}
