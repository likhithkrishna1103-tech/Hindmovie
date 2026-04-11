package m9;

import android.R;
import android.content.res.ColorStateList;
import n.c0;
import p8.b;
import p8.k;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a extends c0 {
    public static final int A = k.Widget_MaterialComponents_CompoundButton_RadioButton;
    public static final int[][] B = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ColorStateList f8311y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f8312z;

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f8311y == null) {
            int iM = z7.a.m(this, b.colorControlActivated);
            int iM2 = z7.a.m(this, b.colorOnSurface);
            int iM3 = z7.a.m(this, b.colorSurface);
            this.f8311y = new ColorStateList(B, new int[]{z7.a.r(1.0f, iM3, iM), z7.a.r(0.54f, iM3, iM2), z7.a.r(0.38f, iM3, iM2), z7.a.r(0.38f, iM3, iM2)});
        }
        return this.f8311y;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f8312z && getButtonTintList() == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z2) {
        this.f8312z = z2;
        if (z2) {
            setButtonTintList(getMaterialThemeColorsTintList());
        } else {
            setButtonTintList(null);
        }
    }
}
