package ua;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n0 extends n1 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f12363v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object f12364w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ int f12365x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Iterator f12366y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ Object f12367z;

    public n0() {
        this.f12363v = 2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.Iterator
    public final boolean hasNext() {
        Object next;
        int i = this.f12363v;
        if (i == 4) {
            throw new IllegalStateException();
        }
        int iC = y.e.c(i);
        if (iC == 0) {
            return true;
        }
        if (iC == 2) {
            return false;
        }
        this.f12363v = 4;
        switch (this.f12365x) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                do {
                    Iterator it = this.f12366y;
                    if (!it.hasNext()) {
                        this.f12363v = 3;
                        next = null;
                    } else {
                        next = it.next();
                    }
                    break;
                } while (!((ta.h) this.f12367z).apply(next));
                break;
            default:
                do {
                    Iterator it2 = this.f12366y;
                    if (!it2.hasNext()) {
                        this.f12363v = 3;
                        next = null;
                    } else {
                        next = it2.next();
                    }
                    break;
                } while (!((h1) this.f12367z).f12339w.contains(next));
                break;
        }
        this.f12364w = next;
        if (this.f12363v == 3) {
            return false;
        }
        this.f12363v = 1;
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f12363v = 2;
        Object obj = this.f12364w;
        this.f12364w = null;
        return obj;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public n0(Iterator it, ta.h hVar) {
        this();
        this.f12365x = 0;
        this.f12366y = it;
        this.f12367z = hVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public n0(h1 h1Var) {
        this();
        this.f12365x = 1;
        this.f12367z = h1Var;
        this.f12366y = h1Var.f12338v.iterator();
    }
}
