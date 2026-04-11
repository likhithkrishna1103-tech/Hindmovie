package q0;

import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.appbar.AppBarLayout;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class s0 implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f10496c;

    public /* synthetic */ s0(Object obj, int i, Object obj2) {
        this.f10494a = i;
        this.f10495b = obj;
        this.f10496c = obj2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i = this.f10494a;
        Object obj = this.f10495b;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((View) ((h.n0) ((rc.b) obj).f11562v).f.getParent()).invalidate();
                return;
            default:
                AppBarLayout appBarLayout = (AppBarLayout) obj;
                q9.g gVar = (q9.g) this.f10496c;
                int i10 = AppBarLayout.S;
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                gVar.k(fFloatValue);
                Drawable drawable = appBarLayout.O;
                if (drawable instanceof q9.g) {
                    ((q9.g) drawable).k(fFloatValue);
                }
                Iterator it = appBarLayout.K.iterator();
                if (it.hasNext()) {
                    throw l4.a.k(it);
                }
                return;
        }
    }
}
