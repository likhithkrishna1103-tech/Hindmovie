package he;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6092b;

    public /* synthetic */ j(int i, Object obj) {
        this.f6091a = i;
        this.f6092b = obj;
    }

    @Override // he.e
    public final Iterator iterator() {
        switch (this.f6091a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return (Iterator) this.f6092b;
            case 1:
                return new ie.c((CharSequence) this.f6092b);
            default:
                return ((Iterable) this.f6092b).iterator();
        }
    }
}
