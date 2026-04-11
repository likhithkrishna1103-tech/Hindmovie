package com.google.android.gms.internal.measurement;

import android.app.Activity;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r1 extends f1 {
    public final /* synthetic */ h1 A;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ int f3170y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ Activity f3171z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r1(h1 h1Var, Activity activity, int i) {
        super(h1Var.f3034u, true);
        this.f3170y = i;
        switch (i) {
            case 1:
                this.f3171z = activity;
                this.A = h1Var;
                super(h1Var.f3034u, true);
                break;
            case 2:
                this.f3171z = activity;
                this.A = h1Var;
                super(h1Var.f3034u, true);
                break;
            case 3:
                this.f3171z = activity;
                this.A = h1Var;
                super(h1Var.f3034u, true);
                break;
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                this.f3171z = activity;
                this.A = h1Var;
                super(h1Var.f3034u, true);
                break;
            default:
                this.f3171z = activity;
                this.A = h1Var;
                break;
        }
    }

    @Override // com.google.android.gms.internal.measurement.f1
    public final void a() {
        switch (this.f3170y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                s0 s0Var = this.A.f3034u.f3049h;
                t7.v.h(s0Var);
                s0Var.onActivityResumed(new a8.b(this.f3171z), this.f2967v);
                break;
            case 1:
                s0 s0Var2 = this.A.f3034u.f3049h;
                t7.v.h(s0Var2);
                s0Var2.onActivityStarted(new a8.b(this.f3171z), this.f2967v);
                break;
            case 2:
                s0 s0Var3 = this.A.f3034u.f3049h;
                t7.v.h(s0Var3);
                s0Var3.onActivityStopped(new a8.b(this.f3171z), this.f2967v);
                break;
            case 3:
                s0 s0Var4 = this.A.f3034u.f3049h;
                t7.v.h(s0Var4);
                s0Var4.onActivityPaused(new a8.b(this.f3171z), this.f2967v);
                break;
            default:
                s0 s0Var5 = this.A.f3034u.f3049h;
                t7.v.h(s0Var5);
                s0Var5.onActivityDestroyed(new a8.b(this.f3171z), this.f2967v);
                break;
        }
    }
}
