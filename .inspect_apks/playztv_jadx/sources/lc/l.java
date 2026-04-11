package lc;

import a2.f0;
import android.content.DialogInterface;
import p1.l1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class l implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ l1 f8105u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ n f8106v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ f0 f8107w;

    public /* synthetic */ l(l1 l1Var, n nVar, f0 f0Var) {
        this.f8105u = l1Var;
        this.f8106v = nVar;
        this.f8107w = f0Var;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        n.S(this.f8105u, this.f8106v, this.f8107w);
    }
}
