package ke;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class y0 extends be.g implements ae.l {
    public final /* synthetic */ int C;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ y0(int i, Object obj, Class cls, String str, String str2, int i10, int i11, int i12) {
        super(i, obj, cls, str, str2, i10, i11);
        this.C = i12;
    }

    @Override // ae.l
    public final Object a(Object obj) {
        switch (this.C) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((z0) this.f2033v).l((Throwable) obj);
                return nd.k.f8990a;
            default:
                be.h.e((Set) obj, "p0");
                r4.g gVar = (r4.g) this.f2033v;
                ReentrantLock reentrantLock = gVar.f11448d;
                reentrantLock.lock();
                try {
                    List listH0 = od.i.h0(gVar.f11447c.values());
                    reentrantLock.unlock();
                    Iterator it = listH0.iterator();
                    if (!it.hasNext()) {
                        return nd.k.f8990a;
                    }
                    ((r4.k) it.next()).getClass();
                    throw null;
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
        }
    }
}
