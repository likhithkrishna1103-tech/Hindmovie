package o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class w extends ImageView {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ff.k f9383v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final f3.a f9384w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f9385x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        g3.a(context);
        this.f9385x = false;
        f3.a(getContext(), this);
        ff.k kVar = new ff.k(this);
        this.f9383v = kVar;
        kVar.z(attributeSet, i);
        f3.a aVar = new f3.a(this);
        this.f9384w = aVar;
        aVar.r(attributeSet, i);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        ff.k kVar = this.f9383v;
        if (kVar != null) {
            kVar.b();
        }
        f3.a aVar = this.f9384w;
        if (aVar != null) {
            aVar.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        ff.k kVar = this.f9383v;
        if (kVar != null) {
            return kVar.w();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        ff.k kVar = this.f9383v;
        if (kVar != null) {
            return kVar.x();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        kf.j jVar;
        f3.a aVar = this.f9384w;
        if (aVar == null || (jVar = (kf.j) aVar.f3937y) == null) {
            return null;
        }
        return (ColorStateList) jVar.f7486c;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        kf.j jVar;
        f3.a aVar = this.f9384w;
        if (aVar == null || (jVar = (kf.j) aVar.f3937y) == null) {
            return null;
        }
        return (PorterDuff.Mode) jVar.f7487d;
    }

    @Override // android.widget.ImageView, android.view.View
    public final boolean hasOverlappingRendering() {
        return !(((ImageView) this.f9384w.f3936x).getBackground() instanceof RippleDrawable) && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        ff.k kVar = this.f9383v;
        if (kVar != null) {
            kVar.B();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        ff.k kVar = this.f9383v;
        if (kVar != null) {
            kVar.C(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        f3.a aVar = this.f9384w;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        f3.a aVar = this.f9384w;
        if (aVar != null && drawable != null && !this.f9385x) {
            aVar.f3935w = drawable.getLevel();
        }
        super.setImageDrawable(drawable);
        if (aVar != null) {
            aVar.b();
            if (this.f9385x) {
                return;
            }
            ImageView imageView = (ImageView) aVar.f3936x;
            if (imageView.getDrawable() != null) {
                imageView.getDrawable().setLevel(aVar.f3935w);
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i) {
        super.setImageLevel(i);
        this.f9385x = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        f3.a aVar = this.f9384w;
        if (aVar != null) {
            aVar.x(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        f3.a aVar = this.f9384w;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        ff.k kVar = this.f9383v;
        if (kVar != null) {
            kVar.J(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        ff.k kVar = this.f9383v;
        if (kVar != null) {
            kVar.K(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        f3.a aVar = this.f9384w;
        if (aVar != null) {
            if (((kf.j) aVar.f3937y) == null) {
                aVar.f3937y = new kf.j();
            }
            kf.j jVar = (kf.j) aVar.f3937y;
            jVar.f7486c = colorStateList;
            jVar.f7485b = true;
            aVar.b();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        f3.a aVar = this.f9384w;
        if (aVar != null) {
            if (((kf.j) aVar.f3937y) == null) {
                aVar.f3937y = new kf.j();
            }
            kf.j jVar = (kf.j) aVar.f3937y;
            jVar.f7487d = mode;
            jVar.f7484a = true;
            aVar.b();
        }
    }
}
