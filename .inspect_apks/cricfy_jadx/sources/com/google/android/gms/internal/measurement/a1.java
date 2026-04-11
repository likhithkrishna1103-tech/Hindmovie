package com.google.android.gms.internal.measurement;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a1 extends g1 {
    public final /* synthetic */ String A;
    public final /* synthetic */ k1 B;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ int f2313z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a1(k1 k1Var, String str, int i) {
        super(k1Var, true);
        this.f2313z = i;
        this.A = str;
        this.B = k1Var;
    }

    @Override // com.google.android.gms.internal.measurement.g1
    public final void a() {
        switch (this.f2313z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                j0 j0Var = this.B.f;
                o8.u.g(j0Var);
                j0Var.beginAdUnitExposure(this.A, this.f2454w);
                break;
            default:
                j0 j0Var2 = this.B.f;
                o8.u.g(j0Var2);
                j0Var2.endAdUnitExposure(this.A, this.f2454w);
                break;
        }
    }
}
