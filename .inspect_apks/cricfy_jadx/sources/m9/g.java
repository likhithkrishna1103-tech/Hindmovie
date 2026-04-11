package m9;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.datastore.preferences.protobuf.k;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g extends f0.b {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public k f8406v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f8407w = 0;

    public g() {
    }

    @Override // f0.b
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
        x(coordinatorLayout, view, i);
        if (this.f8406v == null) {
            this.f8406v = new k(view);
        }
        k kVar = this.f8406v;
        View view2 = (View) kVar.f736d;
        kVar.f733a = view2.getTop();
        kVar.f734b = view2.getLeft();
        this.f8406v.a();
        int i10 = this.f8407w;
        if (i10 == 0) {
            return true;
        }
        k kVar2 = this.f8406v;
        if (kVar2.f735c != i10) {
            kVar2.f735c = i10;
            kVar2.a();
        }
        this.f8407w = 0;
        return true;
    }

    public final int w() {
        k kVar = this.f8406v;
        if (kVar != null) {
            return kVar.f735c;
        }
        return 0;
    }

    public void x(CoordinatorLayout coordinatorLayout, View view, int i) {
        coordinatorLayout.r(view, i);
    }

    public g(int i) {
    }
}
