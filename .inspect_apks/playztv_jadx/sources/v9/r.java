package v9;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.WeakHashMap;
import q0.o0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r extends ArrayAdapter {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ColorStateList f13410u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ColorStateList f13411v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ s f13412w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(s sVar, Context context, int i, String[] strArr) {
        super(context, i, strArr);
        this.f13412w = sVar;
        a();
    }

    public final void a() {
        ColorStateList colorStateList;
        s sVar = this.f13412w;
        ColorStateList colorStateList2 = sVar.F;
        ColorStateList colorStateList3 = null;
        if (colorStateList2 != null) {
            int[] iArr = {R.attr.state_pressed};
            colorStateList = new ColorStateList(new int[][]{iArr, new int[0]}, new int[]{colorStateList2.getColorForState(iArr, 0), 0});
        } else {
            colorStateList = null;
        }
        this.f13411v = colorStateList;
        if (sVar.E != 0 && sVar.F != null) {
            int[] iArr2 = {R.attr.state_hovered, -16842919};
            int[] iArr3 = {R.attr.state_selected, -16842919};
            colorStateList3 = new ColorStateList(new int[][]{iArr3, iArr2, new int[0]}, new int[]{i0.b.b(sVar.F.getColorForState(iArr3, 0), sVar.E), i0.b.b(sVar.F.getColorForState(iArr2, 0), sVar.E), sVar.E});
        }
        this.f13410u = colorStateList3;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (view2 instanceof TextView) {
            TextView textView = (TextView) view2;
            s sVar = this.f13412w;
            Drawable rippleDrawable = null;
            if (sVar.getText().toString().contentEquals(textView.getText()) && sVar.E != 0) {
                ColorDrawable colorDrawable = new ColorDrawable(sVar.E);
                if (this.f13411v != null) {
                    colorDrawable.setTintList(this.f13410u);
                    rippleDrawable = new RippleDrawable(this.f13411v, colorDrawable, null);
                } else {
                    rippleDrawable = colorDrawable;
                }
            }
            WeakHashMap weakHashMap = o0.f10475a;
            textView.setBackground(rippleDrawable);
        }
        return view2;
    }
}
