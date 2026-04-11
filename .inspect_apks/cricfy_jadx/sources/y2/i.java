package y2;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements Handler.Callback {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Handler f14667v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ j f14668w;

    public i(j jVar, p2.l lVar) {
        this.f14668w = jVar;
        Handler handlerN = y1.a0.n(this);
        this.f14667v = handlerN;
        lVar.l(this, handlerN);
    }

    public final void a(long j4) {
        j jVar = this.f14668w;
        if (this != jVar.M1 || jVar.f9953h0 == null) {
            return;
        }
        if (j4 == Long.MAX_VALUE) {
            jVar.R0 = true;
            return;
        }
        try {
            jVar.H0(j4);
        } catch (g2.n e9) {
            jVar.S0 = e9;
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what != 0) {
            return false;
        }
        int i = message.arg1;
        int i10 = message.arg2;
        int i11 = y1.a0.f14551a;
        a(((((long) i) & 4294967295L) << 32) | (4294967295L & ((long) i10)));
        return true;
    }
}
