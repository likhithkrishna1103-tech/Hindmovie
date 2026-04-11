package com.google.android.gms.internal.measurement;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c1 extends g1 {
    public final /* synthetic */ g0 A;
    public final /* synthetic */ k1 B;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ int f2339z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c1(k1 k1Var, g0 g0Var, int i) {
        super(k1Var, true);
        this.f2339z = i;
        this.A = g0Var;
        this.B = k1Var;
    }

    @Override // com.google.android.gms.internal.measurement.g1
    public final void a() {
        switch (this.f2339z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                j0 j0Var = this.B.f;
                o8.u.g(j0Var);
                j0Var.getGmpAppId(this.A);
                break;
            case 1:
                j0 j0Var2 = this.B.f;
                o8.u.g(j0Var2);
                j0Var2.getCachedAppInstanceId(this.A);
                break;
            case 2:
                j0 j0Var3 = this.B.f;
                o8.u.g(j0Var3);
                j0Var3.generateEventId(this.A);
                break;
            case 3:
                j0 j0Var4 = this.B.f;
                o8.u.g(j0Var4);
                j0Var4.getCurrentScreenName(this.A);
                break;
            default:
                j0 j0Var5 = this.B.f;
                o8.u.g(j0Var5);
                j0Var5.getCurrentScreenClass(this.A);
                break;
        }
    }

    @Override // com.google.android.gms.internal.measurement.g1
    public final void b() {
        switch (this.f2339z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.A.t(null);
                break;
            case 1:
                this.A.t(null);
                break;
            case 2:
                this.A.t(null);
                break;
            case 3:
                this.A.t(null);
                break;
            default:
                this.A.t(null);
                break;
        }
    }
}
