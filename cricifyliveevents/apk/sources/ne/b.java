package ne;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Iterator, he.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f9131v = -1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f9132w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f9133x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ke.c f9134y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ me.d f9135z;

    public b(me.d dVar) {
        this.f9135z = dVar;
        int length = ((CharSequence) dVar.f8460b).length();
        if (length < 0) {
            throw new IllegalArgumentException(l0.e.h(length, "Cannot coerce value to an empty range: maximum ", " is less than minimum 0."));
        }
        length = length >= 0 ? 0 : length;
        this.f9132w = length;
        this.f9133x = length;
    }

    public final void a() {
        rd.f fVar;
        me.d dVar = this.f9135z;
        CharSequence charSequence = (CharSequence) dVar.f8460b;
        int i = this.f9133x;
        if (i < 0) {
            this.f9131v = 0;
            this.f9134y = null;
            return;
        }
        if (i <= charSequence.length() && (fVar = (rd.f) ((p) dVar.f8461c).j(charSequence, Integer.valueOf(this.f9133x))) != null) {
            int iIntValue = ((Number) fVar.f10993v).intValue();
            int iIntValue2 = ((Number) fVar.f10994w).intValue();
            this.f9134y = com.bumptech.glide.f.I(this.f9132w, iIntValue);
            int i10 = iIntValue + iIntValue2;
            this.f9132w = i10;
            this.f9133x = i10 + (iIntValue2 == 0 ? 1 : 0);
        } else {
            this.f9134y = new ke.c(this.f9132w, h.f0(charSequence), 1);
            this.f9133x = -1;
        }
        this.f9131v = 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f9131v == -1) {
            a();
        }
        return this.f9131v == 1;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f9131v == -1) {
            a();
        }
        if (this.f9131v == 0) {
            throw new NoSuchElementException();
        }
        ke.c cVar = this.f9134y;
        ge.i.c(cVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
        this.f9134y = null;
        this.f9131v = -1;
        return cVar;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
