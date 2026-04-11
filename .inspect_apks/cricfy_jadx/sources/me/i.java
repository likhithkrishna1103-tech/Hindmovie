package me;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements Iterable, he.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ d f8468v;

    public i(d dVar) {
        this.f8468v = dVar;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new ne.b(this.f8468v);
    }
}
