package com.google.android.gms.internal.measurement;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class y0 extends g1 {
    public final /* synthetic */ String A;
    public final /* synthetic */ String B;
    public final /* synthetic */ k1 C;
    public final /* synthetic */ Object D;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ int f2730z = 1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y0(k1 k1Var, v0 v0Var, String str, String str2) {
        super(k1Var, true);
        this.D = v0Var;
        this.A = str;
        this.B = str2;
        Objects.requireNonNull(k1Var);
        this.C = k1Var;
    }

    @Override // com.google.android.gms.internal.measurement.g1
    public final void a() {
        switch (this.f2730z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                j0 j0Var = this.C.f;
                o8.u.g(j0Var);
                j0Var.getConditionalUserProperties(this.A, this.B, (g0) this.D);
                break;
            default:
                j0 j0Var2 = this.C.f;
                o8.u.g(j0Var2);
                j0Var2.setCurrentScreenByScionActivityInfo((v0) this.D, this.A, this.B, this.f2453v);
                break;
        }
    }

    @Override // com.google.android.gms.internal.measurement.g1
    public void b() {
        switch (this.f2730z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((g0) this.D).t(null);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y0(k1 k1Var, String str, String str2, g0 g0Var) {
        super(k1Var, true);
        this.A = str;
        this.B = str2;
        this.D = g0Var;
        Objects.requireNonNull(k1Var);
        this.C = k1Var;
    }
}
