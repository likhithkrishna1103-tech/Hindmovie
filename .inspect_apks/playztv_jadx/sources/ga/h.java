package ga;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.concurrent.Executor;
import ke.x;
import na.r;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h implements na.e {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final h f5354v = new h(0);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final h f5355w = new h(1);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final h f5356x = new h(2);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final h f5357y = new h(3);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f5358u;

    public /* synthetic */ h(int i) {
        this.f5358u = i;
    }

    @Override // na.e
    public final Object e(zc.c cVar) {
        switch (this.f5358u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Object objD = cVar.d(new r(ma.a.class, Executor.class));
                be.h.d(objD, "c.get(Qualified.qualifie…a, Executor::class.java))");
                return x.d((Executor) objD);
            case 1:
                Object objD2 = cVar.d(new r(ma.c.class, Executor.class));
                be.h.d(objD2, "c.get(Qualified.qualifie…a, Executor::class.java))");
                return x.d((Executor) objD2);
            case 2:
                Object objD3 = cVar.d(new r(ma.b.class, Executor.class));
                be.h.d(objD3, "c.get(Qualified.qualifie…a, Executor::class.java))");
                return x.d((Executor) objD3);
            default:
                Object objD4 = cVar.d(new r(ma.d.class, Executor.class));
                be.h.d(objD4, "c.get(Qualified.qualifie…a, Executor::class.java))");
                return x.d((Executor) objD4);
        }
    }
}
