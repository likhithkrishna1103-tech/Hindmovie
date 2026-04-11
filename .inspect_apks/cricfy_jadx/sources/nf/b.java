package nf;

import androidx.media3.decoder.DecoderInputBuffer;
import f9.x0;
import ge.i;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import lf.f;
import of.o;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f9152e = 1;
    public final /* synthetic */ Object f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(x0 x0Var, String str) {
        super(str);
        this.f = x0Var;
    }

    @Override // nf.a
    public final long a() {
        o oVar;
        switch (this.f9152e) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((fe.a) this.f).b();
                return -1L;
            default:
                x0 x0Var = (x0) this.f;
                long jNanoTime = System.nanoTime();
                long j4 = (jNanoTime - x0Var.f4471b) + 1;
                Iterator it = ((ConcurrentLinkedQueue) x0Var.f4474e).iterator();
                i.d(it, "iterator(...)");
                long j7 = Long.MAX_VALUE;
                int i = 0;
                int i10 = 0;
                o oVar2 = null;
                o oVar3 = null;
                while (it.hasNext()) {
                    o oVar4 = (o) it.next();
                    i.b(oVar4);
                    synchronized (oVar4) {
                        if (x0Var.a(oVar4, jNanoTime) > 0) {
                            i10++;
                        } else {
                            long j10 = j7;
                            long j11 = oVar4.f9835q;
                            if (j11 < j4) {
                                j4 = j11;
                                oVar2 = oVar4;
                            }
                            i++;
                            if (j11 < j10) {
                                j7 = j11;
                                oVar3 = oVar4;
                            } else {
                                j7 = j10;
                            }
                        }
                    }
                }
                long j12 = j7;
                if (oVar2 != null) {
                    oVar = oVar2;
                } else if (i > 5) {
                    oVar = oVar3;
                    j4 = j12;
                } else {
                    j4 = -1;
                    oVar = null;
                }
                if (oVar == null) {
                    if (oVar3 != null) {
                        return (j12 + x0Var.f4471b) - jNanoTime;
                    }
                    if (i10 > 0) {
                        return x0Var.f4471b;
                    }
                    return -1L;
                }
                synchronized (oVar) {
                    if (oVar.f9834p.isEmpty() && oVar.f9835q == j4) {
                        oVar.f9828j = true;
                        ((ConcurrentLinkedQueue) x0Var.f4474e).remove(oVar);
                        f.b(oVar.f9825e);
                        if (!((ConcurrentLinkedQueue) x0Var.f4474e).isEmpty()) {
                            return 0L;
                        }
                        ((c) x0Var.f4472c).a();
                        return 0L;
                    }
                    return 0L;
                }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String str, fe.a aVar) {
        super(str);
        this.f = aVar;
    }
}
