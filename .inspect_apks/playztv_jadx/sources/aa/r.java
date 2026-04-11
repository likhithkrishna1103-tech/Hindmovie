package aa;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r implements Iterator {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f732u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f733v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f734w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ u f735x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ int f736y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ u f737z;

    public r(u uVar, int i) {
        this.f736y = i;
        this.f737z = uVar;
        this.f735x = uVar;
        this.f732u = uVar.f753y;
        this.f733v = uVar.isEmpty() ? -1 : 0;
        this.f734w = -1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f733v >= 0;
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object tVar;
        u uVar = this.f735x;
        if (uVar.f753y != this.f732u) {
            throw new ConcurrentModificationException();
        }
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.f733v;
        this.f734w = i;
        switch (this.f736y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                tVar = this.f737z.i()[i];
                break;
            case 1:
                tVar = new t(this.f737z, i);
                break;
            default:
                tVar = this.f737z.j()[i];
                break;
        }
        int i10 = this.f733v + 1;
        if (i10 >= uVar.f754z) {
            i10 = -1;
        }
        this.f733v = i10;
        return tVar;
    }

    @Override // java.util.Iterator
    public final void remove() {
        u uVar = this.f735x;
        if (uVar.f753y != this.f732u) {
            throw new ConcurrentModificationException();
        }
        q1.c.m("no calls to next() since the last call to remove()", this.f734w >= 0);
        this.f732u += 32;
        uVar.remove(uVar.i()[this.f734w]);
        this.f733v--;
        this.f734w = -1;
    }
}
