package u2;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i implements Handler.Callback {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Handler f12588u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ j f12589v;

    public i(j jVar, j2.m mVar) {
        this.f12589v = jVar;
        Handler handlerN = s1.b0.n(this);
        this.f12588u = handlerN;
        mVar.n(this, handlerN);
    }

    public final void a(long j5) {
        j jVar = this.f12589v;
        if (this != jVar.L1 || jVar.f6735g0 == null) {
            return;
        }
        if (j5 == Long.MAX_VALUE) {
            jVar.Q0 = true;
            return;
        }
        try {
            jVar.H0(j5);
        } catch (a2.q e10) {
            jVar.R0 = e10;
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what != 0) {
            return false;
        }
        int i = message.arg1;
        int i10 = message.arg2;
        int i11 = s1.b0.f11647a;
        a(((((long) i) & 4294967295L) << 32) | (4294967295L & ((long) i10)));
        return true;
    }
}
