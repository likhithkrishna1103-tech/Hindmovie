package o;

import android.content.Context;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends w implements l {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ k f9241y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(k kVar, Context context) {
        super(context, null, g.a.actionOverflowButtonStyle);
        this.f9241y = kVar;
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
        w4.v.t(this, getContentDescription());
        setOnTouchListener(new n.b(this, this));
    }

    @Override // o.l
    public final boolean b() {
        return false;
    }

    @Override // o.l
    public final boolean c() {
        return false;
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (super.performClick()) {
            return true;
        }
        playSoundEffect(0);
        this.f9241y.n();
        return true;
    }

    @Override // android.widget.ImageView
    public final boolean setFrame(int i, int i10, int i11, int i12) {
        boolean frame = super.setFrame(i, i10, i11, i12);
        Drawable drawable = getDrawable();
        Drawable background = getBackground();
        if (drawable != null && background != null) {
            int width = getWidth();
            int height = getHeight();
            int iMax = Math.max(width, height) / 2;
            int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
            int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
            background.setHotspotBounds(paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
        }
        return frame;
    }
}
