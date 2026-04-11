package aa;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p0 extends q1 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f723u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object f724v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ int f725w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Iterator f726x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ Object f727y;

    public p0() {
        this.f723u = 2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.Iterator
    public final boolean hasNext() {
        Object next;
        int i = this.f723u;
        if (i == 4) {
            throw new IllegalStateException();
        }
        int iC = v.e.c(i);
        if (iC == 0) {
            return true;
        }
        if (iC == 2) {
            return false;
        }
        this.f723u = 4;
        switch (this.f725w) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                do {
                    Iterator it = this.f726x;
                    if (!it.hasNext()) {
                        this.f723u = 3;
                        next = null;
                    } else {
                        next = it.next();
                    }
                    break;
                } while (!((z9.h) this.f727y).apply(next));
                break;
            default:
                do {
                    Iterator it2 = this.f726x;
                    if (!it2.hasNext()) {
                        this.f723u = 3;
                        next = null;
                    } else {
                        next = it2.next();
                    }
                    break;
                } while (!((k1) this.f727y).f697v.contains(next));
                break;
        }
        this.f724v = next;
        if (this.f723u == 3) {
            return false;
        }
        this.f723u = 1;
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f723u = 2;
        Object obj = this.f724v;
        this.f724v = null;
        return obj;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public p0(Iterator it, z9.h hVar) {
        this();
        this.f725w = 0;
        this.f726x = it;
        this.f727y = hVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public p0(k1 k1Var) {
        this();
        this.f725w = 1;
        this.f727y = k1Var;
        this.f726x = k1Var.f696u.iterator();
    }
}
