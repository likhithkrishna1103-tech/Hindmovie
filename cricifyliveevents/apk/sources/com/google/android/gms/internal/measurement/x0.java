package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class x0 extends g1 {
    public final /* synthetic */ String A;
    public final /* synthetic */ String B;
    public final /* synthetic */ Bundle C;
    public final /* synthetic */ k1 D;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ int f2717z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x0(k1 k1Var, String str, String str2, Bundle bundle, int i) {
        super(k1Var, true);
        this.f2717z = i;
        switch (i) {
            case 1:
                this.A = str;
                this.B = str2;
                this.C = bundle;
                Objects.requireNonNull(k1Var);
                this.D = k1Var;
                super(k1Var, true);
                break;
            default:
                this.A = str;
                this.B = str2;
                this.C = bundle;
                Objects.requireNonNull(k1Var);
                this.D = k1Var;
                break;
        }
    }

    @Override // com.google.android.gms.internal.measurement.g1
    public final void a() {
        switch (this.f2717z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                j0 j0Var = this.D.f;
                o8.u.g(j0Var);
                j0Var.clearConditionalUserProperty(this.A, this.B, this.C);
                break;
            default:
                long j4 = this.f2453v;
                j0 j0Var2 = this.D.f;
                o8.u.g(j0Var2);
                j0Var2.logEvent(this.A, this.B, this.C, true, true, j4);
                break;
        }
    }
}
