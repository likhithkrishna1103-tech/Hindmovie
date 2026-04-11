package me;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f8453a;

    public a(e eVar) {
        this.f8453a = new AtomicReference(eVar);
    }

    @Override // me.e
    public final Iterator iterator() {
        e eVar = (e) this.f8453a.getAndSet(null);
        if (eVar != null) {
            return eVar.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
