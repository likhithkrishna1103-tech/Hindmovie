package k4;

import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class y extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f7191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f7192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b0 f7193c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(b0 b0Var, Looper looper) {
        super(looper);
        this.f7193c = b0Var;
        this.f7191a = true;
        this.f7192b = true;
    }

    public final void a(boolean z10, boolean z11) {
        boolean z12 = false;
        this.f7191a = this.f7191a && z10;
        if (this.f7192b && z11) {
            z12 = true;
        }
        this.f7192b = z12;
        if (hasMessages(1)) {
            return;
        }
        sendEmptyMessage(1);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        s sVar;
        int iC;
        f1 f1Var;
        b0 b0Var = this.f7193c;
        d1 d1Var = b0Var.f6912g;
        if (message.what != 1) {
            throw new IllegalStateException("Invalid message what=" + message.what);
        }
        f1 f1VarC = b0Var.f6923s.c(b0Var.f6924t.f0(), b0Var.f6924t.C(), b0Var.f6923s.f6979k);
        b0Var.f6923s = f1VarC;
        boolean z10 = this.f7191a;
        boolean z11 = this.f7192b;
        f1 f1VarF = d1Var.f(f1VarC);
        b6.f fVar = d1Var.f6944e;
        ua.i0 i0VarG = fVar.g();
        for (int i = 0; i < i0VarG.size(); i++) {
            s sVar2 = (s) i0VarG.get(i);
            try {
                j1 j1VarK = fVar.k(sVar2);
                if (j1VarK != null) {
                    iC = j1VarK.c();
                } else if (!b0Var.h(sVar2)) {
                    break;
                } else {
                    iC = 0;
                }
                f1 f1VarJ = fVar.j(sVar2);
                if (f1VarJ == null) {
                    fVar.i(sVar2);
                    v1.s0 s0VarQ = ab.b.q(fVar.f(sVar2), b0Var.f6924t.u());
                    try {
                        r rVar = sVar2.f7160d;
                        y1.d.h(rVar);
                        if (f1VarJ == null) {
                            sVar = sVar2;
                            f1Var = f1VarF;
                        } else {
                            sVar = sVar2;
                            f1Var = f1VarJ;
                        }
                        try {
                            rVar.i(iC, f1Var, s0VarQ, z10, z11);
                        } catch (DeadObjectException unused) {
                            d1Var.f6944e.p(sVar);
                        } catch (RemoteException e9) {
                            e = e9;
                            y1.b.q("MediaSessionImpl", "Exception in " + sVar, e);
                        }
                    } catch (DeadObjectException unused2) {
                        sVar = sVar2;
                    } catch (RemoteException e10) {
                        e = e10;
                        sVar = sVar2;
                    }
                }
            } catch (DeadObjectException unused3) {
                sVar = sVar2;
            } catch (RemoteException e11) {
                e = e11;
                sVar = sVar2;
            }
        }
        this.f7191a = true;
        this.f7192b = true;
    }
}
