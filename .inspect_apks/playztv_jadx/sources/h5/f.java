package h5;

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

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f extends i implements Animatable {
    public static final /* synthetic */ int A = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Context f5888w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public g5.l f5889x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ArrayList f5890y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final c f5891z = new c(this);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final d f5887v = new d();

    public f(Context context, int i) {
        this.f5888w = context;
    }

    @Override // h5.i, android.graphics.drawable.Drawable
    public final void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f5895u;
        if (drawable != null) {
            drawable.applyTheme(theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        Drawable drawable = this.f5895u;
        if (drawable != null) {
            return drawable.canApplyTheme();
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Drawable drawable = this.f5895u;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        d dVar = this.f5887v;
        dVar.f5881a.draw(canvas);
        if (dVar.f5882b.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        Drawable drawable = this.f5895u;
        return drawable != null ? drawable.getAlpha() : this.f5887v.f5881a.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        Drawable drawable = this.f5895u;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        int changingConfigurations = super.getChangingConfigurations();
        this.f5887v.getClass();
        return changingConfigurations;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        Drawable drawable = this.f5895u;
        return drawable != null ? drawable.getColorFilter() : this.f5887v.f5881a.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.f5895u == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new e(0, this.f5895u.getConstantState());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable drawable = this.f5895u;
        return drawable != null ? drawable.getIntrinsicHeight() : this.f5887v.f5881a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable drawable = this.f5895u;
        return drawable != null ? drawable.getIntrinsicWidth() : this.f5887v.f5881a.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.f5895u;
        return drawable != null ? drawable.getOpacity() : this.f5887v.f5881a.getOpacity();
    }

    /* JADX WARN: Code restructure failed: missing block: B:85:0x0182, code lost:
    
        if (r8.f5882b != null) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0184, code lost:
    
        r8.f5882b = new android.animation.AnimatorSet();
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x018b, code lost:
    
        r8.f5882b.playTogether(r8.f5883c);
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
        throw new UnsupportedOperationException("Method not decompiled: h5.f.inflate(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):void");
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        Drawable drawable = this.f5895u;
        return drawable != null ? drawable.isAutoMirrored() : this.f5887v.f5881a.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        Drawable drawable = this.f5895u;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.f5887v.f5882b.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        Drawable drawable = this.f5895u;
        return drawable != null ? drawable.isStateful() : this.f5887v.f5881a.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable drawable = this.f5895u;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f5895u;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f5887v.f5881a.setBounds(rect);
        }
    }

    @Override // h5.i, android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i) {
        Drawable drawable = this.f5895u;
        return drawable != null ? drawable.setLevel(i) : this.f5887v.f5881a.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f5895u;
        return drawable != null ? drawable.setState(iArr) : this.f5887v.f5881a.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        Drawable drawable = this.f5895u;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else {
            this.f5887v.f5881a.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z2) {
        Drawable drawable = this.f5895u;
        if (drawable != null) {
            drawable.setAutoMirrored(z2);
        } else {
            this.f5887v.f5881a.setAutoMirrored(z2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f5895u;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f5887v.f5881a.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i) {
        Drawable drawable = this.f5895u;
        if (drawable != null) {
            com.bumptech.glide.d.P(drawable, i);
        } else {
            this.f5887v.f5881a.setTint(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f5895u;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
        } else {
            this.f5887v.f5881a.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f5895u;
        if (drawable != null) {
            drawable.setTintMode(mode);
        } else {
            this.f5887v.f5881a.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z2, boolean z10) {
        Drawable drawable = this.f5895u;
        if (drawable != null) {
            return drawable.setVisible(z2, z10);
        }
        this.f5887v.f5881a.setVisible(z2, z10);
        return super.setVisible(z2, z10);
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        Drawable drawable = this.f5895u;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
            return;
        }
        d dVar = this.f5887v;
        if (dVar.f5882b.isStarted()) {
            return;
        }
        dVar.f5882b.start();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        Drawable drawable = this.f5895u;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f5887v.f5882b.end();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws Throwable {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
