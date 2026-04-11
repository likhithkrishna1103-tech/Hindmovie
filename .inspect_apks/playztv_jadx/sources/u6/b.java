package u6;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.media3.decoder.DecoderInputBuffer;
import com.bumptech.glide.g;
import java.util.ArrayList;
import t6.h;
import x6.f;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b extends a {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f12785y = g.glide_custom_view_target_tag;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ImageView f12786u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final e f12787v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Animatable f12788w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ int f12789x;

    public b(ImageView imageView, int i) {
        this.f12789x = i;
        f.c(imageView, "Argument must not be null");
        this.f12786u = imageView;
        this.f12787v = new e(imageView);
    }

    @Override // u6.d
    public final void a(Object obj) {
        f(obj);
        if (!(obj instanceof Animatable)) {
            this.f12788w = null;
            return;
        }
        Animatable animatable = (Animatable) obj;
        this.f12788w = animatable;
        animatable.start();
    }

    @Override // u6.d
    public final void b(h hVar) throws Throwable {
        e eVar = this.f12787v;
        ArrayList arrayList = eVar.f12792b;
        View view = eVar.f12791a;
        int paddingRight = view.getPaddingRight() + view.getPaddingLeft();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int iA = eVar.a(view.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingRight);
        int paddingBottom = view.getPaddingBottom() + view.getPaddingTop();
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        int iA2 = eVar.a(view.getHeight(), layoutParams2 != null ? layoutParams2.height : 0, paddingBottom);
        if ((iA > 0 || iA == Integer.MIN_VALUE) && (iA2 > 0 || iA2 == Integer.MIN_VALUE)) {
            hVar.m(iA, iA2);
            return;
        }
        if (!arrayList.contains(hVar)) {
            arrayList.add(hVar);
        }
        if (eVar.f12793c == null) {
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            c0.f fVar = new c0.f(eVar);
            eVar.f12793c = fVar;
            viewTreeObserver.addOnPreDrawListener(fVar);
        }
    }

    @Override // u6.d
    public final void c(Drawable drawable) {
        f(null);
        this.f12788w = null;
        this.f12786u.setImageDrawable(drawable);
    }

    @Override // com.bumptech.glide.manager.h
    public final void d() {
        Animatable animatable = this.f12788w;
        if (animatable != null) {
            animatable.stop();
        }
    }

    @Override // u6.d
    public final void e(Drawable drawable) {
        f(null);
        this.f12788w = null;
        this.f12786u.setImageDrawable(drawable);
    }

    public final void f(Object obj) {
        switch (this.f12789x) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f12786u.setImageBitmap((Bitmap) obj);
                break;
            default:
                this.f12786u.setImageDrawable((Drawable) obj);
                break;
        }
    }

    @Override // u6.d
    public final t6.c g() {
        Object tag = this.f12786u.getTag(f12785y);
        if (tag == null) {
            return null;
        }
        if (tag instanceof t6.c) {
            return (t6.c) tag;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    @Override // u6.d
    public final void h(Drawable drawable) {
        e eVar = this.f12787v;
        ViewTreeObserver viewTreeObserver = eVar.f12791a.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(eVar.f12793c);
        }
        eVar.f12793c = null;
        eVar.f12792b.clear();
        Animatable animatable = this.f12788w;
        if (animatable != null) {
            animatable.stop();
        }
        f(null);
        this.f12788w = null;
        this.f12786u.setImageDrawable(drawable);
    }

    @Override // u6.d
    public final void j(t6.c cVar) {
        this.f12786u.setTag(f12785y, cVar);
    }

    @Override // u6.d
    public final void k(h hVar) {
        this.f12787v.f12792b.remove(hVar);
    }

    @Override // com.bumptech.glide.manager.h
    public final void l() {
        Animatable animatable = this.f12788w;
        if (animatable != null) {
            animatable.start();
        }
    }

    public final String toString() {
        return "Target for: " + this.f12786u;
    }
}
