package qc;

import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements n8.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReference f10797a = new AtomicReference();

    @Override // n8.b
    public final void a(boolean z10) {
        Random random = i.f10798j;
        synchronized (i.class) {
            Iterator it = i.f10799k.values().iterator();
            while (it.hasNext()) {
                ((b) it.next()).a(z10);
            }
        }
    }
}
