package com.google.android.gms.internal.measurement;

import android.app.Activity;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l1 extends f1 {
    public final /* synthetic */ String A;
    public final /* synthetic */ i1 B;
    public final /* synthetic */ Object C;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ int f3084y = 1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ String f3085z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l1(i1 i1Var, Activity activity, String str, String str2) {
        super(i1Var, true);
        this.C = activity;
        this.f3085z = str;
        this.A = str2;
        this.B = i1Var;
    }

    @Override // com.google.android.gms.internal.measurement.f1
    public final void a() {
        switch (this.f3084y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                s0 s0Var = this.B.f3049h;
                t7.v.h(s0Var);
                s0Var.getConditionalUserProperties(this.f3085z, this.A, (t0) this.C);
                break;
            default:
                s0 s0Var2 = this.B.f3049h;
                t7.v.h(s0Var2);
                s0Var2.setCurrentScreen(new a8.b((Activity) this.C), this.f3085z, this.A, this.f2966u);
                break;
        }
    }

    @Override // com.google.android.gms.internal.measurement.f1
    public void b() {
        switch (this.f3084y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((t0) this.C).h(null);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l1(i1 i1Var, String str, String str2, t0 t0Var) {
        super(i1Var, true);
        this.f3085z = str;
        this.A = str2;
        this.C = t0Var;
        this.B = i1Var;
    }
}
