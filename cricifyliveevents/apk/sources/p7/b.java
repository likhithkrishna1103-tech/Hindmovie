package p7;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.media3.decoder.DecoderInputBuffer;
import com.bumptech.glide.i;
import java.util.ArrayList;
import o7.h;
import s7.f;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends a {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f10038z = i.glide_custom_view_target_tag;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ImageView f10039v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final e f10040w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Animatable f10041x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ int f10042y;

    public b(ImageView imageView, int i) {
        this.f10042y = i;
        f.c(imageView, "Argument must not be null");
        this.f10039v = imageView;
        this.f10040w = new e(imageView);
    }

    @Override // p7.d
    public final void a(Object obj) {
        h(obj);
        if (!(obj instanceof Animatable)) {
            this.f10041x = null;
            return;
        }
        Animatable animatable = (Animatable) obj;
        this.f10041x = animatable;
        animatable.start();
    }

    @Override // p7.d
    public final void b(Drawable drawable) {
        h(null);
        this.f10041x = null;
        this.f10039v.setImageDrawable(drawable);
    }

    @Override // com.bumptech.glide.manager.h
    public final void c() {
        Animatable animatable = this.f10041x;
        if (animatable != null) {
            animatable.stop();
        }
    }

    @Override // p7.d
    public final void d(o7.c cVar) {
        this.f10039v.setTag(f10038z, cVar);
    }

    @Override // p7.d
    public final void e(h hVar) throws Throwable {
        e eVar = this.f10040w;
        ArrayList arrayList = eVar.f10045b;
        View view = eVar.f10044a;
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
        if (eVar.f10046c == null) {
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            f0.f fVar = new f0.f(eVar);
            eVar.f10046c = fVar;
            viewTreeObserver.addOnPreDrawListener(fVar);
        }
    }

    @Override // p7.d
    public final void f(h hVar) {
        this.f10040w.f10045b.remove(hVar);
    }

    @Override // p7.d
    public final void g(Drawable drawable) {
        h(null);
        this.f10041x = null;
        this.f10039v.setImageDrawable(drawable);
    }

    public final void h(Object obj) {
        switch (this.f10042y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f10039v.setImageBitmap((Bitmap) obj);
                break;
            default:
                this.f10039v.setImageDrawable((Drawable) obj);
                break;
        }
    }

    @Override // p7.d
    public final o7.c j() {
        Object tag = this.f10039v.getTag(f10038z);
        if (tag == null) {
            return null;
        }
        if (tag instanceof o7.c) {
            return (o7.c) tag;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    @Override // p7.d
    public final void k(Drawable drawable) {
        e eVar = this.f10040w;
        ViewTreeObserver viewTreeObserver = eVar.f10044a.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(eVar.f10046c);
        }
        eVar.f10046c = null;
        eVar.f10045b.clear();
        Animatable animatable = this.f10041x;
        if (animatable != null) {
            animatable.stop();
        }
        h(null);
        this.f10041x = null;
        this.f10039v.setImageDrawable(drawable);
    }

    @Override // com.bumptech.glide.manager.h
    public final void l() {
        Animatable animatable = this.f10041x;
        if (animatable != null) {
            animatable.start();
        }
    }

    public final String toString() {
        return "Target for: " + this.f10039v;
    }
}
