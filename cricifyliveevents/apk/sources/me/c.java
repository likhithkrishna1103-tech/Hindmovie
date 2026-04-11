package me;

import c.x;
import df.l;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Iterator, he.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object f8456v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f8457w = -2;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ d f8458x;

    public c(d dVar) {
        this.f8458x = dVar;
    }

    public final void a() {
        Object objA;
        int i = this.f8457w;
        d dVar = this.f8458x;
        if (i == -2) {
            objA = ((x) dVar.f8460b).b();
        } else {
            l lVar = (l) dVar.f8461c;
            Object obj = this.f8456v;
            ge.i.b(obj);
            objA = lVar.a(obj);
        }
        this.f8456v = objA;
        this.f8457w = objA == null ? 0 : 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f8457w < 0) {
            a();
        }
        return this.f8457w == 1;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f8457w < 0) {
            a();
        }
        if (this.f8457w == 0) {
            throw new NoSuchElementException();
        }
        Object obj = this.f8456v;
        ge.i.c(obj, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
        this.f8457w = -1;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
