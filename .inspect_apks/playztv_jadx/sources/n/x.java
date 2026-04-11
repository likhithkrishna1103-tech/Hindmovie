package n;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.ImageView;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class x extends ImageButton {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final p f8566u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final aa.l0 f8567v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f8568w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c3.a(context);
        this.f8568w = false;
        b3.a(getContext(), this);
        p pVar = new p(this);
        this.f8566u = pVar;
        pVar.n(attributeSet, i);
        aa.l0 l0Var = new aa.l0(this);
        this.f8567v = l0Var;
        l0Var.s(attributeSet, i);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        p pVar = this.f8566u;
        if (pVar != null) {
            pVar.b();
        }
        aa.l0 l0Var = this.f8567v;
        if (l0Var != null) {
            l0Var.a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        p pVar = this.f8566u;
        if (pVar != null) {
            return pVar.j();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        p pVar = this.f8566u;
        if (pVar != null) {
            return pVar.k();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        d3 d3Var;
        aa.l0 l0Var = this.f8567v;
        if (l0Var == null || (d3Var = (d3) l0Var.f707x) == null) {
            return null;
        }
        return (ColorStateList) d3Var.f8375c;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        d3 d3Var;
        aa.l0 l0Var = this.f8567v;
        if (l0Var == null || (d3Var = (d3) l0Var.f707x) == null) {
            return null;
        }
        return (PorterDuff.Mode) d3Var.f8376d;
    }

    @Override // android.widget.ImageView, android.view.View
    public final boolean hasOverlappingRendering() {
        return !(((ImageView) this.f8567v.f706w).getBackground() instanceof RippleDrawable) && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        p pVar = this.f8566u;
        if (pVar != null) {
            pVar.q();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        p pVar = this.f8566u;
        if (pVar != null) {
            pVar.r(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        aa.l0 l0Var = this.f8567v;
        if (l0Var != null) {
            l0Var.a();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        aa.l0 l0Var = this.f8567v;
        if (l0Var != null && drawable != null && !this.f8568w) {
            l0Var.f705v = drawable.getLevel();
        }
        super.setImageDrawable(drawable);
        if (l0Var != null) {
            l0Var.a();
            if (this.f8568w) {
                return;
            }
            ImageView imageView = (ImageView) l0Var.f706w;
            if (imageView.getDrawable() != null) {
                imageView.getDrawable().setLevel(l0Var.f705v);
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i) {
        super.setImageLevel(i);
        this.f8568w = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.f8567v.w(i);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        aa.l0 l0Var = this.f8567v;
        if (l0Var != null) {
            l0Var.a();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        p pVar = this.f8566u;
        if (pVar != null) {
            pVar.y(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        p pVar = this.f8566u;
        if (pVar != null) {
            pVar.z(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        aa.l0 l0Var = this.f8567v;
        if (l0Var != null) {
            if (((d3) l0Var.f707x) == null) {
                l0Var.f707x = new d3();
            }
            d3 d3Var = (d3) l0Var.f707x;
            d3Var.f8375c = colorStateList;
            d3Var.f8374b = true;
            l0Var.a();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        aa.l0 l0Var = this.f8567v;
        if (l0Var != null) {
            if (((d3) l0Var.f707x) == null) {
                l0Var.f707x = new d3();
            }
            d3 d3Var = (d3) l0Var.f707x;
            d3Var.f8376d = mode;
            d3Var.f8373a = true;
            l0Var.a();
        }
    }
}
