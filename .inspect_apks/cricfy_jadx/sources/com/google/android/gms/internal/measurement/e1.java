package com.google.android.gms.internal.measurement;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e1 extends g1 {
    public final /* synthetic */ String A;
    public final /* synthetic */ boolean B;
    public final /* synthetic */ g0 C;
    public final /* synthetic */ k1 D;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ String f2373z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e1(k1 k1Var, String str, String str2, boolean z10, g0 g0Var) {
        super(k1Var, true);
        this.f2373z = str;
        this.A = str2;
        this.B = z10;
        this.C = g0Var;
        Objects.requireNonNull(k1Var);
        this.D = k1Var;
    }

    @Override // com.google.android.gms.internal.measurement.g1
    public final void a() {
        j0 j0Var = this.D.f;
        o8.u.g(j0Var);
        j0Var.getUserProperties(this.f2373z, this.A, this.B, this.C);
    }

    @Override // com.google.android.gms.internal.measurement.g1
    public final void b() {
        this.C.t(null);
    }
}
