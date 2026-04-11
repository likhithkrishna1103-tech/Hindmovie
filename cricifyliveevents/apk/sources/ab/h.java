package ab;

import androidx.media3.decoder.DecoderInputBuffer;
import hb.r;
import java.util.concurrent.Executor;
import pe.x;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements hb.e {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final h f398w = new h(0);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final h f399x = new h(1);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final h f400y = new h(2);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final h f401z = new h(3);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f402v;

    public /* synthetic */ h(int i) {
        this.f402v = i;
    }

    @Override // hb.e
    public final Object e(dd.c cVar) {
        switch (this.f402v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Object objF = cVar.f(new r(gb.a.class, Executor.class));
                ge.i.d(objF, "get(...)");
                return x.e((Executor) objF);
            case 1:
                Object objF2 = cVar.f(new r(gb.c.class, Executor.class));
                ge.i.d(objF2, "get(...)");
                return x.e((Executor) objF2);
            case 2:
                Object objF3 = cVar.f(new r(gb.b.class, Executor.class));
                ge.i.d(objF3, "get(...)");
                return x.e((Executor) objF3);
            default:
                Object objF4 = cVar.f(new r(gb.d.class, Executor.class));
                ge.i.d(objF4, "get(...)");
                return x.e((Executor) objF4);
        }
    }
}
