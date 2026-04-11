package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j1 extends f1 {
    public final /* synthetic */ Object A;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ int f3063y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ i1 f3064z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j1(i1 i1Var, Object obj, int i) {
        super(i1Var, true);
        this.f3063y = i;
        this.A = obj;
        this.f3064z = i1Var;
    }

    @Override // com.google.android.gms.internal.measurement.f1
    public final void a() {
        switch (this.f3063y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                s0 s0Var = this.f3064z.f3049h;
                t7.v.h(s0Var);
                s0Var.setConditionalUserProperty((Bundle) this.A, this.f2966u);
                break;
            case 1:
                s0 s0Var2 = this.f3064z.f3049h;
                t7.v.h(s0Var2);
                s0Var2.setUserProperty("fcm", "_ln", new a8.b(this.A), true, this.f2966u);
                break;
            case 2:
                s0 s0Var3 = this.f3064z.f3049h;
                t7.v.h(s0Var3);
                s0Var3.logHealthData(5, "Error with data collection. Data lost.", new a8.b((Exception) this.A), new a8.b(null), new a8.b(null));
                break;
            default:
                s0 s0Var4 = this.f3064z.f3049h;
                t7.v.h(s0Var4);
                s0Var4.registerOnMeasurementEventListener((g1) this.A);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j1(i1 i1Var, Exception exc) {
        super(i1Var, false);
        this.f3063y = 2;
        this.A = exc;
        this.f3064z = i1Var;
    }
}
