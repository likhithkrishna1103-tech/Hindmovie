package o2;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h0 implements s1.h {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ aa.l0 f9126u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ u f9127v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ z f9128w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ IOException f9129x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ boolean f9130y;

    public /* synthetic */ h0(aa.l0 l0Var, u uVar, z zVar, IOException iOException, boolean z2) {
        this.f9126u = l0Var;
        this.f9127v = uVar;
        this.f9128w = zVar;
        this.f9129x = iOException;
        this.f9130y = z2;
    }

    @Override // s1.h
    public final void accept(Object obj) {
        k0 k0Var = (k0) obj;
        aa.l0 l0Var = this.f9126u;
        k0Var.A(l0Var.f705v, (d0) l0Var.f706w, this.f9127v, this.f9128w, this.f9129x, this.f9130y);
    }
}
