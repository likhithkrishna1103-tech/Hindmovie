package m9;

import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.appbar.AppBarLayout;
import h.m0;
import java.util.Iterator;
import ka.i;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f8395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f8396c;

    public /* synthetic */ c(int i, Object obj, Object obj2) {
        this.f8394a = i;
        this.f8395b = obj;
        this.f8396c = obj2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i = this.f8394a;
        Object obj = this.f8395b;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                AppBarLayout appBarLayout = (AppBarLayout) obj;
                i iVar = (i) this.f8396c;
                int i10 = AppBarLayout.V;
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                iVar.p(fFloatValue);
                Drawable drawable = appBarLayout.R;
                if (drawable instanceof i) {
                    ((i) drawable).p(fFloatValue);
                }
                Iterator it = appBarLayout.L.iterator();
                if (it.hasNext()) {
                    throw q4.a.l(it);
                }
                Iterator it2 = appBarLayout.M.iterator();
                if (it2.hasNext()) {
                    throw q4.a.l(it2);
                }
                return;
            default:
                ((View) ((m0) ((p6.c) obj).f10035w).f5371h.getParent()).invalidate();
                return;
        }
    }
}
