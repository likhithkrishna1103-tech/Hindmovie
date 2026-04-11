package androidx.fragment.app;

import android.app.Dialog;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m extends ga.b {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ q f1297u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ n f1298v;

    public m(n nVar, q qVar) {
        this.f1298v = nVar;
        this.f1297u = qVar;
    }

    @Override // ga.b
    public final View v(int i) {
        q qVar = this.f1297u;
        if (qVar.w()) {
            return qVar.v(i);
        }
        Dialog dialog = this.f1298v.C0;
        if (dialog != null) {
            return dialog.findViewById(i);
        }
        return null;
    }

    @Override // ga.b
    public final boolean w() {
        return this.f1297u.w() || this.f1298v.G0;
    }
}
