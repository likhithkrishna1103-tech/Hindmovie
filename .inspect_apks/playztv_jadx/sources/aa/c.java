package aa;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class c implements Iterator {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f646u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Iterator f647v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object f648w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f649x;

    public c(l lVar) {
        this.f649x = lVar;
        Collection collection = lVar.f699v;
        this.f648w = collection;
        this.f647v = collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    public void a() {
        l lVar = (l) this.f649x;
        lVar.d();
        if (lVar.f699v != ((Collection) this.f648w)) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f646u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                break;
            case 1:
                break;
            default:
                a();
                break;
        }
        return this.f647v.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f646u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Map.Entry entry = (Map.Entry) this.f647v.next();
                this.f648w = (Collection) entry.getValue();
                return ((d) this.f649x).a(entry);
            case 1:
                Map.Entry entry2 = (Map.Entry) this.f647v.next();
                this.f648w = entry2;
                return entry2.getKey();
            default:
                a();
                return this.f647v.next();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f646u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                q1.c.m("no calls to next() since the last call to remove()", ((Collection) this.f648w) != null);
                this.f647v.remove();
                ((d) this.f649x).f656x.f761y -= ((Collection) this.f648w).size();
                ((Collection) this.f648w).clear();
                this.f648w = null;
                break;
            case 1:
                q1.c.m("no calls to next() since the last call to remove()", ((Map.Entry) this.f648w) != null);
                Collection collection = (Collection) ((Map.Entry) this.f648w).getValue();
                this.f647v.remove();
                ((e) this.f649x).f662v.f761y -= collection.size();
                collection.clear();
                this.f648w = null;
                break;
            default:
                this.f647v.remove();
                l lVar = (l) this.f649x;
                x0 x0Var = lVar.f702y;
                x0Var.f761y--;
                lVar.e();
                break;
        }
    }

    public c(l lVar, ListIterator listIterator) {
        this.f649x = lVar;
        this.f648w = lVar.f699v;
        this.f647v = listIterator;
    }

    public c(e eVar, Iterator it) {
        this.f647v = it;
        this.f649x = eVar;
    }

    public c(d dVar) {
        this.f649x = dVar;
        this.f647v = dVar.f655w.entrySet().iterator();
    }
}
