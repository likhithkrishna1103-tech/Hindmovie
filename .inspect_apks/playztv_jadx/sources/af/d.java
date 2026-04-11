package af;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import ue.o;
import ye.k;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d extends b {
    public final /* synthetic */ h A;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final o f804x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f805y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f806z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(h hVar, o oVar) {
        super(hVar);
        be.h.e(oVar, "url");
        this.A = hVar;
        this.f804x = oVar;
        this.f805y = -1L;
        this.f806z = true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        boolean zS;
        if (this.f799v) {
            return;
        }
        if (this.f806z) {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            byte[] bArr = ve.b.f13497a;
            be.h.e(timeUnit, "timeUnit");
            try {
                zS = ve.b.s(this, 100);
            } catch (IOException unused) {
                zS = false;
            }
            if (!zS) {
                ((k) this.A.f815c).l();
                a();
            }
        }
        this.f799v = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0081, code lost:
    
        if (r9.f806z == false) goto L28;
     */
    @Override // af.b, hf.w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long l(long r10, hf.f r12) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 218
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: af.d.l(long, hf.f):long");
    }
}
