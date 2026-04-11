package pd;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.AbstractList;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements ListIterator, ce.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f10337v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f10339x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final od.d f10340y;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f10336u = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f10338w = -1;

    public a(c cVar, int i) {
        this.f10340y = cVar;
        this.f10337v = i;
        this.f10339x = ((AbstractList) cVar).modCount;
    }

    public void a() {
        if (((AbstractList) ((b) this.f10340y).f10345y).modCount != this.f10339x) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        switch (this.f10336u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                a();
                b bVar = (b) this.f10340y;
                int i = this.f10337v;
                this.f10337v = i + 1;
                bVar.add(i, obj);
                this.f10338w = -1;
                this.f10339x = ((AbstractList) bVar).modCount;
                break;
            default:
                b();
                c cVar = (c) this.f10340y;
                int i10 = this.f10337v;
                this.f10337v = i10 + 1;
                cVar.add(i10, obj);
                this.f10338w = -1;
                this.f10339x = ((AbstractList) cVar).modCount;
                break;
        }
    }

    public void b() {
        if (((AbstractList) ((c) this.f10340y)).modCount != this.f10339x) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        switch (this.f10336u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (this.f10337v < ((b) this.f10340y).f10343w) {
                }
                break;
            default:
                if (this.f10337v < ((c) this.f10340y).f10348v) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        switch (this.f10336u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (this.f10337v > 0) {
                }
                break;
            default:
                if (this.f10337v > 0) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        switch (this.f10336u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                a();
                int i = this.f10337v;
                b bVar = (b) this.f10340y;
                if (i >= bVar.f10343w) {
                    throw new NoSuchElementException();
                }
                this.f10337v = i + 1;
                this.f10338w = i;
                return bVar.f10341u[bVar.f10342v + i];
            default:
                b();
                int i10 = this.f10337v;
                c cVar = (c) this.f10340y;
                if (i10 >= cVar.f10348v) {
                    throw new NoSuchElementException();
                }
                this.f10337v = i10 + 1;
                this.f10338w = i10;
                return cVar.f10347u[i10];
        }
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        switch (this.f10336u) {
        }
        return this.f10337v;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        switch (this.f10336u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                a();
                int i = this.f10337v;
                if (i <= 0) {
                    throw new NoSuchElementException();
                }
                int i10 = i - 1;
                this.f10337v = i10;
                this.f10338w = i10;
                b bVar = (b) this.f10340y;
                return bVar.f10341u[bVar.f10342v + i10];
            default:
                b();
                int i11 = this.f10337v;
                if (i11 <= 0) {
                    throw new NoSuchElementException();
                }
                int i12 = i11 - 1;
                this.f10337v = i12;
                this.f10338w = i12;
                return ((c) this.f10340y).f10347u[i12];
        }
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        int i;
        switch (this.f10336u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                i = this.f10337v;
                break;
            default:
                i = this.f10337v;
                break;
        }
        return i - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        switch (this.f10336u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                b bVar = (b) this.f10340y;
                a();
                int i = this.f10338w;
                if (i == -1) {
                    throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
                }
                bVar.d(i);
                this.f10337v = this.f10338w;
                this.f10338w = -1;
                this.f10339x = ((AbstractList) bVar).modCount;
                return;
            default:
                c cVar = (c) this.f10340y;
                b();
                int i10 = this.f10338w;
                if (i10 == -1) {
                    throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
                }
                cVar.d(i10);
                this.f10337v = this.f10338w;
                this.f10338w = -1;
                this.f10339x = ((AbstractList) cVar).modCount;
                return;
        }
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        switch (this.f10336u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                a();
                int i = this.f10338w;
                if (i == -1) {
                    throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
                }
                ((b) this.f10340y).set(i, obj);
                return;
            default:
                b();
                int i10 = this.f10338w;
                if (i10 == -1) {
                    throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
                }
                ((c) this.f10340y).set(i10, obj);
                return;
        }
    }

    public a(b bVar, int i) {
        this.f10340y = bVar;
        this.f10337v = i;
        this.f10339x = ((AbstractList) bVar).modCount;
    }
}
