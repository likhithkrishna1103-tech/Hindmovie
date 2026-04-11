package l9;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.SearchView;
import androidx.media3.decoder.DecoderInputBuffer;
import n.u3;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f8021u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Object f8022v;

    public /* synthetic */ b(int i, Object obj) {
        this.f8021u = i;
        this.f8022v = obj;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        s8.a aVar;
        int i17 = this.f8021u;
        Object obj = this.f8022v;
        switch (i17) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                v8.a aVar2 = (v8.a) obj;
                ImageView imageView = aVar2.H;
                if (imageView.getVisibility() != 0 || (aVar = aVar2.f8030c0) == null) {
                    return;
                }
                Rect rect = new Rect();
                imageView.getDrawingRect(rect);
                aVar.setBounds(rect);
                aVar.i(imageView, null);
                return;
            case 1:
                SearchView searchView = (SearchView) obj;
                SearchView.SearchAutoComplete searchAutoComplete = searchView.J;
                View view2 = searchView.R;
                if (view2.getWidth() > 1) {
                    Resources resources = searchView.getContext().getResources();
                    int paddingLeft = searchView.L.getPaddingLeft();
                    Rect rect2 = new Rect();
                    boolean z2 = u3.f8547a;
                    boolean z10 = searchView.getLayoutDirection() == 1;
                    int dimensionPixelSize = searchView.f909k0 ? resources.getDimensionPixelSize(g.d.abc_dropdownitem_text_padding_left) + resources.getDimensionPixelSize(g.d.abc_dropdownitem_icon_width) : 0;
                    searchAutoComplete.getDropDownBackground().getPadding(rect2);
                    searchAutoComplete.setDropDownHorizontalOffset(z10 ? -rect2.left : paddingLeft - (rect2.left + dimensionPixelSize));
                    searchAutoComplete.setDropDownWidth((((view2.getWidth() + rect2.left) + rect2.right) + dimensionPixelSize) - paddingLeft);
                    return;
                }
                return;
            default:
                throw null;
        }
    }
}
