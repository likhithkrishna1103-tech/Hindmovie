package me;

import android.view.View;
import android.view.ViewGroup;
import androidx.media3.decoder.DecoderInputBuffer;
import fe.l;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j implements Iterator, he.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f8477v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Iterator f8478w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Object f8479x;

    public j(ge.b bVar) {
        this.f8477v = 1;
        this.f8479x = new ArrayList();
        this.f8478w = bVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f8477v) {
        }
        return this.f8478w.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f8477v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ((l) ((d) this.f8479x).f8461c).a(this.f8478w.next());
            default:
                Object next = this.f8478w.next();
                ArrayList arrayList = (ArrayList) this.f8479x;
                View view = (View) next;
                ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
                ge.b bVar = viewGroup != null ? new ge.b(3, viewGroup) : null;
                if (bVar == null || !bVar.hasNext()) {
                    while (!this.f8478w.hasNext() && !arrayList.isEmpty()) {
                        this.f8478w = (Iterator) sd.j.m0(arrayList);
                        sd.j.n0(arrayList);
                    }
                } else {
                    arrayList.add(this.f8478w);
                    this.f8478w = bVar;
                }
                return next;
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f8477v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public j(d dVar) {
        this.f8477v = 0;
        this.f8479x = dVar;
        this.f8478w = ((e) dVar.f8460b).iterator();
    }
}
