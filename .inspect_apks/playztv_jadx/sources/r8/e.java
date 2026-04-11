package r8;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.datastore.preferences.protobuf.i;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class e extends c0.b {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public i f11548u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f11549v = 0;

    public e() {
    }

    @Override // c0.b
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
        x(coordinatorLayout, view, i);
        if (this.f11548u == null) {
            i iVar = new i();
            iVar.f1067d = view;
            this.f11548u = iVar;
        }
        i iVar2 = this.f11548u;
        View view2 = (View) iVar2.f1067d;
        iVar2.f1064a = view2.getTop();
        iVar2.f1065b = view2.getLeft();
        this.f11548u.b();
        int i10 = this.f11549v;
        if (i10 == 0) {
            return true;
        }
        i iVar3 = this.f11548u;
        if (iVar3.f1066c != i10) {
            iVar3.f1066c = i10;
            iVar3.b();
        }
        this.f11549v = 0;
        return true;
    }

    public final int w() {
        i iVar = this.f11548u;
        if (iVar != null) {
            return iVar.f1066c;
        }
        return 0;
    }

    public void x(CoordinatorLayout coordinatorLayout, View view, int i) {
        coordinatorLayout.r(view, i);
    }

    public e(int i) {
    }
}
