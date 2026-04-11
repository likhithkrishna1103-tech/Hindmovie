package s;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Iterator, ce.a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f11610u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f11611v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f11612w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ int f11613x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ Object f11614y;

    public a(int i) {
        this.f11610u = i;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f11611v < this.f11610u;
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object objF;
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.f11611v;
        switch (this.f11613x) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                objF = ((e) this.f11614y).f(i);
                break;
            case 1:
                objF = ((e) this.f11614y).j(i);
                break;
            default:
                objF = ((f) this.f11614y).f11625v[i];
                break;
        }
        this.f11611v++;
        this.f11612w = true;
        return objF;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f11612w) {
            throw new IllegalStateException("Call next() before removing an element.");
        }
        int i = this.f11611v - 1;
        this.f11611v = i;
        switch (this.f11613x) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((e) this.f11614y).h(i);
                break;
            case 1:
                ((e) this.f11614y).h(i);
                break;
            default:
                ((f) this.f11614y).b(i);
                break;
        }
        this.f11610u--;
        this.f11612w = false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(f fVar) {
        this(fVar.f11626w);
        this.f11613x = 2;
        this.f11614y = fVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(e eVar, int i) {
        this(eVar.f11635w);
        this.f11613x = i;
        switch (i) {
            case 1:
                this.f11614y = eVar;
                this(eVar.f11635w);
                break;
            default:
                this.f11614y = eVar;
                break;
        }
    }
}
