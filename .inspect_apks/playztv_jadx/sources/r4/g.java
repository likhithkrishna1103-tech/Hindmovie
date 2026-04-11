package r4;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.locks.ReentrantLock;
import ke.y0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f11445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g0 f11446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f11447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ReentrantLock f11448d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f f11449e;
    public final f f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f11450g;

    /* JADX WARN: Type inference failed for: r1v4, types: [r4.f] */
    /* JADX WARN: Type inference failed for: r1v5, types: [r4.f] */
    public g(t tVar, HashMap map, HashMap map2, String... strArr) {
        this.f11445a = tVar;
        g0 g0Var = new g0(tVar, map, map2, strArr, tVar.f11499j, new y0(1, this, g.class, "notifyInvalidatedObservers", "notifyInvalidatedObservers(Ljava/util/Set;)V", 0, 0, 1));
        this.f11446b = g0Var;
        this.f11447c = new LinkedHashMap();
        this.f11448d = new ReentrantLock();
        final int i = 0;
        this.f11449e = new ae.a(this) { // from class: r4.f

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public final /* synthetic */ g f11442v;

            {
                this.f11442v = this;
            }

            @Override // ae.a
            public final Object b() {
                switch (i) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        this.f11442v.getClass();
                        break;
                    case 1:
                        this.f11442v.getClass();
                        break;
                    default:
                        g gVar = this.f11442v;
                        return Boolean.valueOf(!gVar.f11445a.k() || gVar.f11445a.o());
                }
                return nd.k.f8990a;
            }
        };
        final int i10 = 1;
        this.f = new ae.a(this) { // from class: r4.f

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public final /* synthetic */ g f11442v;

            {
                this.f11442v = this;
            }

            @Override // ae.a
            public final Object b() {
                switch (i10) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        this.f11442v.getClass();
                        break;
                    case 1:
                        this.f11442v.getClass();
                        break;
                    default:
                        g gVar = this.f11442v;
                        return Boolean.valueOf(!gVar.f11445a.k() || gVar.f11445a.o());
                }
                return nd.k.f8990a;
            }
        };
        be.h.d(Collections.newSetFromMap(new IdentityHashMap()), "newSetFromMap(...)");
        this.f11450g = new Object();
        final int i11 = 2;
        g0Var.f11459j = new ae.a(this) { // from class: r4.f

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public final /* synthetic */ g f11442v;

            {
                this.f11442v = this;
            }

            @Override // ae.a
            public final Object b() {
                switch (i11) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        this.f11442v.getClass();
                        break;
                    case 1:
                        this.f11442v.getClass();
                        break;
                    default:
                        g gVar = this.f11442v;
                        return Boolean.valueOf(!gVar.f11445a.k() || gVar.f11445a.o());
                }
                return nd.k.f8990a;
            }
        };
    }
}
