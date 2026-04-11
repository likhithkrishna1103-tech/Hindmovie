package p;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b extends e implements Iterator {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public c f9593u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public c f9594v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ int f9595w;

    public b(c cVar, c cVar2, int i) {
        this.f9595w = i;
        this.f9593u = cVar2;
        this.f9594v = cVar;
    }

    @Override // p.e
    public final void a(c cVar) {
        c cVar2;
        c cVarB = null;
        if (this.f9593u == cVar && cVar == this.f9594v) {
            this.f9594v = null;
            this.f9593u = null;
        }
        c cVar3 = this.f9593u;
        if (cVar3 == cVar) {
            switch (this.f9595w) {
                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                    cVar2 = cVar3.f9599x;
                    break;
                default:
                    cVar2 = cVar3.f9598w;
                    break;
            }
            this.f9593u = cVar2;
        }
        c cVar4 = this.f9594v;
        if (cVar4 == cVar) {
            c cVar5 = this.f9593u;
            if (cVar4 != cVar5 && cVar5 != null) {
                cVarB = b(cVar4);
            }
            this.f9594v = cVarB;
        }
    }

    public final c b(c cVar) {
        switch (this.f9595w) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return cVar.f9598w;
            default:
                return cVar.f9599x;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f9594v != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        c cVar = this.f9594v;
        c cVar2 = this.f9593u;
        this.f9594v = (cVar == cVar2 || cVar2 == null) ? null : b(cVar);
        return cVar;
    }
}
