package v;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Iterator, he.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f12508v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f12509w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f12510x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ int f12511y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ Object f12512z;

    public a(int i) {
        this.f12508v = i;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f12509w < this.f12508v;
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object objF;
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.f12509w;
        switch (this.f12511y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                objF = ((e) this.f12512z).f(i);
                break;
            case 1:
                objF = ((e) this.f12512z).j(i);
                break;
            default:
                objF = ((f) this.f12512z).f12522w[i];
                break;
        }
        this.f12509w++;
        this.f12510x = true;
        return objF;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f12510x) {
            throw new IllegalStateException("Call next() before removing an element.");
        }
        int i = this.f12509w - 1;
        this.f12509w = i;
        switch (this.f12511y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((e) this.f12512z).h(i);
                break;
            case 1:
                ((e) this.f12512z).h(i);
                break;
            default:
                ((f) this.f12512z).a(i);
                break;
        }
        this.f12508v--;
        this.f12510x = false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(f fVar) {
        this(fVar.f12523x);
        this.f12511y = 2;
        this.f12512z = fVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(e eVar, int i) {
        this(eVar.f12542x);
        this.f12511y = i;
        switch (i) {
            case 1:
                this.f12512z = eVar;
                this(eVar.f12542x);
                break;
            default:
                this.f12512z = eVar;
                break;
        }
    }
}
