package n7;

import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;
import s7.k;
import v.e;
import z6.l;
import z6.z;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final z f8850c = new z(Object.class, Object.class, Object.class, Collections.singletonList(new l(Object.class, Object.class, Object.class, Collections.EMPTY_LIST, new l7.d(0), null)), null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f8851a = new e(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference f8852b = new AtomicReference();

    public final void a(Class cls, Class cls2, Class cls3, z zVar) {
        synchronized (this.f8851a) {
            e eVar = this.f8851a;
            k kVar = new k(cls, cls2, cls3);
            if (zVar == null) {
                zVar = f8850c;
            }
            eVar.put(kVar, zVar);
        }
    }
}
