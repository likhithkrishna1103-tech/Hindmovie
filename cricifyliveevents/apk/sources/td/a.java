package td;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.AbstractList;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements ListIterator, he.a {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f11989w;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f11991y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final sd.e f11992z;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f11988v = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f11990x = -1;

    public a(c cVar, int i) {
        this.f11992z = cVar;
        this.f11989w = i;
        this.f11991y = ((AbstractList) cVar).modCount;
    }

    public void a() {
        if (((AbstractList) ((b) this.f11992z).f11997z).modCount != this.f11991y) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        switch (this.f11988v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                a();
                b bVar = (b) this.f11992z;
                int i = this.f11989w;
                this.f11989w = i + 1;
                bVar.add(i, obj);
                this.f11990x = -1;
                this.f11991y = ((AbstractList) bVar).modCount;
                break;
            default:
                b();
                c cVar = (c) this.f11992z;
                int i10 = this.f11989w;
                this.f11989w = i10 + 1;
                cVar.add(i10, obj);
                this.f11990x = -1;
                this.f11991y = ((AbstractList) cVar).modCount;
                break;
        }
    }

    public void b() {
        if (((AbstractList) ((c) this.f11992z)).modCount != this.f11991y) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        switch (this.f11988v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (this.f11989w < ((b) this.f11992z).f11995x) {
                }
                break;
            default:
                if (this.f11989w < ((c) this.f11992z).f12000w) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        switch (this.f11988v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (this.f11989w > 0) {
                }
                break;
            default:
                if (this.f11989w > 0) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        switch (this.f11988v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                a();
                int i = this.f11989w;
                b bVar = (b) this.f11992z;
                if (i >= bVar.f11995x) {
                    throw new NoSuchElementException();
                }
                this.f11989w = i + 1;
                this.f11990x = i;
                return bVar.f11993v[bVar.f11994w + i];
            default:
                b();
                int i10 = this.f11989w;
                c cVar = (c) this.f11992z;
                if (i10 >= cVar.f12000w) {
                    throw new NoSuchElementException();
                }
                this.f11989w = i10 + 1;
                this.f11990x = i10;
                return cVar.f11999v[i10];
        }
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        switch (this.f11988v) {
        }
        return this.f11989w;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        switch (this.f11988v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                a();
                int i = this.f11989w;
                if (i <= 0) {
                    throw new NoSuchElementException();
                }
                int i10 = i - 1;
                this.f11989w = i10;
                this.f11990x = i10;
                b bVar = (b) this.f11992z;
                return bVar.f11993v[bVar.f11994w + i10];
            default:
                b();
                int i11 = this.f11989w;
                if (i11 <= 0) {
                    throw new NoSuchElementException();
                }
                int i12 = i11 - 1;
                this.f11989w = i12;
                this.f11990x = i12;
                return ((c) this.f11992z).f11999v[i12];
        }
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        int i;
        switch (this.f11988v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                i = this.f11989w;
                break;
            default:
                i = this.f11989w;
                break;
        }
        return i - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        switch (this.f11988v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                b bVar = (b) this.f11992z;
                a();
                int i = this.f11990x;
                if (i == -1) {
                    throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
                }
                bVar.b(i);
                this.f11989w = this.f11990x;
                this.f11990x = -1;
                this.f11991y = ((AbstractList) bVar).modCount;
                return;
            default:
                c cVar = (c) this.f11992z;
                b();
                int i10 = this.f11990x;
                if (i10 == -1) {
                    throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
                }
                cVar.b(i10);
                this.f11989w = this.f11990x;
                this.f11990x = -1;
                this.f11991y = ((AbstractList) cVar).modCount;
                return;
        }
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        switch (this.f11988v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                a();
                int i = this.f11990x;
                if (i == -1) {
                    throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
                }
                ((b) this.f11992z).set(i, obj);
                return;
            default:
                b();
                int i10 = this.f11990x;
                if (i10 == -1) {
                    throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
                }
                ((c) this.f11992z).set(i10, obj);
                return;
        }
    }

    public a(b bVar, int i) {
        this.f11992z = bVar;
        this.f11989w = i;
        this.f11991y = ((AbstractList) bVar).modCount;
    }
}
