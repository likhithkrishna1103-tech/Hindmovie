package he;

import android.view.View;
import android.view.ViewGroup;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l implements Iterator, ce.a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f6094u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Iterator f6095v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Object f6096w;

    public l(be.a aVar) {
        this.f6094u = 1;
        this.f6096w = new ArrayList();
        this.f6095v = aVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f6094u) {
        }
        return this.f6095v.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f6094u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ((ie.f) ((d) this.f6096w).f6084c).a(this.f6095v.next());
            default:
                Object next = this.f6095v.next();
                ArrayList arrayList = (ArrayList) this.f6096w;
                View view = (View) next;
                ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
                be.a aVar = viewGroup != null ? new be.a(3, viewGroup) : null;
                if (aVar == null || !aVar.hasNext()) {
                    while (!this.f6095v.hasNext() && !arrayList.isEmpty()) {
                        this.f6095v = (Iterator) od.i.c0(arrayList);
                        if (arrayList.isEmpty()) {
                            throw new NoSuchElementException("List is empty.");
                        }
                        arrayList.remove(od.j.R(arrayList));
                    }
                } else {
                    arrayList.add(this.f6095v);
                    this.f6095v = aVar;
                }
                return next;
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f6094u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public l(d dVar) {
        this.f6094u = 0;
        this.f6096w = dVar;
        this.f6095v = ((j) dVar.f6083b).iterator();
    }
}
