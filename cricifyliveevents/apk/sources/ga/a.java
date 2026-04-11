package ga;

import android.R;
import android.content.res.ColorStateList;
import com.bumptech.glide.f;
import k9.b;
import k9.k;
import o.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends a0 {
    public static final int B = k.Widget_MaterialComponents_CompoundButton_RadioButton;
    public static final int[][] C = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};
    public boolean A;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ColorStateList f5234z;

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f5234z == null) {
            int iN = f.n(this, g.a.colorControlActivated);
            int iN2 = f.n(this, b.colorOnSurface);
            int iN3 = f.n(this, b.colorSurface);
            this.f5234z = new ColorStateList(C, new int[]{f.D(1.0f, iN3, iN), f.D(0.54f, iN3, iN2), f.D(0.38f, iN3, iN2), f.D(0.38f, iN3, iN2)});
        }
        return this.f5234z;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.A && getButtonTintList() == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z10) {
        this.A = z10;
        if (z10) {
            setButtonTintList(getMaterialThemeColorsTintList());
        } else {
            setButtonTintList(null);
        }
    }
}
