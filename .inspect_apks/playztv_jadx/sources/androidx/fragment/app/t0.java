package androidx.fragment.app;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityManager;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class t0 implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f1370u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Object f1371v;

    public /* synthetic */ t0(int i, Object obj) {
        this.f1370u = i;
        this.f1371v = obj;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        int i = this.f1370u;
        Object obj = this.f1371v;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                View view2 = (View) obj;
                view2.removeOnAttachStateChangeListener(this);
                WeakHashMap weakHashMap = q0.o0.f10475a;
                q0.d0.c(view2);
                break;
            case 1:
            case 2:
                break;
            default:
                v9.m mVar = (v9.m) obj;
                AccessibilityManager accessibilityManager = mVar.N;
                if (mVar.O != null && accessibilityManager != null) {
                    WeakHashMap weakHashMap2 = q0.o0.f10475a;
                    if (mVar.isAttachedToWindow()) {
                        accessibilityManager.addTouchExplorationStateChangeListener(new r0.b(mVar.O));
                    }
                    break;
                }
                break;
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        AccessibilityManager accessibilityManager;
        switch (this.f1370u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                break;
            case 1:
                m.e eVar = (m.e) this.f1371v;
                ViewTreeObserver viewTreeObserver = eVar.R;
                if (viewTreeObserver != null) {
                    if (!viewTreeObserver.isAlive()) {
                        eVar.R = view.getViewTreeObserver();
                    }
                    eVar.R.removeGlobalOnLayoutListener(eVar.C);
                }
                view.removeOnAttachStateChangeListener(this);
                break;
            case 2:
                m.b0 b0Var = (m.b0) this.f1371v;
                ViewTreeObserver viewTreeObserver2 = b0Var.I;
                if (viewTreeObserver2 != null) {
                    if (!viewTreeObserver2.isAlive()) {
                        b0Var.I = view.getViewTreeObserver();
                    }
                    b0Var.I.removeGlobalOnLayoutListener(b0Var.C);
                }
                view.removeOnAttachStateChangeListener(this);
                break;
            default:
                v9.m mVar = (v9.m) this.f1371v;
                nc.c cVar = mVar.O;
                if (cVar != null && (accessibilityManager = mVar.N) != null) {
                    accessibilityManager.removeTouchExplorationStateChangeListener(new r0.b(cVar));
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
}
