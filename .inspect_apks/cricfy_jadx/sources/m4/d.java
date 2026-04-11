package m4;

import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.carousel.CarouselLayoutManager;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f8168v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f8169w;

    public /* synthetic */ d(int i, Object obj) {
        this.f8168v = i;
        this.f8169w = obj;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        int height;
        int height2;
        switch (this.f8168v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                q qVar = (q) this.f8169w;
                int i17 = qVar.G;
                PopupWindow popupWindow = qVar.F;
                int i18 = i12 - i10;
                int i19 = i16 - i14;
                if ((i11 - i != i15 - i13 || i18 != i19) && popupWindow.isShowing()) {
                    qVar.q();
                    popupWindow.update(view, (qVar.getWidth() - popupWindow.getWidth()) - i17, (-popupWindow.getHeight()) - i17, -1, -1);
                }
                break;
            case 1:
                v vVar = (v) this.f8169w;
                q qVar2 = vVar.f8269a;
                int width = (qVar2.getWidth() - qVar2.getPaddingLeft()) - qVar2.getPaddingRight();
                int height3 = (qVar2.getHeight() - qVar2.getPaddingBottom()) - qVar2.getPaddingTop();
                ViewGroup viewGroup = vVar.f8271c;
                int iC = v.c(viewGroup) - (viewGroup != null ? viewGroup.getPaddingRight() + viewGroup.getPaddingLeft() : 0);
                if (viewGroup == null) {
                    height = 0;
                } else {
                    height = viewGroup.getHeight();
                    ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        height += marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                    }
                }
                int paddingBottom = height - (viewGroup != null ? viewGroup.getPaddingBottom() + viewGroup.getPaddingTop() : 0);
                int iMax = Math.max(iC, v.c(vVar.f8277k) + v.c(vVar.i));
                ViewGroup viewGroup2 = vVar.f8272d;
                if (viewGroup2 == null) {
                    height2 = 0;
                } else {
                    height2 = viewGroup2.getHeight();
                    ViewGroup.LayoutParams layoutParams2 = viewGroup2.getLayoutParams();
                    if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                        height2 += marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin;
                    }
                }
                boolean z10 = width <= iMax || height3 <= (height2 * 2) + paddingBottom;
                if (vVar.A != z10) {
                    vVar.A = z10;
                    view.post(new r(vVar, 1));
                }
                boolean z11 = i11 - i != i15 - i13;
                if (!vVar.A && z11) {
                    view.post(new r(vVar, 2));
                    break;
                }
                break;
            default:
                CarouselLayoutManager carouselLayoutManager = (CarouselLayoutManager) this.f8169w;
                if (i11 - i != i15 - i13 || i12 - i10 != i16 - i14) {
                    view.post(new pa.c(9, carouselLayoutManager));
                }
                break;
        }
    }
}
