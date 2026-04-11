package com.google.android.gms.internal.measurement;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p1 extends f1 {
    public final /* synthetic */ i1 A;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ int f3147y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ t0 f3148z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p1(i1 i1Var, t0 t0Var, int i) {
        super(i1Var, true);
        this.f3147y = i;
        this.f3148z = t0Var;
        this.A = i1Var;
    }

    @Override // com.google.android.gms.internal.measurement.f1
    public final void a() {
        switch (this.f3147y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                s0 s0Var = this.A.f3049h;
                t7.v.h(s0Var);
                s0Var.getCachedAppInstanceId(this.f3148z);
                break;
            case 1:
                s0 s0Var2 = this.A.f3049h;
                t7.v.h(s0Var2);
                s0Var2.getGmpAppId(this.f3148z);
                break;
            case 2:
                s0 s0Var3 = this.A.f3049h;
                t7.v.h(s0Var3);
                s0Var3.getCurrentScreenName(this.f3148z);
                break;
            case 3:
                s0 s0Var4 = this.A.f3049h;
                t7.v.h(s0Var4);
                s0Var4.generateEventId(this.f3148z);
                break;
            default:
                s0 s0Var5 = this.A.f3049h;
                t7.v.h(s0Var5);
                s0Var5.getCurrentScreenClass(this.f3148z);
                break;
        }
    }

    @Override // com.google.android.gms.internal.measurement.f1
    public final void b() {
        switch (this.f3147y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f3148z.h(null);
                break;
            case 1:
                this.f3148z.h(null);
                break;
            case 2:
                this.f3148z.h(null);
                break;
            case 3:
                this.f3148z.h(null);
                break;
            default:
                this.f3148z.h(null);
                break;
        }
    }
}
