package me;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f8454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8455b;

    public b(e eVar, int i) {
        this.f8454a = eVar;
        this.f8455b = i;
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i + '.').toString());
    }

    @Override // me.e
    public final Iterator iterator() {
        return new ge.b(this);
    }
}
