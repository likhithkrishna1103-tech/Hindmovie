package qd;

import androidx.media3.decoder.DecoderInputBuffer;
import be.h;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Comparator {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final a f11194v = new a(0);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final a f11195w = new a(1);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f11196u;

    public /* synthetic */ a(int i) {
        this.f11196u = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f11196u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Comparable comparable = (Comparable) obj;
                Comparable comparable2 = (Comparable) obj2;
                h.e(comparable, "a");
                h.e(comparable2, "b");
                return comparable.compareTo(comparable2);
            default:
                Comparable comparable3 = (Comparable) obj;
                Comparable comparable4 = (Comparable) obj2;
                h.e(comparable3, "a");
                h.e(comparable4, "b");
                return comparable4.compareTo(comparable3);
        }
    }

    @Override // java.util.Comparator
    public final Comparator reversed() {
        switch (this.f11196u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return f11195w;
            default:
                return f11194v;
        }
    }
}
