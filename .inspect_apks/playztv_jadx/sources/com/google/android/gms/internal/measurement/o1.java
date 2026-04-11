package com.google.android.gms.internal.measurement;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o1 extends f1 {
    public final /* synthetic */ i1 A;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ int f3138y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ String f3139z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o1(i1 i1Var, String str, int i) {
        super(i1Var, true);
        this.f3138y = i;
        this.f3139z = str;
        this.A = i1Var;
    }

    @Override // com.google.android.gms.internal.measurement.f1
    public final void a() {
        switch (this.f3138y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                s0 s0Var = this.A.f3049h;
                t7.v.h(s0Var);
                s0Var.endAdUnitExposure(this.f3139z, this.f2967v);
                break;
            default:
                s0 s0Var2 = this.A.f3049h;
                t7.v.h(s0Var2);
                s0Var2.beginAdUnitExposure(this.f3139z, this.f2967v);
                break;
        }
    }
}
