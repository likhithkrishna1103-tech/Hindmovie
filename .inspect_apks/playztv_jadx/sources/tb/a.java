package tb;

import androidx.media3.decoder.DecoderInputBuffer;
import be.h;
import java.util.concurrent.Executor;
import ke.x;
import ma.b;
import ma.d;
import na.e;
import na.r;
import zc.c;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements e {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final a f12440v = new a(0);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final a f12441w = new a(1);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final a f12442x = new a(2);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final a f12443y = new a(3);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f12444u;

    public /* synthetic */ a(int i) {
        this.f12444u = i;
    }

    @Override // na.e
    public final Object e(c cVar) {
        switch (this.f12444u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Object objD = cVar.d(new r(ma.a.class, Executor.class));
                h.d(objD, "c.get(Qualified.qualifie…a, Executor::class.java))");
                return x.d((Executor) objD);
            case 1:
                Object objD2 = cVar.d(new r(ma.c.class, Executor.class));
                h.d(objD2, "c.get(Qualified.qualifie…a, Executor::class.java))");
                return x.d((Executor) objD2);
            case 2:
                Object objD3 = cVar.d(new r(b.class, Executor.class));
                h.d(objD3, "c.get(Qualified.qualifie…a, Executor::class.java))");
                return x.d((Executor) objD3);
            default:
                Object objD4 = cVar.d(new r(d.class, Executor.class));
                h.d(objD4, "c.get(Qualified.qualifie…a, Executor::class.java))");
                return x.d((Executor) objD4);
        }
    }
}
