package a2;

import android.os.RemoteException;
import android.util.Pair;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class o1 implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f371u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f372v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f373w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f374x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ Object f375y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ Object f376z;

    public /* synthetic */ o1(q1 q1Var, Pair pair, o2.u uVar, o2.z zVar, int i) {
        this.f373w = q1Var;
        this.f374x = pair;
        this.f375y = uVar;
        this.f376z = zVar;
        this.f372v = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f371u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                q1 q1Var = (q1) this.f373w;
                Pair pair = (Pair) this.f374x;
                ((b2.h) q1Var.f389v.i).J(((Integer) pair.first).intValue(), (o2.d0) pair.second, (o2.u) this.f375y, (o2.z) this.f376z, this.f372v);
                break;
            default:
                g4.m0 m0Var = (g4.m0) this.f373w;
                g4.m1 m1Var = (g4.m1) this.f374x;
                h4.b0 b0Var = (h4.b0) this.f375y;
                g4.l0 l0Var = (g4.l0) this.f376z;
                ub.o oVar = m0Var.f;
                if (!m0Var.f5115g.j()) {
                    boolean zIsActive = ((h4.t) m0Var.f5118k.f5867v).f5847a.isActive();
                    int i = this.f372v;
                    if (!zIsActive) {
                        StringBuilder sb2 = new StringBuilder("Ignore incoming session command before initialization. command=");
                        sb2.append(m1Var == null ? Integer.valueOf(i) : m1Var.f5135b);
                        sb2.append(", pid=");
                        sb2.append(b0Var.f5792a.f5794b);
                        s1.b.p("MediaSessionLegacyStub", sb2.toString());
                    } else {
                        g4.s sVarL = m0Var.L(b0Var);
                        if (m1Var != null) {
                            if (!oVar.I(sVarL, m1Var)) {
                            }
                        } else if (!oVar.H(sVarL, i)) {
                        }
                        try {
                            l0Var.d(sVarL);
                        } catch (RemoteException e10) {
                            s1.b.q("MediaSessionLegacyStub", "Exception in " + sVarL, e10);
                        }
                    }
                    break;
                }
                break;
        }
    }

    public /* synthetic */ o1(g4.m0 m0Var, g4.m1 m1Var, int i, h4.b0 b0Var, g4.l0 l0Var) {
        this.f373w = m0Var;
        this.f374x = m1Var;
        this.f372v = i;
        this.f375y = b0Var;
        this.f376z = l0Var;
    }
}
