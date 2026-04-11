package pa;

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

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class u extends ArrayAdapter {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ColorStateList f10128v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ColorStateList f10129w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ v f10130x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(v vVar, Context context, int i, String[] strArr) {
        super(context, i, strArr);
        this.f10130x = vVar;
        a();
    }

    public final void a() {
        ColorStateList colorStateList;
        v vVar = this.f10130x;
        ColorStateList colorStateList2 = vVar.G;
        ColorStateList colorStateList3 = null;
        if (colorStateList2 != null) {
            int[] iArr = {R.attr.state_pressed};
            colorStateList = new ColorStateList(new int[][]{iArr, new int[0]}, new int[]{colorStateList2.getColorForState(iArr, 0), 0});
        } else {
            colorStateList = null;
        }
        this.f10129w = colorStateList;
        if (vVar.F != 0 && vVar.G != null) {
            int[] iArr2 = {R.attr.state_hovered, -16842919};
            int[] iArr3 = {R.attr.state_selected, -16842919};
            colorStateList3 = new ColorStateList(new int[][]{iArr3, iArr2, new int[0]}, new int[]{l0.b.b(vVar.G.getColorForState(iArr3, 0), vVar.F), l0.b.b(vVar.G.getColorForState(iArr2, 0), vVar.F), vVar.F});
        }
        this.f10128v = colorStateList3;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (view2 instanceof TextView) {
            TextView textView = (TextView) view2;
            v vVar = this.f10130x;
            Drawable rippleDrawable = null;
            if (vVar.getText().toString().contentEquals(textView.getText()) && vVar.F != 0) {
                ColorDrawable colorDrawable = new ColorDrawable(vVar.F);
                if (this.f10129w != null) {
                    colorDrawable.setTintList(this.f10128v);
                    rippleDrawable = new RippleDrawable(this.f10129w, colorDrawable, null);
                } else {
                    rippleDrawable = colorDrawable;
                }
            }
            textView.setBackground(rippleDrawable);
        }
        return view2;
    }
}
