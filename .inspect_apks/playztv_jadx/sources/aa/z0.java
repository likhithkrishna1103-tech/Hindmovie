package aa;

import androidx.media3.decoder.DecoderInputBuffer;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class z0 extends a1 implements Serializable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final z0 f767v = new z0(0);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final z0 f768w = new z0(1);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f769u;

    public /* synthetic */ z0(int i) {
        this.f769u = i;
    }

    @Override // aa.a1
    public final a1 a() {
        switch (this.f769u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return f768w;
            default:
                return f767v;
        }
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f769u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Comparable comparable = (Comparable) obj;
                Comparable comparable2 = (Comparable) obj2;
                comparable.getClass();
                comparable2.getClass();
                return comparable.compareTo(comparable2);
            default:
                Comparable comparable3 = (Comparable) obj;
                Comparable comparable4 = (Comparable) obj2;
                comparable3.getClass();
                if (comparable3 == comparable4) {
                    return 0;
                }
                return comparable4.compareTo(comparable3);
        }
    }

    public final String toString() {
        switch (this.f769u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return "Ordering.natural()";
            default:
                return "Ordering.natural().reverse()";
        }
    }
}
