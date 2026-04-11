package com.google.android.gms.internal.measurement;

import android.app.Activity;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i1 extends g1 {
    public final /* synthetic */ Activity A;
    public final /* synthetic */ j1 B;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ int f2479z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i1(j1 j1Var, Activity activity, int i) {
        super(j1Var.f2492v, true);
        this.f2479z = i;
        switch (i) {
            case 1:
                this.A = activity;
                this.B = j1Var;
                super(j1Var.f2492v, true);
                break;
            case 2:
                this.A = activity;
                this.B = j1Var;
                super(j1Var.f2492v, true);
                break;
            case 3:
                this.A = activity;
                this.B = j1Var;
                super(j1Var.f2492v, true);
                break;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                this.A = activity;
                this.B = j1Var;
                super(j1Var.f2492v, true);
                break;
            default:
                this.A = activity;
                this.B = j1Var;
                break;
        }
    }

    @Override // com.google.android.gms.internal.measurement.g1
    public final void a() {
        switch (this.f2479z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                j0 j0Var = this.B.f2492v.f;
                o8.u.g(j0Var);
                j0Var.onActivityStartedByScionActivityInfo(v0.a(this.A), this.f2454w);
                break;
            case 1:
                j0 j0Var2 = this.B.f2492v.f;
                o8.u.g(j0Var2);
                j0Var2.onActivityResumedByScionActivityInfo(v0.a(this.A), this.f2454w);
                break;
            case 2:
                j0 j0Var3 = this.B.f2492v.f;
                o8.u.g(j0Var3);
                j0Var3.onActivityPausedByScionActivityInfo(v0.a(this.A), this.f2454w);
                break;
            case 3:
                j0 j0Var4 = this.B.f2492v.f;
                o8.u.g(j0Var4);
                j0Var4.onActivityStoppedByScionActivityInfo(v0.a(this.A), this.f2454w);
                break;
            default:
                j0 j0Var5 = this.B.f2492v.f;
                o8.u.g(j0Var5);
                j0Var5.onActivityDestroyedByScionActivityInfo(v0.a(this.A), this.f2454w);
                break;
        }
    }
}
