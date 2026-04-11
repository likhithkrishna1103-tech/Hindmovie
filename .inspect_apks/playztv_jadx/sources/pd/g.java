package pd;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g extends od.e {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f10360u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final f f10361v;

    public /* synthetic */ g(f fVar, int i) {
        this.f10360u = i;
        this.f10361v = fVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        switch (this.f10360u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                be.h.e((Map.Entry) obj, "element");
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        switch (this.f10360u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                be.h.e(collection, "elements");
                throw new UnsupportedOperationException();
            default:
                be.h.e(collection, "elements");
                throw new UnsupportedOperationException();
        }
    }

    @Override // od.e
    public final int b() {
        switch (this.f10360u) {
        }
        return this.f10361v.C;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.f10360u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f10361v.clear();
                break;
            default:
                this.f10361v.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        switch (this.f10360u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                return this.f10361v.e((Map.Entry) obj);
            default:
                return this.f10361v.containsKey(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        switch (this.f10360u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                be.h.e(collection, "elements");
                return this.f10361v.d(collection);
            default:
                return super.containsAll(collection);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        switch (this.f10360u) {
        }
        return this.f10361v.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f10360u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                f fVar = this.f10361v;
                fVar.getClass();
                return new d(fVar, 0);
            default:
                f fVar2 = this.f10361v;
                fVar2.getClass();
                return new d(fVar2, 1);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        switch (this.f10360u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    f fVar = this.f10361v;
                    fVar.getClass();
                    fVar.b();
                    int iG = fVar.g(entry.getKey());
                    if (iG >= 0) {
                        Object[] objArr = fVar.f10355v;
                        be.h.b(objArr);
                        if (be.h.a(objArr[iG], entry.getValue())) {
                            fVar.k(iG);
                            break;
                        }
                    }
                }
                break;
            default:
                f fVar2 = this.f10361v;
                fVar2.b();
                int iG2 = fVar2.g(obj);
                if (iG2 >= 0) {
                    fVar2.k(iG2);
                    break;
                }
                break;
        }
        return true;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        switch (this.f10360u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                be.h.e(collection, "elements");
                this.f10361v.b();
                break;
            default:
                be.h.e(collection, "elements");
                this.f10361v.b();
                break;
        }
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        switch (this.f10360u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                be.h.e(collection, "elements");
                this.f10361v.b();
                break;
            default:
                be.h.e(collection, "elements");
                this.f10361v.b();
                break;
        }
        return super.retainAll(collection);
    }
}
