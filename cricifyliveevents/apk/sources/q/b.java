package q;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends e implements Iterator {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public c f10307v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public c f10308w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ int f10309x;

    public b(c cVar, c cVar2, int i) {
        this.f10309x = i;
        this.f10307v = cVar2;
        this.f10308w = cVar;
    }

    @Override // q.e
    public final void a(c cVar) {
        c cVar2;
        c cVarB = null;
        if (this.f10307v == cVar && cVar == this.f10308w) {
            this.f10308w = null;
            this.f10307v = null;
        }
        c cVar3 = this.f10307v;
        if (cVar3 == cVar) {
            switch (this.f10309x) {
                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                    cVar2 = cVar3.f10313y;
                    break;
                default:
                    cVar2 = cVar3.f10312x;
                    break;
            }
            this.f10307v = cVar2;
        }
        c cVar4 = this.f10308w;
        if (cVar4 == cVar) {
            c cVar5 = this.f10307v;
            if (cVar4 != cVar5 && cVar5 != null) {
                cVarB = b(cVar4);
            }
            this.f10308w = cVarB;
        }
    }

    public final c b(c cVar) {
        switch (this.f10309x) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return cVar.f10312x;
            default:
                return cVar.f10313y;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f10308w != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        c cVar = this.f10308w;
        c cVar2 = this.f10307v;
        this.f10308w = (cVar == cVar2 || cVar2 == null) ? null : b(cVar);
        return cVar;
    }
}
