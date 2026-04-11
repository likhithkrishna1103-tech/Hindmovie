package m5;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import qb.t1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends f implements Animatable {
    public static final /* synthetic */ int B = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Context f8317x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ba.f f8318y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ArrayList f8319z = null;
    public final j.f A = new j.f(this);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final c f8316w = new c();

    public d(Context context, int i) {
        this.f8317x = context;
    }

    @Override // m5.f, android.graphics.drawable.Drawable
    public final void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f8321v;
        if (drawable != null) {
            drawable.applyTheme(theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        Drawable drawable = this.f8321v;
        if (drawable != null) {
            return drawable.canApplyTheme();
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Drawable drawable = this.f8321v;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        c cVar = this.f8316w;
        cVar.f8312a.draw(canvas);
        if (cVar.f8313b.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        Drawable drawable = this.f8321v;
        return drawable != null ? drawable.getAlpha() : this.f8316w.f8312a.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        Drawable drawable = this.f8321v;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        int changingConfigurations = super.getChangingConfigurations();
        this.f8316w.getClass();
        return changingConfigurations;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        Drawable drawable = this.f8321v;
        return drawable != null ? drawable.getColorFilter() : this.f8316w.f8312a.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.f8321v == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new ba.a(2, this.f8321v.getConstantState());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable drawable = this.f8321v;
        return drawable != null ? drawable.getIntrinsicHeight() : this.f8316w.f8312a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable drawable = this.f8321v;
        return drawable != null ? drawable.getIntrinsicWidth() : this.f8316w.f8312a.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.f8321v;
        return drawable != null ? drawable.getOpacity() : this.f8316w.f8312a.getOpacity();
    }

    /* JADX WARN: Code restructure failed: missing block: B:85:0x0182, code lost:
    
        if (r8.f8313b != null) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0184, code lost:
    
        r8.f8313b = new android.animation.AnimatorSet();
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x018b, code lost:
    
        r8.f8313b.playTogether(r8.f8314c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0192, code lost:
    
        return;
     */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void inflate(android.content.res.Resources r22, org.xmlpull.v1.XmlPullParser r23, android.util.AttributeSet r24, android.content.res.Resources.Theme r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 403
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m5.d.inflate(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):void");
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        Drawable drawable = this.f8321v;
        return drawable != null ? drawable.isAutoMirrored() : this.f8316w.f8312a.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        Drawable drawable = this.f8321v;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.f8316w.f8313b.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        Drawable drawable = this.f8321v;
        return drawable != null ? drawable.isStateful() : this.f8316w.f8312a.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable drawable = this.f8321v;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f8321v;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f8316w.f8312a.setBounds(rect);
        }
    }

    @Override // m5.f, android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i) {
        Drawable drawable = this.f8321v;
        return drawable != null ? drawable.setLevel(i) : this.f8316w.f8312a.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f8321v;
        return drawable != null ? drawable.setState(iArr) : this.f8316w.f8312a.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        Drawable drawable = this.f8321v;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else {
            this.f8316w.f8312a.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z10) {
        Drawable drawable = this.f8321v;
        if (drawable != null) {
            drawable.setAutoMirrored(z10);
        } else {
            this.f8316w.f8312a.setAutoMirrored(z10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f8321v;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f8316w.f8312a.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i) {
        Drawable drawable = this.f8321v;
        if (drawable != null) {
            t1.n(drawable, i);
        } else {
            this.f8316w.f8312a.setTint(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f8321v;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
        } else {
            this.f8316w.f8312a.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f8321v;
        if (drawable != null) {
            drawable.setTintMode(mode);
        } else {
            this.f8316w.f8312a.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z10, boolean z11) {
        Drawable drawable = this.f8321v;
        if (drawable != null) {
            return drawable.setVisible(z10, z11);
        }
        this.f8316w.f8312a.setVisible(z10, z11);
        return super.setVisible(z10, z11);
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        Drawable drawable = this.f8321v;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
            return;
        }
        c cVar = this.f8316w;
        if (cVar.f8313b.isStarted()) {
            return;
        }
        cVar.f8313b.start();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        Drawable drawable = this.f8321v;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f8316w.f8313b.end();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws Throwable {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
