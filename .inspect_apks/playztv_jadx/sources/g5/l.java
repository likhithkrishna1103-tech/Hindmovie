package g5;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.view.View;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.google.android.material.transformation.ExpandableTransformationBehavior;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5287b;

    public /* synthetic */ l(int i, Object obj) {
        this.f5286a = i;
        this.f5287b = obj;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.f5286a) {
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.f5287b;
                actionBarOverlayLayout.Q = null;
                actionBarOverlayLayout.D = false;
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f5286a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((p) this.f5287b).m();
                animator.removeListener(this);
                break;
            case 1:
                h5.f fVar = (h5.f) this.f5287b;
                ArrayList arrayList = new ArrayList(fVar.f5890y);
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ColorStateList colorStateList = ((a9.a) arrayList.get(i)).f632b.I;
                    if (colorStateList != null) {
                        fVar.setTintList(colorStateList);
                    }
                }
                break;
            case 2:
                h9.i iVar = (h9.i) this.f5287b;
                iVar.f6010r = 0;
                iVar.f6004l = null;
                break;
            case 3:
                a7.b bVar = (a7.b) this.f5287b;
                if (((ValueAnimator) bVar.f619w) == animator) {
                    bVar.f619w = null;
                }
                break;
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                k9.f fVar2 = (k9.f) this.f5287b;
                fVar2.f7580b.setTranslationY(0.0f);
                fVar2.b(0.0f);
                break;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.f5287b;
                actionBarOverlayLayout.Q = null;
                actionBarOverlayLayout.D = false;
                break;
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f5287b;
                sideSheetBehavior.x(5);
                WeakReference weakReference = sideSheetBehavior.J;
                if (weakReference != null && weakReference.get() != null) {
                    ((View) sideSheetBehavior.J.get()).requestLayout();
                    break;
                }
                break;
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                ((HideBottomViewOnScrollBehavior) this.f5287b).B = null;
                break;
            case 8:
                v9.j jVar = (v9.j) this.f5287b;
                jVar.p();
                jVar.f13367r.start();
                break;
            case 9:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.f5287b;
                bottomSheetBehavior.H(5);
                WeakReference weakReference2 = bottomSheetBehavior.f3349o0;
                if (weakReference2 != null && weakReference2.get() != null) {
                    ((View) bottomSheetBehavior.f3349o0.get()).requestLayout();
                    break;
                }
                break;
            default:
                ((ExpandableTransformationBehavior) this.f5287b).f3553v = null;
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f5286a) {
            case 1:
                h5.f fVar = (h5.f) this.f5287b;
                ArrayList arrayList = new ArrayList(fVar.f5890y);
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    a9.d dVar = ((a9.a) arrayList.get(i)).f632b;
                    ColorStateList colorStateList = dVar.I;
                    if (colorStateList != null) {
                        fVar.setTint(colorStateList.getColorForState(dVar.M, colorStateList.getDefaultColor()));
                    }
                }
                break;
            case 2:
                h9.i iVar = (h9.i) this.f5287b;
                iVar.f6011s.a(0, false);
                iVar.f6010r = 2;
                iVar.f6004l = animator;
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }
}
