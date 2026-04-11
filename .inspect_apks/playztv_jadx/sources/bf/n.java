package bf;

import androidx.media3.decoder.DecoderInputBuffer;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ConcurrentLinkedQueue;
import k8.t0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n extends xe.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f2090e;
    public final /* synthetic */ Object f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(String str, Object obj, int i) {
        super(str, true);
        this.f2090e = i;
        this.f = obj;
    }

    @Override // xe.a
    public final long a() {
        switch (this.f2090e) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                p pVar = (p) this.f;
                pVar.getClass();
                try {
                    pVar.Q.G(2, 0, false);
                    return -1L;
                } catch (IOException e10) {
                    pVar.a(2, 2, e10);
                    return -1L;
                }
            case 1:
                ((ae.a) this.f).b();
                return -1L;
            default:
                t0 t0Var = (t0) this.f;
                long jNanoTime = System.nanoTime();
                int i = 0;
                long j5 = Long.MIN_VALUE;
                ye.k kVar = null;
                int i10 = 0;
                for (ye.k kVar2 : (ConcurrentLinkedQueue) t0Var.f7429e) {
                    be.h.d(kVar2, "connection");
                    synchronized (kVar2) {
                        if (t0Var.b(kVar2, jNanoTime) > 0) {
                            i10++;
                        } else {
                            i++;
                            long j8 = jNanoTime - kVar2.f14741q;
                            if (j8 > j5) {
                                kVar = kVar2;
                                j5 = j8;
                            }
                        }
                    }
                }
                long j10 = t0Var.f7426b;
                if (j5 < j10 && i <= 5) {
                    if (i > 0) {
                        return j10 - j5;
                    }
                    if (i10 > 0) {
                        return j10;
                    }
                    return -1L;
                }
                be.h.b(kVar);
                synchronized (kVar) {
                    if (!kVar.f14740p.isEmpty()) {
                        return 0L;
                    }
                    if (kVar.f14741q + j5 != jNanoTime) {
                        return 0L;
                    }
                    kVar.f14734j = true;
                    ((ConcurrentLinkedQueue) t0Var.f7429e).remove(kVar);
                    Socket socket = kVar.f14730d;
                    be.h.b(socket);
                    ve.b.d(socket);
                    if (!((ConcurrentLinkedQueue) t0Var.f7429e).isEmpty()) {
                        return 0L;
                    }
                    ((xe.b) t0Var.f7427c).a();
                    return 0L;
                }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(t0 t0Var, String str) {
        super(str, true);
        this.f2090e = 2;
        this.f = t0Var;
    }
}
