package v4;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class y0 extends t0.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerView f13405d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j1.b f13406e;

    public y0(RecyclerView recyclerView) {
        this.f13405d = recyclerView;
        j1.b bVar = this.f13406e;
        if (bVar != null) {
            this.f13406e = bVar;
        } else {
            this.f13406e = new j1.b(this);
        }
    }

    @Override // t0.b
    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        super.c(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || this.f13405d.O()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().U(accessibilityEvent);
        }
    }

    @Override // t0.b
    public void d(View view, u0.e eVar) {
        this.f11731a.onInitializeAccessibilityNodeInfo(view, eVar.f12062a);
        RecyclerView recyclerView = this.f13405d;
        if (recyclerView.O() || recyclerView.getLayoutManager() == null) {
            return;
        }
        h0 layoutManager = recyclerView.getLayoutManager();
        RecyclerView recyclerView2 = layoutManager.f13248b;
        layoutManager.V(recyclerView2.f1451x, recyclerView2.B0, eVar);
    }

    @Override // t0.b
    public final boolean g(View view, int i, Bundle bundle) {
        if (super.g(view, i, bundle)) {
            return true;
        }
        RecyclerView recyclerView = this.f13405d;
        if (recyclerView.O() || recyclerView.getLayoutManager() == null) {
            return false;
        }
        return recyclerView.getLayoutManager().j0(i, bundle);
    }
}
