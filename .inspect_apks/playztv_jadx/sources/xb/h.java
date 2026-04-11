package xb;

import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h implements s7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReference f14346a = new AtomicReference();

    @Override // s7.b
    public final void a(boolean z2) {
        Random random = i.f14347j;
        synchronized (i.class) {
            Iterator it = i.f14348k.values().iterator();
            while (it.hasNext()) {
                ((b) it.next()).b(z2);
            }
        }
    }
}
