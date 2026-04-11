package androidx.fragment.app;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityManager;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.behavior.HideViewOnScrollBehavior;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class y0 implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f1123v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f1124w;

    public /* synthetic */ y0(int i, Object obj) {
        this.f1123v = i;
        this.f1124w = obj;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        int i = this.f1123v;
        Object obj = this.f1124w;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                View view2 = (View) obj;
                view2.removeOnAttachStateChangeListener(this);
                WeakHashMap weakHashMap = t0.m0.f11777a;
                t0.b0.c(view2);
                break;
            case 1:
            case 2:
            case 3:
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                break;
            default:
                pa.p pVar = (pa.p) obj;
                AccessibilityManager accessibilityManager = pVar.O;
                if (pVar.P != null && accessibilityManager != null && pVar.isAttachedToWindow()) {
                    accessibilityManager.addTouchExplorationStateChangeListener(pVar.P);
                    break;
                }
                break;
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        AccessibilityManager accessibilityManager;
        AccessibilityManager accessibilityManager2;
        AccessibilityManager accessibilityManager3;
        switch (this.f1123v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                break;
            case 1:
                n.e eVar = (n.e) this.f1124w;
                ViewTreeObserver viewTreeObserver = eVar.S;
                if (viewTreeObserver != null) {
                    if (!viewTreeObserver.isAlive()) {
                        eVar.S = view.getViewTreeObserver();
                    }
                    eVar.S.removeGlobalOnLayoutListener(eVar.D);
                }
                view.removeOnAttachStateChangeListener(this);
                break;
            case 2:
                n.b0 b0Var = (n.b0) this.f1124w;
                ViewTreeObserver viewTreeObserver2 = b0Var.J;
                if (viewTreeObserver2 != null) {
                    if (!viewTreeObserver2.isAlive()) {
                        b0Var.J = view.getViewTreeObserver();
                    }
                    b0Var.J.removeGlobalOnLayoutListener(b0Var.D);
                }
                view.removeOnAttachStateChangeListener(this);
                break;
            case 3:
                HideBottomViewOnScrollBehavior hideBottomViewOnScrollBehavior = (HideBottomViewOnScrollBehavior) this.f1124w;
                o9.a aVar = hideBottomViewOnScrollBehavior.C;
                if (aVar != null && (accessibilityManager = hideBottomViewOnScrollBehavior.B) != null) {
                    accessibilityManager.removeTouchExplorationStateChangeListener(aVar);
                    hideBottomViewOnScrollBehavior.C = null;
                    break;
                }
                break;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                HideViewOnScrollBehavior hideViewOnScrollBehavior = (HideViewOnScrollBehavior) this.f1124w;
                o9.a aVar2 = hideViewOnScrollBehavior.f2781x;
                if (aVar2 != null && (accessibilityManager2 = hideViewOnScrollBehavior.f2780w) != null) {
                    accessibilityManager2.removeTouchExplorationStateChangeListener(aVar2);
                    hideViewOnScrollBehavior.f2781x = null;
                    break;
                }
                break;
            default:
                pa.p pVar = (pa.p) this.f1124w;
                AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener = pVar.P;
                if (touchExplorationStateChangeListener != null && (accessibilityManager3 = pVar.O) != null) {
                    accessibilityManager3.removeTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
                    break;
                }
                break;
        }
    }

    private final void a(View view) {
    }

    private final void b(View view) {
    }

    private final void c(View view) {
    }

    private final void d(View view) {
    }

    private final void e(View view) {
    }
}
