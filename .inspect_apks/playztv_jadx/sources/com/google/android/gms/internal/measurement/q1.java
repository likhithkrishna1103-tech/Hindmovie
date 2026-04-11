package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class q1 extends f1 {
    public final /* synthetic */ boolean A;
    public final /* synthetic */ t0 B;
    public final /* synthetic */ i1 C;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ String f3160y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ String f3161z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q1(i1 i1Var, String str, String str2, boolean z2, t0 t0Var) {
        super(i1Var, true);
        this.f3160y = str;
        this.f3161z = str2;
        this.A = z2;
        this.B = t0Var;
        this.C = i1Var;
    }

    @Override // com.google.android.gms.internal.measurement.f1
    public final void a() {
        s0 s0Var = this.C.f3049h;
        t7.v.h(s0Var);
        s0Var.getUserProperties(this.f3160y, this.f3161z, this.A, this.B);
    }

    @Override // com.google.android.gms.internal.measurement.f1
    public final void b() {
        this.B.h(null);
    }
}
