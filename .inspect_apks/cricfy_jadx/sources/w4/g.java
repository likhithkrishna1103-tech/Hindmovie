package w4;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f13936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l0 f13937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f13938c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ReentrantLock f13939d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f f13940e;
    public final f f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f13941g;

    /* JADX WARN: Type inference failed for: r1v4, types: [w4.f] */
    /* JADX WARN: Type inference failed for: r1v5, types: [w4.f] */
    public g(t tVar, HashMap map, HashMap map2, String... strArr) {
        this.f13936a = tVar;
        l0 l0Var = new l0(tVar, map, map2, strArr, tVar.f13997j, new hf.h(1, this, g.class, "notifyInvalidatedObservers", "notifyInvalidatedObservers(Ljava/util/Set;)V", 0, 0, 2));
        this.f13937b = l0Var;
        this.f13938c = new LinkedHashMap();
        this.f13939d = new ReentrantLock();
        final int i = 0;
        this.f13940e = new fe.a(this) { // from class: w4.f

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public final /* synthetic */ g f13933w;

            {
                this.f13933w = this;
            }

            @Override // fe.a
            public final Object b() {
                switch (i) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        this.f13933w.getClass();
                        break;
                    case 1:
                        this.f13933w.getClass();
                        break;
                    default:
                        g gVar = this.f13933w;
                        return Boolean.valueOf(!gVar.f13936a.m() || gVar.f13936a.p());
                }
                return rd.l.f11003a;
            }
        };
        final int i10 = 1;
        this.f = new fe.a(this) { // from class: w4.f

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public final /* synthetic */ g f13933w;

            {
                this.f13933w = this;
            }

            @Override // fe.a
            public final Object b() {
                switch (i10) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        this.f13933w.getClass();
                        break;
                    case 1:
                        this.f13933w.getClass();
                        break;
                    default:
                        g gVar = this.f13933w;
                        return Boolean.valueOf(!gVar.f13936a.m() || gVar.f13936a.p());
                }
                return rd.l.f11003a;
            }
        };
        ge.i.d(Collections.newSetFromMap(new IdentityHashMap()), "newSetFromMap(...)");
        this.f13941g = new Object();
        final int i11 = 2;
        l0Var.f13969j = new fe.a(this) { // from class: w4.f

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public final /* synthetic */ g f13933w;

            {
                this.f13933w = this;
            }

            @Override // fe.a
            public final Object b() {
                switch (i11) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        this.f13933w.getClass();
                        break;
                    case 1:
                        this.f13933w.getClass();
                        break;
                    default:
                        g gVar = this.f13933w;
                        return Boolean.valueOf(!gVar.f13936a.m() || gVar.f13936a.p());
                }
                return rd.l.f11003a;
            }
        };
    }
}
