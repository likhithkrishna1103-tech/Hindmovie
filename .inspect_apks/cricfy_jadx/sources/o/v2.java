package o;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.appcompat.widget.SearchView;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class v2 implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f9381v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f9382w;

    public /* synthetic */ v2(int i, Object obj) {
        this.f9381v = i;
        this.f9382w = obj;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        switch (this.f9381v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                SearchView searchView = (SearchView) this.f9382w;
                SearchView.SearchAutoComplete searchAutoComplete = searchView.K;
                View view2 = searchView.S;
                if (view2.getWidth() > 1) {
                    Resources resources = searchView.getContext().getResources();
                    int paddingLeft = searchView.M.getPaddingLeft();
                    Rect rect = new Rect();
                    boolean z10 = x3.f9407a;
                    boolean z11 = searchView.getLayoutDirection() == 1;
                    int dimensionPixelSize = searchView.f566l0 ? resources.getDimensionPixelSize(g.d.abc_dropdownitem_text_padding_left) + resources.getDimensionPixelSize(g.d.abc_dropdownitem_icon_width) : 0;
                    searchAutoComplete.getDropDownBackground().getPadding(rect);
                    searchAutoComplete.setDropDownHorizontalOffset(z11 ? -rect.left : paddingLeft - (rect.left + dimensionPixelSize));
                    searchAutoComplete.setDropDownWidth((((view2.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
                    return;
                }
                return;
            default:
                throw null;
        }
    }
}
