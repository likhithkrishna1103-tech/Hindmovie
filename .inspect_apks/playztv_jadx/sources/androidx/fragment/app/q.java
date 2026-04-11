package androidx.fragment.app;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class q extends ga.b {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ v f1343u;

    public q(v vVar) {
        this.f1343u = vVar;
    }

    @Override // ga.b
    public final View v(int i) {
        v vVar = this.f1343u;
        View view = vVar.f1378a0;
        if (view != null) {
            return view.findViewById(i);
        }
        throw new IllegalStateException("Fragment " + vVar + " does not have a view");
    }

    @Override // ga.b
    public final boolean w() {
        return this.f1343u.f1378a0 != null;
    }
}
