package g4;

import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class y extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f5253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b0 f5254c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(b0 b0Var, Looper looper) {
        super(looper);
        this.f5254c = b0Var;
        this.f5252a = true;
        this.f5253b = true;
    }

    public final void a(boolean z2, boolean z10) {
        boolean z11 = false;
        this.f5252a = this.f5252a && z2;
        if (this.f5253b && z10) {
            z11 = true;
        }
        this.f5253b = z11;
        if (hasMessages(1)) {
            return;
        }
        sendEmptyMessage(1);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        s sVar;
        int iC;
        h1 h1Var;
        b0 b0Var = this.f5254c;
        f1 f1Var = b0Var.f4961g;
        if (message.what != 1) {
            throw new IllegalStateException("Invalid message what=" + message.what);
        }
        h1 h1VarC = b0Var.f4972s.c(b0Var.f4973t.x(), b0Var.f4973t.b(), b0Var.f4972s.f5068k);
        b0Var.f4972s = h1VarC;
        boolean z2 = this.f5252a;
        boolean z10 = this.f5253b;
        h1 h1VarE = f1Var.e(h1VarC);
        ub.o oVar = f1Var.f5006e;
        aa.j0 j0VarW = oVar.w();
        for (int i = 0; i < j0VarW.size(); i++) {
            s sVar2 = (s) j0VarW.get(i);
            try {
                l1 l1VarC = oVar.C(sVar2);
                if (l1VarC != null) {
                    iC = l1VarC.c();
                } else if (!b0Var.h(sVar2)) {
                    break;
                } else {
                    iC = 0;
                }
                h1 h1VarB = oVar.B(sVar2);
                if (h1VarB == null) {
                    oVar.A(sVar2);
                    p1.s0 s0VarN = z7.a.n(oVar.v(sVar2), b0Var.f4973t.w());
                    try {
                        r rVar = sVar2.f5202d;
                        s1.d.h(rVar);
                        if (h1VarB == null) {
                            sVar = sVar2;
                            h1Var = h1VarE;
                        } else {
                            sVar = sVar2;
                            h1Var = h1VarB;
                        }
                        try {
                            rVar.k(iC, h1Var, s0VarN, z2, z10);
                        } catch (DeadObjectException unused) {
                            f1Var.f5006e.P(sVar);
                        } catch (RemoteException e10) {
                            e = e10;
                            s1.b.q("MediaSessionImpl", "Exception in " + sVar, e);
                        }
                    } catch (DeadObjectException unused2) {
                        sVar = sVar2;
                    } catch (RemoteException e11) {
                        e = e11;
                        sVar = sVar2;
                    }
                }
            } catch (DeadObjectException unused3) {
                sVar = sVar2;
            } catch (RemoteException e12) {
                e = e12;
                sVar = sVar2;
            }
        }
        this.f5252a = true;
        this.f5253b = true;
    }
}
