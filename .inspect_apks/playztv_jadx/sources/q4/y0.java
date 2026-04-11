package q4;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class y0 extends q0.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerView f10980d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e1.b f10981e;

    public y0(RecyclerView recyclerView) {
        this.f10980d = recyclerView;
        e1.b bVar = this.f10981e;
        if (bVar != null) {
            this.f10981e = bVar;
        } else {
            this.f10981e = new e1.b(this);
        }
    }

    @Override // q0.b
    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        super.c(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || this.f10980d.O()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().U(accessibilityEvent);
        }
    }

    @Override // q0.b
    public void d(View view, r0.e eVar) {
        this.f10418a.onInitializeAccessibilityNodeInfo(view, eVar.f11226a);
        RecyclerView recyclerView = this.f10980d;
        if (recyclerView.O() || recyclerView.getLayoutManager() == null) {
            return;
        }
        h0 layoutManager = recyclerView.getLayoutManager();
        RecyclerView recyclerView2 = layoutManager.f10818b;
        layoutManager.V(recyclerView2.f1666w, recyclerView2.A0, eVar);
    }

    @Override // q0.b
    public final boolean g(View view, int i, Bundle bundle) {
        if (super.g(view, i, bundle)) {
            return true;
        }
        RecyclerView recyclerView = this.f10980d;
        if (recyclerView.O() || recyclerView.getLayoutManager() == null) {
            return false;
        }
        return recyclerView.getLayoutManager().j0(i, bundle);
    }
}
