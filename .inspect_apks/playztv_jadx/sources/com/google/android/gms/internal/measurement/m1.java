package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m1 extends f1 {
    public final /* synthetic */ String A;
    public final /* synthetic */ Bundle B;
    public final /* synthetic */ i1 C;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ int f3094y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ String f3095z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m1(i1 i1Var, String str, String str2, Bundle bundle, int i) {
        super(i1Var, true);
        this.f3094y = i;
        this.f3095z = str;
        this.A = str2;
        this.B = bundle;
        this.C = i1Var;
    }

    @Override // com.google.android.gms.internal.measurement.f1
    public final void a() {
        switch (this.f3094y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                s0 s0Var = this.C.f3049h;
                t7.v.h(s0Var);
                s0Var.clearConditionalUserProperty(this.f3095z, this.A, this.B);
                break;
            default:
                long j5 = this.f2966u;
                s0 s0Var2 = this.C.f3049h;
                t7.v.h(s0Var2);
                s0Var2.logEvent(this.f3095z, this.A, this.B, true, true, j5);
                break;
        }
    }
}
