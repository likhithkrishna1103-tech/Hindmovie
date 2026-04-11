package s6;

import e6.l;
import e6.z;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;
import s.e;
import x6.k;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final z f11866c = new z(Object.class, Object.class, Object.class, Collections.singletonList(new l(Object.class, Object.class, Object.class, Collections.EMPTY_LIST, new q6.d(0), null)), null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f11867a = new e(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference f11868b = new AtomicReference();

    public final void a(Class cls, Class cls2, Class cls3, z zVar) {
        synchronized (this.f11867a) {
            e eVar = this.f11867a;
            k kVar = new k(cls, cls2, cls3);
            if (zVar == null) {
                zVar = f11866c;
            }
            eVar.put(kVar, zVar);
        }
    }
}
