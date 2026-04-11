package ua;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r implements Iterator {
    public final /* synthetic */ u A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f12380v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f12381w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f12382x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ u f12383y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ int f12384z;

    public r(u uVar, int i) {
        this.f12384z = i;
        this.A = uVar;
        this.f12383y = uVar;
        this.f12380v = uVar.f12398z;
        this.f12381w = uVar.isEmpty() ? -1 : 0;
        this.f12382x = -1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f12381w >= 0;
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object tVar;
        u uVar = this.f12383y;
        if (uVar.f12398z != this.f12380v) {
            throw new ConcurrentModificationException();
        }
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.f12381w;
        this.f12382x = i;
        switch (this.f12384z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                tVar = this.A.i()[i];
                break;
            case 1:
                tVar = new t(this.A, i);
                break;
            default:
                tVar = this.A.j()[i];
                break;
        }
        int i10 = this.f12381w + 1;
        if (i10 >= uVar.A) {
            i10 = -1;
        }
        this.f12381w = i10;
        return tVar;
    }

    @Override // java.util.Iterator
    public final void remove() {
        u uVar = this.f12383y;
        if (uVar.f12398z != this.f12380v) {
            throw new ConcurrentModificationException();
        }
        com.bumptech.glide.d.k("no calls to next() since the last call to remove()", this.f12382x >= 0);
        this.f12380v += 32;
        uVar.remove(uVar.i()[this.f12382x]);
        this.f12381w--;
        this.f12382x = -1;
    }
}
