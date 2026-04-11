package i4;

import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.carousel.CarouselLayoutManager;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f6221u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Object f6222v;

    public /* synthetic */ f(int i, Object obj) {
        this.f6221u = i;
        this.f6222v = obj;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        int height;
        int height2;
        switch (this.f6221u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                s sVar = (s) this.f6222v;
                int i17 = sVar.F;
                PopupWindow popupWindow = sVar.E;
                int i18 = i12 - i10;
                int i19 = i16 - i14;
                if ((i11 - i != i15 - i13 || i18 != i19) && popupWindow.isShowing()) {
                    sVar.q();
                    popupWindow.update(view, (sVar.getWidth() - popupWindow.getWidth()) - i17, (-popupWindow.getHeight()) - i17, -1, -1);
                }
                break;
            case 1:
                x xVar = (x) this.f6222v;
                s sVar2 = xVar.f6325a;
                int width = (sVar2.getWidth() - sVar2.getPaddingLeft()) - sVar2.getPaddingRight();
                int height3 = (sVar2.getHeight() - sVar2.getPaddingBottom()) - sVar2.getPaddingTop();
                ViewGroup viewGroup = xVar.f6327c;
                int iC = x.c(viewGroup) - (viewGroup != null ? viewGroup.getPaddingRight() + viewGroup.getPaddingLeft() : 0);
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
                int iMax = Math.max(iC, x.c(xVar.f6333k) + x.c(xVar.i));
                ViewGroup viewGroup2 = xVar.f6328d;
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
                boolean z2 = width <= iMax || height3 <= (height2 * 2) + paddingBottom;
                if (xVar.A != z2) {
                    xVar.A = z2;
                    view.post(new t(xVar, 1));
                }
                boolean z10 = i11 - i != i15 - i13;
                if (!xVar.A && z10) {
                    view.post(new t(xVar, 2));
                    break;
                }
                break;
            default:
                CarouselLayoutManager carouselLayoutManager = (CarouselLayoutManager) this.f6222v;
                if (i != i13 || i10 != i14 || i11 != i15 || i12 != i16) {
                    view.post(new nc.b(15, carouselLayoutManager));
                }
                break;
        }
    }
}
