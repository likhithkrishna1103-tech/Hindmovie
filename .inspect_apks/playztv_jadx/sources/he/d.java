package he;

import androidx.media3.decoder.DecoderInputBuffer;
import ie.o;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f6083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final nd.a f6084c;

    public /* synthetic */ d(Object obj, ae.l lVar, int i) {
        this.f6082a = i;
        this.f6083b = obj;
        this.f6084c = lVar;
    }

    @Override // he.e
    public final Iterator iterator() {
        switch (this.f6082a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new c(this);
            case 1:
                return new l(this);
            default:
                return new ie.b(this);
        }
    }

    public d(CharSequence charSequence, o oVar) {
        this.f6082a = 2;
        be.h.e(charSequence, "input");
        this.f6083b = charSequence;
        this.f6084c = oVar;
    }
}
