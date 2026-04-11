package ua;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class c implements Iterator {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f12305v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Iterator f12306w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Object f12307x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ Object f12308y;

    public c(l lVar) {
        this.f12308y = lVar;
        Collection collection = lVar.f12353w;
        this.f12307x = collection;
        this.f12306w = collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    public void a() {
        l lVar = (l) this.f12308y;
        lVar.b();
        if (lVar.f12353w != ((Collection) this.f12307x)) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f12305v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                break;
            case 1:
                break;
            default:
                a();
                break;
        }
        return this.f12306w.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f12305v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Map.Entry entry = (Map.Entry) this.f12306w.next();
                this.f12307x = (Collection) entry.getValue();
                return ((d) this.f12308y).a(entry);
            case 1:
                Map.Entry entry2 = (Map.Entry) this.f12306w.next();
                this.f12307x = entry2;
                return entry2.getKey();
            default:
                a();
                return this.f12306w.next();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f12305v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                com.bumptech.glide.d.k("no calls to next() since the last call to remove()", ((Collection) this.f12307x) != null);
                this.f12306w.remove();
                ((d) this.f12308y).f12317y.f12402z -= ((Collection) this.f12307x).size();
                ((Collection) this.f12307x).clear();
                this.f12307x = null;
                break;
            case 1:
                com.bumptech.glide.d.k("no calls to next() since the last call to remove()", ((Map.Entry) this.f12307x) != null);
                Collection collection = (Collection) ((Map.Entry) this.f12307x).getValue();
                this.f12306w.remove();
                ((e) this.f12308y).f12323w.f12402z -= collection.size();
                collection.clear();
                this.f12307x = null;
                break;
            default:
                this.f12306w.remove();
                l lVar = (l) this.f12308y;
                v0 v0Var = lVar.f12356z;
                v0Var.f12402z--;
                lVar.c();
                break;
        }
    }

    public c(l lVar, ListIterator listIterator) {
        this.f12308y = lVar;
        this.f12307x = lVar.f12353w;
        this.f12306w = listIterator;
    }

    public c(e eVar, Iterator it) {
        this.f12306w = it;
        this.f12308y = eVar;
    }

    public c(d dVar) {
        this.f12308y = dVar;
        this.f12306w = dVar.f12316x.entrySet().iterator();
    }
}
