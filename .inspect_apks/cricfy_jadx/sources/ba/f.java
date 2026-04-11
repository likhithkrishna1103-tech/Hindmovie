package ba;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.res.ColorStateList;
import android.view.View;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.behavior.HideViewOnScrollBehavior;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.google.android.material.transformation.ExpandableTransformationBehavior;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import l5.n;
import pa.l;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1867b;

    public /* synthetic */ f(int i, Object obj) {
        this.f1866a = i;
        this.f1867b = obj;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.f1866a) {
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.f1867b;
                actionBarOverlayLayout.R = null;
                actionBarOverlayLayout.E = false;
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f1866a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                j jVar = (j) this.f1867b;
                jVar.f1891r = 0;
                jVar.f1886m = null;
                break;
            case 1:
                ea.g gVar = (ea.g) this.f1867b;
                gVar.f3853b.setTranslationY(0.0f);
                gVar.b(0.0f);
                break;
            case 2:
                ((n) this.f1867b).m();
                animator.removeListener(this);
                break;
            case 3:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f1867b;
                sideSheetBehavior.x(5);
                WeakReference weakReference = sideSheetBehavior.K;
                if (weakReference != null && weakReference.get() != null) {
                    ((View) sideSheetBehavior.K.get()).requestLayout();
                    break;
                }
                break;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                m5.d dVar = (m5.d) this.f1867b;
                ArrayList arrayList = new ArrayList(dVar.f8319z);
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ColorStateList colorStateList = ((u9.a) arrayList.get(i)).f12292b.J;
                    if (colorStateList != null) {
                        dVar.setTintList(colorStateList);
                    }
                }
                break;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.f1867b;
                actionBarOverlayLayout.R = null;
                actionBarOverlayLayout.E = false;
                break;
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                ((HideBottomViewOnScrollBehavior) this.f1867b).F = null;
                break;
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                ((HideViewOnScrollBehavior) this.f1867b).F = null;
                break;
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                l lVar = (l) this.f1867b;
                lVar.p();
                lVar.f10082r.start();
                break;
            case 9:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.f1867b;
                bottomSheetBehavior.H(5);
                WeakReference weakReference2 = bottomSheetBehavior.f2805r0;
                if (weakReference2 != null && weakReference2.get() != null) {
                    ((View) bottomSheetBehavior.f2805r0.get()).requestLayout();
                    break;
                }
                break;
            default:
                ((ExpandableTransformationBehavior) this.f1867b).f3016w = null;
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f1866a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                j jVar = (j) this.f1867b;
                jVar.f1892s.a(0, false);
                jVar.f1891r = 2;
                jVar.f1886m = animator;
                break;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                m5.d dVar = (m5.d) this.f1867b;
                ArrayList arrayList = new ArrayList(dVar.f8319z);
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    u9.c cVar = ((u9.a) arrayList.get(i)).f12292b;
                    ColorStateList colorStateList = cVar.J;
                    if (colorStateList != null) {
                        dVar.setTint(colorStateList.getColorForState(cVar.N, colorStateList.getDefaultColor()));
                    }
                }
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }
}
