package ua;

import androidx.media3.decoder.DecoderInputBuffer;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class w0 extends x0 implements Serializable {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final w0 f12403w = new w0(0);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final w0 f12404x = new w0(1);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f12405v;

    public /* synthetic */ w0(int i) {
        this.f12405v = i;
    }

    @Override // ua.x0
    public final x0 a() {
        switch (this.f12405v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return f12404x;
            default:
                return f12403w;
        }
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f12405v) {
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
        switch (this.f12405v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return "Ordering.natural()";
            default:
                return "Ordering.natural().reverse()";
        }
    }
}
