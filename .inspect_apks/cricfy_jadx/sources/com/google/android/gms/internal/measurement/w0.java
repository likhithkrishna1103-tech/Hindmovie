package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class w0 extends g1 {
    public final /* synthetic */ k1 A;
    public final /* synthetic */ Object B;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ int f2706z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w0(k1 k1Var, Object obj, int i) {
        super(k1Var, true);
        this.f2706z = i;
        this.B = obj;
        this.A = k1Var;
    }

    @Override // com.google.android.gms.internal.measurement.g1
    public final void a() {
        switch (this.f2706z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                j0 j0Var = this.A.f;
                o8.u.g(j0Var);
                j0Var.setUserProperty("fcm", "_ln", new v8.b(this.B), true, this.f2453v);
                break;
            case 1:
                j0 j0Var2 = this.A.f;
                o8.u.g(j0Var2);
                j0Var2.setConditionalUserProperty((Bundle) this.B, this.f2453v);
                break;
            case 2:
                j0 j0Var3 = this.A.f;
                o8.u.g(j0Var3);
                j0Var3.retrieveAndUploadBatches(new b1(this, (ya.s) this.B));
                break;
            case 3:
                j0 j0Var4 = this.A.f;
                o8.u.g(j0Var4);
                j0Var4.logHealthData(5, "Error with data collection. Data lost.", new v8.b((Exception) this.B), new v8.b(null), new v8.b(null));
                break;
            default:
                j0 j0Var5 = this.A.f;
                o8.u.g(j0Var5);
                j0Var5.registerOnMeasurementEventListener((h1) this.B);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w0(k1 k1Var, Bundle bundle) {
        super(k1Var, true);
        this.f2706z = 1;
        this.B = bundle;
        Objects.requireNonNull(k1Var);
        this.A = k1Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w0(k1 k1Var, Exception exc) {
        super(k1Var, false);
        this.f2706z = 3;
        this.B = exc;
        this.A = k1Var;
    }
}
