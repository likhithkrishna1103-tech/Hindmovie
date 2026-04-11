package f9;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p3 extends o {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f4328e;
    public final /* synthetic */ t3 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p3(t3 t3Var, r1 r1Var, int i) {
        super(r1Var);
        this.f4328e = i;
        this.f = t3Var;
    }

    @Override // f9.o
    public final void a() {
        switch (this.f4328e) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                t3 t3Var = this.f;
                t3Var.m1();
                if (t3Var.D1()) {
                    w0 w0Var = ((r1) t3Var.f307w).A;
                    r1.g(w0Var);
                    w0Var.J.a("Inactivity, disconnecting from the service");
                    t3Var.u1();
                    break;
                }
                break;
            default:
                w0 w0Var2 = ((r1) this.f.f307w).A;
                r1.g(w0Var2);
                w0Var2.E.a("Tasks have been queued for a long time");
                break;
        }
    }
}
