package g2;

import android.os.RemoteException;
import android.util.Pair;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c1 implements Runnable {
    public final /* synthetic */ Object A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4639v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ int f4640w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f4641x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ Object f4642y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ Object f4643z;

    public /* synthetic */ c1(e1 e1Var, Pair pair, s2.t tVar, s2.y yVar, int i) {
        this.f4641x = e1Var;
        this.f4642y = pair;
        this.f4643z = tVar;
        this.A = yVar;
        this.f4640w = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4639v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                e1 e1Var = (e1) this.f4641x;
                Pair pair = (Pair) this.f4642y;
                ((h2.f) e1Var.f4667w.i).o(((Integer) pair.first).intValue(), (s2.c0) pair.second, (s2.t) this.f4643z, (s2.y) this.A, this.f4640w);
                break;
            default:
                k4.l0 l0Var = (k4.l0) this.f4641x;
                k4.k1 k1Var = (k4.k1) this.f4642y;
                l4.e0 e0Var = (l4.e0) this.f4643z;
                k4.k0 k0Var = (k4.k0) this.A;
                b6.f fVar = l0Var.f;
                if (!l0Var.f7060g.j()) {
                    boolean zIsActive = ((l4.w) l0Var.f7063k.f7705w).f7765a.isActive();
                    int i = this.f4640w;
                    if (!zIsActive) {
                        StringBuilder sb = new StringBuilder("Ignore incoming session command before initialization. command=");
                        sb.append(k1Var == null ? Integer.valueOf(i) : k1Var.f7056b);
                        sb.append(", pid=");
                        sb.append(e0Var.f7710a.f7713b);
                        y1.b.p("MediaSessionLegacyStub", sb.toString());
                    } else {
                        k4.s sVarL = l0Var.L(e0Var);
                        if (k1Var != null) {
                            if (!fVar.o(sVarL, k1Var)) {
                            }
                        } else if (!fVar.n(sVarL, i)) {
                        }
                        try {
                            k0Var.d(sVarL);
                        } catch (RemoteException e9) {
                            y1.b.q("MediaSessionLegacyStub", "Exception in " + sVarL, e9);
                        }
                    }
                    break;
                }
                break;
        }
    }

    public /* synthetic */ c1(k4.l0 l0Var, k4.k1 k1Var, int i, l4.e0 e0Var, k4.k0 k0Var) {
        this.f4641x = l0Var;
        this.f4642y = k1Var;
        this.f4640w = i;
        this.f4643z = e0Var;
        this.A = k0Var;
    }
}
