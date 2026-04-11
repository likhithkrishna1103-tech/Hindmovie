package bf;

import androidx.media3.decoder.DecoderInputBuffer;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i extends xe.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f2078e;
    public final /* synthetic */ Object f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f2079g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(String str, Object obj, Object obj2, int i) {
        super(str, true);
        this.f2078e = i;
        this.f = obj;
        this.f2079g = obj2;
    }

    @Override // xe.a
    public final long a() {
        long jA;
        int i;
        x[] xVarArr;
        switch (this.f2078e) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                p pVar = (p) this.f;
                pVar.f2093u.a(pVar, (b0) ((be.n) this.f2079g).f2045u);
                return -1L;
            case 1:
                try {
                    ((p) this.f).f2093u.b((x) this.f2079g);
                    break;
                } catch (IOException e10) {
                    cf.n nVar = cf.n.f2753a;
                    cf.n nVar2 = cf.n.f2753a;
                    String str = "Http2Connection.Listener failure for " + ((p) this.f).f2095w;
                    nVar2.getClass();
                    cf.n.i(str, 4, e10);
                    try {
                        ((x) this.f2079g).c(2, e10);
                        break;
                    } catch (IOException unused) {
                    }
                }
                return -1L;
            default:
                k kVar = (k) this.f;
                b0 b0Var = (b0) this.f2079g;
                be.n nVar3 = new be.n();
                p pVar2 = kVar.f2084v;
                synchronized (pVar2.Q) {
                    synchronized (pVar2) {
                        try {
                            b0 b0Var2 = pVar2.K;
                            b0 b0Var3 = new b0();
                            b0Var3.b(b0Var2);
                            b0Var3.b(b0Var);
                            nVar3.f2045u = b0Var3;
                            jA = ((long) b0Var3.a()) - ((long) b0Var2.a());
                            i = 0;
                            xVarArr = (jA == 0 || pVar2.f2094v.isEmpty()) ? null : (x[]) pVar2.f2094v.values().toArray(new x[0]);
                            b0 b0Var4 = (b0) nVar3.f2045u;
                            be.h.e(b0Var4, "<set-?>");
                            pVar2.K = b0Var4;
                            pVar2.D.c(new i(pVar2.f2095w + " onSettings", pVar2, nVar3, i), 0L);
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    try {
                        pVar2.Q.a((b0) nVar3.f2045u);
                    } catch (IOException e11) {
                        pVar2.a(2, 2, e11);
                    }
                    break;
                }
                if (xVarArr != null) {
                    int length = xVarArr.length;
                    while (i < length) {
                        x xVar = xVarArr[i];
                        synchronized (xVar) {
                            xVar.f += jA;
                            if (jA > 0) {
                                xVar.notifyAll();
                            }
                        }
                        i++;
                    }
                }
                return -1L;
        }
    }
}
