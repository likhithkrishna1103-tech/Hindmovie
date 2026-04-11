package ua;

import androidx.media3.decoder.DecoderInputBuffer;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n extends AbstractCollection {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f12361v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Object f12362w;

    public /* synthetic */ n(int i, Serializable serializable) {
        this.f12361v = i;
        this.f12362w = serializable;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        switch (this.f12361v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((v0) this.f12362w).b();
                break;
            case 1:
                ((u) this.f12362w).clear();
                break;
            default:
                ((d) this.f12362w).clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        switch (this.f12361v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Iterator it = ((v0) this.f12362w).a().values().iterator();
                while (it.hasNext()) {
                    if (((Collection) it.next()).contains(obj)) {
                        return true;
                    }
                }
                return false;
            case 1:
            default:
                return super.contains(obj);
            case 2:
                return ((d) this.f12362w).containsValue(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        switch (this.f12361v) {
            case 2:
                return ((d) this.f12362w).isEmpty();
            default:
                return super.isEmpty();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f12361v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new a((v0) this.f12362w);
            case 1:
                u uVar = (u) this.f12362w;
                Map mapB = uVar.b();
                return mapB != null ? mapB.values().iterator() : new r(uVar, 2);
            default:
                return new t0(((d) this.f12362w).entrySet().iterator());
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        switch (this.f12361v) {
            case 2:
                d dVar = (d) this.f12362w;
                try {
                    return super.remove(obj);
                } catch (UnsupportedOperationException unused) {
                    for (Map.Entry entry : dVar.entrySet()) {
                        if (com.bumptech.glide.c.h(obj, entry.getValue())) {
                            dVar.remove(entry.getKey());
                            return true;
                        }
                    }
                    return false;
                }
            default:
                return super.remove(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection collection) {
        switch (this.f12361v) {
            case 2:
                d dVar = (d) this.f12362w;
                try {
                    collection.getClass();
                    return super.removeAll(collection);
                } catch (UnsupportedOperationException unused) {
                    HashSet hashSet = new HashSet();
                    for (Map.Entry entry : dVar.entrySet()) {
                        if (collection.contains(entry.getValue())) {
                            hashSet.add(entry.getKey());
                        }
                    }
                    return dVar.keySet().removeAll(hashSet);
                }
            default:
                return super.removeAll(collection);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection collection) {
        switch (this.f12361v) {
            case 2:
                d dVar = (d) this.f12362w;
                try {
                    collection.getClass();
                    return super.retainAll(collection);
                } catch (UnsupportedOperationException unused) {
                    HashSet hashSet = new HashSet();
                    for (Map.Entry entry : dVar.entrySet()) {
                        if (collection.contains(entry.getValue())) {
                            hashSet.add(entry.getKey());
                        }
                    }
                    return dVar.keySet().retainAll(hashSet);
                }
            default:
                return super.retainAll(collection);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        switch (this.f12361v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ((v0) this.f12362w).f12402z;
            case 1:
                return ((u) this.f12362w).size();
            default:
                return ((d) this.f12362w).f12316x.size();
        }
    }

    public n(d dVar) {
        this.f12361v = 2;
        this.f12362w = dVar;
    }
}
